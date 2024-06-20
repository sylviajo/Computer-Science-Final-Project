import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        //creates the object to run the program
        Guess alex = new Guess();
        //creates the string to contain the user input
        String guess = "";
        //prints out the random array
        alex.printBoggle(alex.randomize());
        System.out.println("place your guesses here: ");
        //starts the users timer for one minute
        long start = System.currentTimeMillis();
        long end = start + 60 * 1000;
        while (System.currentTimeMillis() < end) {
            //scans the user input and prints it back out
            Scanner sc = new Scanner(System.in);
            guess = sc.nextLine();
            System.out.println(guess);

            //tells the user if the word they put in is not in the dictionary
            if (!alex.dictionary(guess)) {
                System.out.println("The word that you entered is not in the dictionary");
            }
            //confirms if the users word is in the dictionary
            if (alex.dictionary(guess)) {
                System.out.println("in dictionary");

            }
            //confirms if the users word is valid
                if (alex.valid(guess)) {
                    System.out.println("valid");
                }
                //tells the user if the word they put in is not valid
                else if (!alex.valid(guess)) {
                    System.out.println("The word that you entered is not valid");
                }

                //tells the user if they already correctly guessed the word they put in
                if (!alex.error(guess)) {
                    System.out.println("The word that you entered has already been guessed");
                }
                //adds the users guess to their overall list of guesses
                alex.increment(guess);
            }


        //alerts the user that the timer is over and prints the final output (guesses and score)
            System.out.println("TIMES UP!");
            alex.output();

            }
            }

