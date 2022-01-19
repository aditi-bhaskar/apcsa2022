package app;
import java.util.Scanner ;

import app.tictactoe.board;
import app.tictactoe.computerplayer;
import app.tictactoe.game;
import app.tictactoe.humanplayer;
import app.tictactoe.player;

import app.storybuilder.storybuilder;

public class App {

    static board tictactoe = new board();
    public static void main(String[] args) throws Exception {
        
        System.out.println("\n \n") ;
        Scanner s = new Scanner(System.in) ;

        int game = 0 ;

        while (game >= 0 && game <= 1)  { // change limits as more games are added
            System.out.println("Which game do you want to play? (enter the number)") ;
            System.out.println("\t 0 - TicTacToe") ;
            System.out.println("\t 1 - StoryBuilder") ;

            game = s.nextInt() ;

            if (game == 0) { // TICTACTOE
                System.out.println("TicTacToe Game");

                player p1 = new humanplayer(tictactoe);
                player p2 = new computerplayer(tictactoe);

                tictactoe.printboard();

                game g = new game(p1, p2, tictactoe);

                System.out.println(g.playgame()); 
                
                return;
            } 
            else if(game == 1) { // STORYBUILDER
                System.out.println("StoryBuilder Game");
                
                storybuilder story = new storybuilder();
                story.buildmeastory() ;

                return;
            }
        
        }
        


    /* DEAD CODE!!!!!!!!!!
        while (tictactoe.checkwin() == false){

            //Human Play
            int a = p1.askformove();
            tictactoe.setsquare(a, 'X');
            tictactoe.printboard();
            if (tictactoe.checkwin()){
                System.out.println(" 'X' Wins!");
                break;
            } else if (tictactoe.checkdraw()) {
                System.out.println("Draw!");
                break;
            }
           
            //ComputerPlay
            int n = p2.askformove();
            tictactoe.setsquare(n, 'O');
            tictactoe.printboard();
            if (tictactoe.checkwin()){
                System.out.println(" 'O' Wins!");
                break;
            } else if (tictactoe.checkdraw()) {
                System.out.println("Draw!");
                break;
            }

        }
    */

    }

}
