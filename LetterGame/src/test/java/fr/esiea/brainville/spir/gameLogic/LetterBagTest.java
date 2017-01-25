package fr.esiea.brainville.spir.gameLogic;

/**
 * Created by arthu on 1/25/2017.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LetterBagTest {

    private LetterBag bag;
    private double margin;
    private int nbShots = 20000000;

    @Before
    public void setup()
    {
        bag = new LetterBag();

        //margin of error at 0.025%
        margin = 0.025;
    }

    @Test
    public void testIsFrequencySum100()
    {
        double[] frequencies = bag.getFrequencies();
        //Just to display if nothing is wrong here:
        float facc = 0;
        for(int i = 0; i < 26; ++i)
        {
            System.out.println("Freq of " + Character.toString((char)(65+i)) + " is : " + frequencies[i]);
            facc += frequencies[i];
        }
        System.out.println("sum of probabilities is : " + facc);

        assertEquals(100, facc, 0);
    }

    @Test
    public void testIsFrequencyOkay()
    {
        // % of chance that a letter is E
        final double target =17.85;

        //Happy variables
        double freq= 0;
        int gotE = 0;
        int currentShot = 0;

        for(currentShot = 0; currentShot< nbShots; ++currentShot)
        {
            if(bag.pick().getChar() == 'e')
                gotE++;
        }

        freq = (double)gotE / (double)nbShots;
        freq *=100;

        System.out.println("Freq of E from " + nbShots + " pick() in the olde bag o'letter is : " + freq + "%");

        assertEquals(target, freq, margin);
    }


}
