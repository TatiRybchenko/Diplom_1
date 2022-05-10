package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest extends TestCase {

    @Test
    public void getPriceIngredient() {
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur",200);
        Float expectedPriceIngredient = Float.valueOf(200);
        Float actualPriceIngredient = ingredient.getPrice();
        assertEquals("Некорректная стоимость ингредиента",expectedPriceIngredient, actualPriceIngredient,0.0);
    }

    @Test
    public void getNameIngredient() {
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur",200);
        String expectedNameIngredient = "dinosaur";
        String actualNameIngredient = ingredient.getName();
        assertEquals("Некорректная наименование ингредиента", expectedNameIngredient, actualNameIngredient);
    }

    @Test
    public void getTypeIngredient() {
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur",200);
        String expectedTypeIngredient = String.valueOf(FILLING);
        String actualTypeIngredient = String.valueOf(ingredient.getType());
        assertEquals("Некорректная наименование ингредиента", expectedTypeIngredient, actualTypeIngredient);
    }
}