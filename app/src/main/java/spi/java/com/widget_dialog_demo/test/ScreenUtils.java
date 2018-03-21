package spi.java.com.widget_dialog_demo.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by yangjian-ds3 on 2018/3/21.
 */

public class ScreenUtils {

    public ScreenUtils() {
    }

    public static float density(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float dp2Px(Context context, float dp) {
        return context == null?-1.0F:dp * density(context);
    }

    public static float dpToPx(Context context, float dp) {
        return context == null?-1.0F:dp * context.getResources().getDisplayMetrics().density;
    }

    public static float pxToDp(Context context, float px) {
        return context == null?-1.0F:px / context.getResources().getDisplayMetrics().density;
    }

    public static int sp2px(float spValue, Context context) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * fontScale + 0.5F);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(pxValue / fontScale + 0.5F);
    }

    public static int[] getScreenPixelSize(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    public static float getScreenDensity(Context context) {
        float density = 0.0F;

        try {
            DisplayMetrics e = context.getResources().getDisplayMetrics();
            density = e.density;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return density;
    }

    public static int getScreenDensityDpi(Context context) {
        int densityDpi = 0;

        try {
            DisplayMetrics e = context.getResources().getDisplayMetrics();
            densityDpi = e.densityDpi;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return densityDpi;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Rect getShowFrameRect(Window window) {
        Rect frame = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame;
    }

    public static int dpToPxInt(Context context, float dp) {
        return (int)(dpToPx(context, dp) + 0.5F);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    public static void hideSoftInputKeyBoard(Context context, View focusView) {
        if(focusView != null) {
            IBinder binder = focusView.getWindowToken();
            if(binder != null) {
                InputMethodManager imd = (InputMethodManager)context.getSystemService("input_method");
                imd.hideSoftInputFromWindow(binder, 0);
            }
        }

    }

    public static void showSoftInputKeyBoard(Context context, View focusView) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService("input_method");
        imm.showSoftInput(focusView, 2);
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static int getDisplayWidth(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService("window");
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }

    public static int getDisplayHeight(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService("window");
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }

    public static int dp2PxInt(Context context, float dp) {
        return (int) (dp2Px(context, dp) + 0.5f);
    }
}
