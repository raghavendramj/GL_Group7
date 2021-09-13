package com.great.learning;

public class SortingAlgorithms {

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

    private static int[] quickSort(int elements[], int low, int high) {

        if (low < high) {
            int location = partition(elements, low, high);
            quickSort(elements, low, location - 1);
            quickSort(elements, location + 1, high);
        }
        return elements;
    }

    private static int partition(int elements[], int start, int end) {
        int pivot = elements[start];
        int ub = start, lb = end;
        do {
            ub++;
        } while (ub <= end && elements[ub] <= pivot);
        do {
            lb--;
        } while (lb <= end && elements[lb] > pivot);

        if (ub < lb) {
            swapElements(elements, ub, lb);
        }
        swapElements(elements, start, lb);
        return lb;
    }

    private static void swapElements(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private static int[] mergeSort(int[] elements, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid);
            mergeSort(elements, mid + 1, high);
            merge(elements, low, mid, high);
        }
        return elements;
    }

    private static int[] merge(int elements[], int lb, int mid, int ub) {

        int i = lb; //inital index of first subarray
        int j = mid + 1; // initial index of second subarray
        int k = lb; // initial index of merged array

        int output[] = new int[elements.length];
        while (i <= mid && j <= ub) {
            /*if (elements[i] < elements[j]) {
                output[k] = elements[i];
                i++;
            } else {
                output[k] = elements[j];
                j++;
            }
            k++;*/

            output[k++] = elements[i] < elements[j] ? elements[i++] : elements[j++];
        }
        if (i > mid) {
            // Copy the remaining elements on left half , if there are any
            while (j <= ub) {
                output[k] = elements[j];
                j++;
                k++;
            }
        } else {
            // Copy the remaining elements on right half , if there are any
            while (i <= mid) {
                output[k] = elements[i];
                i++;
                k++;
            }
        }


        // Copy the remaining elements from array output back the numbers array
        for (int x = lb; x <= ub; x++) {
            elements[x] = output[x];
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
        int elements[] = {2, 40, 15, 8, 3, 15, 16, 21};
        int[] sortedElements = quickSort(elements, 0, elements.length - 1);
        printElements(sortedElements);
    }
}
