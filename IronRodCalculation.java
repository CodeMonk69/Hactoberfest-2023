package basic_programs;

import java.util.*;
import java.util.ArrayList;

class outputTemplate {
    String sumValue = "";
    String sequence = "";
    outputTemplate(String sumValue,String sequence) {
        this.sequence=sequence;
        this.sumValue=sumValue;
    }
}
//ToDo : Optimise it(Apply DP)
public class IronRodCalculation {
    static Scanner sc= new Scanner(System.in);
    static double FullRodSize = 0;
    static ArrayList<Double> rodSizeExceeds = new ArrayList<>();
    public static String[] knapsack(ArrayList<Double> arr, int index, double sum, double FullRodSize) {
        if (index < 0) {
            return new String[]{Double.toString(sum), ""};
        }

        String[] a1 = knapsack(arr, index - 1, sum, FullRodSize);

        if (sum + arr.get(index) <= FullRodSize) {
            String[] a2 = knapsack(arr, index - 1, sum + arr.get(index), FullRodSize);

            if (Double.parseDouble(a2[0]) > Double.parseDouble(a1[0])) {
                return new String[]{a2[0], a2[1] + "," + arr.get(index)};
            }
        }

        return new String[]{a1[0], a1[1] + ","};
    }


    public static void getOutput(ArrayList<Double> input, double FullRodSize) {
        ArrayList<outputTemplate> output = new ArrayList<>();

        while (!input.isEmpty()) {
            String[] tempResult = knapsack(input, input.size() - 1, 0, FullRodSize);
            String sumCount = tempResult[0];
            String[] tempSequence = tempResult[1].split(",");
            ArrayList<String> actualSequence = new ArrayList<>();

            for (String element : tempSequence) {
                if (!element.isEmpty() && !element.isBlank()) {
                    Double processedElement = Double.parseDouble(element);
                    input.remove(processedElement);
                    actualSequence.add(element);
                }
            }

            output.add(new outputTemplate(sumCount, String.join(", ", actualSequence)));
        }

        printOutput(output);
    }

    public static String getValidNumbers(String num) {
        String[] numArray = num.split(",");
        String[] result = new String[numArray.length];

        try {
            for (int i = 0; i < numArray.length; i++) {
                double doubleNum = Double.parseDouble(numArray[i]);
                if (doubleNum == (int) doubleNum) {
                    result[i] = Integer.toString((int) doubleNum);
                } else {
                    result[i] = Double.toString(doubleNum);
                }
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Type Conversion");
        }

        return String.join(",", result);
    }


    public static void printOutput(ArrayList<outputTemplate> output) {
        System.out.println("______________________________________________\n" +
                "              *** Output *** ");
        System.out.println("Full Size of Iron Rod :" + getValidNumbers(""+FullRodSize));
        System.out.println("Total Iron Rod Required : [ "+output.size()+" Pieces ]"+"\n" +
                "\nThese the the partition sequences");
        int i=0;
        for (outputTemplate obj:output) {
            System.out.println("RodNo-"+(i+1)+" | "
                    +"Used :"+getValidNumbers(obj.sumValue)
                    +" Scrap:"+ getValidNumbers(""+(FullRodSize-Double.parseDouble(obj.sumValue)))
                    +" Sequence:[" + getValidNumbers(obj.sequence)+"]");
            i++;
        }
        if(rodSizeExceeds.size()!=0) {
            System.out.println("Impossible to Handle : "+rodSizeExceeds);
        }
        System.out.println("______________________________________________");
    }

    public static ArrayList<Double> getInput() {
        System.out.println("How Many Different Sizes are available? : ");
        int n = sc.nextInt();
        System.out.println("Provide the required Rod Sizes and it's quantity\n" +
                "for example [9 part of 2'3'' size required then give the input as <size,quantity> <2.25,9>] ");
        ArrayList<Double> input = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter No-"+ (i+1)+ " (Size,Quantity)");
            String data = sc.next();
            String[] arrData = data.split(",");
            try {
                double size = Double.parseDouble(arrData[0]);
                int quantity = Integer.parseInt(arrData[1]);
                if(quantity<1) {
                    System.out.println("Wrong Quantity Entered, Try it again");
                    return new ArrayList<>();
                }
                for(int j=0;j<quantity;j++) {
                    input.add(size);
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect information");
                return new ArrayList<>();
            }
        }
        input = filterInput(input);
        Collections.sort(input, Comparator.reverseOrder());

        return input;
    }
    static ArrayList<Double> filterInput(ArrayList<Double> input) {
        ArrayList<Double> filteredInput = new ArrayList<>();

        for (Double size : input) {
            if (size <= FullRodSize) {
                filteredInput.add(size);
            } else {
                rodSizeExceeds.add(size);
            }
        }
        return filteredInput;
    }

    public static void main(String[] arg) {

        System.out.println("Enter FullRodSize : ");
        FullRodSize = sc.nextInt();
        ArrayList<Double> input = getInput();
//        System.out.println("Input is : "+ input);
        System.out.println("Processing ....");
//        int[] arr = {1,6,8,9,4};
        getOutput(input,FullRodSize);
    }
}
