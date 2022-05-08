package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BunTest extends TestCase {

    @Mock
    Bun bun;
    @Test
    public void getBunName() {
        Bun bun = new Bun ("black bun", 100);
        String expectedNameBun = "black bun";
        String actualNameBun = bun.getName();
        assertEquals("Некорректное наименование булки",expectedNameBun, actualNameBun);
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun("black bun",100);
        Float expectedPriceBun= Float.valueOf(100);
        Float actualPriceBun = bun.getPrice();
        assertEquals("Некорректная стоимость булки",expectedPriceBun,actualPriceBun,0.0);
    }
}