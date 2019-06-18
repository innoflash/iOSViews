package net.innoflash.iosview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class DialogToolbar extends RelativeLayout implements View.OnClickListener {
    private TextView titleTextView;
    private TextView closeDialogView;
    private String title;
    private DialogFragment dialogFragment;

    public DialogToolbar(Context context) {
        super(context);
        init();
    }

    public DialogToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DialogToolbar);
        readAttributes(typedArray);
        typedArray.recycle();
    }

    private void readAttributes(TypedArray typedArray) {
        setTitle(typedArray.getString(R.styleable.DialogToolbar_ios_dialog_title));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.dialog_toolbar, this);
        titleTextView = findViewById(R.id.ios_dialog_title);
        closeDialogView = findViewById(R.id.ios_dialog_close);
        closeDialogView.setOnClickListener(this);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getCloseDialogView() {
        return closeDialogView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        getTitleTextView().setText(title);
    }

    public DialogFragment getDialogFragment() {
        return dialogFragment;
    }

    public void setDialogFragment(DialogFragment dialogFragment) {
        this.dialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        if (getDialogFragment() != null) {
            getDialogFragment().dismiss();
            return;
        } else {
            ((Activity) getContext()).finish();
        }

    }
}
