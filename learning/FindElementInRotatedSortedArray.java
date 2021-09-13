package com.great.learning;

public class FindElementInRotatedSortedArray {


    public static void main(String[] args) {
        int elements[] = {2, 5, 6, 9, 10, 15, 19};
        int[] sortedElements = sortElements(new int[]{2, 12, 3, 8, 6, 7, 9});
        printElements(sortedElements);

    }

    private static void printElements(int elements[]) {
        System.out.println("Elements in the array :- ");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private static int[] sortElements(int elements[]) {
        return bubbleSort(elements);
    }

    private static int[] insertionSort(int[] elements) {
        int length = elements.length;
        if (length == 0 || length == 1)
            return elements;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (elements[i] > elements[j]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
        return elements;
    }

    private static int[] selectionSort(int elements[]) {
        int length = elements.length;

        if (length == 0 || length == 1)
            return elements;


        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = 0; j < length; j++) {
                if (elements[minIndex] < elements[j])
                    minIndex = j;
            }
            int temp = elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = temp;
        }

        return elements;
    }

    private static int[] bubbleSort(int elements[]) {
        int length = elements.length;

        if (length == 0 | length == 1)
            return elements;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (elements[i] < elements[j]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
        return elements;
    }

    private static int binarySearch(int elements[], int itemToSearch, int low, int high) {

        if (elements.length == 0)
            return -1;

        int mid = (high + low) / 2;

        if (elements[mid] == itemToSearch)
            return mid;

        if (itemToSearch > elements[mid]) {
            return binarySearch(elements, itemToSearch, mid + 1, high);
        } else {
            return binarySearch(elements, itemToSearch, low, mid - 1);
        }
    }

    private static int searchElement(int elements[], int itemToSearch) {
        elements = sortElements(elements);
        return binarySearch(elements, itemToSearch, 0, elements.length);

    }
}
