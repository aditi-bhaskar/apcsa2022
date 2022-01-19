package app.storybuilder;

import java.util.Scanner;

public class storybuilder {
  
  Scanner noun ;
  boolean isDone ;
  String a_word_ ;
  
  public storybuilder() {
    System.out.println("==========HOW TO PLAY==========") ;
    System.out.println("================================= "
                        + " \nenter 2 nouns [hit 'enter' between the two]" 
                        + " and a sentence will appear!"
                        + " \nthe game will magically end when"
                        + " certain conditions are met..."
                        + " \nhave fun!!!") ;

    System.out.print("\n ||||||||||||| \nOnce upon a time... \n") ;
    
    noun = new Scanner(System.in) ;
    isDone = false;
    a_word_ = "" ;
  
  }

  public void buildmeastory() {
    while (!isDone) {
      
      a_word_ = noun.nextLine() ;
      
      System.out.println(a_word_ + " " + verbfinder() + " " + noun.nextLine() + ".\n") ;
      
      if (a_word_.length() >= 5) {
        if (a_word_.substring(3, 4).equals("c") || a_word_.length() == 7) {
          System.out.println("The End!") ;
          isDone = true ;
        }
      }
      
    }
  }
  
  public String verbfinder() {
   
    int random = (int)(Math.random()*100);
    String return_verb_ = "" ;
    
    //use math.random 
    //have a list of 20 verbs and assign words to a set of math.random outputs

    //VERB IDEAS
      //0. went to
      //1. did a
      //2. ate a tonne of
      //3. spelled the word
      //4. cried because of
      //5. flicked a
      //6. swam to
      //7. annoyed
      //8. was kicked by
      //9. died because of
      //10. gave birth to
      //11. broke a
      //12. drank with
      //13. wrote on
      //14. played with
      //15. slept on
      //16. sat on
      //17. kissed a
      //18. got married to
      //19. flew to
      //20. got a concussion from

    if (random % 20 == 0)
      return_verb_ = "went to" ;
    else if (random % 20 == 1) 
      return_verb_ = "did a" ;
    else if (random % 20 == 2) 
      return_verb_ = "ate a tonne of" ;
    else if (random % 20 == 3) 
      return_verb_ = "spelled the word" ;
    else if (random % 20 == 4) 
      return_verb_ = "cried because of" ;
    else if (random % 20 == 5) 
      return_verb_ = "flicked a" ;
    else if (random % 20 == 6) 
      return_verb_ = "swam to" ;
    else if (random % 20 == 7) 
      return_verb_ = "annoyed" ;
    else if (random % 20 == 8) 
      return_verb_ = "was kicked by" ;
    else if (random % 20 == 9) 
      return_verb_ = "died because of";
    else if (random % 20 == 10) 
      return_verb_ = "gave birth to" ;
    else if (random % 20 == 11) 
      return_verb_ = "broke a" ;
    else if (random % 20 == 12) 
      return_verb_ = "drank with" ;
    else if (random % 20 == 13) 
      return_verb_ = "wrote on" ;
    else if (random % 20 == 14) 
      return_verb_ = "played with" ;
    else if (random % 20 == 15) 
      return_verb_ = "slept on" ;
    else if (random % 20 == 16) 
      return_verb_ = "sat on" ;
    else if (random % 20 == 17) 
      return_verb_ = "kissed a" ;
    else if (random % 20 == 18) 
      return_verb_ = "got married to" ;
    else if (random % 20 == 19) 
      return_verb_ = "flew to" ;
    else if (random % 20 == 20) 
      return_verb_ = "got a concussion from" ;

    //finally, return the "magic" verb
    return return_verb_ ;
  }
  
}
