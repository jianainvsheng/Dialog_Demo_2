package spi.java.com.widget_dialog_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import spi.java.com.widget_dialog_demo.dialog.commom.GNormalDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.usually.UsuallyDialogHelper;
import spi.java.com.widget_dialog_demo.test.GCommonDialog;
import spi.java.com.widget_dialog_demo.test.OrderfillDeclareDialog;
import spi.java.com.widget_dialog_demo.test.newtest.OrderfillDeclareHelper;

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

            GNormalDialog dialog = new GNormalDialog.Builder(this)
                    .setContent("你好我是新版本GCommonDialog")
                    .setThemeStyleResId(R.style.dialog_style)
                    .setNegativeName("cancle")
                    .setPositiveName("ok").build();
            dialog.show();
        }else if(view.getId() == R.id.OrderfillDeclareDialog_new_Test){

            GNormalDialog dialog = new GNormalDialog.Builder<OrderfillDeclareHelper>(this)
                    .setContent("大家好我是新版本OrderfillDeclareDialog")
                    .setPositiveName("ok")
                    .setThemeStyleResId(R.style.dialog_style)
                    .setHelperClass(OrderfillDeclareHelper.class)
                    .build();
            dialog.show();

        }
    }
}
