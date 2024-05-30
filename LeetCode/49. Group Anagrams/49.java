import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to store sorted character sequences as keys and lists of anagrams as values
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for (String word : strs) {
            // Sort the word to create the key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            // Add the word to the corresponding anagram group in the map
            if (!anagrams.containsKey(sortedWord)) {
                anagrams.put(sortedWord, new ArrayList<>());
            }
            anagrams.get(sortedWord).add(word);
        }
        
        // Return all the anagram groups as a list of lists
        return new ArrayList<>(anagrams.values());
    }
  
}

/*
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);            
            map.computeIfAbsent(sorted,  k -> new ArrayList<>()).add(str);
        }

        ans.addAll(map.values());

        return ans;
    }
}
 */

 /*
  import java.util.*;
class Solution {

    public List<List<String>> groupAnagrams(String[] s){
        return new AbstractList<List<String>>() {

            private List<List<String>> ans;
            @Override
            public List<String> get(int index) {
                if (ans == null) init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if (ans == null) init();
                return ans.size();
            }

            private void init(){
                Map<String,List<String>> group = new HashMap<>();
                for (String str:s){
                    int[] count = new int[26];
                    StringBuilder sb = new StringBuilder();
                    for (char ch: str.toCharArray()){
                        count[ch-'a']++;
                    }
                    for (int i=0; i<26; i++){
                        if (count[i]!=0){
                            sb.append('a'+i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    group.computeIfAbsent(key,val->new ArrayList<>()).add(str);
                }
                ans = new ArrayList<>(group.values());
            }
        };
    }

    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String,List<String>> map = new HashMap<>();
    //     for (String s: strs){
    //         char[] charArr = s.toCharArray();
    //         Arrays.sort(charArr);
    //         if (map.containsKey(Arrays.toString(charArr))){
    //             map.get(Arrays.toString(charArr)).add(s);
    //         }else{
    //             List<String> ll = new ArrayList<>();
    //             ll.add(s);
    //             map.put(Arrays.toString(charArr),ll);
    //         }
    //     }
    //     List<List<String>> res = new ArrayList<>();
    //     for (String cArr: map.keySet()){
    //         res.add(map.get(cArr));
    //     }
    //     return res;
    // }
}
  */