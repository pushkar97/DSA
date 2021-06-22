package queues;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularQueue<T> {
    T[] data;
    int size;
    int start = 0;
    int end = 0;

    public CircularQueue(Class<T> clazz, int size) {
        data = (T[])Array.newInstance(clazz, this.size = size);
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return end - start == size;
    }

    public void enqueue(T val) throws Exception {
        if (isFull()) throw new Exception("QueueOverflow");
        int index = end % size;
        data[index] = val;
        end++;
    }

    public T dequeue() throws Exception {
        if(isEmpty()) throw new Exception("QueueUnderflow");
        if(start >= size){
            start %=size;
            end %= size;
        }
        return data[start++];
    }

    public T peek() {
        return isEmpty() ? null : data[start];
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "data=" + Arrays.toString(data) +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) throws Exception {
        CircularQueue<String> queue = new CircularQueue<>(String.class, 5);
        queue.enqueue("alice");
        queue.enqueue("bob");
        queue.enqueue("cindy");
        queue.enqueue("dodo");
        queue.enqueue("emma");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("frodo");
        System.out.println(queue);
        queue.enqueue("gigi");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
