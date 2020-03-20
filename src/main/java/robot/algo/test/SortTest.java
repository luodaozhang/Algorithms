package robot.algo.test;

import robot.algo.common.SortTestHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] randomArr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] randomLowArr = SortTestHelper.generateRandomArray(N, 0, 100);
        Integer[] nearlyOrderedArr = SortTestHelper.generateNearlyOrderedArray(N, 100);

        //一般测试
        System.out.println("一般测试");
        Integer[] randomArr1 = Arrays.copyOf(randomArr,randomArr.length);
        Integer[] randomArr2 = Arrays.copyOf(randomArr,randomArr.length);
        Integer[] randomArr3 = Arrays.copyOf(randomArr,randomArr.length);
        SortTestHelper.testSort("robot.algo.basic.seletion.SelectionSort", randomArr1);
        SortTestHelper.testSort("robot.algo.basic.insertion.InsertionSort", randomArr2);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort","sort1", randomArr3);

        //有序性强测试
        System.out.println("有序性强测试");
        Integer[] randomLowArr1 = Arrays.copyOf(randomLowArr,randomArr.length);
        Integer[] randomLowArr2 = Arrays.copyOf(randomLowArr,randomArr.length);
        Integer[] randomLowArr3 = Arrays.copyOf(randomLowArr,randomArr.length);
        SortTestHelper.testSort("robot.algo.basic.seletion.SelectionSort", randomLowArr1);
        SortTestHelper.testSort("robot.algo.basic.insertion.InsertionSort", randomLowArr2);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort","sort1", randomLowArr3);

        //几乎有序测试
        System.out.println("几乎有序测试");
        Integer[] nearlyOrderedArr1 = Arrays.copyOf(nearlyOrderedArr,randomArr.length);
        Integer[] nearlyOrderedArr2 = Arrays.copyOf(nearlyOrderedArr,randomArr.length);
        Integer[] nearlyOrderedArr3 = Arrays.copyOf(nearlyOrderedArr,randomArr.length);
        SortTestHelper.testSort("robot.algo.basic.seletion.SelectionSort", nearlyOrderedArr1);
        SortTestHelper.testSort("robot.algo.basic.insertion.InsertionSort", nearlyOrderedArr2);
        SortTestHelper.testSort("robot.algo.basic.bubble.BubbleSort","sort1", nearlyOrderedArr3);

    }

}
