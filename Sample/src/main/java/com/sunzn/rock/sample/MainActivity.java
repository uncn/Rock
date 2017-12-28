package com.sunzn.rock.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunzn.rock.library.RackVew;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RackVew mRackVew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRackVew = findViewById(R.id.rv);

        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                mRackVew.start();
                break;
            case R.id.stop:
                mRackVew.stop();
                break;
        }
    }

}
