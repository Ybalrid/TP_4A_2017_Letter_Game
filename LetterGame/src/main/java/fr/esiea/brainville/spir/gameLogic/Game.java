package fr.esiea.brainville.spir.gameLogic;

/**
 * Created by Ybalrid on 24/01/2017.
 */
public class Game {
    private LetterBag bag;

    public Game()
    {
        bag = new LetterBag();



    }

    public void run()
    {
        System.out.println("just to see, pick 50000 letters");
        for(int i = 0; i < 50000; ++i)
        {
            System.out.print(bag.pick().getUpperChar());
            System.out.print(' ');
            if((1+i)%100 == 0)
            {
                System.out.print('\n');
            }
        }

    }
}
