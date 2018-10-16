package com.es.sort;

public  class SortTest {

    public static void main(String[] args) {
//        bubbleSort();

        int sortArr[] = {5,3,1,7,2,10};
        quickSort(sortArr,0,sortArr.length-1);
        for (int a:sortArr) {
            System.out.println(a);
        }
    }

    /**
     * 快速排序，找一个基准数，一般是第一个，
     * 分别从其后面最左和最有找比其大和小的数，并交换位置
     * 结果是比基准点小的都在左边，大的都在右边
     * 并将基准点放中间，一次再对左右进行以上排序直至结束
     */
    public static void quickSort(int []arr,int low,int high){
        if(low >= high){
            return;
        }
        int i = low;
        int j = high;
        int base = arr[low];
        int temp;
        while (i < j){
            while (arr[i] <= base && i < j){
                i++;
            }
            while (arr[j] >= base && i < j){
                j --;
            }
            if(i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i-1];
        arr[i-1] = base;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }



    /**
     * 冒泡排序，先找出最大值(或最小值)放在最后(或最前)
     * 接着找第二大或第二小，一次类推
     */
    public static void bubbleSort(){
        int arr[] = {2,1,3,5,7,12,4,66};
        int temp = 0;
        for(int i=0;i < arr.length;i++){
            for(int j=0;j<arr.length - 1 -i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int a:arr) {
            System.out.println(a);
        }
    }
}
