package matching;

import java.util.List;

public class FuzzyMatcher {

    // Calculate Edit Distance using Dynamic Programming
    public static int editDistance(String s1, String s2) {

        s1 = s1.toLowerCase().trim();
        s2 = s2.toLowerCase().trim();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

    // Returns true if two skills are similar
    public static boolean isSimilar(String skill1, String skill2) {

        int distance = editDistance(skill1, skill2);

        // Allow up to 2 character mistakes
        return distance <= 2;
    }

    // Find the closest matching skill
    public static String findClosestSkill(String inputSkill, List<String> skills) {

        String closestSkill = null;
        int minimumDistance = Integer.MAX_VALUE;

        for (String skill : skills) {

            int distance = editDistance(inputSkill, skill);

            if (distance < minimumDistance) {
                minimumDistance = distance;
                closestSkill = skill;
            }
        }

        return closestSkill;
    }
}