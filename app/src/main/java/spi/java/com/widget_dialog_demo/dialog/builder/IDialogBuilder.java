package spi.java.com.widget_dialog_demo.dialog.builder;
import android.support.annotation.StyleRes;

import spi.java.com.widget_dialog_demo.dialog.IDialog;
import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public interface IDialogBuilder<D extends IDialogBuilder<D,G>,G extends IDialog<D,G>> {

    /**
     * the theme in the dialog
     * @return
     */
    public @StyleRes int getThemeStyleResId();

    /**
     * set the theme style id
     * @param themeStyleResId
     */
    public D setThemeStyleResId(@StyleRes int themeStyleResId);

    /**
     * return the need helper
     * @return
     */
    public Class<? extends BaseDialogHelper<D,G>> getHelperClass();


    /**
     * set helper class
     * @param cls
     * @return
     */
    public D setHelperClass(Class<? extends BaseDialogHelper<D,G>> cls);

    /**
     * create dialog
     * @return
     */
    public G build();

}
