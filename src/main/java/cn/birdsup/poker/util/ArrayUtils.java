package cn.birdsup.poker.util;

import java.util.Arrays;

public class ArrayUtils {

    /**
     * 对数组进行排序
     *
     * @param array 数组
     * @param <T>   数组类型
     * @return 有序数组
     */
    public static <T> T[] sorted(T[] array) {
        Arrays.sort(array);
        return array;
    }

    /**
     * 获取数组长度
     * <ul>
     *     <li>{@code 0 == getLength(null)}</li>
     *     <li>{@code 0 == getLength({})}</li>
     *     <li>{@code 5 == getLength({1,2,3,4,5})}</li>
     * </ul>
     *
     * @param array 目标数组
     * @param <T>   数组类型
     * @return 数组长度
     */
    public static <T> int getLength(T[] array) {
        return null == array ? 0 : array.length;
    }

}
