package fr.esiea.brainville.spir.gameLogic;

/**
 * Created by arthu on 1/26/2017.
 */
public class Player {
    private int playerNumber;
    private String name;

    public Player(int number)
    {
        playerNumber = number;
        name = "not set";
    }

    public void setPlayerName(String newName)
    {
        if(name == "not set")
            name = newName;
    }

    public String getName()
    {
        return name;
    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }
}
