// Digit Factorials
// 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145
    class _34
    {
        public _34()
        {
            int[] factorials = new int[10];
            factorials[0] = 1;
            for (int i = 1; i < 10; i++)
            {
                factorials[i] = factorials[i - 1] * i;
            }

            int sum = 0;
            for (int i = 10; i < 1000000; i++)
            {
                int number = i;
                int sumOfFactorials = 0;
                while (number > 0)
                {
                    sumOfFactorials += factorials[number % 10];
                    number /= 10;
                }
                if (sumOfFactorials == i)
                {
                    sum += i;
                }
            }
            Console.WriteLine(sum);
        }
    }
