package queues;

import java.util.LinkedList;

public class LinkedListQueue<T> {

    LinkedList<T> data;

    public LinkedListQueue(){
        data = new LinkedList<T>();
    }

    public void enqueue(T val) {
        data.add(val);
    }

    public T dequeue() {
        return data.removeFirst();
    }

    public T peek() {
        return data.peekFirst();
    }
}
