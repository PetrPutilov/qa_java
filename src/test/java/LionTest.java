import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
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
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittensCount = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Assertions.assertEquals(1, kittensCount);
    }

}
