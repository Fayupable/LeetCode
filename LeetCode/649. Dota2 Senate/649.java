class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            if (radiantIndex < direIndex) {
                radiant.add(radiantIndex + n);
            } else {
                dire.add(direIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}