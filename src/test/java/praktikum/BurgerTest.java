package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Spy
    Burger burgerSpy = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    //
    float priceBun = 100;
    float priceIngredient = 200;
    float price = priceBun*2+priceIngredient;

    String nameBun = "black bun";
    String nameIngredient = "sour cream";
    IngredientType typeIngredient = IngredientType.SAUCE;
    String fullNameIngredient = String.format("= %s %s =%n", typeIngredient.toString().toLowerCase(), nameIngredient);

    @Test
    public void testAddIngredient() {
        Integer countBefor = burger.ingredients.size();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        Integer countAfter = burger.ingredients.size();

        assertNotEquals(countBefor, countAfter);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        Integer countBefor = burger.ingredients.size();
        burger.removeIngredient(0);
        Integer countAfter = burger.ingredients.size();

        assertNotEquals(countBefor, countAfter);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(2,0);

        assertEquals("chili sauce", burger.ingredients.get(0).getName());
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(price, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceiptPrice() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        Mockito.when(ingredient.getType()).thenReturn(typeIngredient);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(burger.getReceipt(), containsString(String.format("%nPrice: %f%n",price)));

    }

    @Test
    public void testGetReceiptNameBun() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        Mockito.when(ingredient.getType()).thenReturn(typeIngredient);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(burger.getReceipt(), containsString(nameBun));
    }

    @Test
    public void testGetReceiptNameIngredient() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        Mockito.when(ingredient.getType()).thenReturn(typeIngredient);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(burger.getReceipt(), containsString(fullNameIngredient));
    }

    @Test
    public void testGetReceipt() {
        burgerSpy.setBuns(new Bun("black bun", 100));
        burgerSpy.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burgerSpy.getReceipt();

        Mockito.verify(burgerSpy, Mockito.times(1)).getPrice();
    }

}