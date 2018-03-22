package spi.java.com.widget_dialog_demo;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

import spi.java.com.widget_dialog_demo.dialog.builder.Normal.NormalBuilder;
import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.usually.UsuallyDialogHelper;
import spi.java.com.widget_dialog_demo.test.GCommonDialog;
import spi.java.com.widget_dialog_demo.test.OrderfillDeclareDialog;
import spi.java.com.widget_dialog_demo.test.newtest.OrderfillDeclareHelper;
import spi.java.com.widget_dialog_demo.test.newtest.testbuilder.TestNormalBuilder;
import spi.java.com.widget_dialog_demo.test.newtest.testhelper.TestHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){

        if(view.getId() == R.id.GCommonDialog_old_Test){

            GCommonDialog dialog = new GCommonDialog.Builder(this)
            .setContent("你好我是老版本GCommonDialog")
            .setNegativeName("cancle")
            .setPositiveName("ok").build();
            dialog.show();
        }else if(view.getId() == R.id.OrderfillDeclareDialog_old_Test){
            OrderfillDeclareDialog dialog = new OrderfillDeclareDialog(this,"大家好我是老版本OrderfillDeclareDialog","ok", Color.BLUE);
            dialog.show();
        } else if(view.getId() == R.id.GCommonDialog_new_Test){

            Dialog dialog = GNormalDialog.onCreateBuiler(this)
                    .setContent("你好我是新版本GCommonDialog")
                    .setThemeStyleResId(R.style.dialog_style)
                    .setNegativeName("cancle")
                    .setPositiveName("ok").build();
            dialog.show();
        }else if(view.getId() == R.id.OrderfillDeclareDialog_new_Test){

            Dialog dialog = GNormalDialog.onCreateBuiler(this)
                    .setContent("大家好我是新版本OrderfillDeclareDialog")
                    .setPositiveName("ok")
                    .setThemeStyleResId(R.style.dialog_style)
                    .setHelperClass(OrderfillDeclareHelper.class)
                    .build();
            dialog.show();

        }else if(view.getId() == R.id.OrderfillDeclareDialog_new_Builder_test){

            //支持传递外部builder 但是必须是继承dialog本身的builder 在helper中需要转型一下
            TestNormalBuilder builder = new TestNormalBuilder(this);
            builder.setTest("你好");
            Dialog dialog = GNormalDialog.onCreateBuiler(builder)
                    .setThemeStyleResId(R.style.dialog_style)
                    .setHelperClass(TestHelper.class)
                    .build();
            dialog.show();
        }
    }
}
