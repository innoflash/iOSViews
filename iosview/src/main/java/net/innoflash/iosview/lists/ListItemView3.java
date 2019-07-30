package net.innoflash.iosview.lists;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import net.innoflash.iosview.extras.Constants;
import net.innoflash.iosview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListItemView3 extends LinearLayout {

    private ImageView imageView;
    private CircleImageView circleImageView;
    private TextView headingTextView;
    private TextView contentTextView;
    private TextView footerTextView;
    private TextView badgeTextView;
    private String itemHeading;
    private String itemContent;
    private String itemFooter;
    private String badge;
    private ItemType itemType;
    private int scaleType;
    private int icon;
    private int headerColor;
    private int contentColor;
    private boolean hasType;
    private boolean circularImage;

    public ListItemView3(Context context) {
        super(context);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public ListItemView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        scaleType = attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "scaleType", 0);
        //    attrs.getAttributeIntValue(Constants.ANDROID_NAMESPACE, "scaleType", ImageView.ScaleType.)
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ListItemView3);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void readAttributes(TypedArray typedArray) {
        setIcon(typedArray.getResourceId(R.styleable.ListItemView3_item_icon, R.drawable.square));
        setItemHeading(typedArray.getString(R.styleable.ListItemView3_item_heading));
        setItemContent(typedArray.getString(R.styleable.ListItemView3_item_content));
        setItemFooter(typedArray.getString(R.styleable.ListItemView3_item_footer));
        setHasType(typedArray.getBoolean(R.styleable.ListItemView3_item_has_type, false));
        imageView.setScaleType(ImageView.ScaleType.values()[scaleType]);
        setHeaderColor(typedArray.getColor(R.styleable.ListItemView3_item_heading_color, getResources().getColor(R.color.black)));
        setContentColor(typedArray.getColor(R.styleable.ListItemView3_item_content_color, getResources().getColor(R.color.black)));
        setBadge(typedArray.getString(R.styleable.ListItemView3_item_badge));
        setItemType(ItemType.values()[typedArray.getInt(R.styleable.ListItemView3_item_type, 0)]);
        setCircularImage(typedArray.getBoolean(R.styleable.ListItemView3_item_circular_image, true));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_list_item_3, this);
        imageView = findViewById(R.id.item_icon);
        circleImageView = findViewById(R.id.circular_image);
        headingTextView = findViewById(R.id.item_heading);
        contentTextView = findViewById(R.id.item_content);
        footerTextView = findViewById(R.id.item_footer);
        badgeTextView = findViewById(R.id.item_badge);
    }

    public ImageView getImageView() {
        if (circularImage)
            return getCircleImageView();
        return imageView;
    }

    public TextView getHeadingTextView() {
        return headingTextView;
    }

    public TextView getContentTextView() {
        return contentTextView;
    }

    public TextView getFooterTextView() {
        return footerTextView;
    }

    public TextView getBadgeTextView() {
        return badgeTextView;
    }

    public String getItemHeading() {
        return itemHeading;
    }

    public String getItemContent() {
        return itemContent;
    }

    public String getItemFooter() {
        return itemFooter;
    }

    public String getBadge() {
        return badge;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getScaleType() {
        return scaleType;
    }

    public int getIcon() {
        return icon;
    }

    public int getHeaderColor() {
        return headerColor;
    }

    public int getContentColor() {
        return contentColor;
    }

    public CircleImageView getCircleImageView() {
        return circleImageView;
    }

    public boolean isHasType() {
        return hasType;
    }

    public boolean isCircularImage() {
        return circularImage;
    }

    public void setItemHeading(String itemHeading) {
        this.itemHeading = itemHeading;
        getHeadingTextView().setText(itemHeading);
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
        getContentTextView().setText("| " + itemContent);
    }

    public void setItemFooter(String itemFooter) {
        this.itemFooter = itemFooter;
        getFooterTextView().setText(itemFooter);
    }

    public void setBadge(String badge) {
        this.badge = badge;
        if (badge != null)
            if (badge.length() < 4)
                getBadgeTextView().setText(badge);
            else
                getBadgeTextView().setText(badge.substring(0, 3));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
        switch (itemType) {
            case NONE:
                getBadgeTextView().setTextColor(getResources().getColor(R.color.black));
                getBadgeTextView().setBackgroundColor(0);
                getBadgeTextView().setText("view");
                break;
            case BLUE:
                getBadgeTextView().setTextColor(getResources().getColor(R.color.white));
                getBadgeTextView().setBackground(getResources().getDrawable(R.drawable.badge_blue_background));
                break;
            case GREEN:
                getBadgeTextView().setTextColor(getResources().getColor(R.color.white));
                getBadgeTextView().setBackground(getResources().getDrawable(R.drawable.badge_green_background));
                break;
            case ORANGE:
                getBadgeTextView().setTextColor(getResources().getColor(R.color.white));
                getBadgeTextView().setBackground(getResources().getDrawable(R.drawable.badge_orange_background));
                break;
            case RED:
                getBadgeTextView().setTextColor(getResources().getColor(R.color.white));
                getBadgeTextView().setBackground(getResources().getDrawable(R.drawable.badge_red_background));
                break;
        }
    }

    public void setScaleType(int scaleType) {
        this.scaleType = scaleType;

    }

    public void setIcon(int icon) {
        this.icon = icon;
        getCircleImageView().setImageResource(icon);
        imageView.setImageResource(icon);
    }

    public void setHeaderColor(int headerColor) {
        this.headerColor = headerColor;
        getHeadingTextView().setTextColor(headerColor);
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
        getContentTextView().setTextColor(contentColor);
    }

    public void setHasType(boolean hasType) {
        this.hasType = hasType;
        if (hasType)
            getBadgeTextView().setVisibility(VISIBLE);
        else
            getBadgeTextView().setVisibility(GONE);
    }

    public void setCircularImage(boolean circularImage) {
        this.circularImage = circularImage;
        if (circularImage) {
            getCircleImageView().setVisibility(VISIBLE);
            imageView.setVisibility(GONE);
        } else {
            getCircleImageView().setVisibility(GONE);
            imageView.setVisibility(VISIBLE);
        }
    }

    public enum ItemType {
        NONE,
        GREEN,
        BLUE,
        RED,
        ORANGE
    }
}
