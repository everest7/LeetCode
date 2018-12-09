package Heap;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChild(int parentIndex){
        return 2 * parentIndex + 1;
    }
    private int getRightChild(int parentIndex){
        return 2 * parentIndex + 2;
    }
    private int getParent(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeft(int index){
        return getLeftChild(index) < size;
    }
    private boolean hasRight(int index){
        return getRightChild(index) < size;
    }
    private boolean hasParent(int index){
        return getParent(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChild(index)];
    }
    private int rightChild(int index){
        return items[getRightChild(index)];
    }
    private int parent(int index){
        return items[getParent(index)];
    }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity(){
        if (size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek(){
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();

    }

    public void heapifyUp(){
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]){
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while (hasLeft(index)){
            int smallestIndex = getLeftChild(index);
            if (hasRight(index) && rightChild(index) < leftChild(index)){
                smallestIndex = getRightChild(index);
            }
            if (items[index] < items[smallestIndex]){
                break;
            } else {
                swap(index, smallestIndex);
            }
            index = smallestIndex;
        }
    }
}
