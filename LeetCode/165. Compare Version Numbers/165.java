class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }

        return 0;

        
    }


}


class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        System.out.println(v1.length);
        while(i < v1.length && j < v2.length) {
            int value1 = Integer.parseInt(v1[i]);
            int value2 = Integer.parseInt(v2[j]);
            if(value1 == value2) {
                i++;
                j++;
            } else if(value1 > value2) {
                return 1;
            } else {
                return -1;
            }
        }
        while(i < v1.length) {
            if(Integer.parseInt(v1[i]) > 0) return 1;
            i++;
        }
        while(j < v2.length) {
            if(Integer.parseInt(v2[j]) > 0) return -1;
            j++;
        }
        return 0;
    }
}