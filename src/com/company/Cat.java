package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
Task about algorithms

*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<String>();
    while (true) {
      String s = reader.readLine();
      if (s.isEmpty()) {
        break;
      }
      list.add(s);
    }

    String[] array = list.toArray(new String[list.size()]);
    sort(array);

    for (String x : array) {
      System.out.println(x);
    }
  }

  public static void sort(String[] array) {
    // write your code here
    int intArrayLenght = 0;
    int stringArrayLengh = 0;
    int indexInt= 0;
    int indexString = 0;

    // Determine length of string and int arrays
    for( String s: array) {
      if (isNumber(s)) {
        intArrayLenght++;
      } else stringArrayLengh++;
    }

    //Create int array
    int[] intArray = new int[intArrayLenght];

    //Create string array
    ArrayList<String> stringArrayList = new ArrayList<>();

    //Add strings and int to arrays
    for(int x = 0; x < array.length; x++) {
      if (isNumber(array[x])) {
        intArray[indexInt] = Integer.parseInt(array[x]);
        indexInt++;

      } else {
        stringArrayList.add(indexString,array[x]);
        indexString++;
      }
    }

    ArrayList<String> stringArrayListCopy = new ArrayList<>(stringArrayList);

    //Sort numbers
    Arrays.sort(intArray);

    //Create reverse numbers array
    int[] reverseNumberArray = Arrays.copyOf(intArray, intArray.length);
    for (int i = intArray.length - 1; i >= 0; i--) {
      reverseNumberArray[intArray.length - i - 1] = intArray[i];
    }

    //Create strings array
    String[] stringArray = new String[stringArrayLengh];
    for (int i = 0; i < stringArrayLengh; i++) {
      String a = stringArrayList.get(0);
      for (String b: stringArrayList) {
        if (isGreaterThan(a, b)) {
          a = b;

        }
      }
      stringArray[i] = a;
      stringArrayList.remove(a);
    }

    System.out.println(Arrays.toString(stringArray));
    System.out.println(Arrays.toString(reverseNumberArray));


  }
  // String comparison method: 'a' is greater than 'b'
  public static boolean isGreaterThan(String a, String b) {
    return a.compareTo(b) > 0;
  }


  // Is the passed string a number?
  public static boolean isNumber(String s) {
    if (s.length() == 0) return false;

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if ((i != 0 && c == '-') // The string contains a hyphen
              || (!Character.isDigit(c) && c != '-') // or is not a number and doesn't start with a hyphen
              || (i == 0 && c == '-' && chars.length == 1)) // or is a single hyphen
      {
        return false;
      }
    }
    return true;
  }
}
