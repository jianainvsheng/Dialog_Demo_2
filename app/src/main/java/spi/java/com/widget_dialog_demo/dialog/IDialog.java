package spi.java.com.widget_dialog_demo.dialog;

import android.content.Context;
import android.view.View;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public interface IDialog<D ,H extends BaseDialogHelper<D>> {

    /**
     * init the dialog
     * @param context
     */
    public void initDialog(Context context,D data);

    /**
     * create the helper
     * @return
     */
    public H onCreateHelper(Context context,D data) throws NoSuchMethodException;

}
