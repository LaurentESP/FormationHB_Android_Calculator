package laurentesp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private static String registerDisplay;
    private static boolean operationPending;

    public MainActivity() {
        this.calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_view_0);
        if (registerDisplay == null) {
            putInitialValueinCurrentDisplay();
        }
        textView.setText(registerDisplay);
    }

    public void clickMeth(View view){
        final TextView textView = (TextView) findViewById(R.id.text_view_0);
        String butClicked = view.getTag().toString();
        textView.setText(updateDisplay(butClicked,textView));
    }

    private String updateDisplay(String keyClicked, TextView textView){
        String stringToReturn;
        Double valueFromCalc = 0d;
        String valFromTextView = textView.getText().toString();
        switch (keyClicked){
            case "C":
                putInitialValueinCurrentDisplay();
                calculator.clearCalc();
                stringToReturn = registerDisplay;
                break;
            case ".":
                stringToReturn = concatenateDot(registerDisplay);
                registerDisplay = stringToReturn;
                break;
                // Do not register the display in the case of an operator because after we have to enter a new operand
            case "+":
            case "-":
            case "/":
            case "x":
            case "=":
                valueFromCalc = calculator.operateOrPrepareOperation(Double.valueOf(valFromTextView),keyClicked);
                stringToReturn = removeFractionalPartFromDoubleIfNotNecessary(valueFromCalc);
                putInitialValueinCurrentDisplay();
                break;
            default:
                stringToReturn = concatenateTwoNumbers(registerDisplay,keyClicked);
                registerDisplay = stringToReturn;
        }
        return stringToReturn;
    }

    public void putInitialValueinCurrentDisplay(){
        registerDisplay = getString(R.string.initial_value_displayed);
    }

    public String concatenateTwoNumbers(String firstStr, String secStr){
        // No need to concatenates zeroes before numbers
        // Need to concatenate the zero with another value ONLY when the other value is a Dot
        if (firstStr.equals("0")){
            return secStr;
        } else {
            return firstStr + secStr;
        }
    }

    public String concatenateDot(String stringDisplayed) {
        String stringToReturn;
        if (stringDisplayed.contains(".")){
            stringToReturn = stringDisplayed;

        } else {
            stringToReturn = stringDisplayed + ".";
        }
        return stringToReturn;
    }

    static String removeFractionalPartFromDoubleIfNotNecessary(double valIn) {
        String valOut;
        valOut = Double.toString(valIn).replaceAll("\\.0*$", "");
        return valOut;
    }
}
