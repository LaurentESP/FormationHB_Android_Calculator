package laurentesp.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOEOSSA on 04/10/2016.
 */

public class Calculator {
    //static List<StringBuffer> valOperand = new ArrayList<>();

    static StringBuffer valOperand1 = new StringBuffer("0");
    static StringBuffer valOperand2 = new StringBuffer("0");

    // The attribute curOperand is used to determine during the calculation if the user is entering the first or the second operand
    static int curOperand = 0;
    static StringBuffer operator = new StringBuffer("");


    static String getValOutToShowtoUser(String stringIn, String stringInTextView) {
        StringBuffer stringBufOut = new StringBuffer("");
        switch (stringIn) {
            // The "C" button is used to clear the 2 operands and the operator
            case "C":
                valOperand1.setLength(0);
                valOperand2.setLength(0);
                curOperand = 0; // Go Back to first operand
                stringBufOut.setLength(0);
                stringBufOut.append("0");
                break;

            // In the case of the user enters the value 0 we have to check if the operand is not already null because it's useless to concatenate zeros
            case "0":
                if (stringInTextView.equals("0")) {
                    stringBufOut.append(stringInTextView);
                } else {
                    stringBufOut.append(stringInTextView);
                    stringBufOut.append(stringIn);
                }
                if (curOperand == 0) {
                    valOperand1 = stringBufOut;
                } else {
                    valOperand2 = stringBufOut;
                }
                break;

            case "+":
                curOperand = 1;
                stringBufOut.append("0");
                operator.setLength(0);
                operator.append("addFunction");
                break;

            case "-":
                curOperand = 1;
                stringBufOut.append("0");
                operator.setLength(0);
                operator.append("minusFunction");
                break;

            case "x":
                curOperand = 1;
                stringBufOut.append("0");
                operator.setLength(0);
                operator.append("multFunction");
                break;

            case "/":
                curOperand = 1;
                stringBufOut.append("0");
                operator.setLength(0);
                operator.append("divFunction");
                break;


            case "=":
                curOperand = 0;
                stringBufOut.setLength(0);
                stringBufOut.append(getResultFromOperatorOnOperands(valOperand1.toString(),valOperand2.toString(),operator.toString()));
                valOperand1.setLength(0);
                valOperand2.setLength(0);
                break;

            case ".":
                // if there is no character already typed before a point we have to a 0 before the point
                if (stringInTextView == "0") {
                    stringBufOut.append("0");
                    stringBufOut.append(stringIn);
                } else {
                    // There can't be two points in a Double
                    if (!(stringInTextView.contains("."))){
                        stringBufOut.append(stringInTextView);
                        stringBufOut.append(stringIn);
                    } else {
                        stringBufOut.append(stringInTextView);
                    }
                }
                break;

            default:
                // The default case is for 1..9 buttons / Only requirement, if a 0 has been entered previously we won't show it
                if (stringInTextView.equals("0")) {
                    stringBufOut.append(stringIn);
                } else {
                    stringBufOut.append(stringInTextView);
                    stringBufOut.append(stringIn);
                }

                if (curOperand == 0) {
                    valOperand1 = stringBufOut;
                } else {
                    valOperand2 = stringBufOut;
                }
        }

        return stringBufOut.toString();
    }

    static String getLastOperand() {
        StringBuffer stringBufOut = new StringBuffer("");
        if (curOperand == 0) {
            stringBufOut = valOperand1;
        } else {
            stringBufOut = valOperand2;
        }

        return stringBufOut.toString();
    }

    static String getResultFromOperatorOnOperands(String operand1, String operand2, String operator) {
        double valOperand1 =  Double.valueOf(operand1);
        double valOperand2 = Double.valueOf(operand2);
        double valOut = 0;
        switch (operator) {
            case "addFunction":
                valOut = valOperand1 + valOperand2;
                break;
            case "minusFunction":
                valOut = valOperand1 - valOperand2;
                break;
            case "multFunction":
                valOut = valOperand1 * valOperand2;
                break;
            default:
                valOut = valOperand1;
        }
        return removeFractionalPartFromDoubleIfNotNecessary(valOut);
    }

    static String removeFractionalPartFromDoubleIfNotNecessary(double valIn){
        double fractionalPart = valIn % 1;
        double integralPart = valIn - fractionalPart;
        int intPart = (int)integralPart;
        String valOut;

        if ((valIn - integralPart) != 0.0) {
            valOut = new String(Double.toString(valIn));
        } else {
            valOut = new String(Integer.toString(intPart));
        }
        return valOut;
    }

}
