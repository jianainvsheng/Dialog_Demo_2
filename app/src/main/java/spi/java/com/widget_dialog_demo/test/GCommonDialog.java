package spi.java.com.widget_dialog_demo.test;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import spi.java.com.widget_dialog_demo.R;


/**
 * @Description: 通用对话框
 * @Date:15/7/11 下午5:20
 * @author:liufei-ds3
 * @email:liufei-ds3@yolo24.com 未设置customView的情况下，
 * 显示普通的标题（可选，可设置内容和字体颜色），内容（可选，可设置内容和字体颜色)，
 * 取消按钮（可设置显示文字和字体颜色）， 确认按钮（可设置显示文字和字体颜色），
 * 取消按钮和确认按钮只设置其一的情况下，只显示一个按钮
 * <p/>
 * customView : 自定义的布局，外层嵌套了LinearLayout, 布局可以使用Merge标签来减少布局层次
 * <p/>
 * GCommonDialog dialog = new GCommonDialog.Builder()
 * .setCancelable(...)
 * .setTitle(...)
 * .setTitleColor(...)
 * .setContent(...)
 * .setContentColor(...)
 * .setNagtiveName(...)
 * .setNegativeBtnColor(...)
 * .setNegativeCallBack(...)
 * .setPositiveName(...)
 * .setPositiveBtnColor(...)
 * .setPositiveCallBack(...)
 * .setCustomView(...)
 * .build();
 * dialog.show();
 */
public class GCommonDialog extends Dialog implements View.OnClickListener {
    private LinearLayout mContainerLayout;
    private TextView mTitleTv;
    private TextView mContextTv;
    private TextView mNegativeTv;
    private TextView mPositiveTv;
    private View mSaperateLineView;
    private boolean autoDismiss;

    private Builder builder;

    private PositiveCallBack positiveCallBack;
    private NegativeCallBack negativeCallBack;

    public GCommonDialog(Context context, Builder builder) {
        super(context, R.style.dialog_style);
        this.builder = builder;
        initView(context);
    }

    private void initView(Context context) {
        View contentView = getLayoutInflater().inflate(R.layout.dialog_custom, null);
        mContainerLayout = (LinearLayout) contentView.findViewById(R.id.ll_dialog_container);
        mTitleTv = (TextView) contentView.findViewById(R.id.tv_dialog_title);
        mContextTv = (TextView) contentView.findViewById(R.id.tv_dialog_content);
        mPositiveTv = (TextView) contentView.findViewById(R.id.tv_dialog_conform);
        mNegativeTv = (TextView) contentView.findViewById(R.id.tv_dialog_cancle);
        mSaperateLineView = contentView.findViewById(R.id.v_dialog_vertical_line);

        View mCustomView = builder.getCustomView();
        if (mCustomView != null) {
            // 自定义Container的情形
            mContainerLayout.removeAllViews();
            mContainerLayout.addView(mCustomView);
        } else {
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

        setContentView(contentView);

        setCancelable(builder.isCancelable());
        setCanceledOnTouchOutside(builder.isCancelable());
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        int width = ScreenUtils.dp2PxInt(context, 270);
        window.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(mPositiveTv)) {
            if (positiveCallBack != null) {
                positiveCallBack.onClick(view);
            }
            if (autoDismiss) {
                dismiss();
            }
        } else if (view.equals(mNegativeTv)) {
            if (negativeCallBack != null) {
                negativeCallBack.onClick(view);
            }
            if (autoDismiss) {
                dismiss();
            }
        }
    }

    @Override
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Builder {
        private Context context;
        private String title;            // 标题文字
        private String content;          // 正文文字
        private String positiveName;     // 确认按钮文字
        private String negativeName;      // 取消按钮文字
        private boolean cancelable;      // 是否可取消

        private int titleColor;          // 标题文字颜色
        private int contentColor;        // 正文文字颜色
        private int positiveBtnColor;    // 确认按钮文字颜色
        private int negativeBtnColor;    // 取消按钮文字

        private View customView;         // 自定义视图

        private PositiveCallBack positiveCallBack;
        private NegativeCallBack negativeCallBack;

        private boolean autoDismiss = true;

        public GCommonDialog build() {
            return new GCommonDialog(context, this);
        }

        public Context getContext() {
            return context;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public String getTitle() {
            return title;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(int titleRes) {
            this.title = context.getResources().getString(titleRes);
            return this;
        }

        public String getContent() {
            return content;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setContent(int contentRes) {
            this.content = context.getResources().getString(contentRes);
            return this;
        }

        public String getPositiveName() {
            return positiveName;
        }

        public Builder setPositiveName(String positiveName) {
            this.positiveName = positiveName;
            return this;
        }

        public Builder setPositiveName(int positiveNameRes) {
            this.positiveName = context.getResources().getString(positiveNameRes);
            return this;
        }

        public String getNegativeName() {
            return negativeName;
        }

        public Builder setNegativeName(String negativeName) {
            this.negativeName = negativeName;
            return this;
        }

        public Builder setNegativeName(int negativeNameRes) {
            this.negativeName = context.getResources().getString(negativeNameRes);
            return this;
        }

        public int getTitleColor() {
            return titleColor;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public int getContentColor() {
            return contentColor;
        }

        public Builder setContentColor(int contentColor) {
            this.contentColor = contentColor;
            return this;
        }

        public int getPositiveBtnColor() {
            return positiveBtnColor;
        }

        public Builder setPositiveBtnColor(int positiveBtnColor) {
            this.positiveBtnColor = positiveBtnColor;
            return this;
        }

        public int getNegativeBtnColor() {
            return negativeBtnColor;
        }

        public Builder setNegativeBtnColor(int negativeBtnColor) {
            this.negativeBtnColor = negativeBtnColor;
            return this;
        }

        public View getCustomView() {
            return customView;
        }

        public Builder setCustomView(View customView) {
            this.customView = customView;
            return this;
        }

        public boolean isCancelable() {
            return cancelable;
        }

        public Builder setCancelable(boolean canclable) {
            this.cancelable = canclable;
            return this;
        }

        public boolean isAutoDismiss() {
            return autoDismiss;
        }

        public Builder setAutoDismiss(boolean autoDismiss) {
            this.autoDismiss = autoDismiss;
            return this;
        }

        public PositiveCallBack getPositiveCallBack() {
            return positiveCallBack;
        }

        public Builder setPositiveCallBack(PositiveCallBack positiveCallBack) {
            this.positiveCallBack = positiveCallBack;
            return this;
        }

        public NegativeCallBack getNegativeCallBack() {
            return negativeCallBack;
        }

        public Builder setNegativeCallBack(NegativeCallBack negativeCallBack) {
            this.negativeCallBack = negativeCallBack;
            return this;
        }
    }

    public interface PositiveCallBack {
        void onClick(View v);
    }

    public interface NegativeCallBack {
        void onClick(View v);
    }
}
