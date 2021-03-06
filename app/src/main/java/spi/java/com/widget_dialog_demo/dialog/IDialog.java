package spi.java.com.widget_dialog_demo.dialog;

import android.content.Context;
import android.view.View;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.builder.IDialogBuilder;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public interface IDialog<D extends IDialogBuilder<D,G>,G extends IDialog<D,G>> {

    /**
     * init the dialog
     * @param context
     */
    public void initDialog(Context context,D data);

    /**
     * create the helper
     * @return
     */
    public BaseDialogHelper<D,G> onCreateHelper(Context context,D data) throws NoSuchMethodException;

}
