public class BasicsOfProgramming {

    public static void main(String[] args) {
        System.out.println("Maximum element is :- " + findMaximum(new int[]{18}));
        System.out.println("Maximum element is :- " + findMaximum(new int[]{2, 1, 6, 12, 45, 16, 8, 2, 1, 6, 12, 45, 16, 8, 2, 1, 6, 12, 45, 16, 8}));
        System.out.println("Maximum element is :- " + findMaximum(new int[]{2, 1, 6, 12, 45, 1 ,12, 45, 16, 8}));
        System.out.println("Maximum element is :- " + findMaximum(new int[]{2, 1, 6, 12, 45, 16, 8}));
    }

    private static int findMaximum(int elements[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > maximum)
                maximum = elements[i];
        }
        return maximum;
    }
}
