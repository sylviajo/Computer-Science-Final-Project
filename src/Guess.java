import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Guess extends Boggle{
    private int score;//number of guessed words that are valid
    private ArrayList<String> guesses;

    public boolean valid (String guess) {
        int row = 0;
        int col = 0;
        int count = 0;
        int num = 0;
        while (guess.length() > 1) {
            String first = guess.substring(0, 1);
            String second = (guess.substring(1, 2));
            System.out.println(first);

            for (int r = 0; r < array.length; r++) {
                System.out.println("Row: " + r);
                for (int c = 0; c < array[r].length; c++) {
                    System.out.println("Col: " + c);
                    if (array[r][c].equalsIgnoreCase(first)) {
                        row = r;
                        col = c;
                        System.out.println("THIS IS THE ROW: " + row);
                    }

                    if ((row + 1) < array.length) {
                        System.out.println(row + 1);
                        System.out.println(row);
                        System.out.println("r+1");
                        if (array[row + 1][col].equalsIgnoreCase(second)) {
                            System.out.println("a");
                            num++;
                        }
                    }
                    if ((row - 1) > array.length) {
                        System.out.println(row - 1);
                        System.out.println("r-1");
                        if (array[row - 1][col].equalsIgnoreCase(second)) {
                            System.out.println("a");
                            num++;
                        }
                    }
                    if ((col + 1) < array.length) {
                        System.out.println(col + 1);
                        System.out.println("c+1");
                        if (array[row][col + 1].equalsIgnoreCase(second)) {
                            System.out.println("a");
                            num++;
                        }
                    }
                    if ((col - 1) > array.length) {
                        System.out.println(col - 1);
                        System.out.println("c-1");
                        if (array[row][col - 1].equalsIgnoreCase(second)) {
                            System.out.println("a");
                            num++;
                        }
                    }

                }
            }
            if (num > 0) {
                count++;
                System.out.println("b");
                guess = guess.substring(2, guess.length());
            }
        }
            if (count == guess.length() - 1) {
                return true;
            }
            return false;
        }

    public boolean dictionary (String guess) {
        File myObj = new File("dictionary.txt");
        Scanner myReader = new Scanner(System.in);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (guess.equalsIgnoreCase(data)) {
                return true;
            }
        }
        return false;
    }

    public void increment (String guess){
        System.out.println("1");
        if (valid(guess) && dictionary(guess)){
            if (guess.length() >= 2){
                if (guess.length() >= 4){
                    if (guess.length() >= 6){
                        score+= 3;
                    }
                    score+= 2;
                }
                score++;
            }
            System.out.println("Incremented");
        }
    }
    public void output (){
        System.out.println("Time is up!" + "Total list of words guessed: " + guesses + "Total points scored: " + score + "Thanks for playing!");
    }
    public boolean addAnswers (String guess){
        if (valid(guess) && error(guess) && dictionary(guess)){
            guesses.add(guess);
            return true;
        }
        return false;
    }
    public boolean error (String guess){
        for (int i = 0; i < guesses.size(); i++){
            if (guesses.get(i).equalsIgnoreCase(guess)){
                System.out.println("Already Guessed");
                return false;
            }
        }
        return true;
    }
}
