package cn.birdsup.poker;

/**
 * 扑克牌
 *
 * @param rank  点数
 * @param color 花色
 */
public record Poke(Rank rank, Color color) implements Comparable<Poke> {

    @Override
    public int compareTo(Poke other) {
        // 首先比点数，点数一致再比花色
        return other.rank != rank
                ? other.rank.ordinal() - rank.ordinal()
                : other.color.ordinal() - color.ordinal();
    }

    /**
     * 花色
     */
    public enum Color {

        /**
         * 方块
         */
        DIAMOND,

        /**
         * 梅花
         */
        CLUB,

        /**
         * 红桃
         */
        HEART,

        /**
         * 黑桃
         */
        SPADE

    }

    /**
     * 点数
     */
    public enum Rank {
        P1,
        P2,
        P3,
        P4,
        P5,
        P6,
        P7,
        P8,
        P9,
        P10,
        PJ,
        PQ,
        PK,
        PA

    }

}
