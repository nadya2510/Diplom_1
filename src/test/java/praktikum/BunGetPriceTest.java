package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class BunGetPriceTest extends TestCase {
    private Integer indexBun;
    private float priceBun;


    public BunGetPriceTest(Integer indexBun, float priceBun) {
        this.indexBun = indexBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[][] getBunTestGetPrice() {
        //Тестовые данные
        return new Object[][]{
                {0, 100},
                {1, 200},
                {2, 300}
        };
    }


    @Test
    public void testBunGetPrice() {
        // Инициализируем базу данных
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Bun> bunsList = database.availableBuns();
        assertEquals(priceBun, bunsList.get(indexBun).getPrice());
    }

}