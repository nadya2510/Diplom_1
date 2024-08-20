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
        // Соберём бургер
        burgerSpy.setBuns(new Bun("green bun", 100));
        burgerSpy.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burgerSpy.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(burgerSpy.getPrice()).thenReturn(500.00F);
        float priceBurger = burgerSpy.getPrice();
        assertEquals(500.00F, priceBurger, 0.001);
    }

    @Test
    public void testGetReceiptPrice() {
        burgerSpy.setBuns(new Bun("green bun", 100));
        burgerSpy.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        Mockito.when(burgerSpy.getPrice()).thenReturn(200.00F);
        String receipt = burgerSpy.getReceipt();
        MatcherAssert.assertThat(receipt, containsString("200"));
    }

    @Test
    public void testGetReceiptNameBun() {
        burger.setBuns(new Bun("green bun", 100));
        String receipt = burger.getReceipt();
        MatcherAssert.assertThat(receipt, containsString("green bun"));
    }

    @Test
    public void testGetReceiptNameIngredient() {
        burger.setBuns(new Bun("green bun", 100));
        burger.addIngredient( new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        String receipt = burger.getReceipt();
        MatcherAssert.assertThat(receipt, containsString("sauce sour cream"));
    }


}