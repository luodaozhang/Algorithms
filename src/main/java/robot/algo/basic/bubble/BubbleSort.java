package robot.algo.basic.bubble;

import robot.algo.common.SortTestHelper;

import java.util.Arrays;

public class BubbleSort {

    public static void sort1(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortTestHelper.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort2(Comparable[] arr) {
        int n = arr.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swap(arr, i - 1, i);
                    swapped = true;
                }
            }

            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        } while (swapped);
    }

    public static void sort3(Comparable[] arr){

        int n = arr.length;
        int newn; // 使用newn进行优化

        do{
            newn = 0;
            for( int i = 1 ; i < n ; i ++ ) {
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    SortTestHelper.swap( arr , i-1 , i );

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;
        }while(newn > 0);
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort", "sort1", arr1);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort", "sort2", arr2);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort", "sort3", arr3);
    }

}