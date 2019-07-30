package net.innoflash.iosview.lists;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.innoflash.iosview.extras.Constants;
import net.innoflash.iosview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListItemView extends LinearLayout {

    private ImageView imageView;
    private CircleImageView circleImageView;
    private TextView textView;
    private ImageView closeIconView;
    private View line;
    private String text;
    private int image;
    private int closeIcon;
    private int textColor;
    private boolean hasLine;
    private boolean hasImage;
    private boolean circularImage;
    private int scaleType;

    public ListItemView(Context context) {
        super(context);
        init();
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        scaleType = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "scaleType", 0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ListItemView);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        imageView.setScaleType(ImageView.ScaleType.values()[scaleType]);
        setText(typedArray.getString(R.styleable.ListItemView_liv_text));
        setImage(typedArray.getResourceId(R.styleable.ListItemView_liv_icon, R.drawable.square));
        setHasLine(typedArray.getBoolean(R.styleable.ListItemView_liv_has_line, true));
        setCloseIcon(typedArray.getResourceId(R.styleable.ListItemView_liv_arrow, R.drawable.ic_chevron_right_black_18dp));
        setCircularImage(typedArray.getBoolean(R.styleable.ListItemView_liv_circular_image, true));
        setTextColor(typedArray.getColor(R.styleable.ListItemView_liv_text_color, getResources().getColor(R.color.black)));
        setHasImage(typedArray.getBoolean(R.styleable.ListItemView_liv_has_image, true));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_list_item_1, this);
        imageView = findViewById(R.id.image_view);
        circleImageView = findViewById(R.id.circular_image);
        textView = findViewById(R.id.item_text);
        line = findViewById(R.id.line);
        closeIconView = findViewById(R.id.close_button);
    }

    public ImageView getImageView() {
        if (circularImage)
            return getCircleImageView();
        return imageView;
    }

    public CircleImageView getCircleImageView() {
        return circleImageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public ImageView getCloseIconView() {
        return closeIconView;
    }

    public View getLine() {
        return line;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public int getCloseIcon() {
        return closeIcon;
    }

    public boolean isHasLine() {
        return hasLine;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public boolean isCircularImage() {
        return circularImage;
    }

    public void setText(String text) {
        this.text = text;
        getTextView().setText(text);
    }

    public void setImage(int image) {
        this.image = image;
        getCircleImageView().setImageResource(image);
        getImageView().setImageResource(image);
    }

    public void setCloseIcon(int closeIcon) {
        this.closeIcon = closeIcon;
        getCloseIconView().setImageResource(closeIcon);
    }

    public void setHasLine(boolean hasLine) {
        this.hasLine = hasLine;
        if (hasLine)
            line.setVisibility(VISIBLE);
        else
            line.setVisibility(GONE);
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
        if (hasImage) {
            if (isCircularImage())
                getCircleImageView().setVisibility(VISIBLE);
            else
                imageView.setVisibility(VISIBLE);
            textView.setPadding(0, 0, 0, 0);
        } else {
            imageView.setVisibility(GONE);
            getCircleImageView().setVisibility(GONE);
            textView.setPadding(10, 0, 0, 0);
        }
    }

    public void setCircularImage(boolean circularImage) {
        this.circularImage = circularImage;
        if (circularImage) {
            getCircleImageView().setVisibility(VISIBLE);
            getImageView().setVisibility(GONE);
        } else {
            getImageView().setVisibility(VISIBLE);
            getCircleImageView().setVisibility(GONE);
        }
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        getTextView().setTextColor(textColor);
    }
}
