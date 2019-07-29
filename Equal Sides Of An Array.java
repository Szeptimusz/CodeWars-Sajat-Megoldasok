/* 
Feladat eredeti helye: https://www.codewars.com/kata/5679aa472b8f57fb8c000047

FELADAT LEÍRÁSA:
You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of the integers to the left of N is equal to the sum of the integers to the right of N. If there is no index that would make this happen, return -1.

For example:

Let's say you are given the array {1,2,3,4,3,2,1}:
Your function will return the index 3, because at the 3rd position of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.

Let's look at another one.
You are given the array {1,100,50,-51,1,1}:
Your function will return the index 1, because at the 1st position of the array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.

Input:
An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.

Output:
The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index that fits these rules, then you will return -1.
*/

import java.util.*;
public class Kata {
  public static int findEvenIndex(int[] arr) {
    HashMap<Integer,Integer> map = new HashMap<>();
    
    // HashMap-ben tárolja, hogy hátulról haladva mennyi az összeg addig az indexig
    int sumRight = 0;
    map.put(arr.length, 0);
    for (int i = arr.length - 1; i >= 0; i--) {
      sumRight += arr[i];
      map.put(i,sumRight);
    }
    
    // Végigmegy a lehetséges indexeken, számolja a baloldali összeget,
    // map-ből lekérdezi a jobboldali összeget, összehasonlítja őket
    int sumLeft = 0;
    for (int i = 0; i < arr.length; i++) {
      if (sumLeft == map.get(i + 1)) {
        return i;
      }
      sumLeft += arr[i];
    }
    
    // Ha nincs index ahol egyenlő a két oldal
    return -1;
  }
}
