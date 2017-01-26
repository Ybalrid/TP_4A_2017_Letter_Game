package fr.esiea.brainville.spir.gameLogic;

import java.util.ArrayList;

/**
 * Created by arthu on 1/26/2017.
 */
public class LetterJar {

    ArrayList<Letter> jarContent;

    public LetterJar()
    {
        jarContent = new ArrayList<Letter>();
    }

    public void addCommonLetter(Letter l)
    {
        jarContent.add(l);
    }

    public ArrayList<Letter>  getJarContentCopy()
    {
        return new ArrayList<Letter>(jarContent);
    }

}
