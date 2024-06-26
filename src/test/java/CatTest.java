import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    private Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> catFood = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), catFood);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        String sound = cat.getSound();
        Assertions.assertEquals("Мяу", sound);
    }

}
