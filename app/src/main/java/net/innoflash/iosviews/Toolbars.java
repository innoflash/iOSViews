package net.innoflash.iosviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.innoflash.iosview.Toolbar;

public class Toolbars extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbars);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setOptionsClicked(new Toolbar.OptionsClicked() {
            @Override
            public void optionsClicked(View view) {
                Toast.makeText(getApplicationContext(), "You clicked the options on the toolbar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
