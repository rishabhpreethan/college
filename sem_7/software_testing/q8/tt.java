import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tt {
    @Test
    public void testTriangle() {
        main obj = new main();
        String op1 = obj.triangle(10, 10, 10);
        assertEquals("equilateral", op1);
        String op2 = obj.triangle(10, 10, 5);
        assertEquals("isosceles", op2);
        String op3 = obj.triangle(5, 6, 7);
        assertEquals("scalene", op3);
    }
}