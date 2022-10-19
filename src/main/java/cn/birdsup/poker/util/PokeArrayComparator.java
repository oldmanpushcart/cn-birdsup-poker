package cn.birdsup.poker.util;

import cn.birdsup.poker.Poke;

import java.util.Comparator;

/**
 * 扑克牌组比较器
 */
public class PokeArrayComparator implements Comparator<Poke[]> {

    /**
     * 单例
     */
    public static final PokeArrayComparator instance = new PokeArrayComparator();

    @Override
    public int compare(Poke[] o1, Poke[] o2) {

        // 数量大的排前边
        if (o2.length != o1.length) {
            return o2.length - o1.length;
        }

        // 数量一致比牌面：按照顺序逐个比对，找到第一个差异作为比对结果
        for (int index = 0; index < o1.length; index++) {
            final int ret = o1[index].compareTo(o2[index]);
            if (ret != 0) {
                return ret;
            }
        }

        // 若比对完都没差异，说明牌组相等
        return 0;
    }

}
