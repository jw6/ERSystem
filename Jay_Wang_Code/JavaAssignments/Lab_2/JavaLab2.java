import java.util.Arrays;
import java.util.Stack;
import java.io.*;

class Lab {

  /*
    1. Return the nth fibonacci number
    f(0) = 0
    f(1) = 1
    f(10) = 55
  */
  public static int fibonacci(int n) {
    if(n <= 1) return n;
    else return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /*
    2. Sort array of integers
    f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
    Don't use built-in sort() method... that would be lame.
  */
  public static int[] sort(int[] array) {

    //Selection sort
    for(int i = 0; i < array.length - 1; i++) {
        //Select first integer as minimum
        int min = i;
        //And compare one another until minum is found
        for (int j = i + 1; j < array.length; j++)
          if(array[j] < array[min]) min = j;
        //Swap the numbers
        int temp = array[i];
        array[i] = array[min];
        array[min] =temp;
    }
    for(int i = 0; i < array.length; i++)
      System.out.print(array[i] + "\t");
    return array;
  }

  /*
    3. Return the factorial of n
    f(0) = 1
    f(1) = 1
    f(3) = 6
  */
  public static int factorial(int n) {
    int factNumber = 1;
    for(int i = 1; i <= n; i++)
      factNumber = factNumber * i;
    return factNumber;
  }

  /*
    4. Rotate left
    Given array, rotate left n times and return array
    f([1,2,3,4,5], 1) = [2,3,4,5,1]
    f([1,2,3,4,5], 6) = [2,3,4,5,1]
    f([1,2,3,4,5], 3) = [4,5,1,2,3]
  */
  public static int[] rotateLeft(int[] array, int n) {
    for(int i = 0; i < n; i++) {
      int j, temp;
      temp = array[0];
      for(j = 0; j < array.length - 1; j++) {
        array[j] = array[j+1];
      }
      array[j] = temp;
    }

    for(int i = 0; i < array.length; i++)
      System.out.print(array[i] + "\t");
    System.out.println();
    return array;
  }

  /*
    5. Balanced Brackets
    A bracket is any one of the following: (, ), {, }, [, or ]
    The following are balanced brackets:
      ()
      ()()
      (())
      ({[]})
    The following are NOT balanced brackets:
    (
    )
    (()
    ([)]
    Return true if balanced
    Return false if not balanced
  */
  public static boolean balancedBrackets(String bracketsString) {
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < bracketsString.length(); i++) {
      char c = bracketsString.charAt(i);
      if(c == '(' || c == '{' || c == '[') {
        stack.push(c);
      }else if(c == ')') {
        if(stack.isEmpty() || stack.pop() != '(')
          return false;
      }else if(c == '}') {
        if(stack.isEmpty() || stack.pop() != '{')
          return false;
      }else if(c == ']') {
        if(stack.isEmpty() || stack.pop() != '[')
          return false;
      }
    }
    return stack.isEmpty();
  }
}

public class JavaLab2 {
  public static void main(String[] args) {
    Lab funStuff = new Lab();
    System.out.println("Fibonacci number 10 is  " + funStuff.fibonacci(10));
    System.out.println("Fibonacci number 0 is: " + funStuff.fibonacci(0));
    System.out.println("Fibonacci number 3 is: " + funStuff.fibonacci(3));
    System.out.println("Fibonacci number 5 is: " + funStuff.fibonacci(5));

    int[] array = {22, 11, 0, 5, 33, 44};
    int[] array1 = {12, 21, 10, 3, 13, 64};

    funStuff.sort(array);
    System.out.println();
    funStuff.sort(array1);

    System.out.println("\nFactorial number: " + funStuff.factorial(3));
    System.out.println("Rotate 1 time");
    funStuff.rotateLeft(array, 1);
    System.out.println("Rotate 2 times");
    funStuff.rotateLeft(array, 2);
    System.out.println("Rotate 5 times");
    funStuff.rotateLeft(array, 5);

    System.out.println(funStuff.balancedBrackets("[{(a,b)}]"));
    System.out.println(funStuff.balancedBrackets("{(a},b)"));
    System.out.println(funStuff.balancedBrackets("{)(a,b}"));
    System.out.println(funStuff.balancedBrackets("{}()[]"));
    System.out.println(funStuff.balancedBrackets("{}()["));
  }
}
