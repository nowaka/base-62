package no.wak;

import java.util.Map;

/**
 * @author adam
 */
class Helper {
    static String encode(long num, char[] chars) {
        if (num == 0) {
            return String.valueOf(chars[0]);
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            long mod = num % chars.length;
            sb.append(chars[(int) mod]);
            num = num / chars.length;
        }
        return sb.reverse().toString();
    }

    static long decode(String encodedString, Map<Character, Integer> map) {
        char[] chars = encodedString.toCharArray();
        long res = 0;
        for (char aChar : chars) {
            res = res * map.size() + map.get(aChar);
        }
        return res;
    }
}
