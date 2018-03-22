package spi.java.com.widget_dialog_demo.dialog.builder;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.util.Log;

import spi.java.com.widget_dialog_demo.dialog.base.BaseDialog;
import spi.java.com.widget_dialog_demo.dialog.helper.BaseDialogHelper;

/**
 * Created by yangjian on 2018/3/22.
 */

public abstract class BaseBuilder<D extends BaseBuilder<D,G>,G extends BaseDialog<D,G>> implements IDialogBuilder<D,G>{


    private Class<? extends BaseDialogHelper<D,G>> mHelperClass;

    private @StyleRes int mThemeStyleId;

    private Context mContext;

    public BaseBuilder(Context context){

        this.mContext = context;
    }

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

    @Override
    public G build() {
        Class<G> cls = getBuildClass();
        if(cls == null)
            throw new NullPointerException("create build fail");
        Class[] parameterTypes = null;
        Object[] parameters= null;
        if(getThemeStyleResId() <= 0){
            Class[] types= {Context.class};
            parameterTypes = types;
            Object[] par={mContext};
            parameters = par;
        }else{
            Class[] types= {Context.class,int.class};
            parameterTypes = types;
            Object[] par={mContext,getThemeStyleResId()};
            parameters = par;
        }
        //根据参数类型获取相应的构造函数
        try {
            java.lang.reflect.Constructor<G> constructor = cls.getConstructor(parameterTypes);
            G g = constructor.newInstance(parameters);
            g.setBuilder((D)this);
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("BaseDialog","the helper in the diaolg is wrong");
        }
        return null;
    }

    /**
     * return the dialog class
     * @return
     */
    public abstract Class<G> getBuildClass();

    public Context getContext(){

        return mContext;
    }
}
