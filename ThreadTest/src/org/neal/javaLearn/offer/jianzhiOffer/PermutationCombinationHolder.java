package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 结果请按字母顺序输出。
 */
public final class PermutationCombinationHolder {

    /** 1、数组元素的全组合 */
    public  static void combination(char[] chars) {
        char[] subchars = new char[chars.length]; //存储子组合数据的数组
        //全组合问题就是所有元素(记为n)中选1个元素的组合, 加上选2个元素的组合...加上选n个元素的组合的和
        for (int i = 0; i < chars.length; ++i) {
            final int m = i + 1;
            combination(chars, chars.length, m, subchars, m);
        }
    }

    /**
     *  n个元素选m个元素的组合问题的实现. 原理如下:
     *  从后往前选取, 选定位置i后, 再在前i-1个里面选取m-1个.
     *  如: 1, 2, 3, 4, 5 中选取3个元素.
     *  1) 选取5后, 再在前4个里面选取2个, 而前4个里面选取2个又是一个子问题, 递归即可;
     *  2) 如果不包含5, 直接选定4, 那么再在前3个里面选取2个, 而前三个里面选取2个又是一个子问题, 递归即可;
     *  3) 如果也不包含4, 直接选取3, 那么再在前2个里面选取2个, 刚好只有两个.
     *  纵向看, 1与2与3刚好是一个for循环, 初值为5, 终值为m.
     *  横向看, 该问题为一个前i-1个中选m-1的递归.
     */
    public static void combination(char[] chars, int n, int m, char[] subchars, int subn) {
        if (m == 0) { //出口
            for (int i = 0; i < subn; ++i) {
                System.out.print(subchars[i]);
            }
            System.out.println();
        } else {
            for (int i = n; i >= m; --i) { // 从后往前依次选定一个
                subchars[m - 1] = chars[i - 1]; // 选定一个后
                combination(chars, i - 1, m - 1, subchars, subn); // 从前i-1个里面选取m-1个进行递归
            }
        }
    }
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////


    /** 2、数组元素的全排列 */
    public static void permutation(char[] chars) {
        permutation(chars, 0, chars.length - 1);
    }

    /** 数组中从索引begin到索引end之间的子数组参与到全排列 */
    public static void permutation(char[] chars, int begin, int end) {
        if (begin == end) { //只剩最后一个字符时为出口
            for (int i = 0; i < chars.length; ++i) {
                System.out.print(chars[i]);
            }
            System.out.println();
        } else {
            for (int i = begin; i <= end; ++i) { //每个字符依次固定到数组或子数组的第一个
                if (canSwap(chars, begin, i)) { //去重
                    swap(chars, begin, i); //交换
                    permutation(chars, begin + 1, end); //递归求子数组的全排列
                    swap(chars, begin, i); //还原
                }
            }
        }
    }

    public static void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

    //判断去重
    public static boolean canSwap(char[] chars, int begin, int end) {
        for (int i = begin; i < end; ++i) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final char[] chars = new char[] {'a', 'b', 'c'};
        permutation(chars);
        System.out.println("===================");
        combination(chars);
    }
}

//方法2：DFS
//
//import java.util.*;
//
//public class Solution {
//    private char [] seqs;
//    private Integer [] book;
//    //用于结果去重
//    private HashSet<String> result = new HashSet<String>();
//    /**
//     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
//     * 例如输入字符串abc,则打印出由字符a,b,c
//     * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
//     输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。\
//     * @param str
//     * @return
//     */
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> arrange = new ArrayList<String>();
//        if(str == null || str.isEmpty()) return arrange;
//        char[] strs = str.toCharArray();
//        seqs = new char[strs.length];
//        book = new Integer[strs.length];
//        for (int i = 0; i < book.length; i++) {
//            book[i] = 0;
//        }
//        dfs(strs, 0);
//        arrange.addAll(result);
//        Collections.sort(arrange);
//        return arrange;
//    }
//
//    /**
//     * 深度遍历法
//     */
//    private void dfs(char[] arrs, int step){
//        //走完所有可能 记录排列
//        if(arrs.length == step){
//            String str = "";
//            for (int i = 0; i < seqs.length; i++) {
//                str += seqs[i];
//            }
//            result.add(str);
//            return; //返回上一步
//        }
//        //遍历整个序列,尝试每一种可能
//        for (int i = 0; i < arrs.length; i++) {
//            //是否走过
//            if(book[i] == 0){
//                seqs[step] = arrs[i];
//                book[i] = 1;
//                //下一步
//                dfs(arrs, step + 1);
//                //走完最后一步 后退一步
//                book[i] = 0;
//            }
//        }
//    }
//}

//方法3：字典序算法
//import java.util.*;
//
////步骤如下：
////1.从这个序列中从右至左找第一个左邻小于右邻的字符,记录下标为index1 ，如果找不到，说明求解完成。
////2.从这个序列中从右至左找第一个大于str[index1]的字符，记录下标为index2
////3.交换index1和index2的字符，对index1+1后的所有字符进行升序排序，此时得到的即为str按字典序的下一个排列
////4. 重复1~3的步骤，直到全部找完
//
//public class Solution {
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> res = new ArrayList<>();
//
//        if (str != null && str.length() > 0) {
//            char[] seq = str.toCharArray();
//            Arrays.sort(seq); //排列
//            res.add(String.valueOf(seq)); //先输出一个解
//
//            int len = seq.length;
//            while (true) {
//                int p = len - 1, q;
//                //从后向前找一个seq[p - 1] < seq[p]
//                while (p >= 1 && seq[p - 1] >= seq[p]) --p;
//                if (p == 0) break; //已经是“最小”的排列，退出
//                //从p向后找最后一个比seq[p]大的数
//                q = p;
//                --p;
//                while (q < len && seq[q] > seq[p]) q++;
//                --q;
//                //交换这两个位置上的值
//                swap(seq, q, p);
//                //将p之后的序列倒序排列
//                reverse(seq, p + 1);
//                res.add(String.valueOf(seq));
//            }
//        }
//
//        return res;
//    }
//
//    public static void reverse(char[] seq, int start) {
//        int len;
//        if (seq == null || (len = seq.length) <= start)
//            return;
//        for (int i = 0; i < ((len - start) >> 1); i++) {
//            int p = start + i, q = len - 1 - i;
//            if (p != q)
//                swap(seq, p, q);
//        }
//    }
//
//    public static void swap(char[] cs, int i, int j) {
//        char temp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = temp;
//    }
//}