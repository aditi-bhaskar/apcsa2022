package app.tictactoe;

public class game {

    public game(player p1, player p2, board b) {
        p1_ = p1;
        p2_ = p2;
        b_ = b;
        status_ = estatus.INCOMPLETE;
    }

    public estatus playgame() {
        while (status_ == estatus.INCOMPLETE){
            playno_++;
            if ((playno_)%2 == 0){       //  'O'
                int a = p2_.askformove();
                b_.setsquare(a, 'O');
                b_.printboard();
                if (b_.checkwin()){
                    status_ = estatus.O_WINS;
                } 
                if (b_.checkdraw() && (status_ != estatus.X_WINS || status_ != estatus.O_WINS)) {
                    status_ = estatus.DRAW;
                }
            } else {                     //  'X'
                int a = p1_.askformove();
                b_.setsquare(a, 'X');
                b_.printboard();
                if (b_.checkwin()){
                    status_ = estatus.X_WINS;
                } 
                if (b_.checkdraw() && (status_ != estatus.X_WINS || status_ != estatus.O_WINS)) {
                    status_ = estatus.DRAW;
                }
            }
        }

        return status_;
    }


    public enum estatus{
        INCOMPLETE, //0
        DRAW, //1
        X_WINS, //2
        O_WINS //3
    }  
    
    estatus status_;
    private player p1_;
    private player p2_;
    private int playno_ = 0;
    private board b_;

    
   

}
