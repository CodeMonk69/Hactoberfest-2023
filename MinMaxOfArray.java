package basic_programs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinMaxOfArray {
    
    //General Approach
    static int[] getMinMax(int[]arr,int n)   //O(n) Approach  
    {
        int result[]=new int[2];
        int max=arr[0],min=arr[0];
        
        for(int i=1;i<n;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
            else if(arr[i]<min) {
                min=arr[i];
            }
        }
        result[0]=min;
        result[1]=max;
        
        return result;
    }
    //  Divide and conquer method Starts
    static boolean isSmall(int[]arr,int start,int end)
    {
        return (start==end)? true:false;
    }
    
    static int[] solution(int[]arr, int start, int end)  //min max both will be the single element itself
    {
        int [] result=new int[2];
        result[0]=arr[start];
        result[1]=arr[start];
        
        return result;
    }
    
    static int[] combine(int[] a,int []b )
    {
        int [] result=new int[2];
        result[0]= (a[0]>b[0]) ? b[0] : a[0];
        result[1]= (a[1]>b[1]) ? a[1] : b[1];
        
        return result;
    }
    
    static int[] minMaxUsingDivideAndConquer(int[] arr,int start,int end)
    {
        if(isSmall(arr,start,end)) {
            return solution(arr,start,end);
        } else {
            
            int mid=start+(end-start)/2;
            int[] q1=minMaxUsingDivideAndConquer(arr,start,mid);
            int[] q2=minMaxUsingDivideAndConquer(arr,mid+1,end);
            return combine(q1,q2);
        }
    }
    // Divide and conquer method ends
    
    static Scanner sc=new Scanner(System.in);
    public static void main (String args[])
    {
        System.out.println("Enter Size of array = ");
        int n=sc.nextInt();
        int [] arr= new int[n];
        System.out.println("Now Enter each element one by one :- ");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        
        System.out.println("array = "+ Arrays.toString(arr) );

        int []R1= getMinMax(arr,n);
        System.out.println("MinMax Using General approach : MIN="+R1[0] + " MAX="+R1[1] ) ;
        int []R2 =minMaxUsingDivideAndConquer(arr,0,n-1);
        System.out.println("MinMax Using DAC : MIN="+R2[0] + " MAX="+R2[1] ) ;
    }
}
