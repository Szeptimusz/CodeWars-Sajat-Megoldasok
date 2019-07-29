/*
Feladat eredeti helye: https://www.codewars.com/kata/5a99a03e4a6b34bb3c000124

FELADAT LEÍRÁSA:

Is similar to factorial of a number, In primorial, not all the natural numbers get multiplied, only prime numbers are multiplied to calculate the primorial of a number. It's denoted with P#.

Task
Given a number N , calculate its primorial.

Notes
Only positive numbers will be passed (N > 0) .
Input >> Output Examples:
1- numPrimorial (3) ==> return (30)
Explanation:
Since the passed number is (3) ,Then the primorial should obtained by multiplying 2 * 3 * 5 = 30 .

Mathematically written as , P3# = 30 .

*/

import java.math.BigInteger; 
public class Primorial {
    public static String numPrimorial(int n) {
      int count = 0;
      long i = 0;
      BigInteger result = BigInteger.valueOf(1);
      
	  // Ciklus, amíg a talált prímek száma nem éri el a kért mennyiséget
      while (count != n) {
        if (isPrime(i)) {
          result = result.multiply(BigInteger.valueOf(i));
          count++;
        }
        i++;
      }
       
      return result + "";
    }
    
	// Visszaadja, hogy a kapott szám prímszám-e
    public static boolean isPrime(long number) {
      if (number < 2) return false;
    
      for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) return false;
      }
    
      return true;
    }
}