import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findRotateSteps(String ring, String key) {
        return dp(ring, key, 0, 0, new HashMap<>());
    }
    
    private int dp(String ring, String key, int ringIndex, int keyIndex, Map<String, Integer> memo) {
        if (keyIndex == key.length()) {
            return 0;
        }
        
        String memoKey = ringIndex + "_" + keyIndex;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        
        char targetChar = key.charAt(keyIndex);
        int minSteps = Integer.MAX_VALUE;
        for (int pos : findPositions(ring, targetChar)) {
            int stepsToPosition = minStepsToPosition(ring, ringIndex, pos);
            int stepsToNextChar = dp(ring, key, pos, keyIndex + 1, memo);
            int totalSteps = stepsToPosition + stepsToNextChar;
            minSteps = Math.min(minSteps, totalSteps);
        }
        
        memo.put(memoKey, minSteps + 1); // Merkez düğmesine basmak için ekstra bir adım
        return minSteps + 1; // Bir sonraki karakteri işaretlemeden önce merkez düğmesine basılması gerektiği için +1
    }
    
    private int minStepsToPosition(String ring, int currentPos, int targetPos) {
        int clockwiseSteps = Math.abs(targetPos - currentPos);
        int anticlockwiseSteps = ring.length() - clockwiseSteps;
        return Math.min(clockwiseSteps, anticlockwiseSteps);
    }
    
    private int[] findPositions(String ring, char character) {
        int count = 0;
        for (char c : ring.toCharArray()) {
            if (c == character) {
                count++;
            }
        }
        int[] positions = new int[count];
        int index = 0;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == character) {
                positions[index++] = i;
            }
        }
        return positions;
    }
}

//2.cozum
class Solution {
    public int findRotateSteps(String ring, String key) {
          char[] r=ring.toCharArray();
        List<Integer>[] p=new List[26];
        for(int i=0;i<r.length;i++) {
            int c=r[i]-'a';
            List<Integer> l=p[c];
            if(l==null) p[c]=l=new ArrayList<>();
            l.add(i);
        }
        return helper(0,0,p,key.toCharArray(),ring,new int[key.length()][r.length]);
    }
    int helper(int in, int pos, List<Integer>[] p, char[] k, String r, int[][] memo) {
        if(in==k.length) return 0;
        if(memo[in][pos]>0) return memo[in][pos]-1;
        int min=Integer.MAX_VALUE;
        for(int i: p[k[in]-'a']) {
            int m;
            if(i>=pos) m=Math.min(i-pos,pos+r.length()-i);
            else m=Math.min(pos-i,i+r.length()-pos);
            min=Math.min(min,m+helper(in+1,i,p,k,r,memo));
        }
        return (memo[in][pos]=min+2)-1;
    }
}