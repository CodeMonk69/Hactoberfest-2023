import java.util.Scanner;

public class tic_tac_toe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ar[][] = new String [3][3];
        int count[][] = new int [2][9];

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = "("+i+","+j+")\t";
            }

        }

        System.out.println("Enter the name of Player 1:");
        String n1 = in.nextLine();
        System.out.println("Enter the name of Player 2:");
        String n2 = in.nextLine();
        Boolean win = false;
        int c = -1;
        System.out.println(n1+"'s symbol is ((X)) and "+n2+"'s symbol is ((O)) \n");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                count[i][j] = -5;
            }
        }
       
        do {
            int z = 0, k = 0;
            c++;

            
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar.length; j++) {
                    System.out.print(ar[i][j]+"\t");
                }
                System.out.println("\n\n\n");
            }
            
            
            do {
                
                int y = 0;
                
                if (c%2 != 0) {
                    System.out.println(n2+"'s turn:");
                    int a = in.nextInt();
                    int b = in.nextInt();
                    for (int i = 0; i < 9; i++) {
                        if (a == count[0][i] && b == count[1][i]) {
                            System.out.println((ar[a][b]=="((O))\t")?"You have alredy occupied this index.":n1+" has already occupied this index.");
                            y++;
                            break;
                        } 
                    }
                    
                    if(y==0) {
                        ar[a][b] = "((O))\t";
                        count[0][c] = a;
                        count[1][c] = b;
                        z++;
                    }
                    
                }
                else {
                    System.out.println(n1+"'s turn:");
                    int a = in.nextInt();
                    int b = in.nextInt();
                    for (int i = 0; i < 9; i++) {
                        if (a == count[0][i] && b == count[1][i]) {
                            System.out.println((ar[a][b]=="((X))\t")?"You have alredy occupied this index.":n2+" has already occupied this index.");
                            y++;
                            break;
                        } 
                    }
                    
                    if(y==0) {
                        ar[a][b] = "((X))\t";
                        count[0][c] = a;
                        count[1][c] = b;
                        z++;
                    }
                    
                }
                System.out.println("\n");
            } while (z==0);
            
            
            if( ar[0][0]==ar[1][0] && ar[1][0]==ar[2][0] ) {
                win = true;
                if(ar[0][0]=="((O))\t")
                {
                    ar[0][0]="((@))\t";
                    ar[1][0]="((@))\t";
                    ar[2][0]="((@))\t";
                }                
                else
                {
                    ar[0][0]="((#))\t";
                    ar[1][0]="((#))\t";
                    ar[2][0]="((#))\t";
                }      
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[0][0]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[0][1]==ar[1][1] && ar[1][1]==ar[2][1] ) {
                win = true;
                if(ar[0][1]=="((O))\t")
                {
                    ar[0][1]="((@))\t";
                    ar[1][1]="((@))\t";
                    ar[2][1]="((@))\t";
                }  
                else
                {
                    ar[0][1]="((#))\t";
                    ar[1][1]="((#))\t";
                    ar[2][1]="((#))\t";
                }  
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[0][1]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[0][2]==ar[1][2] && ar[1][2]==ar[2][2] ) {
                win = true;
                if(ar[0][2]=="((O))\t")
                {
                    ar[0][2]="((@))\t";
                    ar[1][2]="((@))\t";
                    ar[2][2]="((@))\t";
                }  
                else
                {
                    ar[0][2]="((#))\t";
                    ar[1][2]="((#))\t";
                    ar[2][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[0][2]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[0][0]==ar[0][1] && ar[0][1]==ar[0][2] ) {
                win = true;
                if(ar[0][1]=="((O))\t")
                {
                    ar[0][0]="((@))\t";
                    ar[0][1]="((@))\t";
                    ar[0][2]="((@))\t";
                }  
                else
                {
                    ar[0][0]="((#))\t";
                    ar[0][1]="((#))\t";
                    ar[0][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }                
                System.out.println((ar[0][0]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[1][0]==ar[1][1] && ar[1][1]==ar[1][2] ) {
                win = true;
                if(ar[1][1]=="((O))\t")
                {
                    ar[1][0]="((@))\t";
                    ar[1][1]="((@))\t";
                    ar[1][2]="((@))\t";
                }  
                else
                {
                    ar[1][0]="((#))\t";
                    ar[1][1]="((#))\t";
                    ar[1][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[1][0]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[2][0]==ar[2][1] && ar[2][1]==ar[2][2] ) {
                win = true;
                if(ar[2][1]=="((O))\t")
                {
                    ar[0][0]="((@))\t";
                    ar[0][1]="((@))\t";
                    ar[0][2]="((@))\t";
                }  
                else
                {
                    ar[0][0]="((#))\t";
                    ar[0][1]="((#))\t";
                    ar[0][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[2][0]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[0][0]==ar[1][1] && ar[1][1]==ar[2][2] ) {
                win = true;
                if(ar[0][0]=="((O))\t")
                {
                    ar[0][0]="((@))\t";
                    ar[1][1]="((@))\t";
                    ar[2][2]="((@))\t";
                }  
                else
                {
                    ar[0][0]="((#))\t";
                    ar[1][1]="((#))\t";
                    ar[2][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }                
                System.out.println((ar[0][0]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }
            else if ( ar[2][0]==ar[1][1] && ar[1][1]==ar[0][2]) {
                win = true;
                if(ar[1][1]=="((O))\t")
                {
                    ar[2][0]="((@))\t";
                    ar[1][1]="((@))\t";
                    ar[0][2]="((@))\t";
                }  
                else
                {
                    ar[2][0]="((#))\t";
                    ar[1][1]="((#))\t";
                    ar[0][2]="((#))\t";
                } 
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j]+"\t");
                    }
                    System.out.println("\n\n\n");
                }
                System.out.println((ar[1][1]=="((O))\t")?n2+" is the winner!":n1+" is the winner!");
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 9; j++) {
                    if(count[i][j] == -5) {
                        k = -5;
                    }      
                }
            }

            if(k==0 && win==false) {
                System.out.println("Match drawn!!!");
                win = true;
            }
            
        } while(win == false);
        in.close();
    }
}
