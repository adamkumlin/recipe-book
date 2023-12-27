import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public static void main() {
        showMainMenu();
    }

    static void showMainMenu() {
        System.out.println("Welcome! Choose between the following options");
        System.out.println("-------------------------------------------------");

        boolean running = true;

        Scanner reader = new Scanner(System.in);

        while (running) {
            System.out.println("1. Add new recipe");
            System.out.println("2. Show recipes");
            System.out.println("3. Edit recipe");
            System.out.println("4. Delete recipe");
            System.out.println("5. Exit");

            int mainMenuChoice = Integer.parseInt(reader.nextLine());

            if (mainMenuChoice == 1) {
                Recipe newRecipe = Recipe.inputRecipeData(recipes, reader);
                Recipe.addRecipe(newRecipe, recipes);
            } else if (mainMenuChoice == 2) {
                Recipe.printRecipes(recipes);
            } else if (mainMenuChoice == 3) {
                Recipe.printRecipes(recipes);
                Recipe chosenRecipe = Recipe.chooseRecipe(recipes, "Enter the ID of the recipe you wish to edit", reader);
                Recipe editedRecipe = Recipe.editRecipe(chosenRecipe, recipes, reader);
                Recipe.deleteRecipe(chosenRecipe, recipes);
                Recipe.addRecipe(editedRecipe, recipes);
            } else if (mainMenuChoice == 4) {
                Recipe.printRecipes(recipes);
                Recipe recipeToDelete = Recipe.chooseRecipe(recipes, "Enter the ID of the recipe you wish to delete", reader);
                Recipe.deleteRecipe(recipeToDelete, recipes);
            } else if (mainMenuChoice == 5) {
                running = false;
                reader.close();
            }
        }
    }

}
