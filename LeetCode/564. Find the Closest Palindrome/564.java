import java.util.ArrayList;
import java.util.List;

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long number = Long.parseLong(n);
        List<Long> candidates = getCandidates(n, len);

        long closest = -1;
        for (long candidate : candidates) {
            if (candidate == number) continue;
            if (closest == -1 ||
                Math.abs(candidate - number) < Math.abs(closest - number) ||
                (Math.abs(candidate - number) == Math.abs(closest - number) && candidate < closest)) {
                closest = candidate;
            }
        }

        return String.valueOf(closest);
    }

    private List<Long> getCandidates(String n, int len) {
        List<Long> candidates = new ArrayList<>();
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        candidates.add(getPalindrome(prefix, len % 2 == 0));
        candidates.add(getPalindrome(prefix + 1, len % 2 == 0));
        candidates.add(getPalindrome(prefix - 1, len % 2 == 0));


        candidates.add((long) Math.pow(10, len - 1) - 1); 
        candidates.add((long) Math.pow(10, len) + 1); 
        return candidates;
    }

    private long getPalindrome(long prefix, boolean evenLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        String suffix = new StringBuilder(sb).reverse().substring(evenLength ? 0 : 1);
        return Long.parseLong(sb.append(suffix).toString());
    }
}