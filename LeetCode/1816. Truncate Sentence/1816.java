class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder truncated = new StringBuilder();
        for(int i =0;i<k;i++){
            truncated.append(words[i]);
            if(i<k-1){
                truncated.append(" ");
            }
        }
        return truncated.toString();

        
    }
}