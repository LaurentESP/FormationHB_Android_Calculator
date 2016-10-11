package laurentesp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SimpleCalcFragmentCallBack, View.OnClickListener {

    private Calculator calculator;
    private static String registerDisplay = "";
    private static boolean operationPending;

    public MainActivity() {
        this.calculator = new Calculator();
    }
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUiMain();
    }

    @Override
    public String concatenatesNumber(String stringIn){
        if ((registerDisplay.equals("0")) || (registerDisplay.isEmpty())){
            registerDisplay = stringIn;
        } else {
            registerDisplay += stringIn;
        }
        textView.setText(registerDisplay);
        return registerDisplay;
    }

    @Override
    public String concatenatesDot() {
        // In this case we use the textView value because we never display null value
        // So if no entry from the user and he clicks on a Dot, the value displayed will be "0."
        String textViewVal = textView.getText().toString();
        if (!(textViewVal.contains("."))){
            registerDisplay = textViewVal + ".";
        }
        textView.setText(registerDisplay);
        return registerDisplay;
    }

    @Override
    public String addFunction() {
        String valSum = removeFractionalPartFromDoubleIfNotNecessary(calculator.addCalc(Double.valueOf(registerDisplay)));
        registerDisplay = "";
        textView.setText(valSum);
        return valSum;
    }

    @Override
    public void onClick(View v) {
        String textViewVal = textView.getText().toString();
        String calcStringVal;
        switch (v.getId()){
            case R.id.button_C:
                clearDisplay();
                break;

            case R.id.button_Eq:
                calcStringVal = removeFractionalPartFromDoubleIfNotNecessary(calculator.eqCalc(Double.valueOf(textViewVal)));
                textView.setText(calcStringVal);
                break;
            default:

        }
    }

    public void clearDisplay() {
        registerDisplay = "";
        calculator.clearCalc();
        textView.setText("0");
    }

    private static String removeFractionalPartFromDoubleIfNotNecessary(double valIn) {
        String valOut;
        valOut = Double.toString(valIn).replaceAll("\\.0*$", "");
        return valOut;
    }

    private void initUiMain() {
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view_0);

        initTextViewDisplay();
        initButtonsMain();
    }

    private void initTextViewDisplay() {
        if (registerDisplay.isEmpty()){
            textView.setText("0");
        } else {
            textView.setText(registerDisplay);
        }
    }

    private void initButtonsMain() {
        Button buttonC = (Button) findViewById(R.id.button_C);
        buttonC.setOnClickListener(this);
        Button buttonEq = (Button) findViewById(R.id.button_Eq);
        buttonEq.setOnClickListener(this);
    }


    /*

    public void click(View view){
        final TextView textView = (TextView) findViewById(R.id.text_view_0);
        //String butClicked = view.getTag().toString();
        String butClicked = onButtonClicked(view);
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
    }*/
}
