class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}

/*
 * class Solution {
 * int i = 0;
 * public String reverseParentheses(String s) {
 * char[] ar = s.toCharArray();
 * return helper(ar);
 * }
 * 
 * public String helper(char[] s){
 * StringBuilder sb = new StringBuilder();
 * 
 * while(i < s.length){
 * if(s[i] == ')'){
 * i++;
 * return sb.reverse().toString();
 * }else if(s[i] == '('){
 * i++;
 * String st = helper(s);
 * //System.out.println(st);
 * sb.append(st);
 * }else{
 * sb.append(s[i]);
 * i++;
 * }
 * }
 * return sb.toString();
 * 
 * }
 * }
 */

/*
 * class Solution {
 * public String reverseParentheses(String s) {
 * int n=s.length();
 * Stack<StringBuilder> stack = new Stack<>();
 * StringBuilder str = new StringBuilder();
 * for(int i=0;i<n;i++){
 * char ch = s.charAt(i);
 * if(ch=='('){
 * stack.push(str);
 * str=new StringBuilder();
 * }
 * else if(ch==')'){
 * str.reverse();
 * if(!stack.isEmpty()){
 * stack.peek().append(str);
 * str=stack.pop();
 * }
 * }
 * else str.append(ch);
 * }
 * return str.toString();
 * }
 * }
 */
/*
 * class Solution {
 * public String reverseParentheses(String s) {
 * Stack<StringBuilder> st=new Stack<>();
 * StringBuilder str=new StringBuilder("");
 * for(int i=0;i<s.length();i++){
 * if(s.charAt(i)=='('){
 * st.push(str);
 * str=new StringBuilder("");
 * }
 * else if(s.charAt(i)==')'){
 * str.reverse();
 * StringBuilder str2=st.pop();
 * str2.append(str);
 * str=str2;
 * 
 * }
 * else{
 * str.append(s.charAt(i));
 * }
 * }
 * return str.toString();
 * }
 * }
 */