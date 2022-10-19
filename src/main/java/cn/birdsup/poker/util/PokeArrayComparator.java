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

        final int length = o1.length;

        // 0牌组有啥好比的，直接相等
        if(length == 0) {
            return 0;
        }

        // 如果是多张牌需要特殊处理，德州规定多牌不比花色，只比点数
        else if( length > 1 ) {
            return o2[0].rank().ordinal() - o1[0].rank().ordinal();
        }

        // 单张牌比牌面
        else {
            return o1[0].compareTo(o2[0]);
        }

    }

}
