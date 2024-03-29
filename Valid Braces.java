/* Feladat eredeti helye: https://www.codewars.com/kata/5277c8a221e209d3f6000b56

FELADAT LEÍRÁSA

Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true 
if the string is valid, and false if it's invalid.
This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False

*/

import java.util.*;
public class BraceChecker {

  public boolean isValid(String braces) {
    ArrayList<Character> expectedBrace = new ArrayList<>();
    
    for (int i = 0; i < braces.length(); i++) {
      char brace = braces.charAt(i);

      // Ha nyitó zárójel van, akkor a várt zárójelekhez hozzáadja
      // a záró párját
      if (brace == '(') { 
        expectedBrace.add(')');
        
      } else if (brace == '[') {
        expectedBrace.add(']');
        
      } else if (brace == '{') { 
        expectedBrace.add('}');
        
      } else { 
      
        // A csukó zárójelnek nincs nyitó párja
        if (expectedBrace.isEmpty()) {
          return false;
          
        // Az aktuális zárójel nem egyezik a várttal
        } else if (expectedBrace.get(expectedBrace.size() - 1)
                    != brace) {
          return false;
          
        // Az aktuális zárójel egyezik a várttal, törli a vártat a listából
        } else {
          expectedBrace.remove(expectedBrace.size() - 1);
        }
		
      }
    }
    
    if (expectedBrace.size() > 0) return false;
    
    return true;
  }

}
