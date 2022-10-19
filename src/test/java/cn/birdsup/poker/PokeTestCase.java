package cn.birdsup.poker;

import org.junit.Assert;
import org.junit.Test;

import static cn.birdsup.poker.Poke.Color.*;
import static cn.birdsup.poker.Poke.Rank.*;
import static cn.birdsup.poker.util.ArrayUtils.sorted;

public class PokeTestCase {

    @Test
    public void test$compare() {
        Assert.assertTrue(new Poke(P5, SPADE).compareTo(new Poke(P5, DIAMOND)) < 0);
        Assert.assertTrue(new Poke(P5, SPADE).compareTo(new Poke(P4, DIAMOND)) < 0);
        Assert.assertTrue(new Poke(PA, SPADE).compareTo(new Poke(PK, DIAMOND)) < 0);
    }

    @Test
    public void test$sort() {

        Assert.assertArrayEquals(
                new Poke[]{
                        new Poke(PA, SPADE),
                        new Poke(P5, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(P3, SPADE),
                        new Poke(P2, SPADE)
                },
                sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P3, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(PA, SPADE),
                        new Poke(P2, SPADE)
                })
        );

        Assert.assertArrayEquals(
                new Poke[]{
                        new Poke(PA, SPADE),
                        new Poke(PA, HEART),
                        new Poke(PA, CLUB),
                        new Poke(PA, DIAMOND),
                        new Poke(P2, SPADE)
                },
                sorted(new Poke[]{
                        new Poke(PA, DIAMOND),
                        new Poke(PA, SPADE),
                        new Poke(PA, HEART),
                        new Poke(PA, CLUB),
                        new Poke(P2, SPADE)
                })
        );

    }

}
