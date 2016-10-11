package laurentesp.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SimpleCalcFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SimpleCalcFragmentCallBack parent;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SimpleCalcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleCalcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleCalcFragment newInstance(String param1, String param2) {
        SimpleCalcFragment fragment = new SimpleCalcFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        parent = (SimpleCalcFragmentCallBack) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_calc, container, false);
        return view;
    }
    

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = this.getView();
        declareButtons(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_Dot:
                parent.concatenatesDot();
                break;
            case R.id.button_Add:
                parent.addFunction();
                break;
            case R.id.button_Sub:
                parent.subFunction();
                break;
            case R.id.button_Mult:
                parent.multFunction();
                break;
            case R.id.button_Div:
                parent.divFunction();
                break;
            default :
                parent.concatenatesNumber(v.getTag().toString());
                break;
        }
    }

    public void declareButtons(View view){
        Button buttonO = (Button) view.findViewById(R.id.button_0);
        buttonO.setOnClickListener(this);
        Button button1 = (Button) view.findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        Button button3 = (Button) view.findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        Button button5 = (Button) view.findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        Button button6 = (Button) view.findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        Button button7 = (Button) view.findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        Button button8 = (Button) view.findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        Button button9 = (Button) view.findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        Button buttonAdd = (Button) view.findViewById(R.id.button_Add);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = (Button) view.findViewById(R.id.button_Sub);
        buttonSub.setOnClickListener(this);
        Button buttonMult = (Button) view.findViewById(R.id.button_Mult);
        buttonMult.setOnClickListener(this);
        Button buttonDiv = (Button) view.findViewById(R.id.button_Div);
        buttonDiv.setOnClickListener(this);
        Button buttonDot = (Button) view.findViewById(R.id.button_Dot);
        buttonDot.setOnClickListener(this);
    }
}
