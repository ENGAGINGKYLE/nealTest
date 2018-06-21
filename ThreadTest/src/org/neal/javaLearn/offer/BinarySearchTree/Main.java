package org.neal.javaLearn.offer.BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        BSTImpl<Integer> bst = new BSTImpl<>();
        int[] nums = {5,3,2,4,6,8};
        for(int num : nums)
            bst.add(num);
//        bst.preOrder();
//        System.out.println();
//        bst.order(0);
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.order(1);
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        bst.order(2);
//        System.out.println();
//        System.out.println(bst);

        //广度优先遍历
////        bst.levelOrder();
//        bst.inOrder();
//        System.out.println();
//        bst.removeMin();
//        bst.inOrder();
//        System.out.println();
//        bst.remove(2);
        bst.levelOrder();
        System.out.println();

        BSTImpl<Integer> b = new BSTImpl<>();
        Random random = new Random();

        for(int i=0; i<50; i++){
            b.add(random.nextInt(1000));
        }

        ArrayList<Integer> number = new ArrayList<>();
        while(!b.isEmpty()){
            number.add(b.removeMin());
        }

        System.out.println(number);
    }
}
