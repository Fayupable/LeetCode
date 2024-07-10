public class Solution
{
    public int MinOperations(string[] logs)
    {
        //Initialize depth to 0
        int depth = 0;
        //Iterate through the logs
        foreach (var log in logs)
        {
            //If the log is "../" and depth is greater than 0, decrement the depth
            if (log == "../")
            {
                //If the depth is greater than 0, decrement the depth
                if (depth > 0)
                {
                    depth--;
                }
            }
            //If the log is "./", continue
            else if (log != "./")
            {
                depth++;
            }
        }
        return depth;

    }
}

//other people's solution
/*
public class Solution {
    public readonly string stay = @"./";
    public readonly string back = @"../";
    public int MinOperations(string[] logs) {
        int distance = 0;
        foreach(var log in logs){
            if(log[1] == '.' & distance != 0){
                distance--;
            }
            else if(log[0] != '.'){
                distance++;
            }
        }
        return distance;
    }
}
*/
/*
public class Solution {
    public int MinOperations(string[] logs) {
         int count = 0;
        foreach (string str in logs)
        {
            if (str == "../")
            {
                count--;
            }
            else if (str != "./")
            {
                count++;
            }
            if (count < 0)
            {
                count = 0;
            }
        }
        return count;
    }
}
*/
/*
public class Solution {
    public int MinOperations(string[] logs) {
        int count = 0;
        for(int i=0;i<logs.Length;i++){
            string optn = logs[i];
            if(optn.Equals("../"))
            {
                if(!(count == 0))
                    count--;

            }
            else if(!optn.Equals("./")){
                count++;
            }
           // Console.WriteLine("optn: "+optn+" count: "+count);
        }
        return count;
        
    }
}
*/
/*
public class Solution {
    public int MinOperations(string[] logs) {
        var stack = new Stack<string>();

        foreach(var log in logs)
        {
            if(log == "../")
            {
                if(stack.Count() == 0)
                {
                    continue;
                }
                else
                {
                    stack.Pop();
                }
            }
            else if(log == "./")
            {
                continue;
            }
            else
            {
                stack.Push(log);
            }
        }

        return stack.Count();
    }
}
*/