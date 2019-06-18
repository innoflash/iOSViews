package net.innoflash.iosviews;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button toolbars;
    private Button chips;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbars = findViewById(R.id.toolbars);
        chips = findViewById(R.id.chips);

        setSupportActionBar(toolbar);
        toolbars.setOnClickListener(this);
        chips.setOnClickListener(this);
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
        }
        startActivity(intent);
    }
}
