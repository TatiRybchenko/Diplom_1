package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestCase {

    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        String expectedАddIngredient = String.valueOf(ingredient);
        String actualАddIngredient = String.valueOf(burger.ingredients.get(0));
        assertEquals("Добавление ингредиента не произошло", expectedАddIngredient, actualАddIngredient);
    }
    @Test
    public void removeIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        List<Ingredient> expectedRemoveIngredient = new ArrayList<>();
        List<Ingredient> actualRemoveIngredient = burger.ingredients;
        assertEquals("Удаление ингредиента из списка не произошло", expectedRemoveIngredient, actualRemoveIngredient);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE,"sour cream",200));
        burger.addIngredient(new Ingredient(FILLING,"dinosaur",200));
        burger.addIngredient(new Ingredient(FILLING,"sausage",300));
        burger.moveIngredient(0,2);

        String expectedMoveIngredient = "sausage";
        String actualMoveIngredient = burger.ingredients.get(1).name;
        assertEquals("Перемещение ингредиента не произошло", expectedMoveIngredient, actualMoveIngredient);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        float price = 500;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPriceBurger = 1500;
        float actualPriceBurger = burger.getPrice();
        assertEquals("Цена бургера некорректная", expectedPriceBurger, actualPriceBurger);
    }

    }