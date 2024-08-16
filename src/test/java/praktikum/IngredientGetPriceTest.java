package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class IngredientGetPriceTest extends TestCase {
    private Integer indexIngredient;
    private float priceIngredient;


    public IngredientGetPriceTest(Integer indexIngredient, float priceIngredient) {
        this.indexIngredient = indexIngredient;
        this.priceIngredient =priceIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTestGetPrice() {
        //Тестовые данные
        return new Object[][]{
                {0, 100},
                {1, 200},
                {2, 300},
                {3, 100},
                {4, 200},
                {5, 300}
        };
    }

    @Test
    public void testIngredientGetPrice() {
        // Инициализируем базу данных
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Ingredient> ingredientsList = database.availableIngredients();
        assertEquals(priceIngredient, ingredientsList.get(indexIngredient).getPrice());
    }

}