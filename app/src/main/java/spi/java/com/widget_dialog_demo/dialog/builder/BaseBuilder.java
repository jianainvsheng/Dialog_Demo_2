package spi.java.com.widget_dialog_demo.dialog.builder;

import android.support.annotation.StyleRes;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian on 2018/3/22.
 */

public abstract class BaseBuilder<D extends BaseBuilder<D,G>,G extends BaseDialog<D,G>> implements IDialogBuilder<D,G>{


    private Class<? extends BaseDialogHelper<D,G>> mHelperClass;

    private @StyleRes int mThemeStyleId;

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
    public Class<? extends BaseDialogHelper<D,G>> getHelperClass() {
        return  mHelperClass;
    }

    @Override
    public D setHelperClass(Class<? extends BaseDialogHelper<D,G>> cls) {
        this.mHelperClass = cls;
        return (D) this;
    }
}
