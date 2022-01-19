package app.blackjack;

public class Card {
    
    int[] value_ ;        // eg. 8 OR 13 OR 1
    String[] card_name_ ; // eg. Ace OR Five
    String[] card_suite_ ; // eg. Heart OR Spade

    public enum eplayer {
        DECK,
        PLAYERONE,
        PLAYERTWO
    }

    public Card() { 
        value_ = new int[52] ;
        card_name_ = new String[52] ; 

        for (int i = 0; i < 52; i++) {
            // VALUE of card
            value_[i] = i%13 + 1 ;    //ace = 1 and king = 13

            // CARD NAME
            if (value_[i] == 1) 
                card_name_[i] = "Ace" ;
            else if (value_[i] == 2) 
                card_name_[i] = "Two" ;
            else if (value_[i] == 3) 
                card_name_[i] = "Three" ;
            else if (value_[i] == 4) 
                card_name_[i] = "Four" ;
            else if (value_[i] == 5) 
                card_name_[i] = "Five" ;
            else if (value_[i] == 6) 
                card_name_[i] = "Six" ;
            else if (value_[i] == 7) 
                card_name_[i] = "Seven" ;
            else if (value_[i] == 8) 
                card_name_[i] = "Eight" ;
            else if (value_[i] == 9) 
                card_name_[i] = "Nine" ;
            else if (value_[i] == 10) 
                card_name_[i] = "Ten" ;
            else if (value_[i] == 11) 
                card_name_[i] = "Jack" ;
            else if (value_[i] == 12) 
                card_name_[i] = "Queen" ;
            else if (value_[i] == 13) 
                card_name_[i] = "King" ;
        
            // CARD SUITE
            if (i < 13)
                card_suite_[i] = "Spade" ;
            else if (i < 26) 
                card_suite_[i] = "Clubs" ; 
            else if (i < 39) 
                card_suite_[i] = "Heart" ; 
            else 
                card_suite_[i] = "Diamond" ; 

        }

    }

    // deal cards method
    // eplayer player
    
    // see card given player method

    //getter/setter methods for all class variables

}
