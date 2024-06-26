import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    private Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> lionsFood = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), lionsFood);
    }

    @Test
    public void testLionNotOrdinarySex() {
        Assertions.assertThrows(Exception.class, () -> new Lion(feline, "Небинарный"));
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int kittensCount = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        Assertions.assertEquals(1, kittensCount);
    }

}
