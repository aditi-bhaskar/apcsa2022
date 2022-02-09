package app.storybuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class storybuilder {
  
  Scanner noun ;
  boolean isDone ;
  String a_word_ ;
  String b_word_ ;
  
  String curr_transition = "" ;
  boolean first_time_thru = true ;

  
  public storybuilder() {
    System.out.println("==========HOW TO PLAY==========") ;
    System.out.println("================================= "
                        + " \nenter 2 nouns [hit 'enter' between the two]" 
                        + " and a sentence will appear!"
                        + " \n keep writing more nouns and the story will grow!"
                        + " \nthe game will magically end when"
                        + " certain conditions are met..."
                        + " \nhave fun!!!") ;

    System.out.print("\n ||||||||||||| \nOnce upon a time... \n") ;
    
    noun = new Scanner(System.in) ;
    isDone = false;
    a_word_ = "" ;
    b_word_ = "" ;
  
  }

  public void buildmeastory() {
    while (!isDone) {
      
      if (!first_time_thru) {
        curr_transition = transitionfinder() ;
        System.out.println(curr_transition + "...") ;
      }

      a_word_ = noun.nextLine() ;
      b_word_ = noun.nextLine() ;

      if(a_word_.equals("") || b_word_.equals("")) {
        System.out.println("please enter 2 nouns") ;
        a_word_ = noun.nextLine() ;
        b_word_ = noun.nextLine() ;
      }
      
      if(first_time_thru) {
        System.out.println(a_word_ + " " + verbfinder() 
                            + " " + b_word_ + " " 
                            + locationfinder() + ".\n") ;
                            first_time_thru = false ;
      } else if (!first_time_thru) {
        System.out.println(curr_transition + " " 
                          + a_word_ + " " + verbfinder() 
                          + " " + b_word_ + " " 
                          + locationfinder() + ".\n") ;
      }
      
      if (a_word_.equals("secret") || a_word_.equals("42") || a_word_.equals("treasure")) {
        System.out.println("You have entered the secret lair!");
        System.out.println("You must answer the three passwords correctly!\n\n") ;
        
        System.out.println("1) print fibonacci's first 7; seperate by single spaces: ") ;
        if (noun.nextLine().equals("1 1 2 3 5 8 13 21")) {
          System.out.println("Congrats; you've passed level 1") ;
          
          System.out.println("2) what type of relation are these two primes? 7 and 11") ;
          String leveltwo = noun.nextLine() ;
          if (leveltwo.equals("cousin primes") || leveltwo.equals("cousin")) {
            System.out.println("Congrats; you've passed level 2") ;
            
            System.out.println("3) integer multiple of 3; don't type in 0 or 1 and try to be cool by using negatives") ;
              int treasurethree = noun.nextInt() ;
              if(treasurethree%3 == 0) {
                System.out.println("Congrats; you've passed level 3.\nyou are in the next...") ;
                treasureThree(treasurethree);
              }
              else {
                endStory("treasure", 3) ;
              }
          }
          else {
            endStory("treasure", 2) ;
          }

        } else {
          endStory("treasure", 1) ;
        }
      }
      
      if (a_word_.length() >= 5) {
        if (a_word_.substring(3, 4).equals("c") || a_word_.length() == 7 || a_word_.equals("q")) {
          endStory("regular") ;
        }
      }
      
    }
  }
  
  public String verbfinder() {
   
    int random = (int)(Math.random()*100);
    
    /*
        "The data abstraction must make the program easier to develop (alternatives would
      be more complex) or easier to maintain (future changes to the size of the list would
      otherwise require significant modifications to the program code)."
        // array list is useful here, because i don't have to pre-declare how many 
        //  verbs I want to add to my "little dictionary." I can simply add. having a seperate
        //  variable to store size adds about 3 lines of code and makes it more confusing when I
        //  get the size the array later. furthermore, failing to update that variable when I add
        // or remove from my list causes errors.
    */
    ArrayList<String> return_verb_ = new ArrayList<String>() ;

    return_verb_.add("went to") ;
    return_verb_.add("did a") ;
    return_verb_.add("ate a tonne of") ;
    return_verb_.add("spelled the word") ;
    return_verb_.add("cried because of") ;
    return_verb_.add("flicked a") ;
    return_verb_.add("swam to") ;
    return_verb_.add("annoyed") ;
    return_verb_.add("was kicked by") ;
    return_verb_.add("died because of") ;
    return_verb_.add("gave birth to") ;
    return_verb_.add("broke a") ;
    return_verb_.add("drank with") ;
    return_verb_.add("wrote on") ;
    return_verb_.add("played with") ;
    return_verb_.add("slept on") ;
    return_verb_.add("sat on") ;
    return_verb_.add("kissed a") ;
    return_verb_.add("got married to") ;
    return_verb_.add("flew to") ;
    return_verb_.add("got a concussion from") ;
    return_verb_.add("yelled at") ;
    return_verb_.add("was a goody goody to") ;
    return_verb_.add("played the fiddle with") ;
    return_verb_.add("sang with") ;
    return_verb_.add("yawned into the face of") ;


    //finally, return the "magic" verb
    return return_verb_.get((int)(random % return_verb_.size())) ;
  }

  public String locationfinder() {

    int random = (int)(Math.random()*100);

    ArrayList<String> return_location_ = new ArrayList<String>() ;

    //LOCATIONS    only up to  n-1 bc start at 0
    return_location_.add("at the beach") ;
    return_location_.add("at school") ;
    return_location_.add("in a coma") ;
    return_location_.add("for five minutes") ;
    return_location_.add("with an amiable disposition") ;
    return_location_.add("in the park") ;
    return_location_.add("in an airplane") ;
    return_location_.add("with their friends") ;
    return_location_.add("before reading a book with a similar theme") ;
    return_location_.add("in a pool") ;
    return_location_.add("in the Netherlands") ;
    return_location_.add("in the kitchen") ;
    return_location_.add("2 hours ago") ;
    return_location_.add("for 60 extraordinary seconds") ;
    return_location_.add("before they were caught by the police") ;
    return_location_.add("then bought a jacket") ;
    return_location_.add("on a couch") ;
    return_location_.add("in the mountains") ;
    return_location_.add("near a river") ;
    return_location_.add("in the backyard") ;
    return_location_.add("on the highway") ;
    return_location_.add("in fields of golden hay") ;
    return_location_.add("in bed") ;
    return_location_.add("on an island") ;
    return_location_.add("while watching TV") ;
    return_location_.add("in the mall") ;
    return_location_.add("atop a tree") ;
    return_location_.add("on the stairs") ;
    return_location_.add("behind the curtain") ;

    //finally, return the "magic" location
    return return_location_.get((int)(random % return_location_.size())) ;
  }

  public String transitionfinder() {

    int random = (int)(Math.random()*100) ;
    
    ArrayList<String> return_transition_ = new ArrayList<String>() ;

    return_transition_.add("then") ;
    return_transition_.add("on the other hand") ;
    return_transition_.add("therefore") ;
    return_transition_.add("and then") ;
    return_transition_.add("meanwhile") ;
    return_transition_.add("yesterday") ;
    return_transition_.add("later") ;
    return_transition_.add("so") ;
    return_transition_.add("back in the day") ;
    return_transition_.add("last week") ;

    //finally, return the "magic" transition phrase
    return return_transition_.get((int)(random % return_transition_.size())) ;

  }

  // function overloading - pass in different parameters...
  public void endStory(String which) {
    switch (which) {
      case "regular":
        System.out.println("The End!") ;
        break ;
      case "treasure" :
        System.out.println("Your story - your quest for the ultimate question - has ended") ;
        break ;
      case "fish" :
        System.out.println("\"So long and thanks for all the fish!\" ~Douglas Adams") ;
      default :
        System.out.println("...And so I graciously ended the story") ;
        break ;  
    }
    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||\n") ;
    isDone = true ;
  }

  public void endStory(String which, int level) {
    switch (which) {
      case "regular":
        System.out.println("The End!") ;
        break ;
      case "treasure":
        switch (level) {
          case 1: 
            System.out.println("You have failed level 1; good try") ;
            break ;
          case 2:
            System.out.println("You have failed level 2; good attempt") ;
            break ;
          case 3:
            System.out.println("You have failed level 3; good game") ;
            break ;
          default:
            System.out.println("good try") ;
            break ;
        }
        System.out.println("Your story - your quest for the ultimate question - has ended") ;
        break ;
      default:
        System.out.println("...And so I graciously end the story") ;
        break ;
    }
    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||\n") ;
    isDone = true ;
  }

  public void treasureThree(int input) {
    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||\n") ;
    if (input % 2 == 0) { // multiple of three ; even
      System.out.println("Here are some duck jokes and facts!\nAnatidaephobia: The fear that, somewhere, somehow, there is a duck watching you\nIf your beak hurts, call the ducktor!\nIf a duck can't pay for all its purchases, put it on its bill!") ;
      endStory("bleh") ;
    } else { // multiple of three ; odd
      System.out.println("\"What do you get if you multiply six by nine?\" \"Six by nine. Forty two.\" \"That's it. That's all there is.\" \"I always thought something was fundamentally wrong with the universe\"") ;
      System.out.println("\"There is an art, or, rather, a knack to flying. The knack lies in learning how to throw yourself at the ground and miss. Pick a nice day and try it. All it requires is simply the ability to throw yourself forward with all your weight, and the willingness not to mind that it's going to hurt. That is, it's going to hurt if you fail to miss the ground. Most people fall to miss the ground, and if they are really trying properly, the likelihood is that they will fail to miss it fairly hard. Clearly, it is the second part, the missing, which presents the difficulties. ... Waft higher and higher. Try a few swoops, gentle ones at first, then drift above the treetops breathing regularly. DO NOT WAVE AT ANYBODY.\" ") ;
      endStory("fish") ;
    }
  }

}
