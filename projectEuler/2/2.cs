using System;

class Program
{
    static void Main()
    {
        int limit = 4000000;
        int a = 1, b = 2;
        int sum = 0;

        while (a <= limit)
        {
            if (a % 2 == 0)
            {
                sum += a;
            }
            int next = a + b;
            a = b;
            b = next;
        }

        Console.WriteLine("Sum of even-valued terms in Fibonacci sequence below 4 million: " + sum);
    }
}