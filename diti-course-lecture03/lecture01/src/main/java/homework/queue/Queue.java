package homework.queue;

public interface Queue {
    void enqueue(String item);
    String dequeue();
    boolean isEmpty();
    int size();
}
