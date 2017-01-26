package fr.esiea.brainville.spir.gameLogic;

import fr.esiea.brainville.spir.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Ybalrid on 24/01/2017.
 */
public class Game {
    private LetterBag bag;
    private LetterJar jar;
    private Dictionary dictionary;
    private Player p1, p2;
    private boolean gameRunning;

    public Game()
    {
        p1 = new Player(1);
        p2 = new Player(2);

        System.out.println("Creating a LetterBag");
        bag = new LetterBag();

        System.out.println("Creating a dictionary");
        dictionary = new Dictionary();

        System.out.println("Creating a LetterJar");
        jar = new LetterJar();

        gameRunning = true;
    }

    private void displayJarContent()
    {
        System.out.println("Content of the common jar :");
        ArrayList<Letter> jarContent = jar.getJarContentCopy();

        Iterator<Letter> letters = jarContent.iterator();
        int count = 0;
        while(letters.hasNext())
        {

            System.out.print(letters.next().getUpperChar());
            if(++count%40 == 0)
                System.out.print('\n');
            else
                System.out.print(' ');
        }
        System.out.print('\n');
    }

    public void run()
    {
//        System.out.println("just to see, pick 50000 letters");
//        for(int i = 0; i < 50000; ++i)
//        {
//            System.out.print(bag.pick().getUpperChar());
//            System.out.print(' ');
//            if((1+i)%100 == 0)
//            {
//                System.out.print('\n');
//            }
//        }

        gameLoop(getPlayer(gameStart()));

        gameEnd();

    }

    private void gameLoop(Player starter)
    {
        Player current = starter;
        while(gameRunning)
        {
            gameStep(current);
            current = getNext(current.getPlayerNumber());
        }
    }

    private void gameStep(Player player)
    {
        System.out.println("It's " + player.getName() + " turn!");
        System.out.println("You are picking 2 letters from the bag and putting them into the Jar");
        for(int i = 0; i < 2; i++)
        {
            Letter l = bag.pick();
            System.out.println(player.getName() + " got " + l.getUpperChar() + " from the bag of letters!");
            jar.addCommonLetter(l);
        }

        displayJarContent();

        System.out.println(player.getName() + ", Type a word you can make with theses letters. (leave blank if you can't find one)");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if(input.isEmpty())
        {
            System.out.println("End of your turn!");
            return;
        }

        //check for letters available in that string

        //check for existence of the word in the dictionary


    }

    private void gameEnd()
    {
        System.out.println("Thanks for playing!");
    }

    private Player getPlayer(int n)
    {
        if(n == 1) return p1;
        return p2;
    }

    private Player getNext(int n)
    {
        if(n == 1) return getPlayer(2);
        return getPlayer(1);
    }

    private int gameStart()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player ONE name: ?> ");
        p1.setPlayerName(scanner.nextLine());
        System.out.print("Enter Player TWO name: ?> ");
        p2.setPlayerName(scanner.nextLine());

        //Get p1's pick
        System.out.println(p1.getName() + " is picking a letter from the bag...");
        Letter l1 = bag.pick();
        System.out.println(p1.getName() + " picked letter : " + l1.getUpperChar() + " !");

        System.out.println(p2.getName() + " is picking a letter from the bag...");
        Letter l2 = bag.pick();
        System.out.println(p2.getName() + " picked letter : " + l2.getUpperChar() + " !");

        jar.addCommonLetter(l1);
        jar.addCommonLetter(l2);

        if(l1.getChar() > l2.getChar()) return 2;
        else return 1;
    }
}
