import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] boxedArr1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr1, (a, b) -> {
            if (map.containsKey(a) || map.containsKey(b)) {
                return map.getOrDefault(a, 1001) - map.getOrDefault(b, 1001);
            }
            return a - b;
        });

        return Arrays.stream(boxedArr1).mapToInt(Integer::intValue).toArray();
    }
}

/*
 class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr2Idx = new int[1001];
        Arrays.fill(arr2Idx, -1);
        for(int i = 0; i < arr2.length; i++) {
            arr2Idx[arr2[i]] = i;
        }

        Comparator<Integer> comparator = (Integer a, Integer b) -> {
            if(arr2Idx[a] != -1 && arr2Idx[b] != -1) {
                return arr2Idx[a] - arr2Idx[b];
            } else if(arr2Idx[a] != -1) {
                return - 1;
            } else if (arr2Idx[b] != -1) {
                return 1;
            }
            return a - b;
        };
        mergeSort(arr1, comparator, 0, arr1.length, new int[arr1.length]);

        return arr1;
    }

    private void mergeSort(int[] nums, Comparator<Integer> comparator, int start, int end, int[] tmp) {
        if(end - start == 1) {
            return;
        }
        int p = (start + end)/2;
        mergeSort(nums, comparator, start, p, tmp);
        mergeSort(nums, comparator, p, end, tmp);
        mergeSorted(nums, comparator, start, p, end, tmp);
    }

    private void mergeSorted(int[] nums, Comparator<Integer> comparator, int start, int p, int end, int[] tmp) {
        //int k = 0;
        for(int i = start; i < end; i++){
            tmp[i] = nums[i];
        }

        int i = start;
        int j = p;
        int k = start;

        while(i < p && j < end) {
            while(i < p && comparator.compare(tmp[i], tmp[j]) <= 0) {
                nums[k] = tmp[i];
                i++;
                k++;
            }
            while(j < end && comparator.compare(tmp[j], tmp[i]) <= 0) {
                nums[k] = tmp[j];
                j++;
                k++;
            }
        }
        while(i < p) {
            nums[k] = tmp[i];
            i++;
            k++;
        }
        while(j < end) {
            nums[k] = tmp[j];
            j++;
            k++;
        }
    }
}
 */