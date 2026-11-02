import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Card Dealer: deal k distinct random cards from a deck of strings read from standard input.
 */
public class Permutation {

    /**
     * Deal exactly k cards uniformly at random from the deck supplied on standard input.
     * Read card names with a Scanner and print each dealt card at most once.
     * @param args command-line arguments; args[0] is the number k of cards to deal
     */
    public static void main(String[] args) throws FileNotFoundException {
        int k = Integer.parseInt(args[0]);
        Scanner scan1 = new Scanner(System.in);
        String s = "src/" + scan1.next();
        Scanner scan2 = new Scanner(new File(s));
        RandomizedQueue<String> Deque = new RandomizedQueue<String>();
        while (scan2.hasNext()){
            Deque.enqueue(scan2.next());
        }
        for (int i = 0; i < k; i++){
            System.out.println(Deque.dequeue());
        }

        // TODO: Act as the card dealer: read the deck from standard input and deal k random cards.
        // Hint: use a Scanner to read card names: Scanner scanner = new Scanner(System.in);
        //       then use scanner.next() to read each card, and System.out.println() to print dealt cards.
    }
}
