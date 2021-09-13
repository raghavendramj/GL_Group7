package com.great.learning;

public class QuickSorting {

    private static void swapElements(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private static int partition(int elements[], int lb, int ub) {
        int pivot = elements[lb];
        int start = lb;
        int end = ub;

        while (start < end) {
            while (start <= ub && elements[start] <= pivot) {
                start++;
            }

            while (end <= ub && elements[end] > pivot) {
                end--;
            }

            if (start < end) {
                swapElements(elements, start, end);
            }
        }
        swapElements(elements, lb, end);
        return end;
    }

    private static int[] quickSort(int elements[], int lb, int ub) {
        if (lb < ub) {
            int location = partition(elements, lb, ub);
            quickSort(elements, lb, location - 1);
            quickSort(elements, location + 1, ub);
        }
        return elements;
    }

    private static void printElements(int elements[]) {
        System.out.println("Elements in the array :- ");
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int elements[] = {2, 12, 4, 6, 8, 3, 9, 15, 1, 5};
        int[] sortedElements = quickSort(elements, 0, elements.length - 1);
        printElements(sortedElements);
    }

}
