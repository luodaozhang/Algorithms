package robot.algo.basic.insertion;

import robot.algo.common.SortTestHelper;

public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            Comparable temporary = arr[i];
            int j = i;

            for (; j > 0; j--) {

                if (arr[i].compareTo(arr[j])>0){
                    arr[i] = arr[j];
                }

            }

            arr[j] = temporary;

        }

    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("robot.algo.basic.insertion.InsertionSort", arr);
    }

}
