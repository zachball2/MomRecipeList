package momlist;

import javax.swing.JOptionPane;

/**
 *
 * @author Zachcollins
 */
public class MomList {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Whats your name?");
        String greeting = JOptionPane.showInputDialog("How are you?");
        if (greeting.equalsIgnoreCase("good") || greeting.equalsIgnoreCase("great") || greeting.equalsIgnoreCase("terriffic") || greeting.equalsIgnoreCase("amazing") || greeting.equalsIgnoreCase("awesome")) {
            JOptionPane.showMessageDialog(null, "Im glad youre having a good day");
        }
        if (greeting.equalsIgnoreCase("bad") || greeting.equalsIgnoreCase("not good") || greeting.equalsIgnoreCase("pretty bad") || greeting.equalsIgnoreCase("terriable") || greeting.equalsIgnoreCase("very bad")) {
            JOptionPane.showMessageDialog(null, "I hope your day starts to get better :D)");
        }
        String menu = "";   //creates a menu spot
        JOptionPane.showMessageDialog(null, "Hey " + name + " welcome to my program" //welcome message
                + "\nIn this program you'll be able to make"
                + "\na list of recipes that you'll be able to reference"
                + "\nYou'll be able to add, delete, change, and see all the recipes in the list");

        JOptionPane.showMessageDialog(null, "By: Zach Collins"
                + "\nCSC 222"
                + "\nProf: Plunkett"); //welcome message

        //String playAgain = "y";
        NodeOfRecipe r = new NodeOfRecipe();
        while (!menu.equalsIgnoreCase("Q")) { //While loop for the main program

            menu = JOptionPane.showInputDialog("(A) to add to the recipe" //menu
                    + "\n(D) to delete a recipe"
                    + "\n(O) to show one recipe"
                    + "\n(C) to change recipe"
                    + "\n(S) to show all recipes"
                    + "\n(Q) to quit");

            //String cont = "y";
            if (menu.equalsIgnoreCase("A")) {   //Adding a new player

                String newName = JOptionPane.showInputDialog(null, "Whats the name of the recipe?");    //gets the name
                String recipeType = JOptionPane.showInputDialog(null, "What type of recipe?");  //gets the recipe type
                String instructions = JOptionPane.showInputDialog(null, "How do make the recipe?"); //gets intructions
                int date = Integer.parseInt(JOptionPane.showInputDialog(null, "Whats the date it was last used(XX/YY/ZZ)?"));   //gets dates
                int serving = Integer.parseInt(JOptionPane.showInputDialog(null, "How many serving sizes?"));   //gets serving size

                Recipes b = new Recipes(newName, recipeType, instructions, date, serving);  //builds recipe and format

                r.insert(b);    //inserts recipe
            }

            if (menu.equalsIgnoreCase("D")) {   //removing a recipe
                String newName = JOptionPane.showInputDialog(null, "What's the name of the recipe you want to delete?");    //ask fo r the recipe to delete
                r.delete(newName);  //finds and delets the recipes
            }
            if (menu.equalsIgnoreCase("O")) { //show one recipe
                String recipeType = JOptionPane.showInputDialog("What type recipe are you searching for?"); //ask for the recipe

                Recipes i = r.search(recipeType);   //creates recipe and serches it
                JOptionPane.showMessageDialog(null, i);  //Prints the one recipe
            }
            if (menu.equalsIgnoreCase("C")) {   //Change a recipe
                String delete = JOptionPane.showInputDialog("What recipe would you like to update?");   //creates recipe and ask what recipe
                String newName = JOptionPane.showInputDialog(null, "Whats the name of the recipe?");    //creates name
                String recipeType = JOptionPane.showInputDialog(null, "What type of recipe?");  //creates and ask for the recipe type
                String instructions = JOptionPane.showInputDialog(null, "How do make the recipe?"); //gets instuctions
                int date = Integer.parseInt(JOptionPane.showInputDialog(null, "Whats the date it was last used(XX/YY/ZZ)?"));   //creates date
                int serving = Integer.parseInt(JOptionPane.showInputDialog(null, "How many serving sizes?"));   //creates serving sizes
                Recipes b = new Recipes(newName, recipeType, instructions, date, serving);  //creates the recipe
                r.update(delete, b);    //updates and deletes the prior recipe and creates a new one

            }
            if (menu.equalsIgnoreCase("S")) {   //Displaying all of the recpies
                String t = JOptionPane.showInputDialog("What recipe type?");    //gets the type
                //r.showAll(t);
                //String t = Recipes b;
                r.showAll(t);   //shows those type

            }
            if (menu.equalsIgnoreCase("Q")) {   //Displaying all of the players
                JOptionPane.showMessageDialog(null, "Thanks for using my program " + name);
                JOptionPane.showMessageDialog(null, "This program will cost you 1,000,000$ to purchase\nOnly accepting cash!!");//exit message
                break;  //exit
            }

        }

    }
}
