package classic150;

public class Calculator_224 {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        return helper(arr, 0)[0];
    }

    private int[] helper(char[] arr, int i) {
        int ans = 0;
        int num = 0;
        int sign = 1;

        while (i < arr.length) {
            char c = arr[i];

            if (Character.isDigit(c)) {

                num = num * 10 + (c - '0');
            } else if (c == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                int[] tmp = helper(arr, i + 1);
                num = tmp[0];
                i = tmp[1];
            } else if (c == ')') {
                ans += sign * num;
                return new int[]{ans, i};
            }
            i++;
        }

        ans += sign * num;
        return new int[]{ans, i};
    }

    public static void main(String[] args) {
        Calculator_224 calc = new Calculator_224();
        System.out.println(calc.calculate("1 + (2 - (3 + 4))")); // 输出 -4
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)")); // 输出 23
    }
}
