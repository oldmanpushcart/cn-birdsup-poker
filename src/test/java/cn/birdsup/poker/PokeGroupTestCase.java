package cn.birdsup.poker;

import org.junit.Assert;
import org.junit.Test;

import static cn.birdsup.poker.Poke.Color.*;
import static cn.birdsup.poker.Poke.Rank.*;
import static cn.birdsup.poker.util.ArrayUtils.sorted;

public class PokeGroupTestCase {

    @Test
    public void test$base() {

        // 顺子
        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P3, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(P6, SPADE),
                        new Poke(P2, SPADE)
                })).isStraight()
        );

        // 同色
        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P3, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(P6, SPADE),
                        new Poke(P2, SPADE)
                })).isFlush()
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P3, SPADE),
                        new Poke(P4, SPADE),
                        new Poke(P6, SPADE),
                        new Poke(P2, SPADE)
                })).isFormat(1, 1, 1, 1, 1)
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P5, HEART),
                        new Poke(P5, CLUB),
                        new Poke(P5, SPADE),
                        new Poke(P2, SPADE)
                })).isFormat(4, 1)
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P5, HEART),
                        new Poke(P5, CLUB),
                        new Poke(P2, SPADE),
                        new Poke(P2, SPADE)
                })).isFormat(3, 2)
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P5, HEART),
                        new Poke(P5, CLUB),
                        new Poke(P2, SPADE),
                        new Poke(P3, SPADE)
                })).isFormat(3, 1, 1)
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P5, HEART),
                        new Poke(P3, CLUB),
                        new Poke(P2, SPADE),
                        new Poke(P3, SPADE)
                })).isFormat(2, 2, 1)
        );

        Assert.assertTrue(
                new PokeGroup(sorted(new Poke[]{
                        new Poke(P5, SPADE),
                        new Poke(P5, HEART),
                        new Poke(PJ, CLUB),
                        new Poke(P2, SPADE),
                        new Poke(P3, SPADE)
                })).isFirst(PJ)
        );

    }

}
