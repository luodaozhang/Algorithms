package robot.algo.common;

import java.lang.reflect.Method;

public class SortTestHelper {


    private SortTestHelper() {

    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeR > rangeL;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }

        return arr;

    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ ) {
            arr[i] = i;
        }

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }

    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }

        return true;

    }

    public static void testSort(String sortClassName,Comparable[] arr){
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSort(String sortClassName,String methodName,Comparable[] arr){
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod(methodName, Comparable[].class);
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
