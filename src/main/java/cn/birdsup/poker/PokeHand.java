package cn.birdsup.poker;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static cn.birdsup.poker.Poke.Rank.*;
import static cn.birdsup.poker.util.ArrayUtils.getLength;

/**
 * 手牌
 */
public class PokeHand implements Comparable<PokeHand> {

    private final PokeGroup group;
    private final Type type;

    public PokeHand(Poke[] pokes) {
        this.group = new PokeGroup(sorted(pokes));
        this.type = Type.valueOf(group);
    }

    @Override
    public int compareTo(PokeHand other) {
        // 牌型相同比牌型，牌型不同比牌面
        return other.type != type
                ? type.compareTo(other.type)
                : group.compareTo(other.group);
    }

    /**
     * 对扑克牌组进行排序
     * <p>
     * 手牌的扑克牌组一组固定为5张，其中有A2345的特殊组合需要处理
     * </p>
     *
     * @param pokes 扑克牌组
     * @return 有序扑克牌组
     */
    private static Poke[] sorted(Poke[] pokes) {

        // 先进行自然排序
        Arrays.sort(pokes);

        // 对A2345的特殊点数排列进行特殊处理，A为最小牌面
        if (isSeqRank(pokes, PA, P5, P4, P3, P2)) {
            final Poke first = pokes[0];
            IntStream.range(1, pokes.length).forEach(index -> pokes[index - 1] = pokes[index]);
            pokes[pokes.length - 1] = new Poke(P1, first.color());
        }

        // 返回排序结果
        return pokes;
    }

    /**
     * 判断扑克牌组是否为指定的点数序列
     *
     * @param pokes 扑克牌组
     * @param ranks 点数序列
     * @return TRUE | FALSE
     */
    private static boolean isSeqRank(Poke[] pokes, Poke.Rank... ranks) {
        return getLength(pokes) == getLength(ranks)
                && IntStream.range(0, pokes.length).noneMatch(index -> pokes[index].rank() != ranks[index]);
    }

    /**
     * 牌型
     */
    private enum Type {

        /**
         * 同花大顺
         */
        ROYAL_FLUSH(group -> group.isStraight() && group.isFlush() && group.isFirst(Poke.Rank.PA)),

        /**
         * 同花顺
         */
        STRAIGHT_FLUSH(group -> group.isStraight() && group.isFlush()),

        /**
         * 四条（四带一）
         */
        FOUR_OF_A_KIND(group -> group.isFormat(4, 1)),

        /**
         * 葫芦（三带二）
         */
        FULL_HOUSE(group -> group.isFormat(3, 2)),

        /**
         * 同花
         */
        FLUSH(PokeGroup::isFlush),

        /**
         * 顺子
         */
        STRAIGHT(PokeGroup::isStraight),

        /**
         * 三条
         */
        THREE_OF_A_KIND(group -> group.isFormat(3, 1, 1)),

        /**
         * 两对
         */
        TWO_PAIRS(group -> group.isFormat(2, 2, 1)),

        /**
         * 一对
         */
        ONE_PAIR(group -> group.isFormat(2, 1, 1, 1)),

        /**
         * 无对
         */
        ZILCH(group -> group.isFormat(1, 1, 1, 1, 1));

        private final Predicate<PokeGroup> predicate;

        Type(Predicate<PokeGroup> predicate) {
            this.predicate = predicate;
        }

        public static Type valueOf(PokeGroup group) {
            return Stream.of(Type.values())
                    .filter(type -> type.predicate.test(group))
                    .findFirst()
                    .orElseThrow();
        }

    }

}
