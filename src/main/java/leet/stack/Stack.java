package leet.stack;

// Array-based Stack (LIFO)
public class Stack {

  private int[] arr = new int[10];
  private int top = -1; // points to the last pushed element

  public Stack() {}

  public Stack(int maxSize) {
    arr = new int[maxSize];
  }

  // Push element on top
  public void push(int input) {
    // Full when top reaches last index
    if (top == arr.length - 1) throw new RuntimeException("Stack is full!");

    top++; // move pointer
    arr[top] = input; // insert element
  }

  // Pop element from top
  public int pop() {
    if (top == -1) throw new RuntimeException("Stack is empty");

    int res = arr[top];
    top--; // shrink stack
    return res;
  }

  // Peek top element
  public int top() {
    if (top == -1) throw new RuntimeException("Stack is empty");

    return arr[top];
  }

  // Current number of elements
  public int size() {
    return top + 1;
  }
}
