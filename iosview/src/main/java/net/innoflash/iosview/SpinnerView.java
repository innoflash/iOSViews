package net.innoflash.iosview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerView extends RelativeLayout {
    private ImageView imageView;
    private TextView textView;
    private Spinner spinner;
    private String heading;
    private String[] spinnerEntries;
    private int headingColor;
    private int image;
    private int selection;
    private int entries;

    public SpinnerView(Context context) {
        super(context);
        init();
    }

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        entries = attrs.getAttributeResourceValue(Constants.ANDROID_NAMESPACE, "entries", -1111);
        setEntries(entries);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpinnerView);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void setEntries(int entries) {
        if (entries == -1111)
            spinnerEntries = getResources().getStringArray(R.array.spinner_inputs);
        else
            spinnerEntries = getResources().getStringArray(entries);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerEntries);
        spinner.setAdapter(arrayAdapter);
    }


    private void readAttributes(TypedArray typedArray) {
        setImage(typedArray.getResourceId(R.styleable.SpinnerView_spinner_icon, R.drawable.ic_android_blue_24dp));
        setHeading(typedArray.getString(R.styleable.SpinnerView_spinner_heading));
        setHeadingColor(typedArray.getColor(R.styleable.SpinnerView_spinner_heading_color, getResources().getColor(R.color.ios_blue)));
        setSelection(typedArray.getInt(R.styleable.SpinnerView_spinner_selection, 0));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_spinner, this);
        imageView = findViewById(R.id.spinner_icon);
        textView = findViewById(R.id.spinner_heading);
        spinner = findViewById(R.id.spinner_spinner);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public String getHeading() {
        return heading;
    }

    public int getHeadingColor() {
        return headingColor;
    }

    public int getImage() {
        return image;
    }

    public void setHeading(String heading) {
        this.heading = heading;
        getTextView().setText(heading);
    }

    public void setHeadingColor(int headingColor) {
        this.headingColor = headingColor;
        getTextView().setTextColor(headingColor);
    }

    public void setImage(int image) {
        this.image = image;
        getImageView().setImageResource(image);
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public int getSelection() {
        return getSpinner().getSelectedItemPosition();
    }

    public void setSelection(int selection) {
        this.selection = selection;
        getSpinner().setSelection(selection);
    }
}
