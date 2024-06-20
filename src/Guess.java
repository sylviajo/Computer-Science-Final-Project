import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Guess extends Boggle{
    private int score;//number of guessed words that are valid
    private ArrayList<String> guesses = new ArrayList<String>();

   //Checks to see if each letter is on a connected path, then loops to check the next letter
    public boolean valid (String guess) {
        String mystring = "";
        int row = 0;
        int col = 0;
        int count = 0;
        int num = 0;
        while (guess.length() > 1) {
            num = 0;
            String first = guess.substring(0, 1);
            String second = (guess.substring(1, 2));
            mystring+= first;

            for (int r = 0; r < array.length; r++) {
                for (int c = 0; c < array[r].length; c++) {
                    if (array[r][c].equalsIgnoreCase(first)) {
                        row = r;
                        col = c;
                    }

                    if ((row + 1) < array.length) {
                        if (array[row + 1][col].equalsIgnoreCase(second)) {
                            num++;
                        }
                        if ((col + 1) < array.length) {
                            if (array[row + 1][col + 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                        if ((col - 1) >= 0) {
                            if (array[row + 1][col - 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                    }
                    if ((row - 1) >= 0) {
                        if (array[row - 1][col].equalsIgnoreCase(second)) {
                            num++;
                        }
                        if ((col + 1) < array.length) {
                            if (array[row - 1][col + 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                        if ((col - 1) >= 0) {
                            if (array[row - 1][col - 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                    }
                    if ((row) < array.length) {
                        if (array[row][col].equalsIgnoreCase(second)) {
                            num++;
                        }
                        if ((col + 1) < array.length) {
                            if (array[row][col + 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                        if ((col - 1) >= 0) {
                            if (array[row][col - 1].equalsIgnoreCase(second)) {
                                num++;
                            }
                        }
                    }
                }
            }
            if (num > 0) {
                count++;
                guess = guess.substring(1, guess.length());
            }
            else{
                guess = "";
            }
        }
            if (guess.length() == 0) {
                return false;
            }
            return true;
        }

        //checks to see if the guess is in the english dictionary
    public boolean dictionary (String guess) throws FileNotFoundException {
        ArrayList <String> mylist = new ArrayList<String>();
        File myObj = new File("src/dictionary.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            mylist.add(data);
            if (guess.equalsIgnoreCase(data)) {
                return true;
            }
        }

        return false;
    }

    //increments the users score if the inputed guess is both valid and in the dictionary
    public void increment (String guess) throws FileNotFoundException {
//        guesses = new ArrayList<String>();
        if (valid(guess) && dictionary(guess) && error(guess)){
            guesses.add(guess);
            if (guess.length() >= 2){
                if (guess.length() >= 4){
                    if (guess.length() >= 6){
                        score+= 3;
                    }
                    score+= 2;
                }
                score++;
            }
        }
    }
    //prints the final statement
    public void output (){
        System.out.println("Total list of words guessed: " + guesses + " Total points scored: " + score + " Thanks for playing!");
    }

    //checks the users list of words already guessed and tells the user if their guess has already been guessed
    public boolean error (String guess){
        if (guesses != null){
        for (int i = 0; i < guesses.size(); i++) {
            if (guesses.get(i).equalsIgnoreCase(guess)) {
                return false;
            }
        }
        }
        return true;
    }
    public void printGuesses (){
        for (int r = 0; r < guesses.size(); r++){
            System.out.println(guesses.get(r));
        }
    }
}
