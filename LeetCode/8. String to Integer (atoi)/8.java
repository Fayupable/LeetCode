class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1, result = 0;
        if (s.length() == 0) return 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}

/*
 * 
 * class Solution {
    String atoi(String s, int i, int j,StringBuilder res){
        if(i == s.length()) return res.toString();
        if(s.charAt(i) == ' ' && i == j){
            return atoi(s,i+1,j+1,res);
        }
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            if(i == j) return atoi(s,i+1,j,res.append(s.charAt(i)+""));
            else return res.toString();
        }
        if(Character.isDigit(s.charAt(i))) return atoi(s,i+1,j,res.append(s.charAt(i)+""));
        else return res.toString();
    }
    public int myAtoi(String s) {
        long a = Integer.MAX_VALUE+1;
        String res = atoi(s,0,0,new StringBuilder("")); 
        //System.out.println(res);
        boolean positive = true;
        if(res.length() == 0 || (res.length() == 1 && !Character.isDigit(res.charAt(0))))             return 0;
        if(res.charAt(0) == '-') positive = false;
        long r = 0,pos = 1; 
        int i = 0, j = res.length()-1;
        if(!Character.isDigit(res.charAt(0))) i = 1;
        while(i < res.length() && res.charAt(i) == '0') i++;
        if(i == res.length()) return (int)r;
        if(res.length()-i > 10){
            return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        while(j >= i){
            r += (res.charAt(j--)-'0')*pos;
            //System.out.println(r+" " + j + " " + s.charAt(j) + " "+ i);
            if(r > Integer.MAX_VALUE){
                if(positive) return Integer.MAX_VALUE;
                if(r > a) return Integer.MIN_VALUE;
            } 
            pos *= 10;
        }
        if(!positive) return -1*((int)r);
        return (int)r;
    }

}
 */