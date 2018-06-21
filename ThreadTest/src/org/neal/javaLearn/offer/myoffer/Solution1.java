package org.neal.javaLearn.offer.myoffer;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(Integer num : nums1){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer num : nums2){
            if(map.containsKey(num)){
                arrayList.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }

        int[] arr = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            arr[i] = arrayList.get(i);
        }

        return arr;
    }
}
