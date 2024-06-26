import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assertions.assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittensWithNoParams() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
