package cn.birdsup.poker;

import cn.birdsup.poker.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import static cn.birdsup.poker.Poke.Color.*;
import static cn.birdsup.poker.Poke.Rank.*;

public class PokeHandTestCase {

    @Test
    public void test$base$1() {

        final PokeHand expect;
        final PokeHand[] hands = new PokeHand[]{
                new PokeHand(new Poke[]{
                        new Poke(P5, DIAMOND),
                        new Poke(P3, SPADE),
                        new Poke(P7, DIAMOND),
                        new Poke(P6, HEART),
                        new Poke(PA, HEART),
                }),
                expect = new PokeHand(new Poke[]{
                        new Poke(PJ, CLUB),
                        new Poke(P4, DIAMOND),
                        new Poke(PK, DIAMOND),
                        new Poke(P4, HEART),
                        new Poke(P10, SPADE),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P3, CLUB),
                        new Poke(PA, SPADE),
                        new Poke(P2, HEART),
                        new Poke(P10, DIAMOND),
                        new Poke(PK, HEART),
                }),
                new PokeHand(new Poke[]{
                        new Poke(PJ, SPADE),
                        new Poke(P5, SPADE),
                        new Poke(P4, CLUB),
                        new Poke(P9, DIAMOND),
                        new Poke(P2, DIAMOND),
                }),
                new PokeHand(new Poke[]{
                        new Poke(PQ, DIAMOND),
                        new Poke(P9, SPADE),
                        new Poke(PJ, HEART),
                        new Poke(P8, SPADE),
                        new Poke(P2, SPADE),
                }),
        };

        Assert.assertEquals(expect, ArrayUtils.sorted(hands)[0]);

    }

    @Test
    public void test$base$2() {

        final PokeHand expect;
        final PokeHand[] hands = new PokeHand[]{
                new PokeHand(new Poke[]{
                        new Poke(P10, CLUB),
                        new Poke(P4, SPADE),
                        new Poke(PA, HEART),
                        new Poke(PJ, HEART),
                        new Poke(P3, DIAMOND),
                }),
                new PokeHand(new Poke[]{
                        new Poke(PK, SPADE),
                        new Poke(PJ, SPADE),
                        new Poke(P6, HEART),
                        new Poke(P5, SPADE),
                        new Poke(P9, HEART),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P9, DIAMOND),
                        new Poke(P7, DIAMOND),
                        new Poke(P10, DIAMOND),
                        new Poke(P5, HEART),
                        new Poke(P5, CLUB),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P3, HEART),
                        new Poke(P10, HEART),
                        new Poke(P2, HEART),
                        new Poke(P4, CLUB),
                        new Poke(P8, HEART),
                }),
                expect = new PokeHand(new Poke[]{
                        new Poke(P10, SPADE),
                        new Poke(PK, HEART),
                        new Poke(PA, DIAMOND),
                        new Poke(PA, SPADE),
                        new Poke(PQ, SPADE),
                }),
        };

        Assert.assertEquals(expect, ArrayUtils.sorted(hands)[0]);

    }

    @Test
    public void test$base$3() {

        final PokeHand expect;
        final PokeHand[] hands = new PokeHand[]{
                new PokeHand(new Poke[]{
                        new Poke(P3, HEART),
                        new Poke(P10, DIAMOND),
                        new Poke(P9, CLUB),
                        new Poke(PQ, DIAMOND),
                        new Poke(PA, HEART),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P5, DIAMOND),
                        new Poke(PK, SPADE),
                        new Poke(P7, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(P2, HEART),
                }),
                new PokeHand(new Poke[]{
                        new Poke(PK, CLUB),
                        new Poke(P5, CLUB),
                        new Poke(P7, CLUB),
                        new Poke(P9, DIAMOND),
                        new Poke(P2, DIAMOND),
                }),
                expect = new PokeHand(new Poke[]{
                        new Poke(PQ, HEART),
                        new Poke(P10, SPADE),
                        new Poke(PK, DIAMOND),
                        new Poke(PK, HEART),
                        new Poke(P5, HEART),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P7, DIAMOND),
                        new Poke(P2, CLUB),
                        new Poke(PJ, HEART),
                        new Poke(PA, DIAMOND),
                        new Poke(P7, HEART),
                }),
        };

        Assert.assertEquals(expect, ArrayUtils.sorted(hands)[0]);

    }

    @Test
    public void test$base$305() {

        final PokeHand expect;
        final PokeHand[] hands = new PokeHand[]{
                new PokeHand(new Poke[]{
                        new Poke(P3, DIAMOND),
                        new Poke(P3, CLUB),
                        new Poke(P10, SPADE),
                        new Poke(P7, HEART),
                        new Poke(P5, CLUB),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P10, DIAMOND),
                        new Poke(P2, HEART),
                        new Poke(P5, HEART),
                        new Poke(P6, HEART),
                        new Poke(PK, CLUB),
                }),
                new PokeHand(new Poke[]{
                        new Poke(PA, DIAMOND),
                        new Poke(P7, CLUB),
                        new Poke(P2, SPADE),
                        new Poke(PQ, CLUB),
                        new Poke(P6, CLUB),
                }),
                expect = new PokeHand(new Poke[]{
                        new Poke(P10, CLUB),
                        new Poke(PK, HEART),
                        new Poke(PJ, CLUB),
                        new Poke(PJ, HEART),
                        new Poke(P9, DIAMOND),
                }),
                new PokeHand(new Poke[]{
                        new Poke(P4, SPADE),
                        new Poke(P8, CLUB),
                        new Poke(PJ, SPADE),
                        new Poke(PJ, DIAMOND),
                        new Poke(P7, SPADE),
                }),
        };

        Assert.assertEquals(expect, ArrayUtils.sorted(hands)[0]);

    }

}
