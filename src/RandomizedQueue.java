import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue that removes items uniformly at random.
 * @param <Item> the type of items stored in this randomized queue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
        // TODO: Initialize an empty array-backed randomized queue. Resize by doubling when full and halving when quarter full.
        size = 0;
        items = (Item[]) new Object[1];
    }

    /** Return whether the randomized queue is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this array-backed queue contains no items.
        return size==0;
    }

    /** Return the number of items in the randomized queue. */
    public int size() {
        // TODO: Return this array-backed queue's item count.
        return size;
    }

    /** Resize **/
    public void resize(int newity){
        Item[] newarrity = (Item[]) new Object[newity];
        for (int i=0; i<size; i++){
            newarrity[i]=items[i];
        }
        items = newarrity;

    }

    /** Add an item; reject null with IllegalArgumentException. */
    public void enqueue(Item item) {
        // TODO: Add the item to the backing array, resizing as needed.
        if (item == null){
            throw new IllegalArgumentException();
        } else {
            if (size == items.length) {
                resize(size * 2);
            }
            items[size] = item;
            size++;
        }
    }

    /** Remove and return a uniformly random item; throw NoSuchElementException if empty. */
    public Item dequeue() {
        // TODO: Pick a random index between 0 and size-1; swap the chosen item with the last item, then remove and resize as needed.
        if (size==0){
            throw new NoSuchElementException();
        } else {
            int indity = (int) Math.floor(Math.random()*(size-1));
            Item curity = items[indity];
            items[indity]=items[size-1];
            items[size-1]=null;

            if (size == items.length / 4) {
                resize(items.length / 2);
            }
            size--;

            return curity;

        }



    }

    /** Return a uniformly random item without removing it; throw NoSuchElementException if empty. */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return items[(int) (Math.random()*size)];
    }

    /** Return an independent iterator in uniformly random order; define next() and remove() exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an independent iterator that traverses the array items in random order.


        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] shuffledItems;
        private int current;

        RandomizedQueueIterator(){
            shuffledItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++){
                shuffledItems[i] = items[i];
            }
            for (int i = 0; i < 2*size; i++){
                int j = (int) (Math.random()*size);
                int k = (int) (Math.random()*size);
                Item swap = shuffledItems[j];
                shuffledItems[j] = shuffledItems[k];
                shuffledItems[k] = swap;
            }
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = shuffledItems[current];
            current++;
            return item;
        }
    }

    /** Run unit tests for the randomized queue. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
