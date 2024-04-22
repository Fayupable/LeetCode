class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        if (deadendSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] currentArray = current.toCharArray();
                        int digit = (currentArray[j] - '0' + k + 10) % 10;
                        currentArray[j] = (char) (digit + '0');
                        String next = new String(currentArray);
                        if (!visited.contains(next) && !deadendSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            turns++;
        }

        return -1;
    }
}