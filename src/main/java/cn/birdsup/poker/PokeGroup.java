package cn.birdsup.poker;

import cn.birdsup.poker.util.PokeArrayComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

/**
 * 扑克牌组
 */
public class PokeGroup implements Comparable<PokeGroup> {

    private final Poke[] pokes;
    private final Poke[][] segments;
    private final boolean isStraight;
    private final boolean isFlush;

    public PokeGroup(final Poke[] sorted) {
        this.pokes = sorted;
        this.segments = split(sorted);
        this.isStraight = isStraight(sorted);
        this.isFlush = isFlush(sorted);
    }

    @Override
    public int compareTo(PokeGroup other) {

        // 分组长度不等取最长
        if (other.segments.length != segments.length) {
            return other.segments.length - segments.length;
        }

        // 分组长度相等比牌面
        for (int index = 0; index < segments.length; index++) {

            final int ret;
            if ((ret = PokeArrayComparator.instance.compare(segments[index], other.segments[index])) != 0) {
                return ret;
            }

        }

        // 牌面也一致则判定为相等
        return 0;
    }

    /**
     * 判断第一张牌是否为指定点数
     *
     * @param rank 点数
     * @return TRUE | FALSE
     */
    public boolean isFirst(Poke.Rank rank) {
        return pokes.length > 0
                && pokes[0].rank() == rank;
    }

    /**
     * 是否为顺组牌组
     *
     * @return TRUE | FALSE
     */
    public boolean isStraight() {
        return isStraight;
    }

    /**
     * 是否为同花牌组
     *
     * @return TRUE | FALSE
     */
    public boolean isFlush() {
        return isFlush;
    }

    /**
     * 判断牌分组是否符合指定分组格式
     *
     * @param formats 分组格式
     * @return TRUE | FALSE
     */
    public boolean isFormat(int... formats) {
        return IntStream.range(0, segments.length)
                .noneMatch(index -> segments[index].length != formats[index]);
    }

    /**
     * 根据扑克牌的点数进行分组
     * <ul>
     *     <li>相同点数归为同一牌组</li>
     *     <li>根据牌组大小进行牌组之间的排序</li>
     * </ul>
     *
     * @param pokes 扑克牌组
     * @return 扑克牌分组
     */
    private static Poke[][] split(Poke[] pokes) {
        return Stream.of(pokes)
                .collect(groupingBy(Poke::rank, HashMap::new, toCollection(ArrayList::new)))
                .values()
                .stream()
                .map(group -> group.stream().sorted().toArray(Poke[]::new))
                .sorted(PokeArrayComparator.instance)
                .toArray(Poke[][]::new);
    }

    /**
     * 判断扑克牌组是否均为同一花色
     *
     * @param pokes 扑克牌组
     * @return TRUE | FALSE
     */
    private static boolean isFlush(Poke[] pokes) {
        return Stream.of(pokes)
                .noneMatch(poke -> poke.color() != pokes[0].color());
    }

    /**
     * 判断扑克牌是否为顺子
     *
     * @param sorted 扑克牌组（需排序）
     * @return TRUE | FALSE
     */
    private static boolean isStraight(Poke[] sorted) {
        return IntStream.range(1, sorted.length)
                .noneMatch(index -> sorted[index].rank().ordinal() - sorted[index - 1].rank().ordinal() != -1);
    }

}
