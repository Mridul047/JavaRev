package leet.stack;

public class StackDriver {

  static void main() {
    Stack stack = new Stack(20);

    stack.push(23);
    stack.push(26);
    stack.push(11);
    stack.push(90);

    System.out.println("Current Stack size: " + stack.size());

    while (stack.size() != 0) {
      System.out.println("Stack popped with value: " + stack.pop());
      System.out.println("Current Stack size: " + stack.size());
    }
  }
}
