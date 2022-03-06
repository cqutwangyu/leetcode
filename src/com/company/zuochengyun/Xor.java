package com.company.zuochengyun;

import java.util.Arrays;

/**
 * todo desc
 *
 * @author 王渔
 * @date 2022/3/6 14:32
 */
public class Xor {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println("数组中只有一个数出现了奇数次，它是" + findOddNumber(arr1));
        int[] arr2 = {1, 1, 1, 1, 2, 2, 3, 3, 3, 5};
        System.out.println("数组中只有两个数出现了奇数次，它是" + Arrays.toString(findTwoOddNumber(arr2)));
    }

    private static int findOddNumber(int[] arr) {
        //只有一个种出现了奇数次
        //从头异或到尾，只会留下出现奇数次的那个数
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        return eor;
    }

    private static int[] findTwoOddNumber(int[] arr) {
        //只有两种数出现了奇数次，a!=b
        //从头异或到尾，只会留下出现奇数次的那两个数相异或（eor=a^b）
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        //eor=a^b
        //eor!=0
        //eor必然有一个位置上是1
        //提取最右侧的一个1
        /**
         *         eor:1010111100 二进制
         *        ~eor:0101000011 取反
         *      ~eor+1:0101000100 取反后+1
         *eor&(~eor+1):0000000100 与出的结果就是最右侧的1
         */
        int rightOne = eor & (~eor + 1);

        //找出其中一个奇数次的数
        int eor2 = 0;
        for (int i : arr) {
            //通过这个最右侧的1，把数组中的数分为两组，即可找出其中一个出现奇数次的数。
            if ((i & rightOne) == (eor & rightOne)) {
                eor2 ^= i;
            }
        }

        //eor2为a，那么b=(a^b)^a=b;
        return new int[]{eor ^ eor2, eor2};
    }
}
