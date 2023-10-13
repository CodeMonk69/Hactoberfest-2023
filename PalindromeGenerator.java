package basic_programs;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeGenerator {
    static String []palDomain = {"a","b","c"};
    static ArrayList<String> result = new ArrayList<>();

    static int generateRandomNumber(int lower, int upper){
        return lower + (((int)(Math.random()*10)% (upper-lower+1)));
    }

    static String  palFunction(String s,int count, int palSize) {
        int switchKey = 0;
        if(count < palSize-1){
           switchKey = generateRandomNumber(1,palDomain.length);
        } else if(count == palSize-1) {
            switchKey = generateRandomNumber(palDomain.length+1,2*palDomain.length);
        } else if(count == palSize) {
            return s;
        }
        if(switchKey >palDomain.length) {
            s+=palDomain[switchKey-palDomain.length-1];
            return s;
        } else {
            s = palDomain[switchKey-1] + palFunction(s,count+2,palSize) + palDomain[switchKey-1];
        }
        return s;
    }

    static void palGenerator(int palSize,int palCount){
        while (palCount>0){
            palCount--;
            result.add(palFunction("",0,palSize));
        }
    }
    
    static Scanner sc=new Scanner(System.in);
    public static void main (String[] args)
    {
        System.out.println("Welcome to palindrome world \nEnter the palindromeSize: ");
        int palSize=sc.nextInt();
        System.out.println("Enter the Number of palindrome required: ");
        int palCount=sc.nextInt();

        palGenerator(palSize,palCount);
        System.out.println("Result: "+result);
    }
}
