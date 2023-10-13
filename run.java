import basic_programs.IronRodCalculation;
import basic_programs.PalindromeGenerator;
import basic_programs.PowerOfANumber;
import basic_programs.MinMaxOfArray;
import basic_programs.MergeSort;
import java.util.*;

class run{
    static HashMap<Integer,String> selectionList;
    run() {
        selectionList = new HashMap<Integer,String>();
    }

    static void makeSelection() {
        selectionList.put(1,"Find Power Of A Number");
        selectionList.put(2,"Find Min/Max Of The Array");
        selectionList.put(3,"Merge Sort");
        selectionList.put(4,"Palindrome Generator");
        selectionList.put(5,"Iron Rod Calculation");
    }

    static void loadFunction(int choice) {
        switch(choice) {
            case 1 :
                PowerOfANumber obj1 = new PowerOfANumber();
                obj1.main(new String[0]);
                break;
            case 2 :
                MinMaxOfArray obj2 = new MinMaxOfArray();
                obj2.main(new String[0]);
                break;
            case 3 :
                MergeSort obj3 = new MergeSort();
                obj3.main(new String[0]);
            case 4 :
                PalindromeGenerator obj4 = new PalindromeGenerator();
                obj4.main(new String[0]);
            case 5 :
                IronRodCalculation obj5 = new IronRodCalculation();
                obj5.main(new String[0]);
        }
    }

    static boolean isValidChoice(int choice){
        boolean result = false;
        for (Map.Entry<Integer,String> selectionListDetails : selectionList.entrySet()) {
            if(selectionListDetails.getKey() == choice ) {
                result = true;
            }
        }
        return result;
    }

    static void showList() {
        makeSelection();
        // selectionList.forEach((key, value)-> System.out.println(key + " : " + (value)));
        for (Map.Entry<Integer,String> selectionListDetails : selectionList.entrySet()) {
            System.out.println(selectionListDetails.getKey() + " : " + selectionListDetails.getValue());
        }
    }

    public static Scanner sc = new Scanner(System.in);
    public static void main(String arg[]) {
        run obj = new run();

        System.out.println("*** Basic Program List ***\n");
        int choice=0;
        do {
            loadFunction(choice);
            System.out.println("___________________________\n");
            showList();
            System.out.println("\nEnter your choice : ");
            choice = sc.nextInt();
        } while (isValidChoice(choice));

    }
}