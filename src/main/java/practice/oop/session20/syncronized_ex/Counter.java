package practice.oop.session20.syncronized_ex;

public class Counter {

    /*
    synchronized can be used for thread safety
    synchronized can be used for method and blocks
     */

    int count;

    synchronized void increment() {
        count++;
    }
}
