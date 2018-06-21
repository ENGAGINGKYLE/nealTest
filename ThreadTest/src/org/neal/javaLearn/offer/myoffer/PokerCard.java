package org.neal.javaLearn.offer.myoffer;

import java.util.*;

enum Color{
    Spade(4),//黑桃
    Club(3),//梅花
    Heart(2),//桃心
    Diamond(1);//方块

    private int order;
    Color(int order) {
        this.order = order;
    }

    public int getOrder(){
        return order;
    }
}

public class PokerCard {
    private Color[] color = {Color.Diamond,Color.Heart,Color.Club,Color.Spade};//枚举表示花色
    private String[] pokerNumber = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
    private String[] colors={"♠","♥","♣","♦"};//字符串表示花色

    /**
     * 对三个玩家随机发牌
     * 使用shuffle()打乱牌序
     */
    public void sendCard(){
        //键存储索引，值存储花色和点数组成的字符串
        HashMap<Integer,String> hashMap = new HashMap<>();

        //存储扑克牌的索引
        ArrayList<Integer> arrayList = new ArrayList<>();

        /**
         * 建立玩家集合  有序存放
         */
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        TreeSet<Integer> treeSet2 = new TreeSet<>();
        TreeSet<Integer> treeSet3 = new TreeSet<>();

        int index = 0;

        /**
         * 将牌存入map中，并将牌的索引存入list中
         */
        //for(Color col : color){//使用枚举表示花色
        for(String poker : pokerNumber)
            for(String col : colors){//使用字符串表示花色
                hashMap.put(index,col+" "+poker);
                arrayList.add(index);
                index++;
            }
        //}

        /**
         * 将大小王存入
         */
        hashMap.put(index,"BIGJ");
        arrayList.add(index);
        index++;
        hashMap.put(index,"SMALLJ");
        arrayList.add(index);

        //洗牌
        Collections.shuffle(arrayList);

        //发牌
        for(int i=0; i<arrayList.size(); i++){
            if(i%3==0){
                treeSet1.add(arrayList.get(i));
            }else if(i%3==1){
                treeSet2.add(arrayList.get(i));
            }else if(i%3==2){
                treeSet3.add(arrayList.get(i));
            }
        }

        /**
         * 查看当前玩家手中的牌
         */
        PrintPoker("Player1",treeSet1,hashMap);
        PrintPoker("Player2",treeSet2,hashMap);
        PrintPoker("Player3",treeSet3,hashMap);

    }

    /**
     * 从大到小的输出扑克牌  按照从大小王->3（黑红梅方）的顺序
     * @param playerName  玩家名字
     * @param treeSet 玩家手中的牌的索引
     * @param hashMap 玩家手中的牌的花色和大小
     */
    private void PrintPoker(String playerName,TreeSet<Integer> treeSet,HashMap<Integer,String> hashMap){

        Stack<Integer> stack = new Stack<>();
        for(Integer index : treeSet){
            stack.push(index);
        }

        System.out.print("玩家"+playerName+"手中的牌 ：");
        Integer index = null;
        while(!stack.isEmpty()){
            index = stack.pop();
            System.out.print(hashMap.get(index)+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        PokerCard pokerCard = new PokerCard();
        pokerCard.sendCard();

    }
}
