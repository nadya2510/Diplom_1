package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class IngredientGetNameTest extends TestCase {
    private Integer indexIngredient;
    private String nameIngredient;


    public IngredientGetNameTest(Integer indexIngredient, String nameIngredient) {
        this.indexIngredient = indexIngredient;
        this.nameIngredient = nameIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTestGetName() {
        //Тестовые данные
        return new Object[][]{
                {0, "hot sauce"},
                {1, "sour cream"},
                {2, "chili sauce"},
                {3, "cutlet"},
                {4, "dinosaur"},
                {5, "sausage"}
        };
    }

    @Test
    public void testIngredientGetName() {
        // Инициализируем базу данных
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Ingredient> ingredientsList = database.availableIngredients();
        assertEquals(nameIngredient, ingredientsList.get(indexIngredient).getName());
    }

}