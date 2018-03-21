//package spi.java.com.widget_dialog_demo.test;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.graphics.Color;
//import android.text.TextUtils;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.BaseAdapter;
//
//import spi.java.com.widget_dialog_demo.R;
//
///**
// * 对话框工具类
// *
// * @author houbiaofeng
// * @version v1.0
// * @date 2015/10/29-16:52
// */
//public class CustomDialogUtil {
//
//    /**
//     * 提示确定
//     *
//     * @param context
//     * @param message
//     */
//    public static Dialog showInfoDialog(Context context, String message) {
//        return showInfoDialog(context, context.getString(R.string.movie_tip), message, context.getString(R.string.confirm),
//                null);
//    }
//
//    /**
//     * 带默认标题 提示
//     * @param context
//     * @param message
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @return
//     */
//    public static Dialog showInfoDialog(Context context, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener) {
//        return showInfoDialog(context, context.getString(R.string.movie_tip), message,leftLabel,leftClickListener,rightLabel,rightClickListener);
//    }
//
//    /**
//     * 提示对话框 标题 内容  确定按钮颜色
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param positiveStr
//     * @param onClickListener
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String positiveStr,
//                                        DialogInterface.OnClickListener onClickListener) {
//        return showInfoDialog(context,titleStr,message,null,null,positiveStr,onClickListener,null);
//    }
//
//    /**
//     * 提示对话框 标题 内容 左右按钮
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener) {
//        return showInfoDialog(context,titleStr,message,leftLabel,leftClickListener,rightLabel,rightClickListener,null);
//    }
//
//    /**
//     * 提示对话框 标题 内容 左右按钮
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param leftLabel
//     * @param rightLabel
//     * @param rightClickListener
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        String rightLabel, DialogInterface.OnClickListener rightClickListener) {
//        return showInfoDialog(context, titleStr, message, leftLabel, null, rightLabel, rightClickListener);
//    }
//
//    /**
//     * 提示对话框 标题 内容 左右按钮 确定按钮颜色
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, String rightTextColor) {
//
//        return showInfoDialog(context,titleStr,message,leftLabel,leftClickListener,rightLabel,rightClickListener,rightTextColor,null,null,false,null);
//    }
//
//    /**
//     * 自定义dialog 显示标题 确定 以及右边叉号关闭
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param rightLabel
//     * @param rightClickListener
//     * @param isShowClose
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, boolean isShowClose) {
//        return showInfoDialog(context, titleStr, message, rightLabel, rightClickListener, isShowClose, null);
//    }
//
//    /**
//     * 自定义dialog 显示标题 确定以及右边叉号关闭
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param rightLabel
//     * @param rightClickListener
//     * @param closeClickListener
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, DialogInterface.OnClickListener closeClickListener) {
//        return showInfoDialog(context, titleStr, message, rightLabel, rightClickListener, true, closeClickListener);
//    }
//
//    /**
//     * 自定义dialog 显示 标题 确定以及右边叉号关闭
//     *
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param rightLabel
//     * @param rightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//
//        return showInfoDialog(context,titleStr,message,null,null,rightLabel,rightClickListener,null,null,null,isShowClose,closeClickListener);
//    }
//
//    /**
//     *  自定义dialog 显示标题左右按钮 以及底部按钮颜色
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @return
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener titleLeftClickListener,
//                                        DialogInterface.OnClickListener titleRightClickListener){
//        return showInfoDialog(context,titleStr,message,leftLabel,leftClickListener,rightLabel,rightClickListener,rightTextColor,titleLeftClickListener,titleRightClickListener,false,null);
//    }
//    /**
//     * 自定义dialog
//     * @param context
//     * @param titleStr
//     * @param message
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener titleLeftClickListener,
//                                        DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setMessage(message);
//        if (leftClickListener == null)
//            leftClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        if (rightClickListener == null)
//            rightClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        localBuilder.setCloseButtonCickListener(isShowClose,closeClickListener);
//        localBuilder.setPositiveButton(rightLabel, rightClickListener);
//        if(!TextUtils.isEmpty(rightTextColor)){
//            localBuilder.setPositiveButtonColor(Color.parseColor(rightTextColor));
//        }
//        localBuilder.setNegativeButton(leftLabel, leftClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//        return dialog;
//    }
//
//
//    public static Dialog showInfoDialog(Context context, String titleStr, String message, String leftLabel,
//                                        DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                        DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener titleLeftClickListener,
//                                        DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener,
//                                        int titletype) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setMessage(message);
//        if (leftClickListener == null)
//            leftClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        if (rightClickListener == null)
//            rightClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        localBuilder.setTitleType(titletype);
//        localBuilder.setCloseButtonCickListener(isShowClose,closeClickListener);
//        localBuilder.setPositiveButton(rightLabel, rightClickListener);
//        if(!TextUtils.isEmpty(rightTextColor)){
//            localBuilder.setPositiveButtonColor(Color.parseColor(rightTextColor));
//        }
//        localBuilder.setNegativeButton(leftLabel, leftClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 自定义dialog 自定义view
//     * @param context
//     * @param view
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view){
//        return showCustomViewDialog(context, view, null, null, null, null, null, null, null, null, false, null);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题头
//     * @param context
//     * @param view
//     * @param titleStr
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr){
//        return showCustomViewDialog(context, view, titleStr, null, null, null, null, null, null, null, false, null);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题头带关闭
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, boolean isShowClose, DialogInterface.OnClickListener closeClickListener){
//        return showCustomViewDialog(context, view, titleStr, null, null, null, null, null, null, null, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题 带标题左右按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener){
//        return showCustomViewDialog(context, view, titleStr, null, null, null, null, null, titleLeftClickListener, titleRightClickListener, false, null);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题 带标题左右按钮 是否带关闭按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener){
//        return showCustomViewDialog(context, view, titleStr, null, null, null, null, null, titleLeftClickListener, titleRightClickListener, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题 带底部右按钮 是否带关闭按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, String rightLabel,
//                                              DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener closeClickListener){
//        return showCustomViewDialog(context, view, titleStr, null, null, rightLabel, rightClickListener, rightTextColor, null, null, true, closeClickListener);
//    }
//
//    /**
//     * 自定义dialog 自定义view 带标题 带底部左右按钮 不带关闭按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, String leftLabel,
//                                              DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                              DialogInterface.OnClickListener rightClickListener, String rightTextColor){
//        return showCustomViewDialog(context, view, titleStr, leftLabel, leftClickListener, rightLabel, rightClickListener, rightTextColor, null, null, false, null);
//    }
//    /**
//     * 自定义dialog 自定义view  显示底部左右按钮 以及关闭按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, String leftLabel,
//                                              DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                              DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//
//        return showCustomViewDialog(context, view, titleStr, leftLabel, leftClickListener, rightLabel,
//                rightClickListener, rightTextColor, titleLeftClickListener, titleRightClickListener, isShowClose, closeClickListener, CustomDialog.Builder.TITLE_TYPE_1);
//    }
//
//    /**
//     * 自定义dialog 自定义view  显示底部左右按钮 以及关闭按钮
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param leftLabel
//     * @param leftClickListener
//     * @param rightLabel
//     * @param rightClickListener
//     * @param rightTextColor
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @param titletype 决定对话框Ttile加载什么布局
//     * @return
//     */
//    public static Dialog showCustomViewDialog(Context context, View view, String titleStr, String leftLabel,
//                                              DialogInterface.OnClickListener leftClickListener, String rightLabel,
//                                              DialogInterface.OnClickListener rightClickListener, String rightTextColor, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener,
//                                              int titletype) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setContentView(view);
//        if (leftClickListener == null)
//            leftClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        if (rightClickListener == null)
//            rightClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            };
//        localBuilder.setTitleType(titletype);
//        localBuilder.setCloseButtonCickListener(isShowClose,closeClickListener);
//        localBuilder.setPositiveButton(rightLabel, rightClickListener);
//        if(!TextUtils.isEmpty(rightTextColor)){
//            localBuilder.setPositiveButtonColor(Color.parseColor(rightTextColor));
//        }
//        localBuilder.setNegativeButton(leftLabel, leftClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示列表对话框 不带标题
//     *
//     * @param context
//     * @param items
//     * @param onClickListener
//     */
//    public static Dialog showListItemDialog(Context context, String[] items, DialogInterface.OnClickListener onClickListener) {
//        return showListItemDialog(context, null, items, -1, onClickListener);
//    }
//
//    /**
//     * 显示列表对话框 带标题
//     *
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param defaultIndex
//     * @param onClickListener
//     */
//    public static Dialog showListItemDialog(Context context, String titleStr, String[] items, int defaultIndex, DialogInterface.OnClickListener onClickListener) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context);
//
//        CustomDialog.Builder builder = localBuilder.setItems(items, onClickListener);
//        if (!TextUtils.isEmpty(titleStr)) {
//            builder.setTitle(titleStr);
//        }
//        builder.setItemsIndex(defaultIndex);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view) {
//        return showBottomViewDialog(context, view, null, null,
//                null, false, null);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param isShowClose
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, boolean isShowClose) {
//        return showBottomViewDialog(context, view, null, null,
//                null, isShowClose, null);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param isShowClose
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, String titleStr, boolean isShowClose) {
//        return showBottomViewDialog(context, view, titleStr, isShowClose, null);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomViewDialog(context, view, null, null,
//                null, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, String titleStr, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomViewDialog(context, view, titleStr, null,
//                null, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, String titleStr,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomViewDialog(context, view, titleStr, null,
//                titleRightClickListener, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, String titleStr, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomViewDialog(context, view, titleStr, titleLeftClickListener, titleRightClickListener, isShowClose, closeClickListener, 0.6F);
//    }
//
//    /**
//     * 显示底部弹出的dialg 自定义view
//     * @param context
//     * @param view
//     * @param titleStr
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @param percent 设置对话框基于屏幕高度的百分比【默认为0.6，最大为1，不能为0】
//     * @return
//     */
//    public static Dialog showBottomViewDialog(Context context, View view, String titleStr, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener,
//                                              float percent) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context,R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setContentView(view);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(percent);
//        localBuilder.setWPercent(1f);
//        localBuilder.setGravity(Gravity.BOTTOM);
//        localBuilder.setTitleType(CustomDialog.Builder.TITLE_TYPE_2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param onItemClickListener
//     * @param isShowClose
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, DialogInterface.OnClickListener onItemClickListener, boolean isShowClose) {
//        return showBottomListDialog(context, titleStr, items, -1, onItemClickListener, null, null, isShowClose, null);
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param onItemClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, DialogInterface.OnClickListener onItemClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomListDialog(context, titleStr, items, -1, onItemClickListener, null, null, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param onItemClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, DialogInterface.OnClickListener onItemClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomListDialog(context, titleStr, items, -1, onItemClickListener, null, titleRightClickListener, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param selectPosition
//     * @param onItemClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, int selectPosition, DialogInterface.OnClickListener onItemClickListener
//            , boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomListDialog(context, titleStr, items, selectPosition, onItemClickListener, null, null, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param selectPosition
//     * @param onItemClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, int selectPosition, DialogInterface.OnClickListener onItemClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        return showBottomListDialog(context, titleStr, items, selectPosition, onItemClickListener, null, titleRightClickListener, isShowClose, closeClickListener);
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param selectPosition
//     * @param onItemClickListener
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, int selectPosition, DialogInterface.OnClickListener onItemClickListener, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context, R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setItemsIndex(selectPosition);
//        localBuilder.setItems(items, onItemClickListener);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(0.6f);
//        localBuilder.setWPercent(1f);
//        localBuilder.setGravity(Gravity.BOTTOM);
//        localBuilder.setTitleType(CustomDialog.Builder.TITLE_TYPE_2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param adapter
//     * @param onItemClickListener
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, BaseAdapter adapter, DialogInterface.OnClickListener onItemClickListener, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context, R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setAdapter(adapter, onItemClickListener);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(0.6f);
//        localBuilder.setWPercent(1f);
//        localBuilder.setGravity(Gravity.BOTTOM);
//        localBuilder.setTitleType(CustomDialog.Builder.TITLE_TYPE_2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param adapter
//     * @param onItemClickListener
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, BaseAdapter adapter, View footerView, DialogInterface.OnClickListener onItemClickListener, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context, R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setmFooterView(footerView);
//        localBuilder.setAdapter(adapter, onItemClickListener);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(0.6f);
//        localBuilder.setWPercent(1f);
//        localBuilder.setGravity(Gravity.BOTTOM);
//        localBuilder.setTitleType(CustomDialog.Builder.TITLE_TYPE_2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    /**
//     * 显示底部弹出的带list的dialog
//     * @param context
//     * @param titleStr
//     * @param items
//     * @param selectPosition
//     * @param onItemClickListener
//     * @param titleLeftClickListener
//     * @param titleRightClickListener
//     * @param isShowClose
//     * @param closeClickListener
//     * @param percent 设置对话框基于屏幕高度的百分比【默认为0.6，最大为1，不能为0】
//     * @return
//     */
//    public static Dialog showBottomListDialog(Context context, String titleStr, String[] items, View footerView, int selectPosition, DialogInterface.OnClickListener onItemClickListener, DialogInterface.OnClickListener titleLeftClickListener,
//                                              DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener ,
//                                              float percent) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context, R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setmFooterView(footerView);
//        localBuilder.setItemsIndex(selectPosition);
//        localBuilder.setItems(items, onItemClickListener);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(percent);
//        localBuilder.setWPercent(1f);
//        localBuilder.setGravity(Gravity.BOTTOM);
//        localBuilder.setTitleType(CustomDialog.Builder.TITLE_TYPE_2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//    public static Dialog showBottomListDialog(Context context, String titleStr, BaseAdapter adapter, View footerView, int selectPosition, DialogInterface.OnClickListener onItemClickListener, DialogInterface.OnClickListener titleLeftClickListener, DialogInterface.OnClickListener titleRightClickListener, boolean isShowClose, DialogInterface.OnClickListener closeClickListener, float percent) {
//        CustomDialog.Builder localBuilder = new CustomDialog.Builder(context, R.style.bottomDialogWithAnim);
//        localBuilder.setTitle(titleStr);
//        localBuilder.setmFooterView(footerView);
//        localBuilder.setAdapter(adapter, onItemClickListener);
//        localBuilder.setItemsIndex(selectPosition);
//        localBuilder.setItems(null, onItemClickListener);
//        localBuilder.setCloseButtonCickListener(isShowClose, closeClickListener);
//        localBuilder.setRightButton(titleRightClickListener);
//        localBuilder.setLeftButton(titleLeftClickListener);
//        localBuilder.setHPercent(percent);
//        localBuilder.setWPercent(1.0F);
//        localBuilder.setGravity(80);
//        localBuilder.setTitleType(2);
//        Dialog dialog = localBuilder.create();
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        return dialog;
//    }
//
//
//}
