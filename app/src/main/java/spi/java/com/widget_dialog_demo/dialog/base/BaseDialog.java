package spi.java.com.widget_dialog_demo.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.Log;

import spi.java.com.widget_dialog_demo.dialog.IDialog;
import spi.java.com.widget_dialog_demo.dialog.builder.IDialogBuilder;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public abstract class BaseDialog <D extends IDialogBuilder<D,H>,H extends BaseDialogHelper<D>> extends Dialog implements IDialog<D,H>{

    private H mHelper;

    public BaseDialog(@NonNull Context context,D data) {
        super(context);
        initDialog(context,data);
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId,D data) {
        super(context, themeResId);
        initDialog(context,data);
    }

    @Override
    public void initDialog(Context context, D data) {
        mHelper = onCreateHelper(context,data);
        if(mHelper == null){
            BaseDialogHelper<D> mDefaultHelper = onCreateDefaultHelp(context,data);
            if(mDefaultHelper == null){
                throw new NullPointerException("onCreateHelper and onCreateDefaultHelp fail by which mHelper is null");
            }else{
                if(mDefaultHelper.getContextView() == null){
                    throw new NullPointerException("mDefaultHelper fail by which view is null in the helper");
                } else{
                    setContentView(mDefaultHelper.getContextView());
                    mDefaultHelper.setBuilder(data,this);
                }
            }
        }else{
            if(mHelper.getContextView() == null){
                throw new NullPointerException("ContextView fail by which view is null in the helper");
            }
            setContentView(mHelper.getContextView());
            mHelper.setBuilder(data,this);
        }
    }

    @Override
    public H onCreateHelper(Context context, D data) {

        if(data != null && data.getHelperClass() != null){
            Class<H> cls = data.getHelperClass();
            //参数类型数组
            Class[] parameterTypes={Context.class};
            //根据参数类型获取相应的构造函数
            try {
                java.lang.reflect.Constructor<H> constructor = cls.getConstructor(parameterTypes);
                Object[] parameters={context};
                H h = constructor.newInstance(parameters);
                return h;
            } catch (Exception e) {
                //e.printStackTrace();
                Log.d("BaseDialog","the helper in the diaolg is wrong");
            }
        }
        return null;
    }

    /**
     * set the default helper
     * @param context
     * @param data
     * @return
     */
    public abstract BaseDialogHelper<D> onCreateDefaultHelp(Context context, D data);

    /**
     * return the helper
     * @return
     */
    public H getHelper(){

        return mHelper;
    }

}
