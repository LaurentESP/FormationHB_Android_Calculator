package laurentesp.calculator;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SimpleCalcFragmentCallBack, View.OnClickListener, ScientFragmentCallBack {

    private Calculator calculator;
    private static String registerDisplay = "";
    private static boolean operationPending;
    private static boolean newValEntered = false;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    public MainActivity() {
        this.calculator = new Calculator();
    }
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUiMain();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    @Override
    public String concatenatesNumber(String stringIn){
        if ((registerDisplay.equals("0")) || (registerDisplay.isEmpty())){
            registerDisplay = stringIn;
        } else {
            registerDisplay += stringIn;
        }
        textView.setText(registerDisplay);
        newValEntered = true;
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
        newValEntered = true;
        return registerDisplay;
    }

    @Override
    public String setOperation(String myString){
        String textViewVal = textView.getText().toString();
        Double operationResult = calculator.prepareOperationOrOperates(registerDisplay, newValEntered, myString);
        String valOp = removeFractionalPartFromDoubleIfNotNecessary(operationResult);
        textView.setText(valOp);
        registerDisplay = "";
        newValEntered = false;
        return valOp;
    }

    @Override
    public void onClick(View v) {
        String textViewVal = textView.getText().toString();
        View view = findViewById(R.id.activity_main);
        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(getBaseContext(),R.drawable.button_shape);
        Button button0 = (Button) findViewById(R.id.button_0);
        Button button1 = (Button) findViewById(R.id.button_1);

        String calcStringVal;
        switch (v.getId()){
            case R.id.button_C:
                clearDisplay();
                break;

            case R.id.button_Eq:
                calcStringVal = removeFractionalPartFromDoubleIfNotNecessary(calculator.eqCalc(Double.valueOf(textViewVal)));
                registerDisplay = "";
                newValEntered = false;
                textView.setText(calcStringVal);
                break;

            case R.id.button_theme_1:
                int colorCyan = ContextCompat.getColor(getBaseContext(),R.color.cyan);
                int colorMagenta2 = ContextCompat.getColor(getBaseContext(),R.color.magenta);
                view.setBackgroundColor(colorCyan);
                button0.setBackground(drawable);
                drawable.setShape(GradientDrawable.OVAL);
                break;

            case R.id.button_theme_2:
                int colorMagenta = ContextCompat.getColor(getBaseContext(),R.color.magenta);
                view.setBackgroundColor(colorMagenta);
                button0.setBackground(button1.getBackground());
                drawable.setShape(GradientDrawable.RECTANGLE);
                break;

            case R.id.button_theme_3:
                int colorYellow = ContextCompat.getColor(getBaseContext(),R.color.yellow);
                view.setBackgroundColor(colorYellow);
                drawable.setShape(GradientDrawable.LINE);
                break;

            case R.id.button_theme_4:
                int colorGreen = ContextCompat.getColor(getBaseContext(),R.color.green);
                view.setBackgroundColor(colorGreen);
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
        Button buttonT1 = (Button) findViewById(R.id.button_theme_1);
        buttonT1.setOnClickListener(this);
        Button buttonT2 = (Button) findViewById(R.id.button_theme_2);
        buttonT2.setOnClickListener(this);
        Button buttonT3 = (Button) findViewById(R.id.button_theme_3);
        buttonT3.setOnClickListener(this);
        Button buttonT4 = (Button) findViewById(R.id.button_theme_4);
        buttonT4.setOnClickListener(this);
    }

}
