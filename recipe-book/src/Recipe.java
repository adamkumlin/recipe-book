import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    public int id;
    public String title;
    public String content;

    private Recipe(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static Recipe inputRecipeData(ArrayList<Recipe> recipes, Scanner reader) {
        System.out.println("New recipe");
        System.out.println("--------------------------");
        System.out.println();

        int id = recipes.size();

        System.out.print("Title: ");
        String title = reader.nextLine();

        System.out.print("Content: ");
        String content = reader.nextLine();

        Recipe recipe = new Recipe(id, title, content);

        return recipe;
    }

    public static void addRecipe(Recipe recipe, ArrayList<Recipe> recipes) {
        recipes.add(recipe);
    }

    public static void printRecipes(ArrayList<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            System.out.println("Id:" + recipe.id);
            System.out.println("Title:" + recipe.title);
            System.out.println("Content:" + recipe.content);
            System.out.println();
        }
    }

    public static Recipe chooseRecipe(ArrayList<Recipe> recipes, String prompt, Scanner reader) {
        System.out.println(prompt);
        System.out.println();

        Recipe chosenRecipe = null;

        int id = Integer.parseInt(reader.nextLine());

        for (Recipe recipe : recipes) {
            if (recipe.id == id) {
                chosenRecipe = recipe;
                break;
            }
        }

        return chosenRecipe;
    }

    public static Recipe editRecipe(Recipe recipe, ArrayList<Recipe> recipes, Scanner reader) {
        System.out.println("What do you want to edit?");
        System.out.println();
        System.out.println("1. Title");
        System.out.println("2. Content");

        int mainMenuChoice = Integer.parseInt(reader.nextLine());

        if (mainMenuChoice == 1) {
            System.out.print("Title: ");
            String title = reader.nextLine();
            recipe.title = title;
        } else if (mainMenuChoice == 2) {
            System.out.print("Content: ");
            String content = reader.nextLine();
            recipe.content = content;
        }

        return recipe;
    }

    public static void deleteRecipe(Recipe recipe, ArrayList<Recipe> recipes) {
        recipes.remove(recipe);
    }
}
