package spi.java.com.widget_dialog_demo.test;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import spi.java.com.widget_dialog_demo.R;

/**
 * 填写订单声明对话框
 *
 * @author zhaolei-ds1
 */
public class OrderfillDeclareDialog extends Dialog {

    private TextView mMessage;
    private Button mPositiveButton;
    private String mContent, mButtonName;
    private Context mContext;
    private int mButtoncolor;
    public OrderfillDeclareDialog(Activity context,
                                  String content,
                                  String buttonName,
                                  int buttonColor) {
        super(context, R.style.dialog_style);
        this.mContext = context;
        this.mContent = content;
        this.mButtonName = buttonName;
        this.mButtoncolor = buttonColor;
        initView();
    }

    public OrderfillDeclareDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    private void initView() {
        View view = getLayoutInflater().inflate(R.layout.orderfill_declare_layout, null);
        view.setBackgroundResource(R.drawable.orderfill_declare_bg);
        setContentView(view);
        mMessage = (TextView) view.findViewById(R.id.message);
        mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        mPositiveButton = (Button) view.findViewById(R.id.positiveButton);
        mMessage.setText(mContent);
        mPositiveButton.setText(mButtonName);
        /*try {
            if (mButtoncolor > 0){
                mPositiveButton.setTextColor(mButtoncolor);
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            mPositiveButton.setTextColor(ContextCompat.getColor(mContext, R.color.color_333333));
        }*/

        mPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        final View tempView = view;
        ViewTreeObserver
                vto = tempView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tempView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int height = tempView.getMeasuredHeight();
                setDialogMaxHeight(height);
            }
        });

        Window window = this.getWindow();
        if (null != window) {
            window.setGravity(Gravity.CENTER);
        }
    }

    private void setDialogMaxHeight(int expectHeight) {
        Dialog dialog = this;
        double maxHeight = ScreenUtils.getDisplayHeight(getContext()) * 0.6;
        int setHeight = maxHeight > expectHeight ? expectHeight : (int) maxHeight;
        if (null != dialog.getWindow()) {
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.width = (int) (ScreenUtils.getDisplayWidth(mContext) * 0.85);
            lp.height = setHeight;
            dialog.getWindow().setAttributes(lp);
        }
    }

}
