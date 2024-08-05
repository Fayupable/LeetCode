class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count occurrences of each string
        Map<String, Integer> countMap = countOccurrences(arr);

        // Step 2: Collect distinct strings
        List<String> distinctStrings = collectDistinctStrings(arr, countMap);

        // Step 3: Return the k-th distinct string
        return getKthDistinctString(distinctStrings, k);
    }

    private Map<String, Integer> countOccurrences(String[] arr) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        return countMap;
    }

    private List<String> collectDistinctStrings(String[] arr, Map<String, Integer> countMap) {
        List<String> distinctStrings = new ArrayList<>();
        for (String str : arr) {
            if (countMap.get(str) == 1) {
                distinctStrings.add(str);
            }
        }
        return distinctStrings;
    }

    private String getKthDistinctString(List<String> distinctStrings, int k) {
        return (k <= distinctStrings.size()) ? distinctStrings.get(k - 1) : "";
    }
}

/*
 * class Solution {
 * public String kthDistinct(String[] arr, int k) {
 * List<String> uniqueValInArray = new LinkedList<>();
 * int totalDistinctVal = 0;
 * Set<String> nonDistinctSet = new HashSet<>();
 * Set<String> distinctSet = new HashSet<>();
 * for(String s:arr) {
 * if(!nonDistinctSet.contains(s)) {
 * if(!distinctSet.contains(s)) {
 * distinctSet.add(s);
 * totalDistinctVal++;
 * } else {
 * nonDistinctSet.add(s);
 * distinctSet.remove(s);
 * totalDistinctVal--;
 * }
 * }
 * }
 * if(totalDistinctVal<k) {
 * return "";
 * }
 * for(String s:arr) {
 * if(distinctSet.contains(s)){
 * k--;
 * if(k==0){
 * return s;
 * }
 * }
 * }
 * return "";
 * }
 * }
 */