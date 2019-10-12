package net.innoflash.iosview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public abstract class DialogFullScreen extends DialogFragment {

    private View parentView;
    private View view;
    private TextView closeDialog;
    private TextView dialogTitle;
    private LinearLayout dialogView;
    private String title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.full_dialog_interface, container);
        closeDialog = parentView.findViewById(R.id.ios_dialog_close);
        dialogTitle = parentView.findViewById(R.id.ios_dialog_title);
        dialogView = parentView.findViewById(R.id.ios_dialog_view);

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return parentView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        dialogTitle.setText(title);
    }

    public View getDialogView(int layoutFile, String dialogTitle) {
        view = getLayoutInflater().inflate(layoutFile, dialogView, false);
        setTitle(dialogTitle);
        return view;
    }

    public void setDialogView(View view, String title) {
        dialogView.addView(view);
        setTitle(title);
    }

}
