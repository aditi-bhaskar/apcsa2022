package app.tictactoe;

import java.util.Scanner;

public class humanplayer extends player {
    
    public humanplayer(board b)
    {
        super(b);
    }

    public int askformove() 
    {
        Scanner input = new Scanner(System.in) ;
        int a = 0;
    
        while (a < 1 || a > 9) {
            System.out.print("Enter square-number from 1 to 9: ");
            a = input.nextInt();
            if (a > 1 || a < 9) {
                if (b_.squareplayed(a)) {
                    System.out.print("Square taken. Choose another. ");
                    a = 0;                
                }
            }
        }

        return a;
    }

}
