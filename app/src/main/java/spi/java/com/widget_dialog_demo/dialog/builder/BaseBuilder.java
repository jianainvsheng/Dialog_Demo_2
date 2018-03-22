package spi.java.com.widget_dialog_demo.dialog.builder;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StyleRes;
import android.util.Log;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian on 2018/3/22.
 */

public abstract class BaseBuilder<D extends BaseBuilder<D>> implements IDialogBuilder<D>{


    private Class<? extends BaseDialogHelper<D>> mHelperClass;

    private @StyleRes int mThemeStyleId;

    private Context mContext;

    public BaseBuilder(Context context){

        this.mContext = context;
    }

    @Override
    public int getThemeStyleResId() {
        return mThemeStyleId;
    }

    @Override
    public D setThemeStyleResId(int themeStyleResId) {

        this.mThemeStyleId = themeStyleResId;
        return (D) this;

    }

    @Override
    public Class<? extends BaseDialogHelper<D>> getHelperClass() {
        return  mHelperClass;
    }

    @Override
    public D setHelperClass(Class<? extends BaseDialogHelper<D>> cls) {
        this.mHelperClass = cls;
        return (D) this;
    }

    @Override
    public Dialog build() {
        GNormalDialog<D> dialog;
        if(getThemeStyleResId() <= 0){
            dialog =  new GNormalDialog(getContext());
        }else{
            dialog =  new GNormalDialog(getContext(),getThemeStyleResId());
        }
        dialog.setBuilder((D)this);
        return dialog;
    }

    public Context getContext(){

        return mContext;
    }
}
