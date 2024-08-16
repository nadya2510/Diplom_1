package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest extends TestCase {
    private Integer indexIngredient;
    private IngredientType typeIngredient;


    public IngredientGetTypeTest(Integer indexIngredient, IngredientType typeIngredient) {
        this.indexIngredient = indexIngredient;
        this.typeIngredient = typeIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTestGetType() {
        //Тестовые данные
        return new Object[][]{
                {0, IngredientType.SAUCE},
                {1, IngredientType.SAUCE},
                {2, IngredientType.SAUCE},
                {3, IngredientType.FILLING},
                {4, IngredientType.FILLING},
                {5, IngredientType.FILLING}
        };
    }
    
    @Test
    public void testIngredientGetType() {
        // Инициализируем базу данных
        Database database = new Database();
        // Считаем список доступных булок из базы данных
        List<Ingredient> ingredientsList = database.availableIngredients();
        assertEquals(typeIngredient, ingredientsList.get(indexIngredient).getType());
    }

}