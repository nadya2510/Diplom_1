package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestCase {
    // Инициализируем базу данных
    Database database = new Database();
    // Считаем список доступных булок из базы данных
    List<Bun> buns = database.availableBuns();
    // Считаем список доступных ингредиентов из базы данных
    @Mock
    List<Ingredient> ingredientsMock = database.availableIngredients();

    @Spy
    Burger burgerSpy = new Burger();


    @Test
    public void testAddIngredient() {
        // Создадим новый бургер
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        // Соберём бургер
        burger.setBuns(buns.get(0));
        Integer coundBefor = burger.ingredients.size();
        burger.addIngredient(ingredients.get(1));
        Integer coundAfter = burger.ingredients.size();
        assertNotEquals(coundBefor, coundAfter);

    }

    @Test
    public void testRemoveIngredient() {
        // Создадим новый бургер
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        // Соберём бургер
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        Integer coundBefor = burger.ingredients.size();
        burger.removeIngredient(0);
        Integer coundAfter = burger.ingredients.size();
        assertNotEquals(coundBefor, coundAfter);

    }

    @Test
    public void testMoveIngredient() {
        // Создадим новый бургер
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        // Соберём бургер
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));
        burger.moveIngredient(1,0);

        assertEquals(ingredients.get(2).getName(), burger.ingredients.get(0).getName());

    }

    @Test
    public void testGetPrice() {
        List<Ingredient> ingredients = database.availableIngredients();
        // Соберём бургер
        burgerSpy.setBuns(buns.get(0));
        burgerSpy.addIngredient(ingredients.get(1));
        burgerSpy.addIngredient(ingredients.get(2));
        Mockito.when(burgerSpy.getPrice()).thenReturn(500.00F);
        float priceBurger = burgerSpy.getPrice();
        assertEquals(500.00F, priceBurger);
    }

    @Test
    public void testGetReceipt() {
        List<Ingredient> ingredients = database.availableIngredients();
        // Соберём бургер
        burgerSpy.setBuns(buns.get(0));
        burgerSpy.addIngredient(ingredients.get(1));
        burgerSpy.addIngredient(ingredients.get(2));
        burgerSpy.getReceipt();
        Mockito.verify(burgerSpy, Mockito.times(1)).getPrice();

    }

}