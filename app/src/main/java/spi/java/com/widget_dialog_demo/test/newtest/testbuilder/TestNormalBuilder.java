package spi.java.com.widget_dialog_demo.test.newtest.testbuilder;

import android.content.Context;
import spi.java.com.widget_dialog_demo.dialog.builder.BaseBuilder;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian on 2018/3/22.
 */

public class TestNormalBuilder extends BaseBuilder<TestNormalBuilder> {

    public String test;

    public TestNormalBuilder(Context context) {
        super(context);
    }

    @Override
    public TestNormalBuilder setHelperClass(Class<? extends BaseDialogHelper<TestNormalBuilder>> cls) {
        return super.setHelperClass(cls);
    }

    public void setTest(String test){

        this.test = test;
    }
}
