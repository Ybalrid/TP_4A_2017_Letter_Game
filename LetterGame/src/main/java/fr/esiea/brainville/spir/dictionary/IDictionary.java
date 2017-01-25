package fr.esiea.brainville.spir.dictionary;

/**
 * Created on 16/01/17.
 */

//To be frank, this is just over-engineered. There's only one Dictionary on the program, you don't need an interface for
//making it's API general.

public interface IDictionary {
    boolean isWord(String word);
}
