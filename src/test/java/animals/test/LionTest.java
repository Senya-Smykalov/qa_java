package animals.test;

import animals.Feline;
import animals.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    private Feline felineTwo;
    @Test
    public void testGetKittens() {
        Mockito.when(felineTwo.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineTwo);
        int result = lion.getKittens();
        int kittens = 3;
        assertEquals(kittens, result);
    }
    @Test
    public void testDoesHaveMane() {
        Lion lion = new Lion("Самец", felineTwo);
        assertTrue(lion.doesHaveMane());
        lion = new Lion("Самка", felineTwo);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(felineTwo.getFood("Хищник")).thenReturn(Arrays.asList("Мясо", "Рыбов"));
        Lion lion = new Lion("Самец", felineTwo);
        List<String> result = lion.getFood();
        assertEquals(Arrays.asList("Мясо", "Рыбов"), result);
    }
    @Test
    public void genderTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lion("Что-то другое", felineTwo));
    }

    @Test
    public void errorGender(){
        Lion lion = new Lion("Самец", felineTwo);
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }

}

