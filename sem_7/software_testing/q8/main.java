public class main {
    public static String triangle(int a, int b, int c) {
        boolean side1 = (a >= 1) && (a <= 10);
        boolean side2 = (b >= 1) && (b <= 10);
        boolean side3 = (c >= 1) && (c <= 10);

        if (!side1)
            return "a not in range";
        if (!side2)
            return "b not in range";
        if (!side3)
            return "c not in range";

        if (side1 && side2 && side3) {
            // check for triangle
            if (a < (b + c) && b < (a + c) && c < (a + b)) {
                if ((a == b) && (b == c)) return "equilateral";
                else if ((a != b) && (b != c) && (c != a))  return "scalene";
                else {
                    return "isosceles";
                }
            } else {
                return "Triangle can't be formed";
            }
        }
        return null;
    }
}