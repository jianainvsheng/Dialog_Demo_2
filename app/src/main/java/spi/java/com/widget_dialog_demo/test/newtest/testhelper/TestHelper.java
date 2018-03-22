package spi.java.com.widget_dialog_demo.test.newtest.testhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import spi.java.com.widget_dialog_demo.R;
import spi.java.com.widget_dialog_demo.dialog.builder.Normal.NormalBuilder;
import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;
import spi.java.com.widget_dialog_demo.dialog.helper.usually.UsuallyDialogHelper;
import spi.java.com.widget_dialog_demo.test.newtest.testbuilder.TestNormalBuilder;

/**
 * Created by yangjian on 2018/3/22.
 */

public class TestHelper extends BaseDialogHelper<NormalBuilder,GNormalDialog> {

    private TextView mTestView;

    public TestHelper(Context context) {
        super(context);
    }

    @Override
    public View onCreateContextView(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.test_builer_layout,null);
        mTestView = view.findViewById(R.id.builder_test);
        return view;
    }

    @Override
    public void setBuilder(NormalBuilder builder, GNormalDialog dialog) {
        super.setBuilder(builder, dialog);
        if(builder instanceof TestNormalBuilder){

            mTestView.setText(((TestNormalBuilder)builder).test);
            mTestView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getDialog().dismiss();
                }
            });
        }
    }
}
