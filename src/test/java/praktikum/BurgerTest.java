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
    @Mock
    Burger burgerMock = new Burger();
    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burgerMock.setBuns(burgerMock.bun);
        Mockito.verify(burgerMock).setBuns(burgerMock.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(ingredient,burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        List<Ingredient> expected = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(expected,burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        burger.addIngredient(new Ingredient(FILLING,"sour cream",200));
        burger.moveIngredient(0,1);

        assertEquals("hot sauce",burger.ingredients.get(1).name);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        float price = 12.99f;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(38.97f,burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(12.99f);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кепчук");
        Mockito.when(ingredient.getPrice()).thenReturn(12.99f);

        String expected ="(==== Булка ====)" +"\r\n" + "= sauce Кепчук =" +"\r\n"+"(==== Булка ====)"+"\r\n"+"\r\n"+"Price: 38,970001"+"\r\n";

        assertEquals(expected,burger.getReceipt());
    }
}