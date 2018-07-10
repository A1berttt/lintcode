public class Solution {
//    // longest common substring 1
//    public int longestCommonSubstring(String A, String B) {
//        int len_A = A.length();
//        int len_B = B.length();
//        if(len_A == 0 || len_B == 0)
//            return 0;
//        int[][] mat = new int[2][len_B];
//        int startA = -1;
//        int startB = -1;
//        int ret = 0;
//
//        for(int j = 0; j < len_B; j++) {
//            if(A.charAt(0) == B.charAt(j)){
//                mat[0][j] = 1;
//                if (ret == 0) {
//                    ret = 1;
//                    startA = 0;
//                    startB = j;
//                }
//            }
//        }
//
//        for(int i = 1; i < len_A; i++) {
//            int cur = (i % 2);
//            int pre = (i + 1) % 2;
//            mat[cur][0] = 0;
//            if (A.charAt(i) == B.charAt(0)) {
//                mat[cur][0] = 1;
//                if (ret == 0) {
//                    ret = 1;
//                    startA = i;
//                    startB = 0;
//                }
//            }
//
//            for (int j = 1; j < len_B; j++) {
//                if (A.charAt(i) == B.charAt(j)) {
//                    mat[cur][j] = mat[pre][j - 1] + 1;
//                    if (ret < mat[cur][j]) {
//                        ret = mat[cur][j];
//                        startA = i - ret + 1;
//                        startB = j - ret + 1;
//                    }
//                }
//                else
//                    mat[cur][j] = 0;
//            }
//        }
//        return ret;
//    }

    // longest common substring 2
    public int longestCommonSubstring(String A, String B){
        int lenA = A.length();
        int lenB = B.length();
        if(lenA == 0 || lenB == 0)
            return 0;

        int startA = -1;
        int startB = -1;
        int ret = 0;

        for (int i = 0; i < lenA; i++) {
            int m = i;
            int n = 0;
            int length = 0;
            while(m < lenA && n < lenB) {
                if (A.charAt(m) == B.charAt(n)) {
                    length++;
                    if (ret < length) {
                        ret = length;
                        startA = m - ret + 1;
                        startB = n - ret + 1;
                    }
                }
                else
                    length = 0;
                m++;
                n++;
            }
        }

        for (int j = 1; j < lenB; j++) {
            int m = 0;
            int n = j;
            int length = 0;
            while(m < lenA && n < lenB) {
                if (A.charAt(m) == B.charAt(n)) {
                    length++;
                    if (ret < length) {
                        ret = length;
                        startA = m - ret + 1;
                        startB = n - ret + 1;
                    }
                }
                else
                    length = 0;
                m++;
                n++;
            }
        }
        return ret;
    }
}

