package spi.java.com.widget_dialog_demo.dialog.commom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.builder.IDialogBuilder;
import spi.java.com.widget_dialog_demo.dialog.builder.Normal.NormalBuilder;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;
import spi.java.com.widget_dialog_demo.dialog.helper.usually.UsuallyDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public class GNormalDialog extends BaseDialog<NormalBuilder> {

    public GNormalDialog(@NonNull Context context, NormalBuilder data) {
        super(context, data);
    }

    public GNormalDialog(@NonNull Context context, int themeResId, NormalBuilder data) {
        super(context, themeResId, data);
    }

    public static NormalBuilder onCreateBuiler(Context context){

        return new NormalBuilder(context);
    }

    @Override
    public BaseDialogHelper<NormalBuilder> onCreateDefaultHelp(Context context, NormalBuilder data) {
        return new UsuallyDialogHelper(context);
    }

    public interface PositiveCallBack {
        void onClick(View v);
    }

    public interface NegativeCallBack {
        void onClick(View v);
    }
}
