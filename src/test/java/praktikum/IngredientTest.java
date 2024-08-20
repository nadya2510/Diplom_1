package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType typeIngredient;
    private String nameIngredient;
    private float priceIngredient;


    public IngredientTest(IngredientType typeIngredient, String nameIngredient,float priceIngredient ) {
        this.typeIngredient = typeIngredient;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTest() {
        //Тестовые данные
        return new Object[][]{
                { IngredientType.SAUCE, "hot sauce", 100},
                { IngredientType.SAUCE, "sour cream", 200},
                { IngredientType.SAUCE, "chili sauce", 300},
                { IngredientType.FILLING, "cutlet", 100},
                { IngredientType.FILLING, "dinosaur", 200},
                { IngredientType.FILLING, "sausage", 300}

        };
    }

    @Test
    public void testIngredientGetType() {
        List<Ingredient> ingredients = new ArrayList<>();;
        ingredients.add(new Ingredient(typeIngredient, nameIngredient, priceIngredient));
        // Инициализируем базу данных
        Database database = Mockito.mock(Database.class);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        // Считаем список доступных булок из базы данных
        assertEquals(typeIngredient, database.availableIngredients().get(0).getType());
    }

    @Test
    public void testIngredientGetName() {
        List<Ingredient> ingredients = new ArrayList<>();;
        ingredients.add(new Ingredient(typeIngredient, nameIngredient, priceIngredient));
        // Инициализируем базу данных
        Database database = Mockito.mock(Database.class);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        // Считаем список доступных булок из базы данных
        assertEquals(nameIngredient, database.availableIngredients().get(0).getName());
    }

    @Test
    public void testIngredientGetPrice() {
        List<Ingredient> ingredients = new ArrayList<>();;
        ingredients.add(new Ingredient(typeIngredient, nameIngredient, priceIngredient));
        // Инициализируем базу данных
        Database database = Mockito.mock(Database.class);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
        // Считаем список доступных булок из базы данных
        assertEquals(priceIngredient, database.availableIngredients().get(0).getPrice(),0.001);
    }




}