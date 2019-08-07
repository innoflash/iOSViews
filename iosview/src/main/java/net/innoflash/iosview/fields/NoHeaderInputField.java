package net.innoflash.iosview.fields;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import net.innoflash.iosview.R;
import net.innoflash.iosview.utils.Constants;

public class NoHeaderInputField extends LinearLayout {

    private ImageView imageView;
    private EditText editText;
    private String hint;
    private String value;
    private int icon;
    private int scaleType;
    private int type;
    private boolean activated;

    public NoHeaderInputField(Context context) {
        super(context);
        init();
    }

    public NoHeaderInputField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        scaleType = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "scaleType", 0);
        type = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "inputType", android.text.InputType.TYPE_CLASS_TEXT);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NoHeaderInputField);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        imageView.setScaleType(ImageView.ScaleType.values()[scaleType]);
        getEditText().setInputType(type);
        setHint(typedArray.getString(R.styleable.NoHeaderInputField_field_hint));
        setValue(typedArray.getString(R.styleable.NoHeaderInputField_field_value));
        setIcon(typedArray.getResourceId(R.styleable.NoHeaderInputField_field_icon, R.drawable.ic_android_blue_24dp));
        setActivated(typedArray.getBoolean(R.styleable.NoHeaderInputField_field_activated, true));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_auth_input, this);
        imageView = findViewById(R.id.auth_icon);
        editText = findViewById(R.id.auth_input);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public EditText getEditText() {
        return editText;
    }

    public String getHint() {
        return hint;
    }

    public String getValue() {
        return getEditText().getText().toString();
    }

    public int getIcon() {
        return icon;
    }

    public int getScaleType() {
        return scaleType;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean isActivated() {
        return activated;
    }

    public void setHint(String hint) {
        this.hint = hint;
        getEditText().setHint(hint);
    }

    public void setValue(String value) {
        this.value = value;
        getEditText().setText(value);
    }

    public void setIcon(int icon) {
        this.icon = icon;
        getImageView().setImageResource(icon);
    }

    @Override
    public void setActivated(boolean activated) {
        this.activated = activated;
        getEditText().setActivated(activated);
    }
}
