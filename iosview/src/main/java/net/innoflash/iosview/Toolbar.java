package net.innoflash.iosview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Toolbar extends RelativeLayout implements View.OnClickListener {

    private RelativeLayout theParent;
    private Button backButton;
    private TextView toolbarTextView;
    private ImageButton optionsImageButton;
    private Activity activity;
    private OptionsClicked optionsClicked;
    private String pageTitle;
    private int icon;
    private int toolbarBackgroundColor;
    private int titleColor;
    private int backColor;
    private boolean hasOptions;
    private boolean noBackButton;

    public Toolbar(Context context) {
        super(context);
        init();
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Toolbar);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setPageTitle(typedArray.getString(R.styleable.Toolbar_toolbar_title));
        setIcon(typedArray.getResourceId(R.styleable.Toolbar_toolbar_icon, R.drawable.ic_more_vert_black_18dp));
        setHasOptions(typedArray.getBoolean(R.styleable.Toolbar_toolbar_has_options, true));
        setNoBackButton(typedArray.getBoolean(R.styleable.Toolbar_toolbar_no_back_button, false));
        setToolbarBackgroundColor(typedArray.getColor(R.styleable.Toolbar_toolbar_background, getResources().getColor(R.color.ios_toolbar_color)));
        setTitleColor(typedArray.getColor(R.styleable.Toolbar_toolbar_title_color, getResources().getColor(R.color.black)));
        setBackColor(typedArray.getColor(R.styleable.Toolbar_toolbar_back_color, getResources().getColor(R.color.ios_blue)));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.ios_toolbar, this);
        backButton = findViewById(R.id.nav_back);
        toolbarTextView = findViewById(R.id.page_title);
        optionsImageButton = findViewById(R.id.more_actions);
        theParent = findViewById(R.id.the_parent);

        backButton.setOnClickListener(this);
        optionsImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_back) {
            activity = (Activity) getContext();
            activity.finish();
        } else {
            if (optionsClicked != null)
                optionsClicked.optionsClicked(this);
        }
    }

    public Button getBackButton() {
        return backButton;
    }

    public TextView getToolbarTextView() {
        return toolbarTextView;
    }

    public ImageButton getOptionsImageButton() {
        return optionsImageButton;
    }

    public Activity getActivity() {
        return activity;
    }

    public OptionsClicked getOptionsClicked() {
        return optionsClicked;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public int getIcon() {
        return icon;
    }

    public boolean isHasOptions() {
        return hasOptions;
    }

    public boolean isNoBackButton() {
        return noBackButton;
    }

    public void setOptionsClicked(OptionsClicked optionsClicked) {
        this.optionsClicked = optionsClicked;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        toolbarTextView.setText(pageTitle);
    }

    public void setIcon(int icon) {
        this.icon = icon;
        optionsImageButton.setImageResource(icon);
    }

    public void setHasOptions(boolean hasOptions) {
        this.hasOptions = hasOptions;
        if (hasOptions) {
            optionsImageButton.setVisibility(VISIBLE);
        } else {
            optionsImageButton.setVisibility(GONE);
        }
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        toolbarTextView.setTextColor(titleColor);
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
        backButton.setTextColor(backColor);
    }

    public void setNoBackButton(boolean noBackButton) {
        this.noBackButton = noBackButton;
        if (noBackButton) {
            backButton.setVisibility(GONE);
        } else
            backButton.setVisibility(VISIBLE);
    }

    public int getToolbarBackgroundColor() {
        return toolbarBackgroundColor;
    }

    public void setToolbarBackgroundColor(int toolbarBackgroundColor) {
        this.toolbarBackgroundColor = toolbarBackgroundColor;
        theParent.setBackgroundColor(toolbarBackgroundColor);
        toolbarTextView.setBackgroundColor(toolbarBackgroundColor);
    }

    public interface OptionsClicked {
        void optionsClicked(View view);
    }
}
