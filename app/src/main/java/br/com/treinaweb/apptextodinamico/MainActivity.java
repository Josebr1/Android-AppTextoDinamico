package br.com.treinaweb.apptextodinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        relativeLayout = new RelativeLayout(this);

        Button btn = new Button(this);
        btn.setId((int)System.currentTimeMillis());
        btn.setText("Texto dinamico");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.leftMargin = 150;
        params.topMargin = 50;
        btn.setLayoutParams(params);
        view = btn;

        relativeLayout.addView(btn);
        setContentView(relativeLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = new TextView(getApplicationContext());
                txt.setTextColor(getColor(R.color.colorPrimary));
                txt.setId((int)System.currentTimeMillis());
                txt.setText("Texto: " + System.currentTimeMillis());
                RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                textParams.addRule(RelativeLayout.BELOW, view.getId());
                view = txt;
                relativeLayout.addView(txt, textParams);
            }
        });
    }
}
