package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        assertEquals(typeIngredient, ingredient.getType());
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        assertEquals(nameIngredient, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        assertEquals(priceIngredient, ingredient.getPrice(),0.001);
    }
}