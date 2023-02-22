import java.util.Arrays;

import java.util.Collections;

import java.util.Comparator;

public class mod6 {

  // method to sort a Comparable array elements using bubble sort

  public static <E extends Comparable<E>> void bubbleSort(E[] list) {

    // looping from i=0 to list.length-1

    for (int i = 0; i < list.length; i++) {

      // looping from j=0 to list.length-i-2

      for (int j = 0; j < list.length - 1 - i; j++) {

        // comparing elements at j and j+1

        if (list[j].compareTo(list[j + 1]) > 0) {

          // swapping elements

          E temp = list[j];

          list[j] = list[j + 1];

          list[j + 1] = temp;

        }

      }

    }

  }

  // method to sort a generic array using given comparator

  public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

    for (int i = 0; i < list.length; i++) {

      for (int j = 0; j < list.length - 1 - i; j++) {

        // using comparator to compare elements at j and j+1

        if (comparator.compare(list[j], list[j + 1]) > 0) {

          E temp = list[j];

          list[j] = list[j + 1];

          list[j + 1] = temp;

        }

      }

    }

  }

  // main method for testing

  public static void main(String[] args) {

    // creating an unsorted Sttring array

    String sarray[] = { "Carlos", "Theano", "Joel", "Norma", "Astrid", "Juan", "Giselle" };

    // displaying array

    System.out.println("String array before sorting: "

        + Arrays.toString(sarray));

    // sorting

    bubbleSort(sarray);

    // displaying sorted array

    System.out.println("String array after sorting: "

        + Arrays.toString(sarray));

    // fetching a Comparator from Collections that will help us to sort

    // elements in reverse order (descending order)

    Comparator<String> scmp = Collections.reverseOrder();

    // sorting array using the given comparator and displaying sorted array

    bubbleSort(sarray, scmp);

    System.out.println("String array after sorting in descending order: "

        + Arrays.toString(sarray));

    // note: you can use any String Comparator as you want. Or you may

    // define one Comparator to sort elements using a different, like

    // length.

    // repeating the same using an integer array

    Integer iarray[] = { 17, 22, 54, 77, 82, 141, 338, 8248, 24 };

    System.out.println("\nInteger array before sorting: "

        + Arrays.toString(iarray));

    bubbleSort(iarray);

    System.out.println("Integer array after sorting: "

        + Arrays.toString(iarray));

    Comparator<Integer> icmp = Collections.reverseOrder();

    bubbleSort(iarray, icmp);

    System.out.println("Integer array after sorting in descending order: "

        + Arrays.toString(iarray));

  }

}