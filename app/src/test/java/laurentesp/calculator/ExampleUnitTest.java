package laurentesp.calculator;

import org.junit.Test;

import static laurentesp.calculator.Calculator.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void shouldReturnTrueIfTheResultOfAddMethodIsOK() throws Exception {
        assertEquals("3", getResultFromOperatorOnOperands("2","1","addFunction"));
    }

    @Test
    public void shouldReturnFalseIfTheResultOfAddMethodIsNOK() throws Exception {
        assertNotEquals("5.0", getResultFromOperatorOnOperands("2","1","addFunction"));
    }

    @Test
    public void shouldReturnTrueIfCanRemoveFractionalPart() throws Exception {
        assertEquals("0", removeFractionalPartFromDoubleIfNotNecessary(0.0));
    }

    @Test
    public void shouldReturnTrueIfShouldNotRemoveFractionnalPart() throws Exception {
        assertEquals("0.1", removeFractionalPartFromDoubleIfNotNecessary(0.1));
    }

    @Test
    public void shouldReturnTrueIfTheResultOfMinusMethodIsPositiveAndOK() throws Exception {
        assertEquals("3", getResultFromOperatorOnOperands("4","1","minusFunction"));
    }

    @Test
    public void shouldReturnTrueIfTheResultOfMinusMethodIsNegativeAndOK() throws Exception {
        assertEquals("-3", getResultFromOperatorOnOperands("1","4","minusFunction"));
    }

    @Test
    public void shouldReturnTrueIfTheResultOfMinusMethodIsFractionalAndOK() throws Exception {
        assertEquals("40.2", getResultFromOperatorOnOperands("45.2","5","minusFunction"));
    }
}