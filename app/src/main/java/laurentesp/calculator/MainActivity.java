package laurentesp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_view_0);
        textView.setText(Calculator.getLastOperand());
    }

    public void clickMeth(View view){
        final TextView textView = (TextView) findViewById(R.id.text_view_0);
        String butClicked = view.getTag().toString();
        textView.setText(Calculator.getValOutToShowtoUser(butClicked, textView.getText().toString()));
        //Todo : Put the switch case in the activity because the buttons tags are UX.
        // We have to call some methods of Calculator in each case
        // Todo : concatenation affichage : 2 tests : si textView == 0  et verifDot
        // Todo : getText de textView en méthode (découpage du code)
    }


}
