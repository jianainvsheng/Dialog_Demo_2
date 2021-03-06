package spi.java.com.widget_dialog_demo.dialog.helper;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import spi.java.com.widget_dialog_demo.dialog.IDialog;
import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.builder.IDialogBuilder;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public abstract class BaseDialogHelper<D extends IDialogBuilder<D,G>,G extends IDialog<D,G>> {

    private D mBuilder;

    private G mDialog;

    /**
     * show the context of view in the dialog
     */
    private View mContextView;

    public BaseDialogHelper(Context context){

        this.mContextView = onCreateContextView(context);
        if(mContextView == null){
            throw new NullPointerException("ContextView is null");
        }
    }

    public abstract View onCreateContextView(Context context);

    /**
     * Binding builder
     * @param builder
     */
    public void setBuilder(D builder, G dialog){

        this.mBuilder = builder;
        this.mDialog = dialog;
    }

    /**
     * return the modle
     * @return
     */
    public D getBuilder(){

        return mBuilder;
    }

    public G getDialog(){

        return mDialog;
    }
    /**
     * return the contextView
     * @return
     */
    public View getContextView(){

        return mContextView;
    }

    /**
     * return the context but may be empty
     * @return
     */
    public Context getContext(){

        return (mContextView == null ? null : mContextView.getContext());
    }
}
