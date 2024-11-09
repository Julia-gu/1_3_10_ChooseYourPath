import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasKey = false;
        boolean foundClue = false;
        boolean hasFlashlight = false;
        boolean escaped = false;

        System.out.println("You're standing in front of a haunted house. Do you want to go in? (yes/no)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            while (!escaped) { 
                System.out.println("You can go left, right, or head upstairs. Where do you want to go?");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("left")) {
                    System.out.println("You find yourself in a dusty library. There's a strange-looking key on the desk. Do you take it? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !hasKey) {
                        hasKey = true;
                        System.out.println("You grab the key and decided to keep it. It might be useful later!");
                    } else if (hasKey) {
                        System.out.println("You already took the key.");
                    }

                    System.out.println("There’s also an old, dusty book with a clue about an escape route. Do you want to read it? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !foundClue) {
                        foundClue = true;
                        System.out.println("The clue mentions a locked door upstairs that might lead to an exit.");
                    } else if (foundClue) {
                        System.out.println("You already read the clue.");
                    }

                } else if (choice.equalsIgnoreCase("right")) {
                    System.out.println("You walk into a dark, silent kitchen... but you noticed there might be something cabinet.");

                    System.out.println("Do you open the cabinet? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !hasFlashlight) {
                        hasFlashlight = true;
                        System.out.println("You find a flashlight inside the cabinet. This could be useful in the dark!");
                    } else if (hasFlashlight) {
                        System.out.println("You already have the flashlight.");
                    }

                } else if (choice.equalsIgnoreCase("upstairs")) {
                    System.out.println("You reach the top of the stairs and find a locked door.");

                    if (hasKey) {
                        System.out.println("You use the key to unlock the door.");
                        
                        if (foundClue) {
                            System.out.println("You remember the clue and search around, finding a hidden lever. When you pull it, a secret passage opens!");
                            escaped = true;
                        } else {
                            System.out.println("The door opens, but there's no obvious way out here. After searching, you come up empty.");
                        }
                    } else {
                        System.out.println("The door is locked, and you don't have the key. Looks like you’re stuck for now.");
                    }
                } else {
                    System.out.println("That's not an option. Try again.");
                }

                if (!escaped) {
                    System.out.println("Do you want to keep exploring? (yes/no)");
                    choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("no")) {
                        System.out.println("You leave the haunted house, deciding you've had enough adventure for today.");
                        break; 
                    }
                }
            }
        } else {
            System.out.println("You decide to stay outside. Maybe the haunted house is a little too creepy today.");
        }

        if (escaped) {
            System.out.println("Good job! You made it out of the haunted house!");
        }

        scanner.close();
    }
}
