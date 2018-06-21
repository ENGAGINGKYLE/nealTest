package org.neal.javaLearn.offer.myoffer;

import org.junit.Test;

public class TestClass {

    @Test
    public void testBST(){

        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums){
            bst.add(num);
        }

        bst.inOrder();

        System.out.println("===============================");

//        System.out.println(bst);

        bst.preOrder();
        bst.preOrderNonRecursive();
        bst.levelOrder();
        System.out.println(bst.min());
    }
}
