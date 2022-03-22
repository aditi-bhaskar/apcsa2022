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

  // declaring all sets of words as global
  ArrayList<String> verbs_ ;
  ArrayList<String> locations_ ;
  ArrayList<String> transitions_ ;

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

    // FILLING UP MY ARRAYLISTS -
    // array list is useful here, because I don't have to pre-declare how many 
    // verbs I want to add to my "little dictionary." I can simply add. having a separate
    // variable to store size adds about 3 lines of code and makes it more confusing when I
    // modify the size of the array later. furthermore, failing to update that variable when I add
    // or remove from my list causes errors.
    
    //VERBS
    verbs_ = new ArrayList<String>() ;
    verbs_.add("went to") ;
    verbs_.add("did a") ;
    verbs_.add("ate a tonne of") ;
    verbs_.add("spelled the word") ;
    verbs_.add("cried because of") ;
    verbs_.add("flicked a") ;
    verbs_.add("swam to") ;
    verbs_.add("annoyed") ;
    verbs_.add("was kicked by") ;
    verbs_.add("died because of") ;
    verbs_.add("gave birth to") ;
    verbs_.add("broke a") ;
    verbs_.add("drank with") ;
    verbs_.add("wrote on") ;
    verbs_.add("played with") ;
    verbs_.add("slept on") ;
    verbs_.add("sat on") ;
    verbs_.add("kissed a") ;
    verbs_.add("got married to") ;
    verbs_.add("flew to") ;
    verbs_.add("got a concussion from") ;
    verbs_.add("yelled at") ;
    verbs_.add("was a goody goody to") ;
    verbs_.add("played the fiddle with") ;
    verbs_.add("sang with") ;
    verbs_.add("yawned into the face of") ;
    verbs_.add("hitchhiked to") ;
    verbs_.add("bounced off") ;
    verbs_.add("etched a") ;
    verbs_.add("incited") ;
    verbs_.add("jumped on") ;
    verbs_.add("listed all the flaws of") ;
    verbs_.add("magically appeared in front of") ;
    verbs_.add("nodded along to") ;
    verbs_.add("opted out of kayaking with") ;
    verbs_.add("palavared with") ;
    verbs_.add("quit") ;
    verbs_.add("ran to") ;
    verbs_.add("tricked") ;
    verbs_.add("undoubtedly disliked") ;
    verbs_.add("videoed") ;
    verbs_.add("washed their car with") ;
    verbs_.add("x'ed out the name of") ;
    verbs_.add("zzzz'ed") ;

    //LOCATIONS
    locations_ = new ArrayList<String>() ;
    locations_.add("at the beach") ;
    locations_.add("at school") ;
    locations_.add("in a coma") ;
    locations_.add("for five minutes") ;
    locations_.add("with an amiable disposition") ;
    locations_.add("in the park") ;
    locations_.add("in an airplane") ;
    locations_.add("with their friends") ;
    locations_.add("before reading a book with a similar theme") ;
    locations_.add("in a pool") ;
    locations_.add("in the Netherlands") ;
    locations_.add("in the kitchen") ;
    locations_.add("2 hours ago") ;
    locations_.add("for 60 extraordinary seconds") ;
    locations_.add("before they were caught by the police") ;
    locations_.add("then bought a jacket") ;
    locations_.add("on a couch") ;
    locations_.add("in the mountains") ;
    locations_.add("near a river") ;
    locations_.add("in the backyard") ;
    locations_.add("on the highway") ;
    locations_.add("in fields of golden hay") ;
    locations_.add("in bed") ;
    locations_.add("on an island") ;
    locations_.add("while watching TV") ;
    locations_.add("in the mall") ;
    locations_.add("atop a tree") ;
    locations_.add("on the stairs") ;
    locations_.add("behind the curtain") ;
    locations_.add("while petting a duck") ;

    //TRANSITIONS
    transitions_ = new ArrayList<String>() ;
    transitions_.add("then") ;
    transitions_.add("on the other hand") ;
    transitions_.add("therefore") ;
    transitions_.add("and then") ;
    transitions_.add("meanwhile") ;
    transitions_.add("yesterday") ;
    transitions_.add("later") ;
    transitions_.add("so") ;
    transitions_.add("back in the day") ;
    transitions_.add("last week") ;


    // FINALLY, actually getting to the program's most 
    // important part -  building a story!!
    /* "Calls to your student-developed procedure" */
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
    // in turn, buildmeastory is called from the constructor
    
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
    
    /*
        "The data abstraction must make the program easier to develop (alternatives would
      be more complex) or easier to maintain (future changes to the size of the list would
      otherwise require significant modifications to the program code)."
    */

    // the ArrayList “verbs_” was declared global, so any time when “verbs_” is
    // used in this method, it’s referring to that ArrayList.
    ArrayList<String> selected_verbs = new ArrayList<String>() ;

    //ITERATION WITHIN FUNCTION!
    // find && store the "returnable" verbs in a new array. 
    for (int i = 0; i < verbs_.size(); i++) {
      if (isAlliterating) { // alliterating case
        if (verbs_.get(i).substring(0, 1).equals(start)) {
          //selection and appending
          selected_verbs.add(verbs_.get(i)) ;
        }
      }
      else { // not alliterating case
        // adding all the verbs
        selected_verbs.add(verbs_.get(i)) ;
      }
    }

    // selecting a random verb
    // utilize the .size() attribute of the ArrayList class
    if (selected_verbs.size() > 0){
      ret += selected_verbs.get((int)(Math.random() * (selected_verbs.size()))) ;
    } else { // no verbs in selected_verbs
      ret += verbs_.get((int)(Math.random() * (verbs_.size()))) ;
    }

    //finally, return the random verb
    return ret ;
  }

  public String locationfinder() {
    
    //return the random location
    return locations_.get((int)(Math.random() * locations_.size())) ;
  }

  public String transitionfinder() {
  
    //return the random transition phrase
    return transitions_.get((int)(Math.random() * transitions_.size())) ;

  }

}