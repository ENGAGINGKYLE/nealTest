package org.neal.javaLearn.offer.myoffer;

/**
 * 将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public static String repaceSpace(StringBuffer str) {

        StringBuffer stringBuffer = new StringBuffer();

        if (str == null) {
            return null;
        }

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        String str = "we are chinese!";
        System.out.println(repaceSpace(new StringBuffer(str)));
    }
}
