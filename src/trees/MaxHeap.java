package trees;

import java.util.Arrays;

public class MaxHeap {

    int size;
    int[] heap;
    int counter;

    public MaxHeap() {
        this(16);
    }

    public MaxHeap(int size) {
        this.size = size;
        counter = 0;
        heap = new int[size];
    }

    int max() {return heap[0];}

    boolean isLeaf(int i) {
        return i >= counter/2;
    }

    int getLeftChild(int i) {
        return hasLeftChild(i) ? 2*i + 1 : -1;
    }

    int getRightChild(int i) {
        return hasRightChild(i) ? 2*i + 2 : -1;
    }

    int getParent(int i) {
        return i == 0 ? -1 : (i-1)/2;
    }

    boolean hasLeftChild(int i) { return 2*i + 1 < counter; }

    boolean hasRightChild(int i) { return 2*i + 2 < counter; }

    boolean hasParent(int i) { return i > 0; }

    private void ensureCapacity() {
        if(counter == size) {
            heap = Arrays.copyOf(heap, size*2);
            size*=2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void add(int i) {
        ensureCapacity();
        heap[counter++] = i;
        heapUp();
    }

    private void heapUp() {
        int current = counter -1;
        while (hasParent(current) && heap[current] > heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public int pop() {
        int val = heap[0];
        heap[0] = --counter;
        heap[counter] = 0;
        heapDown(0);
        return val;
    }

    private void heapDown(int i) {
        if (isLeaf(i)) return;
        int j = heap[getLeftChild(i)] > heap[i] ? getLeftChild(i) : i;
        j = heap[getRightChild(i)] > heap[j] ? getRightChild(i) : j;

        if (j != i){
            swap(i,j);
            heapDown(j);
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < counter/2; i++) {
            b.append("Node:").append(heap[i]);
            if(hasLeftChild(i)) b.append(", left child:").append(heap[getLeftChild(i)]);
            if(hasRightChild(i)) b.append(", right child:").append(heap[getRightChild(i)]);
            b.append("\n");

        }
        return b.toString();
    }

    public static void main(String[] args) {
        MaxHeap m = new MaxHeap(7);
        m.add(10);
        m.add(12);
        m.add(6);
        m.add(14);
        m.add(26);
        m.add(3);
        m.add(8);
        System.out.println(m);
        System.out.println(m.pop());
        m.add(7);
        m.add(9);
        System.out.println(m);

    }
}
