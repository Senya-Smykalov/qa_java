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
        int result = felineMock.getKittens();
        int kittens = 1;
        assertEquals(kittens, result);
    }
    @Test
    public void testGetKittensCount() {
        int result = felineMock.getKittens(3);
        int kittensCount = 3;
        assertEquals(kittensCount, result);
    }
}
