package net.innoflash.iosview.lists;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.innoflash.iosview.Constants;
import net.innoflash.iosview.R;

public class ListItemView2 extends RelativeLayout {
    private ImageView imageView;
    private TextView headerTextView;
    private TextView contentTextView;
    private View line;
    private String header;
    private String content;
    private int image;
    private boolean hasLine;
    private boolean hasImage;
    private boolean circularImage;
    private int headerColor;
    private int contentColor;
    private int scaleType;

    public ListItemView2(Context context) {
        super(context);
        init();
    }

    public ListItemView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        scaleType = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "scaleType", 0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ListItemView2);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        imageView.setScaleType(ImageView.ScaleType.values()[scaleType]);
        setImage(typedArray.getResourceId(R.styleable.ListItemView2_liv2_icon, R.drawable.ic_android_blue_24dp));
        setHeader(typedArray.getString(R.styleable.ListItemView2_liv2_head_text));
        setContent(typedArray.getString(R.styleable.ListItemView2_liv2_content_text));
        setHasLine(typedArray.getBoolean(R.styleable.ListItemView2_liv2_has_line, true));
        setHasImage(typedArray.getBoolean(R.styleable.ListItemView2_liv2_has_image, true));
        setHeaderColor(typedArray.getColor(R.styleable.ListItemView2_liv2_header_color, getResources().getColor(R.color.black)));
        setContentColor(typedArray.getColor(R.styleable.ListItemView2_liv2_content_color, getResources().getColor(R.color.black)));
        setCircularImage(typedArray.getBoolean(R.styleable.ListItemView2_liv2_circular_image, false));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_list_item_2, this);
        headerTextView = findViewById(R.id.item_heading);
        contentTextView = findViewById(R.id.item_content);
        line = findViewById(R.id.line);
        imageView = findViewById(R.id.item_icon);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getHeaderTextView() {
        return headerTextView;
    }

    public TextView getContentTextView() {
        return contentTextView;
    }

    public View getLine() {
        return line;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public int getImage() {
        return image;
    }

    public boolean isHasLine() {
        return hasLine;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHeader(String header) {
        this.header = header;
        getHeaderTextView().setText(header);
    }

    public void setContent(String content) {
        this.content = content;
        getContentTextView().setText(content);
    }

    public void setImage(int image) {
        this.image = image;
        getImageView().setImageResource(image);
    }

    public void setHasLine(boolean hasLine) {
        this.hasLine = hasLine;
        if (hasLine)
            getLine().setVisibility(VISIBLE);
        else
            getLine().setVisibility(GONE);
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
        if (hasImage) {
            getImageView().setVisibility(VISIBLE);

        } else {
            getImageView().setVisibility(GONE);
        }
    }

    public int getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(int headerColor) {
        this.headerColor = headerColor;
        getHeaderTextView().setTextColor(headerColor);
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
        getContentTextView().setTextColor(contentColor);
    }

    public boolean isCircularImage() {
        return circularImage;
    }

    public void setCircularImage(boolean circularImage) {
        this.circularImage = circularImage;
    }
}
