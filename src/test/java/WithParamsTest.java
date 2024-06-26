import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

public class WithParamsTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void testLionHasMane(String sex, boolean result) throws Exception {
        Lion lion = new Lion(feline, sex);
        Assertions.assertEquals(result, lion.doesHaveMane());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "3, 3",
            "100, 100"
    })
    public void testFelineGetKittens(int kittensCount, int result) {
        Feline feline = new Feline();
        int kittensNumber = feline.getKittens(kittensCount);
        Assertions.assertEquals(result, kittensNumber);
    }

}
