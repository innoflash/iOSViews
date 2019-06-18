package net.innoflash.iosview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ChipLineView extends LinearLayout {

    private ChipView chipView;
    private TextView textView;
    private String chipLineKey;
    private String chipLineValue;
    private int chipLineIcon;

    public ChipLineView(Context context) {
        super(context);
        init();
    }

    public ChipLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChipLineView);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setChipLineIcon(typedArray.getResourceId(R.styleable.ChipLineView_ios_chipline_icon, R.drawable.ic_arrow_forward_blue_18dp));
        setChipLineKey(typedArray.getString(R.styleable.ChipLineView_ios_chipline_key));
        setChipLineValue(typedArray.getString(R.styleable.ChipLineView_ios_chipline_value));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_chip_line, this);
        chipView = findViewById(R.id.chipView);
        textView = findViewById(R.id.chipValue);
    }

    public ChipView getChipView() {
        return chipView;
    }

    public TextView getTextView() {
        return textView;
    }

    public String getChipLineKey() {
        return chipLineKey;
    }

    public String getChipLineValue() {
        return chipLineValue;
    }

    public int getChipLineIcon() {
        return chipLineIcon;
    }

    public void setChipLineKey(String chipLineKey) {
        this.chipLineKey = chipLineKey;
        getChipView().setChipText(chipLineKey);
    }

    public void setChipLineValue(String chipLineValue) {
        this.chipLineValue = chipLineValue;
        getTextView().setText(chipLineValue);
    }

    public void setChipLineIcon(int chipLineIcon) {
        this.chipLineIcon = chipLineIcon;
        getChipView().setChipIcon(chipLineIcon);
    }
}
