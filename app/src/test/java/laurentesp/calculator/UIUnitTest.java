package laurentesp.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by SOEOSSA on 09/10/2016.
 */

public class UIUnitTest {
    MainActivity mainActivity = new MainActivity();

    @Test
    public void checkIfConcatenationOfTwoNumbersIsOK() throws Exception{
        assertEquals("31",mainActivity.concatenateTwoNumbers("3","1"));
    }

    @Test
    public void checkIfConcatenationOfTwoNumbersWithFirstNumberIsZeroIsOK() throws Exception{
        assertEquals("1",mainActivity.concatenateTwoNumbers("0","1"));
    }

    @Test
    public void checkIfConcatenationWhenNoDotInFirstString() throws Exception{
        assertEquals("1.",mainActivity.concatenateDot("1"));
    }

    @Test
    public void checkIfNotConcatenationIsDoneWhenDotAlreadyExistsInString() throws Exception{
        assertEquals("1.345",mainActivity.concatenateDot("1.345"));
    }
}
