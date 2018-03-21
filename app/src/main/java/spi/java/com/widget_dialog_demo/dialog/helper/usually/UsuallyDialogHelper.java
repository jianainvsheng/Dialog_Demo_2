package spi.java.com.widget_dialog_demo.dialog.helper.usually;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import spi.java.com.widget_dialog_demo.R;
import spi.java.com.widget_dialog_demo.dialog.builder.Normal.NormalBuilder;
import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;
import spi.java.com.widget_dialog_demo.test.ScreenUtils;
/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public class UsuallyDialogHelper extends BaseDialogHelper<NormalBuilder> implements View.OnClickListener{

    private LinearLayout mContainerLayout;
    private TextView mTitleTv;
    private TextView mContextTv;
    private TextView mNegativeTv;
    private TextView mPositiveTv;
    private View mSaperateLineView;
    private boolean autoDismiss;
    private GNormalDialog.PositiveCallBack positiveCallBack;
    private GNormalDialog.NegativeCallBack negativeCallBack;
    public UsuallyDialogHelper(Context context) {
        super(context);
    }

    @Override
    public View onCreateContextView(Context context) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);
        mContainerLayout = (LinearLayout) contentView.findViewById(R.id.ll_dialog_container);
        mTitleTv = (TextView) contentView.findViewById(R.id.tv_dialog_title);
        mContextTv = (TextView) contentView.findViewById(R.id.tv_dialog_content);
        mPositiveTv = (TextView) contentView.findViewById(R.id.tv_dialog_conform);
        mNegativeTv = (TextView) contentView.findViewById(R.id.tv_dialog_cancle);
        mSaperateLineView = contentView.findViewById(R.id.v_dialog_vertical_line);
        return contentView;
    }

    @Override
    public void setBuilder(NormalBuilder builder, Dialog dialog) {
        super.setBuilder(builder, dialog);
        // 普通视图，有标题栏或内容
        if (TextUtils.isEmpty(builder.getTitle())) {
            mTitleTv.setVisibility(View.GONE);
        } else {
            mTitleTv.setVisibility(View.VISIBLE);
            mTitleTv.setText(builder.getTitle());
            int titleColor = builder.getTitleColor();
            if (titleColor != 0) {
                mTitleTv.setTextColor(titleColor);
            }
        }
        if (TextUtils.isEmpty(builder.getContent())) {
            mContextTv.setVisibility(View.GONE);
        } else {
            mContextTv.setVisibility(View.VISIBLE);
            mContextTv.setText(builder.getContent());
            int contentColor = builder.getContentColor();
            if (contentColor != 0) {
                mContextTv.setTextColor(contentColor);
            }
        }

        if (TextUtils.isEmpty(builder.getNegativeName())) {
            mNegativeTv.setVisibility(View.GONE);
            mSaperateLineView.setVisibility(View.GONE);
            mPositiveTv.setBackgroundResource(R.drawable.selector_dialog_bottom);
        } else if (TextUtils.isEmpty(builder.getPositiveName())) {
            mPositiveTv.setVisibility(View.GONE);
            mSaperateLineView.setVisibility(View.GONE);
            mNegativeTv.setBackgroundResource(R.drawable.selector_dialog_bottom);
        }

        mPositiveTv.setText(builder.getPositiveName());
        int conformBtnColor = builder.getPositiveBtnColor();
        if (conformBtnColor != 0) {
            mPositiveTv.setTextColor(conformBtnColor);
        }
        mPositiveTv.setOnClickListener(this);
        mNegativeTv.setText(builder.getNegativeName());
        int cancleBtnColor = builder.getNegativeBtnColor();
        if (cancleBtnColor != 0) {
            mNegativeTv.setTextColor(cancleBtnColor);
        }
        mNegativeTv.setOnClickListener(this);

        this.positiveCallBack = builder.getPositiveCallBack();
        this.negativeCallBack = builder.getNegativeCallBack();
        this.autoDismiss = builder.isAutoDismiss();
        dialog.setCancelable(builder.isCancelable());
        dialog.setCanceledOnTouchOutside(builder.isCancelable());
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        int width = ScreenUtils.dp2PxInt(getContext(), 270);
        window.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(mPositiveTv)) {
            if (positiveCallBack != null) {
                positiveCallBack.onClick(view);
            }
            if (autoDismiss) {
                getDialog().dismiss();
            }
        } else if (view.equals(mNegativeTv)) {
            if (negativeCallBack != null) {
                negativeCallBack.onClick(view);
            }
            if (autoDismiss) {
                getDialog().dismiss();
            }
        }
    }
}
