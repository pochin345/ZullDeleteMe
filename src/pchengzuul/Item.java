package pchengzuul;

/**
 * an item in a room for our game
 *
 * @author  PoChin Cheng
 * @version 2021.12.26
 */

public class Item {
    private String description;
    private int weight;

    public Item(String description, int weight)
    {
        this.description = description;
        this.weight = weight;
    }

    private String getDescription()
    {
        return description;
    }

    private int getWeight()
    {
        return weight;
    }

    public String getLongDescription()
    {
        return getDescription() + " - " + getWeight() + " lbs";
    }
}
