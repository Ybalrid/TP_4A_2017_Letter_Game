package fr.esiea.brainville.spir.gameLogic;

/**
 * Created by arthu on 1/25/2017.
 */
public class LetterBag {

    private float[] frequencies;

    public LetterBag()
    {
        loadLetterFreq();
        frequencies = new float[26];
    }

    private void loadLetterFreq()
    {
        //TODO load file, extract freq in a array of 26 floats
    }

    public Letter pick()
    {
        return new Letter(getRandomWeightedFrenchChar());
    }

    private char getRandomWeightedFrenchChar()
    {
        //TODO impl for real
        char c = 'a';


        return c;
    }
}
