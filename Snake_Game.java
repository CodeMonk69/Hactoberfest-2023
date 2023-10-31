import java.util.Scanner;

public class Snake_Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nWelcome to the Snake Game\n\nEnter the length of the snake:");

        int ar[] = new int[155],len=in.nextInt();

        String snake = "<~~~";
        for (int i = 0; i < len; i++) {
            snake += "~";
        }

        System.out.println("The Snake will look like "+snake+"\nEnter the Snake's running speed:");
        int speed = in.nextInt(); 
        int j=0;    


        do {
            
            System.out.print("-");
            for (int i = 0; i < ar.length; i++) {
                ar[i] = 0;
                if(i>=(ar.length-j) && i<((ar.length-j)+(snake.length()))) {
                    System.out.print(snake.charAt(i-(ar.length-j)));
                }
                else {
    
                    System.out.print(" ");
                }
            }
            System.out.println("-");
            j++;
            
            //delay loop
            for (int k = 0; k < Math.pow(ar.length,3); k+=speed) {
            }

            if(j != (ar.length+1)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }

        
        }
        while(j < (ar.length+1));
        in.close();

    }
    
}
