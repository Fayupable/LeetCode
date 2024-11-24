class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentGas = 0, startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= totalCost ? startStation : -1;
    }
}