package fr.esiea.brainville.spir.gameLogic;

import fr.esiea.brainville.spir.main.Main;

import java.io.*;
import java.util.Random;


/**
 * Created by arthu on 1/25/2017.
 */
public class LetterBag {

    private double[] frequencies;
    Random randomGenerator;

    public double[] getFrequencies()
    {
        return frequencies;
    }

    public LetterBag() {
        randomGenerator = new Random();
        frequencies = new double[26];
        loadLetterFreq();

    }

    private void loadLetterFreq() {
        //TODO load file, extract freq in a array of 26 floats

        //open file
        System.out.println("Reading french letter frequency from file : ");
        try {
            InputStream freqFileSteam = getClass().getResourceAsStream("/frequency.txt");
            BufferedReader freqFileBufferedReader = new BufferedReader(new InputStreamReader(freqFileSteam));

            String buffer;
            int index=0;
            while ((buffer = freqFileBufferedReader.readLine()) != null) {
                //System.out.println(Float.parseFloat(buffer.substring(2)));
                frequencies[index++] = Double.parseDouble(buffer.substring(2));
            }
        }
        catch (FileNotFoundException e) { System.out.println("Cant find resource : frequency.txt");}
        catch (IOException e) {/*Insert sadness and hatred for Java here*/ }
    }

    public Letter pick() {
        return new Letter(getRandomWeightedFrenchChar());
    }

    private char getRandomWeightedFrenchChar() {
        //TODO impl for real

        int position = randomGenerator.nextInt(10000);

        int acc = 0;
        int alphabetLetter = 0;
        for(int i = 0; i < 26; ++i)
        {
            if(position >= acc && position <= acc+Math.round(frequencies[i]*100))
            {
                alphabetLetter = i;
                break;
            }
            acc+= Math.round(frequencies[i]*100);
        }


        char c = 'a';
        c += (char)alphabetLetter;


        return c;
    }
}
