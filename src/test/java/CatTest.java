import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> catFood = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), catFood);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assertions.assertEquals("Мяу", sound);
    }

}
