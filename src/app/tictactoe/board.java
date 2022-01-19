package app.tictactoe;

public class board {

    char tictactoe[];

    public board() 
    {
        tictactoe = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void clearboard() 
    {
        tictactoe[0] = '1';
        tictactoe[1] = '2';     
        tictactoe[2] = '3';
        tictactoe[3] = '4';
        tictactoe[4] = '5';
        tictactoe[5] = '6';
        tictactoe[6] = '7';
        tictactoe[7] = '8';
        tictactoe[8] = '9';
    }

    public void printboard() 
    {
        System.out.println("\n\t------------------");
        for (int i = 0; i < 9; i++) {
            if ((i+1)%3 == 0){
                System.out.println("\t" + tictactoe[i] + "\n\t------------------");
            } else {
                System.out.print("\t" + tictactoe[i] + "   |");   
            }
        }
    }

    public void setsquare(int sqno, char player)
    {
        //player can be 'X' or 'O'
        tictactoe[sqno-1] = player;
    }

    public char getsquare(int sqno)
    {
        char content = tictactoe[sqno-1];
        return content;
    }

    public boolean squareplayed(int sqno)
    {
        if ((tictactoe[sqno-1] == 'X' || tictactoe[sqno-1] == 'O'))
            return true;
        else
            return false;
    }

    public boolean checkwin() 
    {
        boolean win = false;

        // All 8 possible ways to win (get 3 in a row)
       
        if (tictactoe[0] == tictactoe[1] && tictactoe[1] == tictactoe[2])
            win = true; //row 1
        else if (tictactoe[3] == tictactoe[4] && tictactoe[4] == tictactoe[5])
            win = true; //row2
        else if (tictactoe[6] == tictactoe[7] && tictactoe[7] == tictactoe[8])
            win = true; //row3
        else if (tictactoe[0] == tictactoe[3] && tictactoe[3] == tictactoe[6])
            win = true; //column1
        else if (tictactoe[1] == tictactoe[4] && tictactoe[4] == tictactoe[7])
            win = true; //column2
        else if (tictactoe[2] == tictactoe[5] && tictactoe[5] == tictactoe[8])
            win = true; //column3
        else if (tictactoe[6] == tictactoe[4] && tictactoe[4] == tictactoe[2])
            win = true; //diag +slope
        else if (tictactoe[0] == tictactoe[4] && tictactoe[4] == tictactoe[8])
            win = true; //diag -slope
        
        
        return win;
    }

    public boolean checkdraw()
    {
        boolean draw = false;

        int k = 0;

        for (int i = 0; i < 9; i++) {
            if (tictactoe[i] == 'X' || tictactoe[i] == 'O') {
                k++;
            }
            else {
                break;
            }
        }
        if (k == 9) {
            draw = true;
        }
        
        return draw;

    }
}

