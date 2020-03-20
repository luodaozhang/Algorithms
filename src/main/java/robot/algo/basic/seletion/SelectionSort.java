package robot.algo.basic.seletion;

import robot.algo.common.SortTestHelper;

public class SelectionSort {

    private SelectionSort(){

    }


    public static void sort(Comparable[] arr){

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int miniIndex = i;

            for (int j = i+1; j < n; j++) {

                if (arr[i].compareTo(arr[j])>0) {
                    miniIndex = j;
                }

            }

            SortTestHelper.swap(arr,i,miniIndex);

        }

    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("robot.algo.basic.seletion.SelectionSort", arr);

    }

}
