/*  find power of a number where a>=1 and b>=0 , a^n */

package basic_programs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class PowerOfANumber {
    
    //General Approach
    static int power(int a,int n)   //O(n) Approach  
    {
        int r=a;
        for(int i=1;i<n;i++) {
            r*=a;
        }
        return r;
    }
    
    // general Divide and conquer method  O(n)
    static int DAC_Power(int a, int n)
    {
        if(n==1) return a;
        else if(n==0) return 1;

        int mid=n/2;
        int q1= DAC_Power(a,mid);
        int q2= DAC_Power(a,(n-(mid)));
        
        return q1*q2;
    }
    
    // efficient Divide and conquer  O(log(n))
    static int Eff_DAC_Power(int a,int n)
    {
        if(n==0) return 1;
        else{
            int mid=n/2;
            int q1= Eff_DAC_Power(a,mid);
            if(n%2==0) {
                return q1*q1;
            } else {
                return a*q1*q1;
            }
        }
    }
    
    static Scanner sc=new Scanner(System.in);
    public static void main (String args[])
    {
        System.out.println("Welcome to power(a^n) calculator world \nEnter the value of a: ");
        int a=sc.nextInt();
        System.out.println("Enter the value of n: ");
        int n=sc.nextInt();
        
        System.out.println("Power(a^n) using divide_and_conquer technique[ O(n) ]: "+DAC_Power(a,n)); //n
        System.out.println("Power(a^n) using General power technique[ O(n) ]: "+power(a,n));   //n
        System.out.println("Power(a^n) using effective_divide_and_conquer technique[ O(logn) ]: "+Eff_DAC_Power(a,n));  //logn
    }
}
