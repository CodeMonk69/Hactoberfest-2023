import devide_and_conquer.MatchingIndexElement;
import devide_and_conquer.BinarySearch;
import java.util.*;
class run{
    static HashMap<Integer,String> selectionList;
    run() {
        selectionList = new HashMap<Integer,String>();
    }

    static void makeSelection() {
        selectionList.put(1,"Binary Search");
        selectionList.put(2,"Matching Index Element");
    }

    static void loadFunction(int choice) {
        switch(choice) {
            case 1 : 
                BinarySearch obj1 = new BinarySearch();
                obj1.main(new String[0]);
                break;
            case 2 :
                MatchingIndexElement obj2 = new MatchingIndexElement();
                obj2.main(new String[0]);
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

        System.out.println("*** Divide And Conquer Program List ***\n");
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