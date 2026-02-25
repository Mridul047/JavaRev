package leet.queue;

// Array-based Circular Queue (FIFO)
public class Queue {

  // Underlying array to store elements
  private int[] arr = new int[5];

  // 'start' points to the front element
  // 'end' points to the next insertion position
  private int start = 0;
  private int end = 0;

  // Tracks how many elements are currently in the queue
  private int currentSize = 0;

  public Queue() {}

  public Queue(int maxSize) {
    arr = new int[maxSize];
  }

  // Insert element at the 'end' (enqueue)
  public void push(int input) {
    // Queue is full when size == capacity
    if (currentSize == arr.length) throw new RuntimeException("Queue is full!");

    // Place element at 'end'
    arr[end] = input;

    // Move 'end' forward in circular manner
    end = (end + 1) % arr.length;

    // Increase size
    currentSize++;
  }

  // Remove element from the 'start' (dequeue)
  public int pop() {
    // Queue is empty when size == 0
    if (currentSize == 0) throw new RuntimeException("Queue is empty!");

    // Fetch the front element
    int res = arr[start];

    // Move 'start' forward in circular manner
    start = (start + 1) % arr.length;

    // Reduce size
    currentSize--;

    return res;
  }

  // Peek the front element without removing it
  public int top() {
    if (currentSize == 0) throw new RuntimeException("Queue is empty!");

    return arr[start];
  }
}
