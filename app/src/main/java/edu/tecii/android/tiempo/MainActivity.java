package edu.tecii.android.tiempo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.txtV)
    TextView txtV;
    @Bind(R.id.inputNum)
    EditText inputNum;
    @Bind(R.id.btnCal)
    Button btnCal;
    @Bind(R.id.txtResu)
    TextView txtResu;
    @Bind(R.id.txtResu1)
    TextView txtResu1;
    @Bind(R.id.txtResu2)
    TextView txtResu2;
    @Bind(R.id.txtResu3)
    TextView txtResu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtV.setVisibility(View.VISIBLE);
        txtV.setText("Ingresa un número decimal");
    }

    @OnClick(R.id.btnCal)
    public void handleClickSubmit() {
        hideKeyboard();
        String num = inputNum.getText().toString().trim();
        double num1 = Double.parseDouble(num);
        if (!num.isEmpty()) {
            int hora = (int)(num1);
            num1 = (num1 - hora)*60;
            int minu = (int)(num1);
            num1 = (num1 - minu)*60;
            int seg = (int)(num1);
            num1 = (num1 - seg)*60;
            int dseg = (int)(num1);

            String resu = "El total de Horas es: "+hora+ "\n";
            String resu1 = "El total de Minutos es: "+minu+"\n";
            String resu2 = "El total de Segundos es: "+seg+"\n";
            String resu3 = "El total de Décimos de segundos es: "+dseg+"\n";

            //String strTip = String.format(getString(R.string.global_message_tip), tip);
            txtResu.setVisibility(View.VISIBLE);
            txtResu.setText(resu);
            txtResu1.setVisibility(View.VISIBLE);
            txtResu1.setText(resu1);
            txtResu2.setVisibility(View.VISIBLE);
            txtResu2.setText(resu2);
            txtResu3.setVisibility(View.VISIBLE);
            txtResu3.setText(resu3);
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}

