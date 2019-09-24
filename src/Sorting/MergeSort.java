package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,4,6,5,2,3};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int low, int high){
        if (low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr,low, mid);
            mergeSort(arr, mid + 1, high);
            mergeParts(arr,low, mid, high);
        }
    }

    public void mergeParts(int[] arr, int low, int mid, int high){
        int[] temp = new int[arr.length];
        for (int i = low; i <= high; i++){
            temp[i] = arr[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high){
            if (temp[i] < temp[j]){
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid){
            arr[k++] = temp[i++];
        }
        while (j <= high){
            arr[k++] = temp[j++];
        }

    }
}
