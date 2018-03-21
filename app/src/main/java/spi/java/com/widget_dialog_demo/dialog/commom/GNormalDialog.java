package spi.java.com.widget_dialog_demo.dialog.commom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.builder.IDialogBuilder;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;
import spi.java.com.widget_dialog_demo.dialog.helper.usually.UsuallyDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public class GNormalDialog<H extends BaseDialogHelper<GNormalDialog.Builder>> extends BaseDialog<GNormalDialog.Builder, H> {

    public GNormalDialog(@NonNull Context context, Builder data) {
        super(context, data);
    }

    public GNormalDialog(@NonNull Context context, @StyleRes int themeResId, Builder data) {
        super(context, themeResId, data);
    }

    @Override
    public BaseDialogHelper<Builder> onCreateDefaultHelp(Context context, Builder data) {
        return new UsuallyDialogHelper(context);
    }

    public static class Builder<H extends BaseDialogHelper<GNormalDialog.Builder>> implements IDialogBuilder<Builder, H> {
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

        private @StyleRes int mThemeStyleId;

        private Class<H> mHelperClass;

        private GNormalDialog<H> mDialog;

        private GNormalDialog.PositiveCallBack positiveCallBack;
        private GNormalDialog.NegativeCallBack negativeCallBack;


        private boolean autoDismiss = true;

        public Context getContext() {
            return context;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public String getTitle() {
            return title;
        }

        public GNormalDialog.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public GNormalDialog.Builder setTitle(int titleRes) {
            this.title = context.getResources().getString(titleRes);
            return this;
        }

        public String getContent() {
            return content;
        }

        public GNormalDialog.Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public GNormalDialog.Builder setContent(int contentRes) {
            this.content = context.getResources().getString(contentRes);
            return this;
        }

        public String getPositiveName() {
            return positiveName;
        }

        public GNormalDialog.Builder setPositiveName(String positiveName) {
            this.positiveName = positiveName;
            return this;
        }

        public GNormalDialog.Builder setPositiveName(int positiveNameRes) {
            this.positiveName = context.getResources().getString(positiveNameRes);
            return this;
        }

        public String getNegativeName() {
            return negativeName;
        }

        public GNormalDialog.Builder setNegativeName(String negativeName) {
            this.negativeName = negativeName;
            return this;
        }

        public GNormalDialog.Builder setNegativeName(int negativeNameRes) {
            this.negativeName = context.getResources().getString(negativeNameRes);
            return this;
        }

        public int getTitleColor() {
            return titleColor;
        }

        public GNormalDialog.Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public int getContentColor() {
            return contentColor;
        }

        public GNormalDialog.Builder setContentColor(int contentColor) {
            this.contentColor = contentColor;
            return this;
        }

        public int getPositiveBtnColor() {
            return positiveBtnColor;
        }

        public GNormalDialog.Builder setPositiveBtnColor(int positiveBtnColor) {
            this.positiveBtnColor = positiveBtnColor;
            return this;
        }

        public int getNegativeBtnColor() {
            return negativeBtnColor;
        }

        public GNormalDialog.Builder setNegativeBtnColor(int negativeBtnColor) {
            this.negativeBtnColor = negativeBtnColor;
            return this;
        }

        public View getCustomView() {
            return customView;
        }

        public GNormalDialog.Builder setCustomView(View customView) {
            this.customView = customView;
            return this;
        }

        public boolean isCancelable() {
            return cancelable;
        }

        public GNormalDialog.Builder setCancelable(boolean canclable) {
            this.cancelable = canclable;
            return this;
        }

        public boolean isAutoDismiss() {
            return autoDismiss;
        }

        public GNormalDialog.Builder setAutoDismiss(boolean autoDismiss) {
            this.autoDismiss = autoDismiss;
            return this;
        }

        public GNormalDialog.PositiveCallBack getPositiveCallBack() {
            return positiveCallBack;
        }

        public GNormalDialog.Builder setPositiveCallBack(GNormalDialog.PositiveCallBack positiveCallBack) {
            this.positiveCallBack = positiveCallBack;
            return this;
        }

        public GNormalDialog.NegativeCallBack getNegativeCallBack() {
            return negativeCallBack;
        }

        public GNormalDialog.Builder setNegativeCallBack(GNormalDialog.NegativeCallBack negativeCallBack) {
            this.negativeCallBack = negativeCallBack;
            return this;
        }

        @Override
        public int getThemeStyleResId() {

            return mThemeStyleId;
        }

        @Override
        public Builder setThemeStyleResId(@StyleRes int themeStyleResId) {

            this.mThemeStyleId = themeStyleResId;
            return this;
        }

        @Override
        public Class<H> getHelperClass() {
            return mHelperClass;
        }

        @Override
        public Builder setHelperClass(Class<H> cls) {

            this.mHelperClass = cls;
            return this;
        }

        public GNormalDialog<H> build() {
            if(getThemeStyleResId() <= 0){
                mDialog = new GNormalDialog(context, this);
                return mDialog;
            }else{
                mDialog = new GNormalDialog(context,getThemeStyleResId(),this);
                return mDialog;
            }
        }
    }

    public interface PositiveCallBack {
        void onClick(View v);
    }

    public interface NegativeCallBack {
        void onClick(View v);
    }
}
