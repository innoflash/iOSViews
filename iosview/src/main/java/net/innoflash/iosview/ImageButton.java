package net.innoflash.iosview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ImageButton extends RelativeLayout {
    private ImageView imageView;
    private TextView textView;
    private String text;
    private int image;

    public ImageButton(Context context) {
        super(context);
        init();
    }

    public ImageButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageButton);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setText(typedArray.getString(R.styleable.ImageButton_image_button_text));
        setImage(typedArray.getResourceId(R.styleable.ImageButton_image_button_image, R.drawable.ic_android_blue_24dp));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_image_button, this);
        imageView = findViewById(R.id.ios_image_button_image);
        textView = findViewById(R.id.ios_image_button_text);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public void setText(String text) {
        this.text = text;
        getTextView().setText(text);
    }

    public void setImage(int image) {
        this.image = image;
        getImageView().setImageResource(image);
    }
}
