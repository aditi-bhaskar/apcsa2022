package app.tictactoe;

public abstract class player {
    
    player(board b)
    {   
        b_ = b;

    }

    protected board getBoard()
    {
        return b_;
    }
    
    public abstract int askformove();

    protected board b_;
}

