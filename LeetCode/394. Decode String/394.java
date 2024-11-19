class Solution {
    public String decodeString(String s) {
        return decodeHelper(s, new int[]{0});
    }

    private String decodeHelper(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        while (index[0] < n && s.charAt(index[0]) != ']') {
            if (Character.isDigit(s.charAt(index[0]))) {
                int count = 0;
                while (index[0] < n && Character.isDigit(s.charAt(index[0]))) {
                    count = count * 10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
                index[0]++; 
                String nested = decodeHelper(s, index);
                index[0]++; 
                for (int i = 0; i < count; i++) {
                    result.append(nested);
                }
            } else {
                result.append(s.charAt(index[0]));
                index[0]++;
            }
        }

        return result.toString();
    }
}