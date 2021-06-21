package bullscows;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthUnique = 0;
        int possibleSymbols = 0;
        Random random = new Random();
        System.out.println("Input the length of the secret code:");

        
        try {
            lengthUnique = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (lengthUnique <= 0) {
            System.out.println("Error: The length of the secret number should be greater than 0!");
            return;
        }
        if (lengthUnique > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        } else {
            System.out.println("Input the number of possible symbols in the code:");

            try {
                possibleSymbols = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
                if (possibleSymbols < lengthUnique) {
                    System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", lengthUnique, possibleSymbols);
                    return;
                }
                if (possibleSymbols > 36) {
                    System.out.print("Error: Number of possible symbols should be equal or less than 36 and greater than 0.\n");
                    return;
                }

            StringBuilder stAsterisk = new StringBuilder();
            int count = lengthUnique;
            while (count > 0) {
                stAsterisk.append("*");
                count--;
            }
            char firstChar;
            char lastChar;

            if (possibleSymbols > 10) {
                firstChar = 'a';
                lastChar = (char) (possibleSymbols - 10 + 'a' -1);
                System.out.printf("The secret is prepared: %s (0-9,%s-%s).%n",stAsterisk,firstChar,lastChar);
            } else {
                System.out.printf("The secret is prepared: %s (0-9).%n",stAsterisk);
            }

            System.out.println("Okay, let's start a game!");

        }

        char randomSymbol;
        StringBuilder checkUnique = new StringBuilder();
        StringBuilder distinctString = new StringBuilder();

        while (distinctString.length() < lengthUnique) { // add (length - 1) digits to the StringBuilder
            if (possibleSymbols > 10) {
                randomSymbol = (char) (random.nextInt(2) == 0 ? random.nextInt(10) + 48: random.nextInt(possibleSymbols - 10) + 97);
            } else {
                randomSymbol = (char) (random.nextInt(possibleSymbols) + 48);
            }
            if (!checkUnique.toString().contains(randomSymbol + "")) {
                checkUnique.append(randomSymbol);
                distinctString.append(randomSymbol);
            }
        }
        System.out.println(distinctString);
        System.out.println(distinctString.length());
        grade(scanner, distinctString);

    }

    public static void grade(Scanner scanner, StringBuilder distinctString) {
        int turnCount = 0;
        while (true) {

            int bull = 0;
            int cow = 0;
            turnCount++;

            System.out.println("Turn " + turnCount + ":");

            String input = scanner.next();
            if (input.length() != distinctString.length()) {
                System.out.println("Error: Enter number of the same length as of secret code: " + distinctString.length());
                return;
            }

            String stGuess = new String(distinctString);

            for (int i = 0; i < stGuess.length(); i++) {
                for (int j = 0; j < stGuess.length(); j++) {
                    boolean equal = stGuess.charAt(i) == input.charAt(j);
                    if (i == j) {
                        if (equal) {
                            bull++;
                        }
                    }
                    if (i != j) {
                        if (equal) {
                            cow++;
                        }

                    }
                }
            }
            if (bull == 0 && cow == 0) {
                System.out.println("Grade: None.");
                continue;

            }
            String stBull = "bull";
            String stCow = "cow";
            if (cow > 1) {
                stCow = "cows";
            }
            if (bull > 1) {
                stBull = "bulls";
            }
            if (bull == distinctString.length()) {
                System.out.println("Grade: " + bull + " " + stBull);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            String gradeOutput = cow == 0 && bull > 0 ? bull + " "+ stBull: cow > 0 && bull > 0 ? bull + " " + stBull + " and " + cow + " " + stCow: cow + " " + stCow;
            System.out.println("Grade: " + gradeOutput);
        }
    }
}
