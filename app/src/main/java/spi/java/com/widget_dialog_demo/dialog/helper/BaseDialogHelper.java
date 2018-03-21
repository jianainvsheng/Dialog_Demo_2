package spi.java.com.widget_dialog_demo.dialog.helper;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public abstract class BaseDialogHelper<D> {

    private D mModel;

    private Dialog mDialog;

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
     * Binding model
     * @param modle
     */
    public void setModel(D modle, Dialog dialog){

        this.mModel = modle;
        this.mDialog = dialog;
    }

    /**
     * return the modle
     * @return
     */
    public D getModel(){

        return mModel;
    }

    public Dialog getDialog(){

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
