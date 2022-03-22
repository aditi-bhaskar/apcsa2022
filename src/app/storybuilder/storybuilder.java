package app.storybuilder;

import java.util.ArrayList;
import java.util.Scanner;

// Storybuilder.
// Because I like to write
// and I like to write what is, essentially, nonsense
// and I like to re-read that nonsense,
// edit it,
// and make it all the more nonsensical.
// So here I write a class to build you your own nonsensical stories
// and hopefully you'll continue the story in your free time!

public class storybuilder {
  
  boolean isDone ;
  
  String curr_transition ;
  boolean first_time_thru ;

  public storybuilder(Scanner input) {
    
    System.out.println("==========HOW TO PLAY==========") ;
    System.out.println("================================= "
                        + " \nenter 2 nouns [hit 'enter' between the two]" 
                        + " and a sentence will appear!"
                        + " \nkeep writing more nouns and the story will grow!"
                        + " \nif you enter two nouns that start with the same letter,"
                        + " the verb output will alliterate"
                        + " \nthe game will magically end when"
                        + " you type \"object\" and \"class\"..."
                        + " \nhave fun!!!") ;

    System.out.print("\n ||||||||||||| \nOnce upon a time... \n\n") ;
    
    // setting globals
    isDone = false;
    curr_transition = "" ;
    first_time_thru = true ;

    String first_input ;
    String second_input ;
    
    // to consume remaining line, since nextInt() was prev method called 
    //  (in App.java) and it causes an error...
    input.nextLine() ;

    /* "Calls to your student-developed procedure" 
    */
    while (!isDone) {
      first_input = input.nextLine() ;
      second_input = input.nextLine() ;

      System.out.println(buildmeastory(input, first_input, second_input)); 
    }
  }

  /* "At least one procedure that contributes to the program’s intended purpose,
      where you have defined:
        ◆ the procedure’s name
        ◆ the return type (if necessary)
        ◆ one or more parameters "
  */
  
  // \name "buildmeastory"
  // \params Scanner "input", String "a_word", String "b_word"
  // \returns String - a single sentence in the story
  public String buildmeastory(Scanner input, String a_word, String b_word) {
    
    String ret = "" ;
    curr_transition = transitionfinder() ;

    /* Instructions for output (tactile, audible, visual, or textual) based on input and
        program functionality
    */

    if(a_word.equals("") || b_word.equals("")) {
      System.out.println("please enter 2 nouns") ;
    }
    else if (a_word.equals("object") && b_word.equals("class")) {
      ret += "An object is an instance of a class."  ;
      ret += "\n";
      ret += "The End!" ;
      isDone = true ;
    } 
    // first time thru case
    else if(first_time_thru) {
      ret += a_word + " " ;
      ret += verbfinder(false, "")  + " " ;
      ret += b_word + " " ;
      ret += locationfinder() + ".\n" ;

      first_time_thru = false ;

    } 
    // alliterating case
    else if (a_word.substring(0, 1).equals(b_word.substring(0, 1))) {
      ret += curr_transition + " "  ;
      ret += a_word + " " ;
      ret += verbfinder(true, a_word.substring(0, 1)) + " ";
      ret += b_word + " " ;
      ret += locationfinder()  + ".\n" ;

      first_time_thru = false ;
    }
    // regular/default path
    else {// (! first_time_thru) 
      ret += curr_transition + " "  ;
      ret += a_word + " " + verbfinder(false, "") ;
      ret += " " + b_word ;
      ret += " " + locationfinder() + ".\n" ;
    }
    
    return ret ;
  }
  
  // \param boolean isAlliterating defines whether or not returned verb will alliterate
  // \param String start says the start letter.
  public String verbfinder(boolean isAlliterating, String start) {
   
    String ret = "" ;
    int random = (int)(Math.random()*100);
    
    /*
        "The data abstraction must make the program easier to develop (alternatives would
      be more complex) or easier to maintain (future changes to the size of the list would
      otherwise require significant modifications to the program code)."
    */

    // array list is useful here, because I don't have to pre-declare how many 
    //  verbs I want to add to my "little dictionary." I can simply add. having a separate
    //  variable to store size adds about 3 lines of code and makes it more confusing when I
    //  modify the size of the array later. furthermore, failing to update that variable when I add
    // or remove from my list causes errors.
    ArrayList<String> return_verb_ = new ArrayList<String>() ;

    //VERBS
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
    return_verb_.add("hitchhiked to") ;
    return_verb_.add("bounced off") ;
    return_verb_.add("etched a") ;
    return_verb_.add("incited") ;
    return_verb_.add("jumped on") ;
    return_verb_.add("listed all the flaws of") ;
    return_verb_.add("magically appeared in front of") ;
    return_verb_.add("nodded along to") ;
    return_verb_.add("opted out of kayaking with") ;
    return_verb_.add("palavared with") ;
    return_verb_.add("quit") ;
    return_verb_.add("ran to") ;
    return_verb_.add("tricked") ;
    return_verb_.add("undoubtedly disliked") ;
    return_verb_.add("videoed") ;
    return_verb_.add("washed their car with") ;
    return_verb_.add("x'ed out the name of") ;
    return_verb_.add("zzzz'ed") ;

    ArrayList<String> selected_verbs = new ArrayList<String>() ;

    //ITERATION WITHIN FUNCTION!
    // find && store the "returnable" verbs in a new array. 
    for (int i = 0; i < return_verb_.size(); i++) {
      if (isAlliterating) { // alliterating case
        if (return_verb_.get(i).substring(0, 1).equals(start)) {
          //selection and appending
          selected_verbs.add(return_verb_.get(i)) ;
        }
      }
      else { // not alliterating case
        // adding all the verbs
        selected_verbs.add(return_verb_.get(i)) ;
      }
    }

    // selecting a random verb
    // utilize the .size() attribute of the ArrayList class
    if (selected_verbs.size() > 0){
      ret += selected_verbs.get((int)(Math.random() * (selected_verbs.size()))) ;
    } else { // no verbs in selected_verbs
      ret += return_verb_.get((int)(Math.random() * (return_verb_.size()))) ;
    }

    //finally, return the "magic" verb
    return ret ;
  }

  public String locationfinder() {

    int random = (int)(Math.random()*100);

    ArrayList<String> return_location_ = new ArrayList<String>() ;
    
    //LOCATIONS
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
    return_location_.add("while petting a duck") ;

    //finally, return the "magic" location
    return return_location_.get((int)(random % return_location_.size())) ;
  }

  public String transitionfinder() {

    int random = (int)(Math.random()*100) ;
    
    ArrayList<String> return_transition_ = new ArrayList<String>() ;

    //TRANSITIONS
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

}