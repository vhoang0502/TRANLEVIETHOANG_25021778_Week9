import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @BeforeAll
    public static void setUpAll() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("=== Kết thúc ===");
    }


    @Test
    public void testMax_A_GreaterThan_B() {
        assertEquals(5, MathUtils.max(5, 3), "a > b phải trả về a");
    }

    @Test
    public void testMax_A_Equals_B() {
        assertEquals(4, MathUtils.max(4, 4), "a = b phải trả về a (hoặc b)");
    }

    @Test
    public void testMax_A_LessThan_B() {
        assertEquals(8, MathUtils.max(2, 8), "a < b phải trả về b");
    }

    @Test
    public void testMax_BoundaryValues() {
        // Biên Integer.MAX_VALUE và Integer.MIN_VALUE
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
        assertEquals(-1, MathUtils.max(Integer.MIN_VALUE, -1));
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testDivide_PositiveDivider() {
        assertEquals(5, MathUtils.divide(10, 2), "b > 0: kết quả 5");
    }

    @Test
    public void testDivide_NegativeDivider() {
        assertEquals(-5, MathUtils.divide(10, -2), "b < 0: kết quả -5");
    }

    @Test
    public void testDivide_ZeroDivider_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}