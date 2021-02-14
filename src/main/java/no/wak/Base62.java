package no.wak;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author adam
 */
public class Base62 {

    private static final char[] BASE_62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        .toCharArray();
    private static final int BASE = BASE_62.length;

    private Base62() {
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
            return Helper.encode(num, BASE_62);
        }
    }

    public static class Decoder {

        private static final Decoder DEFAULT = new Decoder();
        private final Map<Character, Integer> map;

        private Decoder() {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < BASE_62.length; i++) {
                map.put(BASE_62[i], i);
            }
            this.map = Collections.unmodifiableMap(map);
        }

        public long decode(String encodedString) {
            return Helper.decode(encodedString, map);
        }
    }
}
