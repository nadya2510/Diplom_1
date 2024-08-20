package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
        List<Bun> buns = new ArrayList<>();;
        buns.add(new Bun(nameBun, priceBun));
        // Инициализируем базу данных
        Database database = Mockito.mock(Database.class);
        Mockito.when(database.availableBuns()).thenReturn(buns);
        // Считаем список доступных булок из базы данных
        assertEquals(nameBun, database.availableBuns().get(0).getName());
    }
    @Test
    public void testBunGetPrice() {
        List<Bun> buns = new ArrayList<>();;
        buns.add(new Bun(nameBun, priceBun));
        // Инициализируем базу данных
        Database database = Mockito.mock(Database.class);
        Mockito.when(database.availableBuns()).thenReturn(buns);
        // Считаем список доступных булок из базы данных
        assertEquals(priceBun, database.availableBuns().get(0).getPrice(),0.001);
    }

}