public class Solution
{
    public string ReverseParentheses(string s)
    {
        Stack<int> stack = new Stack<int>();
        int n = s.Length;
        int[] pair = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (s[i] == '(')
            {
                stack.Push(i);
            }
            else if (s[i] == ')')
            {
                int j = stack.Pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0, step = 1;
        while (index < n)
        {
            if (s[index] == '(' || s[index] == ')')
            {
                index = pair[index];
                step = -step;
            }
            else
            {
                sb.Append(s[index]);
            }
            index += step;
        }
        return sb.ToString();

    }
}

/
/*
public class Solution {
    public string ReverseParentheses(string s) {
        Stack<char> box = new Stack<char>();
        Queue<char> box2= new Queue<char>();
        foreach(var c in s)
        {
            if(c == ')')
            {
                while(box.Count != 0 && box.Peek() != '(') 
                    box2.Enqueue(box.Pop());
                box.Pop();
                while(box2.Count!= 0) box.Push(box2.Dequeue());
            }
            else
            {
                box.Push(c);
            }
        }
        string result = "";
        while(box.Count!= 0)
            result = box.Pop() + result;
        return result;
    }
}
*/
/*
public class Solution {


    public string ReverseParentheses(string s) {
        
        int lb = -1;
        int rb = -1;
        int lb_count = 0;
        for(int i = 0; i < s.Length; i++){
            if (s[i] == '('){
                if (lb == -1) {lb = i;}
                else {lb_count += 1;}
            }
            if (s[i] == ')'){
                if (lb_count == 0) {rb = i; break;}
                else {lb_count -= 1;}
            }
        }
        if (lb == -1 || rb == -1) return s;

        string left_part = "";
        string right_part = "";

        if (lb > 0) {left_part = s.Substring(0, lb);}
        if (rb <= s.Length) {right_part = s.Substring(rb+1);}

        string middle = ReverseParentheses(s.Substring(lb+1, rb-lb-1));
        string rev_mid = new string(middle.Reverse().ToArray());
        
        string res = left_part + rev_mid + ReverseParentheses(right_part);

        return res;
    }
}
*/