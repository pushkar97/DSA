package queues;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<T> {
    T[] data;
    int size;

    int start = 0;
    int end = 0;

    public ArrayQueue(Class<T> clazz, int size) {
        this.size = size;
        Object obj = Array.newInstance(clazz, size);
        data = (T[]) obj;
    }

    public boolean isEmpty() {return start == end;}

    public boolean isFull() {return start == 0 && end == size;}

    public void enqueue(T val) throws Exception {
        if (isFull()) throw new Exception("QueueOverflow: " + toString());
        if (end == size) {
            for (int j = 0, i = start; i < end; i++, j++) data[j] = data[i];
            end-=start;
            start = 0;
        }
        data[end++] = val;
    }

    public T dequeue() throws Exception {
        if (isEmpty()) throw new Exception("QueueUnderflow: " + toString());
        return data[start++];
    }

    public T peek() {
        if (isEmpty()) return null;
        return data[start];
    }
    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + Arrays.toString(data) +
//                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue<String> queue = new ArrayQueue<>(String.class, 5);
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);

    }
}
