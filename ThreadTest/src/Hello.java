import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 34, 45, 245};
        int[] array = {3,2,3,2,4,112,2,34,36,234,54,234,356,23,467,23,445,234,356,234,356,234,65,34,87,4,63,42,53,52};

        System.out.println(binarySearch(arr,34));
        bubbleSort(array);
        for(int i : array){
            System.out.print(i+"  ");
        }
        System.out.println();

        bubble(array);
        for(int i : array){
            System.out.print(i+"  ");
        }
    }

    public static void bubble(int[] arr){
        int len = arr.length;

        for(int i=0; i<len; i++){
            for(int j=0; j<len-1-i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                 }

            }
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right) >>> 1;

            if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i <= len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static class Raw{
    String id;
    String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

static class TreeNode{
    String id;
    List<TreeNode> children;

    public String getId() {
        return id;
    }


    public TreeNode(){
        id=null;
        children = null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
}
