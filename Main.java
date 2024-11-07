import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasKey = false;
        boolean foundClue = false;
        boolean hasFlashlight = false;
        boolean escaped = false;

        System.out.println("You are standing at the entrance of a spooky haunted house. Do you enter? (yes/no)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            while (!escaped) { 
                System.out.println("You can go left, right, or upstairs. Where do you go?");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("left")) {
                    System.out.println("You find an old library with a strange-looking key on the desk. Do you take it? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !hasKey) {
                        hasKey = true;
                        System.out.println("You took the key. It might be useful later!");
                    } else if (hasKey) {
                        System.out.println("You already have the key.");
                    }

                    System.out.println("There’s also a dusty book with a clue about an exit. Do you read it? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !foundClue) {
                        foundClue = true;
                        System.out.println("The clue hints at an escape route through a locked door upstairs.");
                    } else if (foundClue) {
                        System.out.println("You already read the clue.");
                    }

                } else if (choice.equalsIgnoreCase("right")) {
                    System.out.println("You enter a dark kitchen. There's an eerie silence... but you see a faint light coming from a cabinet.");
                    
                    System.out.println("Do you open the cabinet? (yes/no)");
                    choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes") && !hasFlashlight) {
                        hasFlashlight = true;
                        System.out.println("Inside the cabinet, you find a flashlight. This might help you see in dark places!");
                    } else if (hasFlashlight) {
                        System.out.println("You already have the flashlight.");
                    }

                } else if (choice.equalsIgnoreCase("upstairs")) {
                    System.out.println("At the top of the stairs, you find a locked door.");
                    
                    if (hasKey) {
                        System.out.println("You use the key to unlock the door.");
                        
                        if (foundClue) {
                            System.out.println("Remembering the clue, you find a hidden lever near the door. You pull it, and a secret passage opens!");
                            escaped = true;
                        } else {
                            System.out.println("The door opens, but there's no indication of an escape route here. You explore further but find nothing.");
                        }
                    } else {
                        System.out.println("The door is locked, and you don't have the key. You're stuck!");
                    }
                } else {
                    System.out.println("Invalid choice. Try again.");
                }

                if (!escaped) {
                    System.out.println("Would you like to keep exploring? (yes/no)");
                    choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("no")) {
                        System.out.println("Thanks for playing. Better luck next time!");
                        break; 
                    }
                }
            }
        } else {
            System.out.println("You decide not to enter. Maybe another day.");
        }

        if (escaped) {
            System.out.println("Congratulations! You escaped the haunted house using your wits and courage.");
        }

        scanner.close();
    }
}
