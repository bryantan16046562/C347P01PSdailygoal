package dailygoal.android.myapplicationdev.com.c347p01psdailygoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();

        String[] readd = i.getStringArrayExtra("read");
        TextView tv1 = (TextView) findViewById(R.id.textView1) ;
        tv1.setText(readd[0] + " : " + readd[1]);

        String[] arrivee = i.getStringArrayExtra("arrive");
        TextView tv2 = (TextView) findViewById(R.id.textView2) ;
        tv2.setText(arrivee[0] + " : " + arrivee[1]);

        String[] attemptt = i.getStringArrayExtra("attempt");
        TextView tv3 = (TextView) findViewById(R.id.textView3) ;
        tv3.setText(attemptt[0] + " : " + attemptt[1]);

        String[] reflection = i.getStringArrayExtra("reflection");
        TextView tv4 = (TextView) findViewById(R.id.textView4) ;
        tv4.setText("Reflection: " + reflection[1]);


        Button btn = (Button) findViewById(R.id.buttonback);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
