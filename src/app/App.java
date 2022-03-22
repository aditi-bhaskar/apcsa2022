package app;
import java.util.Scanner ;

import app.storybuilder.storybuilder;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("\n \n") ;
        Scanner s = new Scanner(System.in) ;

        int game = 0 ;

        while (game >= 0 && game <= 1)  { 
            
            /* "instructions for input from... the user (including user actions that trigger events)"
            */
            
            System.out.println("Play or Quit? (enter the number)") ;
            System.out.println("\t 0 - Quit") ;
            System.out.println("\t 1 - Play StoryBuilder") ;

            game = s.nextInt() ;
            while (game < 0 && game > 1) {
                System.out.println("enter one of the following numbers") ;
                System.out.println("\t 0 - Quit") ;
                System.out.println("\t 1 - StoryBuilder") ;
    
                game = s.nextInt() ;
            }

            // to consume remaining line, since nextInt() was prev method called 
            //  (in App.java) and it causes an error...
            s.nextLine() ;

            if (game == 0) { // QUIT
                System.out.println("QUITTING?");
                System.out.println("You have successfully quit."); 
                return ;
            } 
            if(game == 1) { // STORYBUILDER
                System.out.println("Storybuilder Game");
                storybuilder story = new storybuilder();
                story.createMyStory(s);
                return ;
            }  
        }

        s.close() ;
        
    }

}
