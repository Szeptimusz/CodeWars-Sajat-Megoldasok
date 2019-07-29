/*	
Feladat eredeti helye: https://www.codewars.com/kata/578aa45ee9fd15ff4600090d

FELADAT LEÍRÁSA:
	
You have an array of numbers.
Your task is to sort ascending odd numbers but even numbers must be on their places.

Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.

Example

sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
*/

import java.util.*;
public class Kata {
  public static int[] sortArray(int[] array) {
	//Feladat megoldása módosított kiválasztásos rendezéssel
	// Csak a páratlan számokat veszi figyelembe és rendezi	
  
    for (int i = 0; i < array.length - 1; i++) {
    
      if (array[i] % 2 != 0) {
          int minIndex = i;
          
          for (int j = i + 1; j < array.length; j++) {
            if (array[j] % 2 != 0) {
              if (array[j] < array[minIndex]) {
                  minIndex = j;
              }
            }
          }    

          int tmp = array[minIndex];
          array[minIndex] = array[i];
          array[i] = tmp;
      }
    }
    System.out.print(Arrays.toString(array));
    return array;
  }
}