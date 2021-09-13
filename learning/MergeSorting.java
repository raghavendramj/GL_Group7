package com.great.learning;

public class MergeSorting {

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
        int elements[] = {2, 12, 4, 6, 8, 3, 9, 15, 1, 5};
        int[] sortedElements1 = mergeSort(elements, 0, elements.length - 1);
        printElements(sortedElements1);
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 67, 5, 9};
        int[] sortedElements2 = mergeSort(randomNumbers, 0, elements.length - 1);
        printElements(sortedElements2);
    }

}
