  //Jay Wang lab 1 assignment

import java.io.*;
import java.util.*;

  /* Create new Java Project, new class and copy below and paste into the class
   *  workout the code below to the best of your ability.
   *  if confused on how to get started ask batch mates or ask in general slack
   *  don't hesitate to ask!
   *
   * 1. Cast from double to int
   *
   * labels:[primitives, casting]
   *
   * f(0.0) = 0
   * f(3.1) = 3
   */

class NumbersAtItsBest {
  public static int castToInt(double n) {
    int i = (int) n;
    System.out.println("The int is " + i);
    return i;
  }

  /*
   * 2. Cast from short to byte
   *
   * labels:[primitives, casting]
   *
   * f(2) = 2
   * f(128) = -128
   */
  public static byte castToByte(short n) {
    //A byte is 8 bit and a short is 2 byte
    //deal with overflow
    byte b = (byte)((n >> 8) & 0xff);
    System.out.println("The byte is " + b);
    return b;
  }


  /*
   * 3. Division
   *
   * labels:[operators, exceptions, control statements]
   *
   * f(10,2) = 5.0
   * f(3,2) = 1.5
   *Bonus as we haven't covered exceptions
   * f(1,0) = throw IllegalArgumentException
   */
  public static double divide(double operandOne, double operandTwo) {
    if(operandTwo == 0)
      throw new java.lang.ArithmeticException("Divide by zero");

    System.out.println("The quotient is " + operandOne/operandTwo);
    return operandOne/operandTwo;
  }

  /*
   * 4. Check if int is Even
   *
   * labels:[operators, control statements]
   *
   * f(2) = true
   * f(3) = false
   */
  public static boolean isEven(int n) {
    boolean flag = true;
    if(n % 2 == 0)
      ;
    else
      flag = false;
    System.out.println("Is this number even? " + flag);
    return flag;
  }

  /*
   * 5. Check if all of the Array is even
   *
   * labels:[operators, arrays, control statements]
   *
   * f([2]) = true
   * f([2,4,6,8,10]) = true
   *
   * f([3]) = false
   * f([2,4,6,8,11]) = false
   */
  public static boolean isAllEven(int[] array) {
    boolean flag = false;
    for(int e : array) {
      if(e % 2 == 0) flag = true;
      else flag = false;
    }
    System.out.println("Is this array all even? " + flag);
    return flag;
  }

  /*
   * 6. Return the Average
   *
   * labels:[arrays, operators, control statements, exceptions]
   *
   * f([2]) = 2.0
   * f([2,3]) = 2.5
   * Bonus as we haven't covered exceptions
   * f(null) = throw IllegalArgumentException
   */
  public static double average(int[] array) {
    double total = 0;
    for(int e : array) {
      total += e;
    }
    System.out.println("The average = " + total / array.length);
    return total / array.length;
  }
}

public class JavaLab1 {
  public static void main(String[] args) {
    NumbersAtItsBest goodNumber = new NumbersAtItsBest();
    goodNumber.castToInt(2.23);
    goodNumber.castToByte((short)10);
    goodNumber.isEven(4);
    goodNumber.divide(10, 2);
    // goodNumber.divide(10, 0);
    int[] array = {3, 4, 1};
    int[] array1 = {2, 2, 2, 4, 6};
    goodNumber.isAllEven(array);
    goodNumber.isAllEven(array1);
    goodNumber.average(array);
  }
}
