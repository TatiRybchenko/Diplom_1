package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTypeTest {
    private Ingredient ingredient;
    private IngredientType ingredientType;

    public ParameterizedIngredientTypeTest(IngredientType ingredientType){
        this.ingredientType=ingredientType;
    }
    @Parameterized.Parameters
    public static Object [][] getIngredientTypeTest(){

        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }
    @Test
    public void valueIngredientTypeFillingSauceTest(){
        ingredient = new Ingredient(ingredientType,"sausage",300);
        String expectedIngredientType = String.valueOf(ingredientType);
        String actualIngredientType = String.valueOf(ingredient.getType());
        assertEquals("Ингредиент отсутствует", expectedIngredientType, actualIngredientType);

    }
}

