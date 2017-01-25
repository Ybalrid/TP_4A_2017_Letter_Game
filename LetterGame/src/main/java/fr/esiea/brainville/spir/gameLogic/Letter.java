package fr.esiea.brainville.spir.gameLogic;

/**
 * Created by arthu on 1/25/2017.
 */
public class Letter {

    char c;

    public Letter(char symbol)
    {
        c = symbol;
    }

    public char getChar()
    {
        return c;
    }

    public char getUpperChar()
    {
        char C = c;
        C-=32;
        return C;
    }


}
