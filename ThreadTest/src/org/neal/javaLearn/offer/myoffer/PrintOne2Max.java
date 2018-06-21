package org.neal.javaLearn.offer.myoffer;

/**
 * 如n=3,则从1打印到999
 */
public class PrintOne2Max {
    public void printOne2Max(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 将number输出  去掉数字开头的'0' 避免出现'098'这种情况出现  从最高位开始输出
     * @param number
     */
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;  //标记数值最高位是否为0
        int nlength = number.length;

        for(int i=0; i<nlength;i++){

            if(isBeginning0&&number[i]!='0'){
                isBeginning0 = false;
            }

            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /**
     * 对number进行溢出判断   每次加1
     * @param number
     */
    private static boolean increment(char[] number) {
        int nLength = number.length;
        int nTakeover = 0;   //进位标志
        boolean isOverflow = false;  //溢出标志


        for(int i=nLength-1; i>=0; i--){//从最低位开始
            int nSum = number[i] - '0' + nTakeover;//计算出每一位上的总值

            if(i == nLength-1){//如果是第一位，则加一
                nSum++;
            }

            if (nSum >= 10) {//判断每一位上的数值是否大于10 如果大于10则产生进位
                if(i == 0){//如果是最高位的nSum  当nSum大于10 的时候则将溢出标志修改为true
                    isOverflow = true;
                }else{//否则修改进位标志  并将该位上的数值修改  减去10
                    nSum -= 10;
                    nTakeover = 1;
                    number[i] =(char)('0' + nSum);
                }
            }else{//如果数值小于10  则不会产生进位  直接修改该位上的数值
                number[i] = (char)('0' + nSum);
                break;
            }
        }

        return isOverflow;
    }
}
