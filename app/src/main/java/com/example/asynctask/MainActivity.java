package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btn1,btn2;
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txt=findViewById(R.id.txtView);
         AsyncClass asyncClass=new AsyncClass();
        btn1=findViewById(R.id.btnStart);
        btn2=findViewById(R.id.btnStop);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        asyncClass.doInBackground();
        asyncClass.onProgressUpdate();

    }
});

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setSelected(false);
                asyncClass.onPostExecute("AsyncTask Completed");
            }
        });
    }

    private class AsyncClass extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(getApplicationContext(),"Banner is Moving",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            txt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            txt.setSelected(true);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
}