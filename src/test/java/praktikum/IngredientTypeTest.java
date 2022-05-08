package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest extends TestCase {

    @Mock
    Ingredient  ingredient;
    @Test
    public void valuesIngredientTypeSauce() {

        Ingredient  ingredient = new Ingredient(SAUCE,"sour cream",200);
        String expectedIngredientType = String.valueOf(SAUCE);
        String actualIngredientType = String.valueOf(ingredient.getType());
        assertEquals("Некорректное наименование типа ингредиента",expectedIngredientType,actualIngredientType);
    }

    @Test
    public void valueIngredientTypeFilling() {
        Ingredient  ingredient = new Ingredient(FILLING,"sausage",300);
        String expectedIngredientType = String.valueOf(FILLING);
        String actualIngredientType = String.valueOf(ingredient.getType());
        assertEquals("Некорректное наименование типа ингредиента",expectedIngredientType,actualIngredientType);
    }
}