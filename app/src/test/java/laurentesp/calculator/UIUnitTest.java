package laurentesp.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by SOEOSSA on 09/10/2016.
 */

public class UIUnitTest {
    Calculator testMyCalculator = new Calculator();

    @Test
    public void checkIfClearIsOkOnOperator (){
        testMyCalculator.clearCalc();
        assertEquals("",testMyCalculator.getCurOperator());
    }

    @Test
    public void checkIfClearIsOkOnOperand (){
        testMyCalculator.clearCalc();
        assertEquals(0d,testMyCalculator.getReturnVal(),0d);
    }

    @Test
    public void checkIfClearIsOkOnOperatorWhenOperatorHasBeenSetBefore (){
        testMyCalculator.setCurOperator("Add");
        testMyCalculator.clearCalc();
        assertEquals("",testMyCalculator.getCurOperator());
    }

    @Test
    public void checkIfClearIsOkOnOperandWhenOperandHasBeenSetBefore (){
        testMyCalculator.setReturnVal(45d);
        testMyCalculator.clearCalc();
        assertEquals(0d,testMyCalculator.getReturnVal(),0d);
    }

    @Test
    public void checkIfAddIsOK(){
        testMyCalculator.setCurOperator("Add");
        testMyCalculator.clearCalc();
        assertEquals(3d, testMyCalculator.eqCalc(3d),0d);
    }

}
