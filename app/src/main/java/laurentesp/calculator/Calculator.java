package laurentesp.calculator;

import android.content.Context;

/**
 * Created by SOEOSSA on 04/10/2016.
 */

public class Calculator {

    static private Double returnVal = 0d;
    static private String curOperator = "";

    public static Double getReturnVal() {
        return returnVal;
    }

    public static void setReturnVal(Double returnVal) {
        Calculator.returnVal = returnVal;
    }

    public static String getCurOperator() {
        return curOperator;
    }

    public static void setCurOperator(String curOperator) {
        Calculator.curOperator = curOperator;
    }

    public void clearCalc() {
        returnVal = 0d;
        curOperator = "";
    }

    public enum operationWithOneOperand {
        COS,SIN, TAN, SQ, ASIN, ACOS, ATAN, Pow3, eX, pow10,invX, Ln, Log, sqrt, pm
    }

    public Double prepareOperationOrOperates(String valIn, Boolean isNewVal, String chosenOperator) {
        if (isNewVal) {
            returnVal = 0d;
            curOperator = "";
        }
        switch (chosenOperator) {
            case "COS" :
            case "SIN" :
            case "TAN" :
            case "SQ" :
            case "ASIN" :
            case "ACOS" :
            case "ATAN" :
            case "Pow3" :
            case "eX" :
            case "pow10" :
            case "invX" :
            case "Ln" :
            case "Log":
            case "sqrt" :
            case "pm" :
                curOperator =  chosenOperator;
                if (valIn.isEmpty()) {
                    returnVal = eqCalc(returnVal);
                } else {
                    returnVal = eqCalc(Double.valueOf(valIn));
                }
                break;

            default:
                    if (curOperator.isEmpty()){
                        if (valIn.isEmpty()) {
                            returnVal = 0d;
                        } else {
                            returnVal = Double.valueOf(valIn);
                        }
                    } else {
                        if (!(valIn.isEmpty())) {
                            returnVal = eqCalc(Double.valueOf(valIn));
                        }
                    }
                    curOperator =  chosenOperator;
        }
      return returnVal;
    }

    public Double eqCalc(Double valIn){

        switch (curOperator) {
            case "Add":
                returnVal += valIn;
            break;

            case "Sub":
                returnVal -= valIn;
            break;

            case "Div":
                returnVal /= valIn;
            break;

            case "Mult":
                returnVal *= valIn;
            break;

            case "COS" :
                returnVal = Math.cos(valIn);
                break;

            case "SIN" :
                returnVal = Math.sin(valIn);
                break;

            case "TAN" :
                returnVal = Math.tan(valIn);
                break;
            case "SQ" :
                returnVal = valIn*valIn;
                break;
            case "ASIN" :
                returnVal = Math.asin(valIn);
                break;
            case "ACOS" :
                returnVal = Math.acos(valIn);
                break;
            case "ATAN" :
                returnVal = Math.atan(valIn);
                break;
            case "Pow3" :
                returnVal = Math.pow(valIn,3);
                break;
            case "eX" :
                returnVal = Math.exp(valIn);
                break;
            case "pow10" :
                returnVal = Math.pow(10,valIn);
                break;
            case "invX" :
                returnVal = 1/valIn;
                break;
            case "Ln" :
                returnVal = Math.log(valIn);
                break;
            case "Log":
                returnVal = Math.log10(valIn);
                break;
            case "sqrt" :
                returnVal = Math.sqrt(valIn);
                break;
            case "pm":
                returnVal = - valIn;
                break;
            case "XPowY":
                returnVal = Math.pow(returnVal,valIn);
                break;
            default:
                returnVal = valIn;
        }

        return returnVal;
    }
}
