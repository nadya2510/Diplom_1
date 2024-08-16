package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class BunGetNameTest extends TestCase {
    private Integer indexBun;
    private String nameBun;


    public BunGetNameTest(Integer indexBun, String nameBun) {
        this.indexBun = indexBun;
        this.nameBun = nameBun;
    }

    @Parameterized.Parameters
    public static Object[][] getBunTestGetName() {
        //Тестовые данные
        return new Object[][]{
                {0, "black bun"},
                {1, "white bun"},
                {2, "red bun"}
        };
    }


    @Test
    public void testBunGetName() {
        // Инициализируем базу данных
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Bun> bunsList = database.availableBuns();
        assertEquals(nameBun, bunsList.get(indexBun).getName());
    }

}