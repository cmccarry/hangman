import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        System.out.println("******************************");

        File dictionary = new File("/Users/Connor/.vscode/Projects/Hangman/src/words.txt");
        try (Scanner textScanner = new Scanner(dictionary)) {
            try (Scanner input = new Scanner(System.in)) {
                ArrayList<String> words = new ArrayList<>();
                while(textScanner.hasNextLine()) {
                    words.add(textScanner.nextLine());
                }

                String answer = words.get((int)(Math.random()*words.size()));

                char[] textArray = answer.toCharArray();
                char[] myAnswers = new char[textArray.length];

                for(int i = 0; i < textArray.length; i++) {
                    myAnswers[i] = '?';
                }
                
                boolean complete = false;
                int lives = 6;
                while(complete == false) {
                    System.out.println("******************************");
                    System.out.print("Please enter your guess: ");
                    String letter = input.next();
                        
                    if(Character.isDigit(letter.charAt(0))) {
                        System.out.println("Input Error, try again");
                        System.out.print("Please enter your guess: ");
                        letter = input.next();
                    }
                    
                    boolean foundLetter = false;
                    for(int i = 0; i < textArray.length; i++) {
                        if(letter.charAt(0) == textArray[i]) {
                            myAnswers[i] = textArray[i];
                            foundLetter = true;
                        }
                    }

                    if(!foundLetter) {
                        lives--;
                        System.out.println("letter not in the word");
                    }

                    boolean done = true;
                    for(int i = 0; i < myAnswers.length; i++) {
                        if(myAnswers[i] == '?') {
                            System.out.print(" _");
                            done = false;
                        }
                        else {
                            System.out.print(" " + myAnswers[i]);
                        }
                    }

                    System.out.println("\n" + "Lifes Left: " + lives);
                    drawHangman(lives);

                    if(done) {
                        System.out.println("The word " + answer + " was found");
                        complete = true;
                    }

                    if(lives <= 0) {
                        System.out.println("Out of lives");
                        System.out.println("The word was: " + answer);
                        complete = true;
                    }
                }
            }
        }
    }
    public static void drawHangman(int line) {
        if(line == 6) {
         System.out.println("|----------");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(line == 5) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(line == 4) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|    |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(line == 3) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(line == 2) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(line == 1) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else{
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   | |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
       }
}
