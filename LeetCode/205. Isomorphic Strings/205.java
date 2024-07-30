class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1.containsKey(c1) && map1.get(c1) != c2) {
                return false;
            }
            if (map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;

    }
}
//other peoples solutions
/*
 * class Solution {
 * public boolean isIsomorphic(String s, String t) {
 * if(s.length() != t.length()) return false;
 * if (s.length() == 31000 && t.length() == 31000) {
 * return !(t.charAt(t.length() - 3) == '@');
 * }
 * HashMap<Character, Character> map = new HashMap<>();
 * for(int i = 0; i < t.length(); i++){
 * 
 * if(!map.containsKey(s.charAt(i))){
 * if(!map.containsValue(t.charAt(i))) {
 * map.put(s.charAt(i), t.charAt(i));
 * } else {
 * return false;
 * }
 * } else {
 * if(map.get(s.charAt(i)) != t.charAt(i)) {
 * return false;
 * }
 * }
 * }
 * return true;
 * }
 * }
 */