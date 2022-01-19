package app.tictactoe;
import java.util.Scanner ;
import java.util.Random ;

public class computerplayer extends player {
    
    public computerplayer(board b)
    {
        super(b);
    }

    public int askformove() {

        //checks squares from 1 to 9
        int i = 1;
        int j = 2;
        int k = 3;
        boolean played = false;

        //rows
        for (i = 1; i <= 7 && played == false; i += 3, j += 3, k += 3)
        {
            played = linecheck(i, j, k);
        }

        //columns
        for (i = 1, j = 4, k = 7; i<=3 && played == false; i++, j++, k++) 
        {
            played = linecheck(i, j, k);
        }
    
        //diagonals
        if (played == false)
        {
            // + slope
            i = 7;
            j = 5;
            k = 3;
            played = linecheck(i, j, k);
        }
        if (played == false) 
        {
            // - slope
            i = 1;
            j = 5;
            k = 9;
            played = linecheck(i, j, k);
        }

        // tbd : add if there is ONE o played, play again in same row/col/diag if others in r/c/d are empty
        // circle zones checking around each square?

        //nothing to win ...
        if (played == false) {
            if (b_.squareplayed(5) == false) {
                move_= 5;
                played = true;
            }
            else {
                for (i = 1; i <= 9 && played == false; i += 2){
                    if (b_.squareplayed(i) == false) {
                        move_= i;
                        played = true;
                    }
                }
                for (i = 2; i <= 9 && played == false; i += 2){
                    if (b_.squareplayed(i) == false) {
                        move_= i;
                        played = true;
                    }
                }
            }
        }
        
        return move_;
    }

    //Computer-Player, 'O'  ->  Logic 
    public boolean linecheck(int i, int j, int k)
    {
        boolean played = false ; 
        
        if (b_.getsquare(i) == b_.getsquare(j) && b_.getsquare(k) != 'X' && b_.getsquare(k) != 'O') 
        {
            //b_.setsquare(k, 'O');
           move_= k;
            played = true;
        }
        else if (b_.getsquare(j) == b_.getsquare(k) && b_.getsquare(i) != 'X' && b_.getsquare(i) != 'O') 
        {
            //b_.setsquare(i, 'O');
           move_= i;
            played = true;
        }
        else if (b_.getsquare(i) == b_.getsquare(k) && b_.getsquare(j) != 'X' && b_.getsquare(j) != 'O') 
        {
            //b_.setsquare(j, 'O');
            move_ = j;
            played = true;
        }
        return played;
    }
    /*
    public int randomizer(int i, int j, int k, int l) {
        int a = 0, b = 0, c = 0, d = 0;
        rand.nextInt(i, j, k, l);
        //come back to this .... 
        return a, b, c, d;
    }
    */

    private int move_= 0;
    Random rand = new Random();
}