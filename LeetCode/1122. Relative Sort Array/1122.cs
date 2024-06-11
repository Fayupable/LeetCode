using System;
using System.Collections.Generic;

public class Solution
{
    public int[] RelativeSortArray(int[] arr1, int[] arr2)
    {
        // Create a rank dictionary to store the order of elements in arr2
        Dictionary<int, int> rank = new Dictionary<int, int>();
        for (int i = 0; i < arr2.Length; i++)
        {
            rank[arr2[i]] = i;
        }

        // Convert arr1 to a List of integers for easier manipulation
        List<int> arr1List = new List<int>(arr1);

        // Sort arr1 using merge sort
        MergeSort(arr1List, rank);

        // Convert back to int array
        return arr1List.ToArray();
    }

    private void MergeSort(List<int> arr, Dictionary<int, int> rank)
    {
        if (arr.Count < 2)
            return;

        int mid = arr.Count / 2;
        List<int> left = new List<int>(arr.GetRange(0, mid));
        List<int> right = new List<int>(arr.GetRange(mid, arr.Count - mid));

        MergeSort(left, rank);
        MergeSort(right, rank);
        Merge(arr, left, right, rank);
    }

    private void Merge(List<int> arr, List<int> left, List<int> right, Dictionary<int, int> rank)
    {
        int i = 0, j = 0, k = 0;

        while (i < left.Count && j < right.Count)
        {
            if (Compare(left[i], right[j], rank) <= 0)
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
            }
        }

        while (i < left.Count)
        {
            arr[k++] = left[i++];
        }

        while (j < right.Count)
        {
            arr[k++] = right[j++];
        }
    }

    private int Compare(int x, int y, Dictionary<int, int> rank)
    {
        if (rank.ContainsKey(x) && rank.ContainsKey(y))
        {
            return rank[x] - rank[y];
        }
        else if (rank.ContainsKey(x))
        {
            return -1;
        }
        else if (rank.ContainsKey(y))
        {
            return 1;
        }
        else
        {
            return x - y;
        }
    }
}
