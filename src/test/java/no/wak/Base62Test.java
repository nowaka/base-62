package no.wak;

import java.util.Random;
import no.wak.Base62.Decoder;
import no.wak.Base62.Encoder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author adam
 */
public class Base62Test {

    @Test
    void testLoopEncode() {
        Random r = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            long num = Math.abs(r.nextLong());
            Base62.getEncoder().encode(num);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    @Test
    public void testLoopDecode() {
        Random r = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            int idx = Math.abs(r.nextInt(dict.length));
            Base62.getDecoder().decode(dict[idx]);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }


    @Test
    public void testEncode() {
        Encoder encoder = Base62.getEncoder();
        Assertions.assertThat(encoder.encode(0)).isEqualTo("a");
        Assertions.assertThat(encoder.encode(1)).isEqualTo("b");
        Assertions.assertThat(encoder.encode(61)).isEqualTo("9");
        Assertions.assertThat(encoder.encode(62)).isEqualTo("ba");
        Assertions.assertThat(encoder.encode(100)).isEqualTo("bM");
        Assertions.assertThat(encoder.encode(Integer.MAX_VALUE))
            .isEqualTo("cvuMLb");
        Assertions.assertThat(encoder.encode(Long.MAX_VALUE))
            .isEqualTo("k9viXaIfiWh");
    }

    @Test
    public void testDecode() {
        Decoder decoder = Base62.getDecoder();
        Assertions.assertThat(decoder.decode("a")).isEqualTo(0);
        Assertions.assertThat(decoder.decode("b")).isEqualTo(1);
        Assertions.assertThat(decoder.decode("9")).isEqualTo(61);
        Assertions.assertThat(decoder.decode("ba")).isEqualTo(62);
        Assertions.assertThat(decoder.decode("bM")).isEqualTo(100);
        Assertions.assertThat(decoder.decode("cvuMLb"))
            .isEqualTo(Integer.MAX_VALUE);
        Assertions.assertThat(decoder.decode("k9viXaIfiWh"))
            .isEqualTo(Long.MAX_VALUE);
    }

//    @Test
//    public void testEncodeBase26() {
//        Assertions.assertThat(decoder.encode(0)).isEqualTo("a");
//        Assertions.assertThat(decoder.encode(25)).isEqualTo("z");
//        Assertions.assertThat(decoder.encode(26)).isEqualTo("ba");
//    }

    private final String[] dict = new String[]{"gsWV5BWri1u", "crlsiUgoc2r", "kDMNRAeINLM",
        "kvRVOAmUiPM",
        "g6W9uPfaURd", "hMQ5fYSDTbN", "6GFR4ILtwG", "fwUtGVyjNDC", "h6rFDAfGPoC", "bu92qtmuL4s",
        "uk5CJVRVd", "jdqNHv5dnuN", "bt4dJYN4JDW", "hVEDibhgmZT", "bPsDjf94Aot", "ipdZsT3TOu5",
        "bPTUz2ksmfg", "cVQyi3pvOIy", "be9UiV1TBEH", "d4S8Tr0OygR", "hO36Jo7Bp2W", "kC5SVYwwrYP",
        "cOA4um81lEk", "jccj0YNzvFr", "bifVyF5WaIu", "czmKF08YkD5", "kgWyilq1u2f", "eJF18ljpcy5",
        "dYzFhh9O5PL", "jlxhjG05h4G", "g6UDl7r7hIO", "b5oo2xQICpy", "dCEjIkAQfh0", "b5cHziVXrp0",
        "irZJwuVmsXp", "gDtXFKGhGHO", "hRxfdG3b5AK", "b9SRBa3vBmm", "jRfdvWeLlu7", "duvH1j2yCSp",
        "eYajlh4XEFp", "fkz09M0Jwe1", "bUi4wK4a8lN", "kCsxo1GzdpP", "f31Knjydg1G", "gGTev2kGs88",
        "o7P3hnKaqg", "kqzdjqUUX7s", "KqRy8ssuNF", "bbZeUtTl8Kc", "cjhKQlhKwB0", "jxiME3tP7hN",
        "jV2oXuR3XZF", "jMgvH6HTDRd", "cNjR6yVGiSm", "ixnBxbPhTt9", "fTfwpKl3CyQ", "jwUDJ0Vrrvm",
        "dxgTf04WPpr", "hxAcQ0iKDDr", "VdO0QIqOzP", "f6VGg7QsaXY", "hyrJbhaovtf", "hm9um90tadB",
        "gQjBpD11Omf", "b5O8l3AccGN", "cjra5mdsTXq", "cOIhezDaFWR", "i4cg9qvwkYp", "gjGS3gLKQz9",
        "brx0pwJgYr9", "cAu2UPgLxmH", "handrJykqPd", "bN0bHDYZUhP", "fAxzPyrQDum", "gZSmlNBZqXo",
        "esfEezbth58", "bErSCuK4IvH", "kUiynfBgOxL", "cBcXgJoXN8O", "egtLwHSf7wL", "cwmY4ICTmi6",
        "dtxcxge9hcz", "iKkxlqSCNdn", "flPeHyO17Rk", "iYrvY9dcnc9", "iXcTFp5LisM", "c156falwWSj",
        "h9W2svEFaCK", "kJ13PyOaBXT", "iK61LZsPHaj", "bLB4zMi4VTW", "e0wqNkAc3h0", "dvfLOP1acez",
        "b0X6rImftDC", "itoRYVFzC89", "emAiBr32oDJ", "cfvjs32hy8w", "hGHAwIVvkkr", "caNyU7i0JoY",
        "bD1b5GaBW07", "kKF0wlVenfw", "cfmJSHtLJtx", "ezNd8WcKum2", "gEXINcn9cGd", "htOKKHys2GR",
        "kSM7VIzrpSo", "jrPhhHbq1SO", "hZv829wlDgL", "lYzMXZUfRl", "czuCI29T3BM", "f9XjsQfNArJ",
        "eiQYHMJ2wxF", "RkZZveKxCB", "hknVf1DJfE8", "gr7V7QS233X", "iVmBICrlB7g", "EVYtxHEX1z",
        "iA9qhFF5z7o", "ttsBRam8vM", "hUXUtk3bY3i", "bfeDAmXHWWY", "gmMdfj6FXjr", "eYm6DyxURG",
        "bxOr5f11F7a", "hAFcvYyloei", "fO7ggEchxoR", "b4dJp8GobAz", "jgs2sDerljB", "iuLzsqHbGQA",
        "icl32pZY2dY", "hxPhvTX9euS", "iVe17dNfdws", "cKYzNQcUxSl", "7ys1RC7GxL", "gnMavOvW65Y",
        "kfftYjHvBHd", "eaDv2zQulJJ", "cCJ7henodYF", "jqBbmaAtBz5", "iX8v3dBOGVE", "d2fVnQuTg3B",
        "j1QWII6B3F", "bf7sexMm9J5", "gM62xbkC891", "g2yPjYOkw4r", "hLjjAPbFt9B", "csDbpIUCQRm",
        "buTT9KN1BxH", "jaJLtDMQOpQ", "bdGTtFSFpuY", "d4rEPA2pcZj", "ixhTdPfROES", "iiyHMSNvuvt",
        "gRKWtzXSjas", "eLhXcA2oRVo", "kLqUlDmmb4b", "fx6SFmn5XSr", "hvu75mPl2tA", "kLXubZiD74g",
        "jQpUIsa6P1D", "fmJY0ADL7gC", "f9LYRGQWj2x", "iWgZ1fxw76V", "grrDisM9Koc", "gp7HULYlp23",
        "cNERHiZB2dg", "dk7PuiBcnRE", "kWXqWx6cTgH", "dPWE9HvocYm", "gP5elgzm645", "kUc2hVhNXbw",
        "eDkWyQlkD1I", "ib2UGWPTUct", "gQ6eT2BHNBu", "fO4Ql0lEo1A", "eGL52zoefqm", "eaZaCqV7UNs",
        "gqHSfCtqo4R", "dXT8mETh85c", "iKarsze7mEw", "dTsGKAKGimr", "kB8HHO4Nqrh", "jnUin9V1Gzw",
        "j0zaCuF81tm", "fVCvS9euCu7", "kUtTXIDbN0Y", "idpZT9AmpDo", "j1ntWvQbjhU", "62gn9J3Pgy",
        "gFw8N4vai8W", "ksmCqq2Uxn2", "cAg8Ad68y1K", "x487hK1LDk", "V9MQOlDxST", "hChreU7BWqr",
        "kb0cMJTElsy", "nerBlQrdAv", "gxwq4BUukf1", "cESbQPyDWok", "cul0u4YgPbw", "f1KnB0wurgi",
        "jqjG5CisBiA", "hxd3e7tcqe0", "diP1UgXiVnm", "jati0rbkRXK", "QaKKHEBlFw", "jzBfSFKGzDO",
        "gtgKyH78ub2", "bxwTwC3KeIU", "cbxAz6jKmGe", "g9W0IFBwpf9", "iiMzxWroMOJ", "isZsPl5RPGW",
        "cxatUL5YRRc", "LcAcvDPTNZ", "gibi3Gk4QQX", "k1WUIOqGduR", "bWVZsyY0Or", "gqip541zQDN",
        "jpzsHI7DTHH", "k9fz2qjYzNI", "kPbFOplQhEq", "hRILJAv5QXr", "ghip2VP2DvP", "b4YMrJAvVSQ",
        "knbv8GtarpT", "iwgTFSlLFdR", "ZuXLXp1PuJ", "kLpW4pvV1st", "kT9OJl88jN0", "bshkHg9Buf0",
        "iy0nV6oLKo7", "hs7qyVhI6Nl", "bbZExMFdToh", "gaQEDS9UoBK", "dbQZrUJ34RT", "c0BOsonHJCL",
        "bUkR4XiywkA", "gpSMzxCr45q", "d0OTZPEzkSV", "eNOolzrBEXr", "j5Ki975KJtF", "b6nfvHbg9SD",
        "cPABm1XuSsv", "hZ1BzFCRjzP", "eCQU7JNabil", "cp0ODGzclGP", "enpynMBy5gu", "c7nM5DRxNr",
        "eNzZFVABVwi", "dWMYziPWX4G", "hQGVDaBIoVF", "c0JWFgNvOr0", "bsft63oV5IS", "fagANNrv6dg",
        "iNyerdBQYCW", "c6lzpBwXVst", "kgZ5R1yWaA3", "eAC9TilMy1I", "cZM4gkxm17x", "dnP4dEhZCCe",
        "o5LACPStH7", "j8l7N5lzfSz", "ilofrYLjER8", "eNrjdxhgNB6", "eRJCXa3HBW4", "hq7tIhKasru",
        "bmSo4NofMed", "iTHtupef5Yk", "iErbEzxMAUb", "hzQIOWsmWIa", "gWdDkbvuZrL", "iYgy2yUBfxL",
        "eWB2cfPTnap", "jmtNmY90kJS", "ii49lmPA43S", "fBxrJFMx5nd", "fXtMrFxIvfe", "g1hWs1PzZ0f",
        "dwy3bV6Ga2F", "hhVlU0Ep1uH", "fy7J7IlgC1q", "dgAZfAaoGR5", "bKevq1DwMg1", "ejQITBwSyMQ",
        "eBOLclGRbQ0", "isZF5H7gvxp", "c3IMh0nvmIz", "g3wJAApJUrS", "gv0MHllKT1E", "eJcFvgaK8ie",
        "jQkgkXloqa8", "jkqhVMdzA3W", "c243pqIfIie", "eEMGr1XeNSA", "edZsz8ioWyl", "e9u6wfK50eq",
        "d9X4oUF7VQe", "cw4GbihGyG8", "gBDYf5hC7DR", "e6dgqFzaYEB", "kYWOgHEEq5p", "b8rqMlcIDEC",
        "jYwoJ6VcKhQ", "gg5ARoTty2v", "SxgX6YJIG0", "joWiLTvSlz0", "bhGRcmYtIcG", "efs9U0VgD3s",
        "hbk7AyGPOes", "i35MNdRTRAr", "gI2vlODcQxZ", "hFYWv1XFPud", "heIDYNJEZEp", "jyyvIBZ1lD2",
        "bdjAQbFwgJB", "hxRGtDAyjma", "hrdJtzhH8Y7", "b3w1bTOSHdt", "gUy16UAYUtz", "hviOXntWT0V",
        "jLkrWVUbqcC", "fijL2IYkP01", "bmPsJ41FFbL", "e8zrMrYV9v5", "jQaULPGH4tO", "fxJPl0SBYGJ",
        "eoV1fewbuy9", "bnzeyCLTJLS", "esQX1zydq1s", "grRsLIzRbHw", "QfW9gXsYnB", "f5pUvJM4Q3e",
        "evUdoWjEUV8", "bnaTlP9DGH9", "iTVACz3ZWtK", "sQlUXRy8L", "hFjCGEUpbD4", "dwJsXb7L4Wu",
        "EZJHORJZUL", "eLscA0nGDII", "ihbvQip5g9y", "eskKSDJWT1X", "dFLgFKDruHN", "kJ5evi1SYt8",
        "cqzsb6ZNYBZ", "cS90lV45Hnc", "ipiyrWjTmhZ", "l3A6ys2nuh", "gVgJZidDXsc", "ezzB7a6EQ59",
        "joQhZVyXRIx", "bcocoMHBIfa", "ba3mAP8646N", "h8exNOWVkF2", "ipgSApna05b", "ckNEYbANApe",
        "hUwz9oxfih6", "ijFPOhASBOw", "fkTnxvajDjb", "goL0hX5YZzy", "cub6wQmoIrA", "cdznGAHllUD",
        "iKgdo9HQcgn", "kKbXj3buAvQ", "fAypXNIN63t", "jrWlbLm3g9Y", "glCoMm3ngE8", "dJrAMPzDDpi",
        "i4NU31eES37", "bkAcYZbODua", "bXj2IONkusn", "gvhtJ8U3jxz", "kyOnmyu9jl0", "6tXdAxqMV1",
        "dYQ1i7sWXvJ", "hqbvxgQ7HNr", "gbR43c213mt", "edhgFoPo20A", "bIvxvvFTd7I", "RWFVZpNs6m",
        "fH0GJajAmQL", "f1pwl9CvQoX", "hYSmeLws1TF", "hqq5tx8flou", "jKPcClqrLrN", "gSJE53xQj7c",
        "iv0Or0Lk86W", "iLOkGeJ1fMK", "hIodLi9x3mj", "hxuB2wdAZSc", "bAFFJEiO6jV", "d8UMpp4CVKq",
        "iGk4UzeaWP2", "fniIetVMNDk", "ilwPCPKFvZi", "jPSIp99dP1Y", "hewY2jQbYqW", "jhK4j5xJrGN",
        "pKKMHYxEWw", "haQLReyOPuK", "b1aJwaa3Zn9", "iJOvPDPCBix", "dg2KWBhjTzo", "eH8ZYYEH7BJ",
        "hlY1bHceh5W", "b9PAKhp79M0", "cbgwJfnhusj", "eoeDLoe2gfD", "idepS9x2YTO", "hIdvnlMuibe",
        "kQHn41e9BsA", "gGBSAFr8F1d", "i28JVi7RJIr", "jd3nePpnOXJ", "hzeEfCpAg6x", "eUX1hLEyPwe",
        "gYBu8B4izua", "kIVEtfos2PV", "jL70kv1y8TC", "jOs4QVMIaGH", "clKoG4kgtIv", "eZTT7Y7Adc0",
        "hQZ7lFYJriV", "IlgnkF1K7k", "hdNu8iv6cWR", "c3QyrN8leYr", "cAAPxguMCcN", "eEH6XxLsECc",
        "hZKjRQxoyaO", "ko0BcDtDfFh", "c4Fbc9pPXDI", "kJaFjTp3feN", "kXDhQL9XZoq", "bmQGReZX8Sa",
        "i8ucQW5iP37", "ct927GoXjF0", "cIRnrIdqHVf", "ig8xMhYwBwJ", "gMjASBfC5ua", "i8uNzLsTmu",
        "dSuJk6XORCm", "jRhghHCzGNc", "fbh9Hofxihd", "jlb4fa92wLw", "gRsJkz7ZvCQ", "kLW53SRFRhi",
        "beJZnHySf3M", "f85AcVKKD6w", "f2iJ5CYwEUs", "jkeiF1KDOoD", "kUJbqbnmVbi", "ku2l0XhjaOD",
        "hqcEvrp5aTM", "kr8n8fU32Qm", "cf0Kf9MBfV4", "ka7TJuwnuxV", "jJZpy9jriC5", "cNdy2ktF28z",
        "I9JpqT3kmS", "jcbM58S91j5", "dDRDBsUoEKe", "hXpi74RSBHP", "cCqAsWJlAaD", "fwjC4QfBqcN",
        "cxjujnazSFc", "z7OmdSZ8mB", "eWZ8tydT4Pi", "bsUoa2ZcsCD", "e3nSoRUlitM", "iiAmiPLQTn5",
        "eBknfQLh4HM", "dMzy85oNjrg", "idU6p8AsXWl", "e6csu9zHYdp", "bKNEi9lxgZD", "cXNY0RoVEZq",
        "jClzXNMr9pk", "fslk071Kxal", "b8bmD9tyDhN", "fdL1xDgVQ7W", "isyyN7ya3iq", "fR9Mn7ibv2R",
        "kgXKG9PJrLb", "bYx4k9FgYhJ", "iIIVctun5PT", "ijyZmaXx7lf", "ftRZXksTU6R", "SR1B9rpRKa",
        "kZelB6anXJe", "dtKfgcra5g", "dDaZ7DWx7CG", "isbmeGV4XTr", "k67v6RE18Ua", "hAuRzGol51P",
        "ia6NwrKlapC", "e1tRZfvJY8g", "hgOAtIQtjPY", "hYMS7KUvD5s", "keN25VN13nq", "bFjt1e1BbY6",
        "imyZblu5qYn", "fMymSqfG0L8", "hzkeTvuqJ4F", "jqQZ2vJunMU", "k0xbD65zMz1", "eJeruCKDmFR",
        "kzNilNuX3Xk", "3AeQ9IdErO", "dmpb6Dp2tHf", "bLcDcbATzPm", "eSSDEgDlQJy", "c5s21DRgDI3",
        "dc5kBuV2sNe", "emlDzj7Vsz2", "expRgg6NkPs", "W5caiE1PyS", "h28pw1zt9Q2", "0nUlQkTpKh",
        "gSmDRTHYQt2", "kbHSpWLyWRH", "fTCknghKpbw", "b2rUlOS4Cos", "fCJvEjSEZGz", "bKsdVwu6QXG",
        "dtoOKWvqNm0", "dRgTkkYkQpv", "esdoHMFkGH", "emVmsnncIrO", "jUC6ftMgral", "caTlEgN0Vy5",
        "gHTuPYMaeHD", "hkw6mYba7Ck", "ibpMzG6oVZa", "ksnlt5zElNe", "f3jWFpmtrnx", "e6sFhmzTLW",
        "isHGj1Sf7ry", "xuMGIruA4R", "hNuXspLkZ0e", "zlJry9VJng", "eUdTQgCPYnj", "cgp201E5VDN",
        "fwWUaIK9xRd", "c6IznLzUNgY", "dDBLDF74FRL", "c6CsX20RvU1", "iOszGvxqt0O", "kiQ2TR3aqvg",
        "bhvJXnF5vqw", "W0lB9uwufW", "jE2B6ewSLeB", "bv0JxnSevIu", "d8NHY1X8wuz", "dFPHSuGtc8I",
        "bVcmfeiansL", "ePdRE632Fd5", "edDRp1u2GRN", "d5BXFIb9MLZ", "ghEed1gybm9", "cYUXh8LGMqO",
        "g8N4HlZWxcP", "pZB2Z55HvD", "cBhTcRM5Q3H", "5tzqUfRgNw", "xOnSV7U9VY", "hjDZyEJ2hye",
        "eEFmtY5rFi0", "jygmGVjt5kl", "cbLUTRcaN82", "k2Wfdon0cpc", "dZKdhNBv8Y4", "ccnwCX1UVWS",
        "geUX4gypQ4q", "i1q91X0LpE5", "fefuxm5MnwN", "kk794wh19Lj", "hCO8eTkLP2F", "jSbA3asUBMh",
        "ecsuOBoD8YS", "ilIG6Jv5WV5", "dmzp5zGhCB9", "eyvfSwpj2xv", "kNp6tRZN4Nr", "fDfGykP4jNc",
        "jqa7SiPhvU3", "iEblWtvBWcx", "bTAeX3280pl", "dauWBRUoa3P", "jivBaOZwZxO", "fMQNpeIBHKw",
        "j3fJLxiBrSm", "e8RtGNUkh3k", "fzPfCq3Dyv8", "cdp6pgVzA1V", "gU3v758Wtac", "gGJKc7TlMg8",
        "dQTz7aOzSza", "jc3EVlEMlRs", "ixm3WFcBHWQ", "g7jTUfUoKi6", "A70xphnR4I", "hPkmhGUy2Yt",
        "bdPNQ29J9W8", "geFEyLm0WZt", "bExykEyZRUD", "3pQtIy6fHr", "cEeUX9qF5hI", "fiY45N4gK3S",
        "g8LCM3exrVu", "eSwLP57iWs3", "knqRObFoKvn", "gvUsjepwJTz", "c3AORu6eJbz", "eYuFfRvxf27",
        "d898B0ASRgt", "jAaPWVOWone", "dVYVwCdzpjf", "bQ7ZVUfrRta", "h5B8habEnYC", "f60YmqYTTvN",
        "eb1Slbauj3r", "eoPALxtpPWJ", "fg2d5C4lg6C", "i6Q3ZP5j5Jv", "dlTOM17jFa7", "j515MZvN8pV",
        "iPlyzUBL7SA", "ibDvRb891ZK", "jMTxSBBrd00", "dzKhQT8m5e9", "efKlBPl3FOW", "h4ITYLXARD",
        "f79caU0fwCc", "gAlox3iRRf7", "ijL9YxqDLp1", "e09pma6byFN", "g1x1oSARHUY", "iEs30Fcw4iZ",
        "eCmkcJfm4yW", "juGm6QCJYUY", "lBsfNkRGcn", "foWCrhohVMu", "d0KY0V3QWDP", "fZjCg58twTI",
        "bmaN7WhRS6M", "QFviFltPfI", "ezkuZdaf3xP", "c4AgEKkAK3S", "cYCp8RtUZ07", "QjYM1lyjhD",
        "jscMCnhvAh6", "fSsxkhRkbuV", "eRGIhVCG3eq", "g1xZiJBDnz4", "j0qjbRVM3jL", "dUcXKFoUoOV",
        "fcestSvVn4N", "cUNgHoeB9Ya", "gpmODiT8PQh", "fFblDcnF9Jq", "jWCdKTwyfUY", "bGi6xfdkqOe",
        "1qxAiq7sQg", "e3YaQryP3bi", "hrPR21JUvLu", "bQNPkGTPEvR", "h3uJm2p0lzq", "d3tplQXQj70",
        "eLzNIEW9ynx", "idjG5b4SNVL", "f2Hv1DyO9cr", "b3Ub9bKfumK", "hdY6RhzHxVX", "clwtJFCDoYG",
        "dgneOPQdCZW", "fzUWBikUXGQ", "rcGmiorhxG", "j7qntmGyjSa", "fLW8agCW6mX", "dh45q1ifWar",
        "ioqMOwLd7Xi", "jaMT3pFuRZa", "kRtqEUC55gT", "iHLf5TIe0L1", "bN1RzhWgZ9a", "isarfq5ESGI",
        "fMtyIQRXxLp", "fF8jug1fltG", "hmMzJJsidtC", "ijDHMDA1T49", "kA5y3f0wzam", "gSLwRGwD3DH",
        "jWmmUiUTLrV", "uQ4jKRwTMH", "zFR0CpQfWR", "kGLF3e6THL8", "fTCs5pZtYFF", "czn4MprXSUS",
        "dPtf6V627VZ", "kOeY1Er3tmK", "cMq793M7aml", "hPJkPoRkWC8", "fUbWyYdB2Sz", "gOK3QPDo2Mm",
        "ht4e9kuxneh", "c17hP2puG8H", "bhVeFopikrD", "hKRf4J10yPm", "kRnebALDXBL", "enhG1ksBvgl",
        "iQCGDQHI5ge", "pV6uFJilqN", "hPu37cS4epf", "ivxRA0alQbp", "jFtNzJELjgz", "dwkGAP8QQRf",
        "goqfF4XV9BD", "i5wKk0ai0L2", "fechSS96k5O", "idwwcDllQrs", "hxFU8JBmfH6", "f8LEpmVb4FI",
        "9dcJemZdTN", "b6oZubRTiw6", "ic40uMptmCy", "g5nLQ1UxAYm", "fsnlg62udbc", "kjrWJIJkFj2",
        "dfz8CR2UY0a", "cPWjRsuTOHO", "jSaN1WPq1ce", "dv5tOz8yMtH", "kwt5bWrgGCN", "lwRYkppNql",
        "bKYUMypuyaU", "ktwdGtAvEGU", "etbNpHchqsH", "djobFZVZAgU", "hV5HBakptlX", "ehtk0sP4xIi",
        "he6TIxzrJ7k", "fez8Wfz3bPV", "cFfnnm2CXCR", "hf4JF6A3qgO", "CDOxLl6ybE", "fsitxHsLBx3",
        "d0EQXk93GWG", "cBlWoi3Vjto", "b9Ci0oCWeco", "TnsrFZbvMS", "t0AUbJ0y3J", "kwXDfzpfmZ5",
        "iXUH947ZM74", "ZP6JUGq3fT", "ibGr3y5Kej9", "idnAoNBTAO2", "holWg9FQiDD", "fSnzVMh8fAX",
        "sDy17LSBE3", "j6EOBDTaMYy", "dVcHxrWfV6R", "dSkOxII70y1", "iDqkFZuHbbi", "h7MaLrYNDCZ",
        "QQ19TfcMLR", "bTvBhb8rvTI", "ft1PajCSga1", "e3E03Aqv6hT", "inI4pw3iOdn", "gp8ymK3pKV2",
        "jOFAAFuNnvy", "dw7NFxRUX7E", "evn8Av645BX", "jrOvJlec1mA", "iEvpDXQD7G2", "kzqJed7sYjf",
        "gbMVynrv6dZ", "gPijluThndd", "fbUbF4L7gw", "hEGMLJP7Jfd", "jI0F3DHdtke", "dWo0EV61G4k",
        "iRK77oAAFm4", "fX1KqYbwmDl", "cNgBawVty9L", "j9W2Seigmtp", "bGFRXcbYVjY", "fzW0AcaxeuX",
        "flWZGwfn5XS", "ilvlcFIqv6d", "jpgiecpHc8s", "cgiHLrvgJFu", "gRBbiYc4ROw", "dkSSXX2I55O",
        "gvMbxFMwb8K", "gBaInuzuRzf", "bNe5nPQt7iE", "WRaCZr2loZ", "jyjwNtn2riX", "je6drXkNj5m",
        "i7G1FcLcriB", "k5oF3zoJu9", "kzmc34gccWS", "fL5ZaCQRLUl", "2AIEZ4WaG5", "fbe0Yy3S9WP",
        "kRBJ5iCONqw", "cxxhmSIy5MH", "h7LlRwNDhp7", "iuiwJdaqgET", "ezHR3sJNJkC", "knb85f32XSq",
        "cz0qyKlNINm", "jF3ucDAJ2fS", "erJQsXVPtnZ", "bwl5c7IV69z", "e10nSaRtExn", "fUVFdsLSMaO",
        "kLJJhG9WOzS", "fzGUCouMUgT", "jRkJbANHykQ", "jiRodr8lLGd", "uejTlq9u11", "gqR7jxb0iyY",
        "dU2PI3pKuXg", "9svIQAJtRR", "iN4zI3v2KbO", "i0TiLZCcvi4", "h6M7tFvqoNO", "h3PVrt3aHct",
        "kEAtYCpeTha", "d5Gz9vuFifr", "iM0d1vA5MVS", "b8qKcFgeSFU", "dPiCrxvvlEc", "c0fIaO5OCeu",
        "cfPHkWf9UG4", "C4fBxvYcvq", "bGuOSsrd1TF", "jP9ro69shhP", "4K23GsiFxe", "bfMU9hWa3dt",
        "jg4pOtQA4hW", "jEpwLxvzoYC", "hGEfX9c4Kdr", "e2zZbYgQUfd", "k1dUOqgh0B3", "emmi6i20aCt",
        "hzbeh9BMipy", "hIB20fPEDFa", "eiGuMjdYeDr", "f0WoNfChWFL", "h5tHR24AC98", "dBDOMtiQN6C",
        "hx84xEyihit", "iWjL2nQtchX", "fFNrwfywy38", "hhbu7YBBWS5", "fIMEdJjfXNg", "eERGK4Gq5Vc",
        "Tzp17Rtsiv", "eLcZUQNoGHV", "fHOgchKVSs0", "dH9DqdBIP6Y", "ipIBiYhoYrR", "bIT7HyMKYnv",
        "cJqoCSsNeVF", "fzFUwCzlSGj", "jCJvrwADwgg", "dIP7P0N0YZL", "h42VOQxrUB7", "jBGvpWdkLj9",
        "dTk0vv8gi0Q", "gnHIfkDyGEe", "fwcgtGtuVau", "dBEnOO4hrWp", "iyZA8QJXEi4", "bNBzrtWunMY",
        "GjdXJFD6pV", "kC2tMR9LxE4", "dPr4RdrbKWh", "k0nEkLoMPqr", "rTPEanUuwF", "fHq8gItKUBb",
        "jJkbV6D01KA", "cWc8nF3d4bM", "flDqKqIohvd", "j2vQPVkKGAM", "eDHC4vTJadI", "fEpxXgu2Nwf",
        "ivhAba04ePS", "2Tiwo0vlDF", "ekN8l9bZDxo", "b8ttAcFwIEt", "bYjKFAJ6LkA", "kVKITHoslZI",
        "bNWXefEKwsq", "iIzMIFQxx76", "hxkUsNVLNxj", "db9472DojWi", "drFQiGyKQ8V", "fZFiuUWQuyn",
        "bVoFSffRuaV", "jJ9wRYNpTsN", "fh4RKqj9BPj", "k7j8Ixjsy9L", "hVuKDK9xfF9", "ijTijTWYMUP",
        "kB6NAPNhSY0", "bO3u7Gc225b", "eYzl08eIi2H", "kWb0tTIVs4I", "khjoV718VG0", "jv4uofIDeBr",
        "iOUpez6kn3u", "eWf4qtxYtUC", "ArthBkgf2k", "iv4Vkr2Rk51", "jwDtwWY20mr", "iCH8Dhya9Ek",
        "AjOqdhWUeI", "f1mnJJEJrNr", "Co8ntkaMoT", "eudNW0FDPPo", "dwgiWeDRdck", "fwcqXgJa2nr",
        "gkJxhgRIHER", "iitRahCsQH2", "dmngIJz9g8A", "k84mXOvC2rS", "kgJOShYt6Dy", "EX6RWSe0a0",
        "erf2EuhidTN", "bN04ryi7ym7", "fN4PjM5Kh3a", "dl2NCnt0OLT", "5cBBYVdAln", "fGSTfE34AGO",
        "jez474dMVjO", "gxYwDbCVEay", "c2SzLsiUgjN", "iI2LeGLbrB7", "jndPMBjzuug", "HqMDL7kuAB",
        "c9CAgLDTmBI", "ja55jnfMBmo", "eUlKFRMrgoD", "jb0Ap7wtUX1", "hdismM25Fbv", "fg1wdWqsZ8m",
        "getyLdQiRd4", "hjWslsHlktR", "bffAgASkLf", "jaXPSDA2GLL", "ei49ZXGqUvs", "kZt4auKnbUu",
        "gBKHsZjSJtM", "hXZeV2uxaf8", "BNeHdhz4Y7", "eJ67lLypq1S", "eNieI6p9pMn", "hK13CLIJObK",
        "cdRIB5VwYlt", "gLfwEQTpPS2", "fxgXayCiwWI", "iKrpeDVbZaz", "dpVQfJZLVp4", "NmNXIkvW0e",
        "cLtVylnLGjI", "gBzjFUw4duI", "ic19aDjbljN", "crTE0RrT4v2", "iX91oiCgHfB", "jJ1WqHXQ1Qk",
        "k2VWS8bpfsP", "e7p7qjcPhl3", "hn10CQaDUmu", "cTeTzOQJ5v7", "jx2pUUwKZHc", "fEBlKhYLmO4",
        "kv4odh0gAA0", "cemVX5xZhHB", "fgroEs5kDPl", "cHeT6o711zv", "cU64uaJGYb6", "jDUTUu0dhw8",
        "bxrAAOUQLN6", "g73xUinq9JJ", "hmu8LhxzBW2", "dvzo2ceQ4xv", "cJL6RS8PhAU", "bqKkUQgWA3i",
        "bnmoghHu0ef", "jNmFR0oDLNI", "iVgC1QSLP0X", "ftH4mFgE1Z0", "gpLTEev9o2J", "bWt8RpJcDG3"};
}