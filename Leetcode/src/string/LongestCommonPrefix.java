package string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < prefix.length()) {
                prefix = prefix.substring(0, strs[i].length());
            }
            for (int j = 0; j < Math.min(prefix.length(), strs[i].length()); j++) {
                // ["ab", "a"]
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                }
            }
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) { return ""; }
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            while (!strs[i].startsWith(prefix)) {
//                prefix = prefix.substring(0, prefix.length()-1);
//                if (prefix.isEmpty()) return "";
//            }
//        }
//        return prefix;
//    }
}
