package fr.esiea.brainville.spir.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arthu on 1/25/2017.
 */
public class Dictionary implements IDictionary {

    Map<String, Word> dictionaryContent;
    public Dictionary()
    {
        dictionaryContent = new HashMap<String, Word>();
        //Load dictionary file

        InputStream freqFileSteam = getClass().getResourceAsStream("/dico.txt");
        BufferedReader freqFileBufferedReader = new BufferedReader(new InputStreamReader(freqFileSteam));

        String buffer; String asciiWord;
        try{
        while((buffer = freqFileBufferedReader.readLine()) != null)
        {
            asciiWord = conformToAscii(buffer);

            //System.out.println("Dictionary entry : " + asciiWord);
            if(notValid(asciiWord)) continue;
            dictionaryContent.put(asciiWord, new Word(asciiWord));
        }
        }
        catch(IOException e)
        {
            //Just because.
            e.printStackTrace();
        }
    }

    /**
     * Replace eventual non ascii char to the corresponding letter
     * @param input a word that may contain non ascii char
     * @return same word as input, but without non ASCII stuff (e.g. Ê -> E)
     */
    private String conformToAscii(String input)
    {
        //TODO impl for real

        if(input == "führer" || input == "führers") return "trump";

        input = input.replace('é', 'e');
        input = input.replace('è', 'e');
        input = input.replace('ê', 'e');
        input = input.replace('ë', 'e');
        input = input.replace('î', 'i');
        input = input.replace('û', 'u');
        input = input.replace('ï', 'i');
        input = input.replace('â', 'a');
        input = input.replace('ö', 'o');
        input = input.replace('ç', 'c');
        input = input.replace('ô', 'o');
        input = input.replace('ç', 'c');
        input = input.replace('ü', 'u');
        input = input.replace('ñ', 'n');
        input = input.replace('à', 'a');
        input = input.replace('ã', 'a');


        return input;
    }

    public final boolean notValid(String w)
    {
        if(w.contains("-")) return true;
        if(w.contains(" ")) return true;
        if(w.contains("'")) return true;
        if(w.contains(".")) return true;

        return false;
    }

    public boolean isWord(String word)
    {
        Word w = dictionaryContent.get(word);
            if(w == null)
                return false;
        return true;
    }

    public Map<String, Word> getContent() {
        return dictionaryContent;
    }
}
