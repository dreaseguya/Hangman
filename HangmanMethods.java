//class: HangmanMethods

import java.util.Random;

import javax.swing.JOptionPane;

public class HangmanMethods {
    public static String toBeGuessed;
    public static StringBuilder currentWord;
    public static char guessedLetter;
    public static int howManyGuesses;
    public static int wrongGuess;
    public static boolean win;

 
    
    public static String getGuessedLetter() {
        String ui="";
        while (true) {try{
            ui = JOptionPane.showInputDialog("Enter your guess: ");
            break;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please rewrite");
        }}
        return ui;
    }
    public static boolean isThere(String toBeGuessed, char guessedLetter2) {
        int isIt = toBeGuessed.indexOf(guessedLetter2);
        if(isIt == -1) {
            System.out.println("it's not there");
            return false;
        }
            else {
            System.out.println("Yay!");
            return true;
        }
    }
    public static String emptySpaces(String toBeGuessed) {
         String emptySpaces ="";
        emptySpaces = "-";
            int i =0;
            while (true) {
                if (i<toBeGuessed.length()) {
                    i++;
                    emptySpaces = emptySpaces + "-";
                }
                if (i == toBeGuessed.length()-1) break;
            }
        
        return emptySpaces;
        }
    
    public static boolean charEquals(char a) {
        boolean hh = true;
        if (guessedLetter == a) hh= true;
        if (guessedLetter != a) hh= false;
        return hh;
    }
    public static String setUpWord() {
        String[] wordsList ={"hello", "bye", "excited", "whatever", "potato", "tomato","handbag", "mouse",
        		"computer", "banana", "paper", "serendipity", "singular", "humble", "loving", "caring", 
        		"kind", "octopus", "encrypted", "fighting", "scanner", "musician", "coffee", "tower", "happiness",
        		"rectangle", "position", "integer", "theorem", "sadness", "clown", "master", "battery"};
        Random rand = new Random();
        int randInt = rand.nextInt(wordsList.length);
        toBeGuessed = wordsList[randInt];
        System.out.println(toBeGuessed);
        return toBeGuessed;
        
    }
   
   
    

}


