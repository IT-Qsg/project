package lut.day5;

public class Z_day5_1 {
    public static void main(String... arge) {
        int[] a = {3, 3, 3, 0, 5};
        int[] b = {9, 8, 0, 6, 7, 8, 2, 7, 53};
        System.arraycopy(a, 0, b, 3, 3);//
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "   ");
        }
        System.out.println();
    }

    }
