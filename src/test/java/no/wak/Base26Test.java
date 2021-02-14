package no.wak;

import no.wak.Base26.Decoder;
import no.wak.Base26.Encoder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author adam
 */
public class Base26Test {

    @Test
    public void testEncodeBase26() {
        Encoder encoder = Base26.getEncoder();
        Assertions.assertThat(encoder.encode(0)).isEqualTo("a");
        Assertions.assertThat(encoder.encode(25)).isEqualTo("z");
        Assertions.assertThat(encoder.encode(26)).isEqualTo("ba");
    }

    @Test
    public void testDecodeBase26() {
        Decoder decoder = Base26.getDecoder();
        Assertions.assertThat(decoder.decode("a")).isEqualTo(0);
        Assertions.assertThat(decoder.decode("z")).isEqualTo(25);
        Assertions.assertThat(decoder.decode("ba")).isEqualTo(26);
    }


}