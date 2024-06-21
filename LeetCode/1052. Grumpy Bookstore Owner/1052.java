class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCustomers = 0;

        // Calculate the number of customers satisfied without using the technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        int maxAdditionalSatisfied = 0; // Maximum additional satisfied customers
        int additionalSatisfied = 0;    // Current additional satisfied customers in the window

        // Use a sliding window to find the maximum additional satisfied customers
        for (int i = 0; i < n; i++) {
            // If the owner is grumpy, add the current customers to additionalSatisfied
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }

            // If the window size exceeds 'minutes', remove the customers who were part of the window
            if (i >= minutes && grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }

            // Update the maxAdditionalSatisfied to be the maximum value found
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        // The total maximum satisfied customers
        return satisfiedCustomers + maxAdditionalSatisfied;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(solution.maxSatisfied(customers, grumpy, minutes)); // Expected output: 16
    }
}

/*
  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        // find the number of satisfied customers without applying the secret technique
        int satisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            } 
        }
        
        int max = 0;
        int currSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
            if (grumpy[windowEnd] == 1) {
                currSum += customers[windowEnd];
            }
            
            if (windowEnd - windowStart + 1 == X) {
                max = Math.max(max, currSum);
                if (grumpy[windowStart] == 1) {
                    currSum -= customers[windowStart];
                }
                windowStart++;
            }
        }
        
        return satisfiedCustomers + max;   
}
}
 */

 /*
  class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unrealizedCustomers = 0;

        // Calculate initial number of unrealized customers in first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unrealizedCustomers += customers[i] * grumpy[i];
        }

        int maxUnrealizedCustomers = unrealizedCustomers;

        // Slide the 'minutes' window across the rest of the customers array
        for (int i = minutes; i < n; i++) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unrealizedCustomers += customers[i] * grumpy[i];
            unrealizedCustomers -= customers[i - minutes] * grumpy[i - minutes];

            // Update the maximum unrealized customers
            maxUnrealizedCustomers = Math.max(
                maxUnrealizedCustomers,
                unrealizedCustomers
            );
        }

        System.out.println(maxUnrealizedCustomers);

        // Start with maximum possible satisfied customers due to secret technique
        int totalCustomers = maxUnrealizedCustomers;

        // Add the satisfied customers during non-grumpy minutes
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }

        // Return the maximum number of satisfied customers
        return totalCustomers;
    }
}
  */
  /*
   class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int j=0;j<n;j++) {
            curWin+=customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if(j >= minutes - 1 ) {
                curWin -= customers[i] * grumpy[i++];
            }
        }
        int res = maxWin;
        for(i=0;i<grumpy.length;i++) {
            res+=customers[i] * (1 - grumpy[i]);
        }
        return res;

    }
}
   */
  /*
   class Solution {
    public ArrayList<Integer> getLostCustomersList(int[] customers, int[] grumpy) {
        ArrayList<Integer> expectedLostCustomers = new ArrayList<Integer>();
        for (int i = 0; i < customers.length; i += 1) {
            expectedLostCustomers.add(customers[i] * grumpy[i]);
        }
        return expectedLostCustomers;
    }

    public int getLostCustomersInWindow(ArrayList<Integer> lostCustomers, int startIndex, int windowSize) {
        int sum = 0;
        for (int i = startIndex; i < startIndex + windowSize; i += 1) {
            sum += lostCustomers.get(i);
        }
        return sum;
    }

    public int getStartIndexOfWhenToBeNonGrumpy(int[] customers, int[] grumpy, int minutes) {
        ArrayList<Integer> lostCustomers = this.getLostCustomersList(customers, grumpy);
        int maxLostCustomers = 0;
        int maxLostCustomersWindowStartIndex = 0;
        for (int i = 0; i <= customers.length - minutes; i += 1) {
            int lostCustomersInWindow = this.getLostCustomersInWindow(lostCustomers, i, minutes);
            if (lostCustomersInWindow > maxLostCustomers) {
                maxLostCustomers = lostCustomersInWindow;
                maxLostCustomersWindowStartIndex = i;
            }
        }
        return maxLostCustomersWindowStartIndex;
    }

    public int getSatisfiedCustomers(int[] customers, int[] grumpy, int nonGrumpyIndex, int windowSize) {
        int satisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i += 1) {
            if (grumpy[i] == 0 || (i >= nonGrumpyIndex && i < nonGrumpyIndex + windowSize)) {
                satisfiedCustomers += customers[i];
            }
        }
        return satisfiedCustomers;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int startIndex = this.getStartIndexOfWhenToBeNonGrumpy(customers, grumpy, minutes);
        return this.getSatisfiedCustomers(customers, grumpy, startIndex, minutes);
    }
}
   */
  /*
   class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int[] bigSeq = new int[minutes+1];

        List<Integer> grumpyCount = new ArrayList<>();
        int notGrumpyCount = 0;

        for(int i = 0; i<customers.length; i++) {
            if(grumpy[i] == 0) {
                notGrumpyCount += customers[i];
            } else {
                int grCount = 0;
                for(int j=0; j<minutes && i+j<customers.length; j++) {
                    if(grumpy[i+j] != 0)
                        grCount += customers[i+j]; 
                }
                grumpyCount.add(grCount);
            }
        } 

        Optional<Integer> gm = grumpyCount.stream().max(Integer::compare);
        int maxSeq = gm.isPresent() ? gm.get() : 0;

        return notGrumpyCount + maxSeq;

    }
}
   */