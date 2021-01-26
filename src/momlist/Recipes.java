package momlist;
/**
 *
 * @author Zachcollins
 */
public class Recipes {

    private String recipeName;   //creates my int for the ID's of the team
    private String typeRecipe;    //creates string for the schools name
    private String instructions; //creates string for the city of the school
    private int date;
    private int servings;

    public Recipes(String rn, String tr, String i, int d, int s) {
        recipeName = rn;       //puts my values into the football team being created
        typeRecipe = tr;
        instructions = i;
        date = d;
        servings = s;

    }

    public String getRecipeName() {
        return recipeName;    //gets the teams Id that the user has entered
    }

    public String getRecipeType() {
        return typeRecipe;    //gets the school name that the user has entered 
    }

    public String getInstructions() {
        return instructions;    //gets the instructions
    }

    public int getDate() {
        return date;       //gets the dates
    }

    public int getServings() {
        return servings;       //gets the servings
    }

    public Recipes deepCopy() {
        Recipes clone = new Recipes(recipeName, typeRecipe, instructions, date, servings);  //creates a spot for a deep copy
        return clone;   //give copy
    }

    public int compareTo(String test) {
        return recipeName.compareTo(test);  //get the name and compare it
    }

    public String toString() {  //how the recipe is formated
        return ("Name of Recipe: " + recipeName + "\t | Type of Recipe: "
                + typeRecipe + "\t | How to make it: " + instructions + "\t | Date of last use: " + date + "\t | Serving size" + servings); //creates the list and the order that the values that I have gotten from my users to be put in and viewd
    }

}
