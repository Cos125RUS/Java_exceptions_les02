package org.example;

public class Task02 {
    public static void main(String[] args) {
        String[][] arr = {{"f", "7", null}, {"3", "t", "0"}, {"4", "3", null}};
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    int val = isNumeric(arr[i][j]);
                    sum += val;
                }
            }
        }
        return sum;
    }

    public static int isNumeric(String value) {
        try {
            int num = Integer.parseInt(value);
            return num;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
