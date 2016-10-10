package laurentesp.calculator;

import android.content.Context;

/**
 * Created by SOEOSSA on 04/10/2016.
 */

public class Calculator {

    static Double calcOperand = null;
    static Double operand1 = null;
    static Double operand2 = null;
    static String calcOperator = "";
    static boolean equalsAlreadyEntered = false;

    public Double operateOrPrepareOperation (Double curOperand, String curOperator){
        Double valToReturn = 0d;

        if (operand1 == null) {
            operand1 = curOperand;
            valToReturn = operand1;
        } else {
            operand2 = curOperand;
            valToReturn = this.eq2();
        }


       /* if (calcOperand == null){
            valToReturn = curOperand;
        } else {
            valToReturn = this.eq(curOperand);
        } */

        if (!(curOperator.equals("="))){
            calcOperator = curOperator;
            equalsAlreadyEntered = false;
            calcOperand = curOperand;
        } else {
            if (!equalsAlreadyEntered) {
                // We change the value of the Operand from the first equal to be able to have 3 + 4 = 7 if we push new "=" then the result will be 11
                calcOperand = curOperand;
            }
            equalsAlreadyEntered = true;
        }



        return valToReturn;
    }

    public Double eq (Double secondOperand){
        Double valToReturn = 0d;

        switch (calcOperator) {
            case "+":
                valToReturn = calcOperand + secondOperand;
            break;
            case "-":
                valToReturn = calcOperand - secondOperand;
            break;
            case "/":
                valToReturn = calcOperand / secondOperand;
            break;
            case "x":
                valToReturn = calcOperand * secondOperand;
            break;

            default:
                valToReturn = secondOperand;
        }

        return valToReturn;
    }

    public Double eq2 (){
        Double valToReturn = 0d;
        if (operand2 == null) {
            valToReturn = operand1;
        } else {
            switch (calcOperator) {
                case "+":
                    valToReturn = operand1 + operand2;
                    break;
                case "-":
                    valToReturn = operand1 - operand2;
                    break;
                case "/":
                    valToReturn = operand1 / operand2;
                    break;
                case "x":
                    valToReturn = operand1 * operand2;
                    break;

                default:
                    valToReturn = operand1;
            }
        }
        operand1 = valToReturn;
        return valToReturn;
    }

    public void clearCalc() {
        calcOperator = "";
        calcOperand = null;
        operand1 = null;
        operand2 = null;
    }

}
