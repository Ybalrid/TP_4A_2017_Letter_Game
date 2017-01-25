package fr.esiea.brainville.spir.dictionary;

import fr.esiea.brainville.spir.dictionary.IDictionary;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test sample for Dictionary.
 */
public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setup() {
        //TODO

        dictionary = new Dictionary();
    }

    @Test
    public void testIsWord() {
       assertTrue(dictionary.isWord("maman"));
       assertFalse(dictionary.isWord("namam"));
    }

    @Test
    public void testIsEveryWordOnlyAscii()
    {
        Map<String, Word> content = dictionary.getContent();
        Iterator it = content.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            assertTrue(stringIsOnlyAscii((String)pair.getKey()));
        }
    }

    @Test
    public void testIsRejectingWordsCorrectly()
    {
        assertTrue(dictionary.notValid("presse-papier"));
        assertFalse(dictionary.notValid("chocolat"));
        assertTrue(dictionary.notValid("aujourd'hui"));
        assertTrue(dictionary.notValid("a priori"));
    }

    public final boolean stringIsOnlyAscii(String str)
    {
        //System.out.println("Testing " + str +" for ASCII");
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) > 122 || str.charAt(i) < 97)
            {
                System.out.println("Character " + str.charAt(i) + " in " + str + " is not ASCII");
                return false;
            }
        }

        return true;
    }
}
