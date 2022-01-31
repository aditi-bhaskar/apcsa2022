package app.storybuilder;

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
    int n = 28 ; //number of verbs
    
    String[] return_verb_ = new String[n];
    //VERBS    only up to  n-1 bc start at 0
    return_verb_[0] = "went to" ;
    return_verb_[1] = "did a" ;
    return_verb_[2] = "ate a tonne of" ;
    return_verb_[3] = "spelled the word" ;
    return_verb_[4] = "cried because of" ;
    return_verb_[5] = "flicked a" ;
    return_verb_[6] = "swam to" ;
    return_verb_[7] = "annoyed" ;
    return_verb_[8] = "was kicked by" ;
    return_verb_[9] = "died because of" ;
    return_verb_[10] = "gave birth to" ;
    return_verb_[11] = "broke a" ;
    return_verb_[12] = "drank with" ;
    return_verb_[13] = "wrote on" ;
    return_verb_[14] = "played with" ;
    return_verb_[15] = "slept on" ;
    return_verb_[16] = "sat on" ;
    return_verb_[17] = "kissed a" ;
    return_verb_[18] = "got married to" ;
    return_verb_[19] = "flew to" ;
    return_verb_[20] = "got a concussion from" ;
    return_verb_[21] = "beesechurgered" ;
    return_verb_[22] = "yelled at" ;
    return_verb_[23] = "was a goody goody to" ;
    return_verb_[24] = "was more LOSER than" ;
    return_verb_[25] = "played the fiddle with" ;
    return_verb_[26] = "sang with" ;
    return_verb_[27] = "yawned into the face of" ;


    //finally, return the "magic" verb
    return return_verb_[(int)(random % n)] ;
  }

  public String locationfinder() {

    int random = (int)(Math.random()*100);
    int n = 29 ; //number of locations
    
    String[] return_location_ = new String[n];

    //LOCATIONS    only up to  n-1 bc start at 0
    return_location_[0] = "at the beach" ;
    return_location_[1] = "at school" ;
    return_location_[2] = "in a coma" ;
    return_location_[3] = "for five minutes" ;
    return_location_[4] = "with an amiable disposition" ;
    return_location_[5] = "in the park" ;
    return_location_[6] = "in an airplane" ;
    return_location_[7] = "with their friends" ;
    return_location_[8] = "before reading a book with a similar theme" ;
    return_location_[9] = "in a pool" ;
    return_location_[10] = "in the Netherlands" ;
    return_location_[11] = "in the kitchen" ;
    return_location_[12] = "2 hours ago" ;
    return_location_[13] = "for 60 extraordinary seconds" ;
    return_location_[14] = "before they were caught by the police" ;
    return_location_[15] = "then bought a jacket" ;
    return_location_[16] = "on a couch" ;
    return_location_[17] = "in the mountains" ;
    return_location_[18] = "near a river" ;
    return_location_[19] = "in the backyard" ;
    return_location_[20] = "on the highway" ;
    return_location_[21] = "in fields of golden hay" ;
    return_location_[22] = "in bed" ;
    return_location_[23] = "on an island" ;
    return_location_[24] = "while watching TV" ;
    return_location_[25] = "in the mall" ;
    return_location_[26] = "atop a tree" ;
    return_location_[27] = "on the stairs" ;
    return_location_[28] = "behind the curtain" ;

    //finally, return the "magic" location
    return return_location_[(int)(random % n)] ;
  }

  public String transitionfinder() {

    int random = (int)(Math.random()*100) ;
    int n = 10 ; //number of transitions
    
    String[] return_transition_ = new String[n] ;

    return_transition_[0] = "then" ;
    return_transition_[1] = "on the other hand" ;
    return_transition_[2] = "therefore" ;
    return_transition_[3] = "and then" ;
    return_transition_[4] = "meanwhile" ;
    return_transition_[5] = "yesterday" ;
    return_transition_[6] = "later" ;
    return_transition_[7] = "so" ;
    return_transition_[8] = "back in the day" ;
    return_transition_[9] = "last week" ;

    //finally, return the "magic" transition phrase
    return return_transition_[(int)(random % n)] ;
  }

  
  // TODO: do the breaks need to be in here?

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
    if (input % 2 == 0) { // multiple of three; even
      System.out.println("Here are some duck jokes and facts!\nAnatidaephobia: The fear that, somewhere, somehow, there is a duck watching you\nIf your beak hurts, call the ducktor!\nIf a duck can't pay for all its purchases, put it on its bill!") ;
      endStory("bleh") ;
    } else { // multiple of three ; odd
      System.out.println("\"What do you get if you multiply six by nine?\" \"Six by nine. Forty two.\" \"That's it. That's all there is.\" \"I always thought something was fundamentally wrong with the universe\"") ;
      System.out.println("\"There is an art, or, rather, a knack to flying. The knack lies in learning how to throw yourself at the ground and miss. Pick a nice day and try it. All it requires is simply the ability to throw yourself forward with all your weight, and the willingness not to mind that it's going to hurt. That is, it's going to hurt if you fail to miss the ground. Most people fall to miss the ground, and if they are really trying properly, the likelihood is that they will fail to miss it fairly hard. Clearly, it is the second part, the missing, which presents the difficulties. ... Waft higher and higher. Try a few swoops, gentle ones at first, then drift above the treetops breathing regularly. DO NOT WAVE AT ANYBODY.\" ") ;
      endStory("fish") ;
    }
  }

}
