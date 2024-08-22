package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String nameBun;
    private float priceBun;

    public BunTest( String nameBun,float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[][] getBunTest() {
        //Тестовые данные
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(nameBun, bun.getName());
    }
    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(priceBun, bun.getPrice(),0.001);
    }

}