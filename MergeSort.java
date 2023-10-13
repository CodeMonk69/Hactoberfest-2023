package basic_programs;

import java.util.*;
import java.lang.*;

public class MergeSort {

    static boolean isSmall(int start,int end)
    {
        return (end - start + 1) == 1;
    }

    static int[] solution(int []arr, int start,int end)
    {
        int[] a =new int[end-start+1];
        int n=end-start+1;
        int k=start;
        for(int i=0;i<n;i++) {
            a[i]=arr[k++];
        }
        // System.out.println("solution ="+ Arrays.toString(a));
        return a;
    }

    static int Divide( int start, int end)
    {
        return start+(end-start)/2;
    }

    static int[] Combine(int[] arr1, int[] arr2)
    {
        int m=arr1.length;
        int n=arr2.length;
        int[] arr =new int[m+n];

        int i=0, j=0, k=0;

        while(i<m && j<n)  {  // combine all elements till same length
            if(arr1[i]<=arr2[j])
                arr[k++]=arr1[i++];
            else
                arr[k++]=arr2[j++];
        }

        while(i<m) {// append remaining elements of 1st array in result array
            arr[k++]=arr1[i++];
        }

        while(j<n) { // append remaining elements of 2nd array in result array
            arr[k++]=arr2[j++];
        }

        return arr;
    }

    static int[] mergeSort(int []arr,int start, int end)
    {
        if (isSmall(start,end)) {
            return solution(arr,start,end);
        } else {
            int mid=Divide(start,end);
            //System.out.println("mid= "+mid);
            int []arr1=mergeSort(arr,start,mid);
            System.out.println("left part= "+Arrays.toString(arr1));
            int []arr2=mergeSort(arr,mid+1,end);
            System.out.println("right part= "+Arrays.toString(arr2));
            int []arr3=Combine(arr1,arr2);
            System.out.println("Combined= "+Arrays.toString(arr3));
            return arr3;
        }

    }

    static Scanner sc=new Scanner(System.in);
    public static void main (String[] args)
    {
        int n=sc.nextInt();
        int [] arr= new int[n];

        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println("Array Prepared : arr1="+ Arrays.toString(arr) );
        System.out.println("Merged and Sorted : " +Arrays.toString(mergeSort(arr,0,n-1))) ;
    }
}
