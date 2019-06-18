package net.innoflash.iosview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ChipView extends LinearLayout {
    private ImageButton chipIconView;
    private TextView chipTextView;
    private String chipText;
    private int chipIcon;

    public ChipView(Context context) {
        super(context);
        init();
    }

    public ChipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChipView);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setChipText(typedArray.getString(R.styleable.ChipView_ios_chip_text));
        setChipIcon(typedArray.getResourceId(R.styleable.ChipView_ios_chip_icon, R.drawable.ic_arrow_forward_blue_18dp));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_chip_view, this);
        chipIconView = findViewById(R.id.chipIcon);
        chipTextView = findViewById(R.id.chipText);
    }

    public String getChipText() {
        return chipText;
    }

    public void setChipText(String chipText) {
        this.chipText = chipText;
        chipTextView.setText(chipText);
    }

    public int getChipIcon() {
        return chipIcon;
    }

    public void setChipIcon(int chipIcon) {
        this.chipIcon = chipIcon;
        chipIconView.setImageResource(chipIcon);
    }
}
