package search;

/**
 * @description: 二分查找
 * @author: shan junwei
 * @create: 2019-08-11 17:05
 **/

public class BinarySearch {


    public static int Search(int[] array, int left, int right, int key) {
        int middle = (left + right) / 2;
        if (array[middle] == key) {
            System.out.println(
                    "你要找的值在位置"+  middle
            );
            return middle;
        } else if (key < array[middle]) {
            return Search(array, left, middle - 1, key);
        } else {
            return Search(array, middle + 1, right, key);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 70};
        Search(array, 0, array.length - 1, 2);
    }

}
