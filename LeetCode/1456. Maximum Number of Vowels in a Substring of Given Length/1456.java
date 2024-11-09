class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0,c=0;
        char ch;
        int ans=0;
        for(j=0;j<s.length();j++){
            if((j-i+1)>k){
                ch=s.charAt(i);
                ans= Math.max(c,ans);
                if(ch=='a' || ch=='e' || ch=='i'|| ch=='o'||ch=='u'){
                    if(c>0)
                    c--;
                }
                i++;
            }
            ch=s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i'|| ch=='o'||ch=='u'){
                c++;
            }
        }
        return Math.max(c,ans);
    }
}