package org.neal.javaLearn.offer.jianzhiOffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int blankNum = 0;
        int length = str.length();
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                blankNum++;
            }
        }
        newLength = length + 2 * blankNum; // 替换后的字符串长度
        char[] newChars = new char[newLength];// 新的字符数组
        int index = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                newChars[index--] = '0';
                newChars[index--] = '2';
                newChars[index--] = '%';
            } else {
                newChars[index--] = str.charAt(i);
            }
        }
        return new String(newChars);
    }

    /**
     *         //借助StringBuffer
     *         public String replaceSpace(StringBuffer str) {
     *             StringBuffer sb = new StringBuffer();
     *             for (int i = 0; i < str.length(); i++) {
     *                 if (str.charAt(i) == ' ') {
     *                     sb.append("%20");
     *                 } else {
     *                     sb.append(str.charAt(i));
     *                 }
     *             }
     *             return sb.toString();
     *         }
     */
}
