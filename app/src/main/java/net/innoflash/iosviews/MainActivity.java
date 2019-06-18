package net.innoflash.iosviews;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button toolbars;
    private Button chips;
    private Button inputs;
    private Button spinners;
    private Button liv1;
    private Button liv2;
    private Button liv3;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbars = findViewById(R.id.toolbars);
        chips = findViewById(R.id.chips);
        inputs = findViewById(R.id.input);
        spinners = findViewById(R.id.spinners);
        liv1 = findViewById(R.id.liv1);
        liv3 = findViewById(R.id.liv3);

        setSupportActionBar(toolbar);
        toolbars.setOnClickListener(this);
        chips.setOnClickListener(this);
        inputs.setOnClickListener(this);
        spinners.setOnClickListener(this);
        liv1.setOnClickListener(this);
        liv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbars:
                intent = new Intent(this, Toolbars.class);
                break;
            case R.id.chips:
                intent = new Intent(this, ChipTags.class);
                break;
            case R.id.input:
                intent = new Intent(this, Inputs.class);
                break;
            case R.id.spinners:
                intent = new Intent(this, Spinners.class);
                break;
            case R.id.liv1:
                intent = new Intent(this, LIV1.class);
                break;
            case R.id.liv3:
                intent = new Intent(this, LIV3.class);
                break;
        }
        startActivity(intent);
    }
}
