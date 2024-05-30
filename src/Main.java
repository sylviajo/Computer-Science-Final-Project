import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
    Guess alex = new Guess();
    String guess = "";
    alex.printBoggle(alex.randomize());
        System.out.println("place your guesses here: ");
        long start = System.currentTimeMillis();
        long end = start + 10 * 1000;
        System.out.println(start);
        System.out.println(end);
        while (System.currentTimeMillis() < end) {
            Scanner sc = new Scanner(System.in);
            guess = sc.nextLine();
            System.out.println(guess);
            if (!alex.valid(guess)) {
                System.out.println("The word that you entered is not valid");
            }
            if (!alex.dictionary(guess)) {
                System.out.println("The word that you entered is not in the dictionary");
            }
            if (!alex.error(guess)) {
                System.out.println("The word that you entered has already been guessed");
            }
            alex.increment(guess);
        }
        System.out.println("TIMES UP!");
        alex.output();
        if (alex.valid(guess)){
            System.out.println("valid");
        }
    }
}