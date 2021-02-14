package no.wak;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author adam
 */
public class Base26 {

    private static final char[] BASE_26 = "abcdefghijklmnopqrstuvwxyz"
        .toCharArray();
    private static final int BASE = BASE_26.length;

    private Base26() {
        // do nothing
    }

    public static Encoder getEncoder() {
        return Encoder.DEFAULT;
    }


    public static Decoder getDecoder() {
        return Decoder.DEFAULT;
    }

    public static class Encoder {

        private static final Encoder DEFAULT = new Encoder();

        public String encode(long num) {
            return Helper.encode(num, BASE_26);
        }
    }

    public static class Decoder {

        private static final Decoder DEFAULT = new Decoder();
        private final Map<Character, Integer> map;

        private Decoder() {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < BASE; i++) {
                map.put(BASE_26[i], i);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        public long decode(String encodedString) {
            return Helper.decode(encodedString, map);
        }
    }
}
