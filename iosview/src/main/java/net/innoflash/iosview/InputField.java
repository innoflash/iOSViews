package net.innoflash.iosview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InputField extends RelativeLayout {
    private ImageView imageView;
    private TextView textView;
    private EditText editText;
    private String heading;
    private String value;
    private String hint;
    private boolean enabled;
    private int headingColor;
    private int image;
    private int type;

    public InputField(Context context) {
        super(context);
        init();
    }

    public InputField(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        type = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "inputType", android.text.InputType.TYPE_CLASS_TEXT);
        getEditText().setInputType(type);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputField);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setImage(typedArray.getResourceId(R.styleable.InputField_input_icon, R.drawable.ic_android_blue_24dp));
        setHeading(typedArray.getString(R.styleable.InputField_input_heading));
        setValue(typedArray.getString(R.styleable.InputField_input_value));
        setHint(typedArray.getString(R.styleable.InputField_input_hint));
        setHeadingColor(typedArray.getColor(R.styleable.InputField_input_heading_color, getResources().getColor(R.color.ios_blue)));
        setEnabled(typedArray.getBoolean(R.styleable.InputField_input_enabled, true));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_input, this);
        imageView = findViewById(R.id.input_icon);
        textView = findViewById(R.id.input_heading);
        editText = findViewById(R.id.input_field);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public EditText getEditText() {
        return editText;
    }

    public String getHeading() {
        return heading;
    }

    public String getValue() {
        return getEditText().getText().toString();
    }

    public String getHint() {
        return hint;
    }

    public int getHeadingColor() {
        return headingColor;
    }

    public int getImage() {
        return image;
    }

    public void setHeading(String heading) {
        this.heading = heading;
        if (heading == null) {
            getTextView().setVisibility(GONE);
        }
        getTextView().setText(heading);
    }

    public void setValue(String value) {
        this.value = value;
        getEditText().setText(value);
    }

    public void setHint(String hint) {
        this.hint = hint;
        getEditText().setHint(hint);
    }

    public void setHeadingColor(int headingColor) {
        this.headingColor = headingColor;
        getTextView().setTextColor(headingColor);
    }

    public void setImage(int image) {
        this.image = image;
        getImageView().setImageResource(image);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        getEditText().setEnabled(enabled);
    }
}
