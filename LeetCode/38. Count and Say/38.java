class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder result = new StringBuilder();
        char repeat = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == repeat){
                count++;
            } else {
                result.append(count).append(repeat);
                count = 1;
                repeat = s.charAt(i);
            }
        }
        result.append(count).append(repeat);
        return result.toString();
    }
}