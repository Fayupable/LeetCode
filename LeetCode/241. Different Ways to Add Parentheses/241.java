import java.util.*;

class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '+' || currentChar == '-' || currentChar == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int combinedResult = 0;
                        switch (currentChar) {
                            case '+':
                                combinedResult = left + right;
                                break;
                            case '-':
                                combinedResult = left - right;
                                break;
                            case '*':
                                combinedResult = left * right;
                                break;
                        }
                        results.add(combinedResult);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }
}