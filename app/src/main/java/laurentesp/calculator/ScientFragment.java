package laurentesp.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ScientFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ScientFragmentCallBack parent;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ScientFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScientFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScientFragment newInstance(String param1, String param2) {
        ScientFragment fragment = new ScientFragment();
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
        parent = (ScientFragmentCallBack) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_scient, container, false);
        declareButtons(fragView);
        return fragView;
    }

    @Override
    public void onClick(View v) {
        parent.setOperation(v.getTag().toString());
    }

    public void declareButtons(View view){
        Button buttonSin = (Button) view.findViewById(R.id.button_Sin);
        buttonSin.setOnClickListener(this);
        Button buttonCos = (Button) view.findViewById(R.id.button_Cos);
        buttonCos.setOnClickListener(this);
        Button buttonTan = (Button) view.findViewById(R.id.button_Tan);
        buttonTan.setOnClickListener(this);
        Button buttonAcos = (Button) view.findViewById(R.id.button_acos);
        buttonAcos.setOnClickListener(this);
        Button buttonAsin = (Button) view.findViewById(R.id.button_asin);
        buttonAsin.setOnClickListener(this);
        Button buttonAtan = (Button) view.findViewById(R.id.button_atan);
        buttonAtan.setOnClickListener(this);
        Button buttonLog = (Button) view.findViewById(R.id.button_log);
        buttonLog.setOnClickListener(this);
        Button buttonLn = (Button) view.findViewById(R.id.button_ln);
        buttonLn.setOnClickListener(this);
        Button buttonP2 = (Button) view.findViewById(R.id.button_Sq);
        buttonP2.setOnClickListener(this);
        Button buttonP3 = (Button) view.findViewById(R.id.button_pow_3);
        buttonP3.setOnClickListener(this);
        Button buttonPX = (Button) view.findViewById(R.id.button_x_pow_y);
        buttonPX.setOnClickListener(this);
        Button buttonInv = (Button) view.findViewById(R.id.button_inv_x);
        buttonInv.setOnClickListener(this);
        Button buttonPM = (Button) view.findViewById(R.id.button_pm);
        buttonPM.setOnClickListener(this);
        Button buttonTenPow = (Button) view.findViewById(R.id.button_pow_10);
        buttonTenPow.setOnClickListener(this);
        Button buttonSrqt = (Button) view.findViewById(R.id.button_sqrt);
        buttonSrqt.setOnClickListener(this);
        Button buttonExp = (Button) view.findViewById(R.id.button_exp);
        buttonExp.setOnClickListener(this);
    }


}
