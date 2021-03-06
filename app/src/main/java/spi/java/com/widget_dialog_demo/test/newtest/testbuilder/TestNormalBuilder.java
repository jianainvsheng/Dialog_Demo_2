package spi.java.com.widget_dialog_demo.test.newtest.testbuilder;

import android.content.Context;

import spi.java.com.widget_dialog_demo.dialog.builder.Normal.NormalBuilder;
import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian on 2018/3/22.
 */

public class TestNormalBuilder extends NormalBuilder {

    public String test;

    public TestNormalBuilder(Context context) {
        super(context);
    }

    @Override
    public NormalBuilder setHelperClass(Class<? extends BaseDialogHelper<NormalBuilder, GNormalDialog>> cls) {
        return super.setHelperClass(cls);
    }

    public void setTest(String test){

        this.test = test;
    }
}
