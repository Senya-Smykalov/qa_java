package animals.test;

import animals.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline felineMock;
    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));
        List<String> result = felineMock.eatMeat();
        assertEquals(List.of("Мясо"), result);
    }
    @Test
    public void testGetFamily() {
        String result = felineMock.getFamily();
        assertEquals("Кошачьи", result);
    }
    @Test
    public void testGetKittens() {
        int kittens = 1;
        int result = felineMock.getKittens(kittens);

        assertEquals(kittens, result);
    }
    @Test
    public void testGetKittensCount() {
        int kittensCount = 3;
        int result = felineMock.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }
}
