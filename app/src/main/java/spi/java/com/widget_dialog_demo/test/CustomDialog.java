//package spi.java.com.widget_dialog_demo.test;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.graphics.drawable.Drawable;
//import android.util.DisplayMetrics;
//import android.view.Gravity;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.ViewStub;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import spi.java.com.widget_dialog_demo.R;
//
//
///**
// * 自定义弹出层对话框
// *
// * @author niu
// */
//public class CustomDialog extends Dialog {
//
//    public CustomDialog(Context context, int theme) {
//        super(context, theme);
//    }
//
//    public CustomDialog(Context context) {
//        super(context);
//    }
//
//    /**
//     * Helper class for creating a custom dialog
//     */
//    public static class Builder {
//
//        /**
//         * type 1,2,3, 是加载三种不同的layout； 2016-9-26 14:07:37 zhaolei添加注释
//         */
//        public final static int TITLE_TYPE_1 = 1;
//        public final static int TITLE_TYPE_2 = 2;
//        public final static int TITLE_TYPE_3 = 3;
//        public final static float HEIGHT_PERCENT = 0f;
//        public final static float WIDTH_PERCENT = 0.85f;
//        private Context context;
//        private String title;
//        private int titleIcon = 0;
//        private String message;
//        private String positiveButtonText;
//        private String negativeButtonText;
//        private View contentView;
//        private int mPositiveButtonColor = 0xff333333;
//        private int mNegtiveButtonColor = 0xff333333;
//
//        private OnClickListener positiveButtonClickListener, negativeButtonClickListener,
//                itemsClickListener, closeButtonCickListener, leftTitleButtonClickListener, rightTitleButtonClickListener;
//        ;
//        private String[] items;
//        private int index = -1;
//        private boolean mIsShowClose;
//        private int mTheme = R.style.bottomDialog;
//        private float mHPercent = HEIGHT_PERCENT;
//        private float mWPercent = WIDTH_PERCENT;
//        private BaseAdapter mAdapter;
//        private View mFooterView;
//        private int mRightTitleButton;
//        private int mTitleType = TITLE_TYPE_1;
//        private int mDialogAnim = 0;
//        private int mGravity = 0;
//
//        public Builder(Context context) {
//            this.context = context;
//        }
//
//        public Builder(Context context, int theme) {
//            this.context = context;
//            this.mTheme = theme;
//        }
//
//        public Builder setGravity(int gravity) {
//            this.mGravity = gravity;
//            return this;
//        }
//
//        /**
//         * 设置对话框基于屏幕高度的百分比【默认为0.6，最大为1，不能为0】
//         *
//         * @param percent
//         */
//        public Builder setHPercent(float percent) {
//            this.mHPercent = percent;
//            return this;
//        }
//
//        public Builder setWPercent(float percent) {
//            this.mWPercent = percent;
//            return this;
//        }
//
//        public Builder setTheme(int theme) {
//            this.mTheme = theme;
//            return this;
//        }
//
//        public Builder setTitleType(int titleType) {
//            this.mTitleType = titleType;
//            return this;
//        }
//
//        public Builder setDialogAnim(int dialogAnim) {
//            this.mDialogAnim = dialogAnim;
//            return this;
//        }
//
//        public Builder setAdapter(BaseAdapter adapter, OnClickListener listener) {
//            this.mAdapter = adapter;
//            this.itemsClickListener = listener;
//            return this;
//        }
//
//        /**
//         * Set the Dialog message from String
//         *
//         * @param message
//         * @return
//         */
//        public Builder setMessage(String message) {
//            this.message = message;
//            return this;
//        }
//
//        /**
//         * @param positiveButtonColor
//         * @return
//         * @Description: 设置确定按钮的颜色
//         * @author xingchao.song
//         * @date 2014-11-12 下午5:18:52
//         */
//        public Builder setPositiveButtonColor(int positiveButtonColor) {
//            mPositiveButtonColor = positiveButtonColor;
//            return this;
//        }
//
//        public Builder setNegtiveButtonColor(int negtiveButtonColor) {
//            mNegtiveButtonColor = negtiveButtonColor;
//            return this;
//        }
//
//        public Builder setCloseButtonCickListener(boolean isShowClose, OnClickListener closeButtonCickListener) {
//            this.mIsShowClose = isShowClose;
//            this.closeButtonCickListener = closeButtonCickListener;
//            return this;
//        }
//
//        /**
//         * Set the Dialog message from resource
//         *
//         * @param message
//         * @return
//         */
//        public Builder setMessage(int message) {
//            this.message = (String) context.getText(message);
//            return this;
//        }
//
//        /**
//         * Set the Dialog title from resource
//         *
//         * @param title
//         * @return
//         */
//        public Builder setTitle(int title) {
//            this.title = (String) context.getText(title);
//            return this;
//        }
//
//        /**
//         * Set the Dialog title from String
//         *
//         * @param title
//         * @return
//         */
//        public Builder setTitle(String title) {
//            this.title = title;
//            return this;
//        }
//
//        /**
//         * 设置标题图标
//         *
//         * @return
//         */
//        public Builder setTitleIcon(int icon) {
//            this.titleIcon = icon;
//            return this;
//        }
//
//        /**
//         * Set a custom content view for the Dialog. If a message is set, the contentView is not added to the Dialog...
//         *
//         * @param v
//         * @return
//         */
//        public Builder setContentView(View v) {
//            this.contentView = v;
//            return this;
//        }
//
//        /**
//         * Set the positive button resource and it's listener
//         *
//         * @param positiveButtonText
//         * @param listener
//         * @return
//         */
//        public Builder setPositiveButton(int positiveButtonText, OnClickListener listener) {
//            this.positiveButtonText = (String) context.getText(positiveButtonText);
//            this.positiveButtonClickListener = listener;
//            return this;
//        }
//
//        /**
//         * Set the positive button text and it's listener
//         *
//         * @param positiveButtonText
//         * @param listener
//         * @return
//         */
//        public Builder setPositiveButton(String positiveButtonText, OnClickListener listener) {
//            this.positiveButtonText = positiveButtonText;
//            this.positiveButtonClickListener = listener;
//            return this;
//        }
//
//
//        /**
//         * @param mFooterView  listview  footerview;
//         */
//        public void setmFooterView(View mFooterView) {
//            this.mFooterView = mFooterView;
//        }
//
//        /**
//         * Set the negative button resource and it's listener
//         *
//         * @param negativeButtonText
//         * @param listener
//         * @return
//         */
//        public Builder setNegativeButton(int negativeButtonText, OnClickListener listener) {
//            this.negativeButtonText = (String) context.getText(negativeButtonText);
//            this.negativeButtonClickListener = listener;
//            return this;
//        }
//
//        public Builder setItems(String[] items, OnClickListener listener) {
//            this.items = items;
//            this.itemsClickListener = listener;
//            return this;
//        }
//
//        public Builder setItemsIndex(int i) {
//            this.index = i;
//            return this;
//        }
//
//        /**
//         * Set the negative button text and it's listener
//         *
//         * @param negativeButtonText
//         * @param listener
//         * @return
//         */
//        public Builder setNegativeButton(String negativeButtonText, OnClickListener listener) {
//            this.negativeButtonText = negativeButtonText;
//            this.negativeButtonClickListener = listener;
//            return this;
//
//        }
//
//        /**
//         * 设置标题左边按钮
//         *
//         * @param listener
//         * @return
//         */
//        public Builder setLeftButton(OnClickListener listener) {
//            this.leftTitleButtonClickListener = listener;
//            return this;
//        }
//
//        /**
//         * 设置标题右边按钮
//         *
//         * @param listener
//         * @return
//         */
//        public Builder setRightButton(OnClickListener listener) {
//            this.rightTitleButtonClickListener = listener;
//            return this;
//        }
//
//        public Builder setRightButton(int mRightTitleRes, OnClickListener listener) {
//            this.rightTitleButtonClickListener = listener;
//            this.mRightTitleButton = mRightTitleRes;
//            return this;
//        }
//
//        /**
//         * Create the custom dialog
//         */
//        public CustomDialog create() {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            // instantiate the dialog with the custom Theme
//            final CustomDialog dialog = new CustomDialog(context, mTheme);
//            View layout = inflater.inflate(R.layout.movie_custom_dialog, null);
//            ViewStub titleStub = (ViewStub) layout.findViewById(R.id.title_container);
//            if (mTitleType == TITLE_TYPE_1) {
//                titleStub.setLayoutResource(R.layout.custom_dialog_title_1);
//                titleStub.inflate();
//                layout.setBackgroundResource(R.drawable.gome_popwindow_shape);
//            }else if(mTitleType == TITLE_TYPE_3){
//                titleStub.setLayoutResource(R.layout.custom_dialog_title_3);
//                titleStub.inflate();
//                layout.setBackgroundResource(R.drawable.gome_popwindow_shape);
//            } else {
//                titleStub.setLayoutResource(R.layout.custom_dialog_title_2);
//                titleStub.inflate();
//                layout.setBackgroundResource(R.color.main_default_white_text_color);
//                //是否显示标题或者关闭
//                if ((title == null || "".equals(title)) && mIsShowClose == false) {
//                    layout.findViewById(R.id.title_line).setVisibility(View.GONE);
//                }
//            }
//            if (mTitleType != TITLE_TYPE_1 && mTitleType != TITLE_TYPE_2 && mTitleType != TITLE_TYPE_3) {
//                titleStub.setVisibility(View.GONE);
//            }
//            // set the dialog title
//            TextView tvTitle = (TextView) layout.findViewById(R.id.title);
//            if (title != null && !"".equals(title)) {
//                tvTitle.setText(title);
//                if (titleIcon != 0) {
//                    // tvTitle.setCompoundDrawablePadding(5);
//                    Drawable left = context.getResources().getDrawable(titleIcon);
//                    left.setBounds(0, 0, left.getMinimumWidth(), left.getMinimumHeight());
//                    tvTitle.setCompoundDrawables(left, null, null, null);
//                }
//            } else {
//                tvTitle.setVisibility(View.GONE);
//
//            }
//            //设置title左右按钮
//            ImageView ivLeft = (ImageView) layout.findViewById(R.id.title_left);
//            if (leftTitleButtonClickListener != null) {
//                ivLeft.setVisibility(View.VISIBLE);
//                ivLeft.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        leftTitleButtonClickListener.onClick(dialog, 0);
//                    }
//                });
//            } else {
//                ivLeft.setVisibility(View.GONE);
//            }
//
//            ImageView ivRight = (ImageView) layout.findViewById(R.id.title_right);
//            if (rightTitleButtonClickListener != null) {
//                ivRight.setVisibility(View.VISIBLE);
//                if (mRightTitleButton != 0) {
//                    ivRight.setImageResource(mRightTitleButton);
//                }
//                ivRight.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        rightTitleButtonClickListener.onClick(dialog, 1);
//                    }
//                });
//            } else {
//                ivRight.setVisibility(View.GONE);
//            }
//            /////////////////////////////////////
//            if (positiveButtonText != null && negativeButtonText != null) {
//                layout.findViewById(R.id.v_cut_line).setVisibility(View.VISIBLE);
//            }
//            if (positiveButtonText == null && negativeButtonText == null) {
//                layout.findViewById(R.id.ll_button_list).setVisibility(View.GONE);
//            }
//            // set the confirm button
//            if (positiveButtonText != null) {
//                Button btnPositive = (Button) layout.findViewById(R.id.positiveButton);
//                btnPositive.setText(positiveButtonText);
//                btnPositive.setTextColor(mPositiveButtonColor);
//                if (positiveButtonClickListener != null) {
//                    btnPositive.setOnClickListener(new View.OnClickListener() {
//                        public void onClick(View v) {
//                            positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
//                        }
//                    });
//                }
//            } else {
//                // if no confirm button just set the visibility to GONE
//                layout.findViewById(R.id.positiveButton).setVisibility(View.GONE);
//            }
//            // set the cancel button
//            if (negativeButtonText != null) {
//                Button negtiveButton = (Button) layout.findViewById(R.id.negativeButton);
//                negtiveButton.setText(negativeButtonText);
//                negtiveButton.setTextColor(mNegtiveButtonColor);
//                if (negativeButtonClickListener != null) {
//                    ((Button) layout.findViewById(R.id.negativeButton)).setOnClickListener(new View.OnClickListener() {
//                        public void onClick(View v) {
//                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
//                        }
//                    });
//                }
//            } else {
//                // if no confirm button just set the visibility to GONE
//                layout.findViewById(R.id.negativeButton).setVisibility(View.GONE);
//            }
//            //是否显示close
//            if (mIsShowClose) {
//                ImageView closeDialogButton = (ImageView) layout.findViewById(R.id.close);
//                closeDialogButton.setVisibility(View.VISIBLE);
//
//                closeDialogButton.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        if (closeButtonCickListener == null) {
//                            dialog.dismiss();
//                        } else {
//                            closeButtonCickListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
//                        }
//
//                    }
//                });
//            } else {
//                ImageView closeDialogButton = (ImageView) layout.findViewById(R.id.close);
//                closeDialogButton.setVisibility(View.GONE);
//            }
//            // set items
//            if (items != null && items.length > 0) {
//                ListView itemsListView = ((ListView) layout.findViewById(R.id.items));
//                itemsListView.setVisibility(View.VISIBLE);
//                mAdapter = new DialogListAdapter(context, items, index);
//                if ( null != mFooterView){
//                    itemsListView.addFooterView(mFooterView);
//                }
//                itemsListView.setAdapter(mAdapter);
//                itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                        itemsClickListener.onClick(dialog, arg2);
//                    }
//                });
//            } else {
//                if (mAdapter != null) {
//                    ListView itemsListView = ((ListView) layout.findViewById(R.id.items));
//                    itemsListView.setVisibility(View.VISIBLE);
//                    if ( null != mFooterView){
//                        itemsListView.addFooterView(mFooterView);
//                    }
//                    itemsListView.setAdapter(mAdapter);
//                    itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                            itemsClickListener.onClick(dialog, arg2);
//                        }
//                    });
//                } else {
//                    ((ListView) layout.findViewById(R.id.items)).setVisibility(View.GONE);
//                }
//            }
//            // set the content message
//            if (message != null) {
//                TextView msg = ((TextView) layout.findViewById(R.id.message));
//                msg.setVisibility(View.VISIBLE);
//                msg.setText(message);
//            } else if (contentView != null) {
//                // if no message set
//                // add the contentView to the dialog body
//                LinearLayout rav = (LinearLayout) layout.findViewById(R.id.body_content);
//                rav.removeAllViews();
//                rav.setGravity(Gravity.CENTER);
//                LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//                rav.addView(contentView, params);
//
//            }
//            dialog.setContentView(layout);
//
//            Window dialogWindow = dialog.getWindow();
//
//            WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//            if (mWPercent >= WIDTH_PERCENT) {
//                p.width = (int) (MobileDeviceUtil.getDisplayWidth(context) * mWPercent); // 宽度设置为屏幕的0.85
//            }
//            if (mHPercent > HEIGHT_PERCENT) {
//                p.height = (int) (MobileDeviceUtil.getDisplayHeight(context) * mHPercent); // 宽度设置为屏幕的0.6
//            }
//            if (mDialogAnim > 0) {
//                dialogWindow.setWindowAnimations(mDialogAnim);
//            }
//            if (mGravity > 0) {
//                dialogWindow.setGravity(mGravity);
//            }
//            return dialog;
//        }
//
//    }
//
//    public static class DialogListAdapter extends BaseAdapter {
//        private String[] datas;
//        private int index = -1;
//        private Context ctx;
//        private DisplayMetrics densy;
//
//        public DialogListAdapter(Context context) {
//            this.ctx = context;
//        }
//
//        public DialogListAdapter(Context context, String[] d, int i) {
//            this.datas = d;
//            this.index = i;
//            this.ctx = context;
//            densy = ctx.getResources().getDisplayMetrics();
//        }
//
//        public void changeView(int arg2) {
//            index = arg2;
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public int getCount() {
//            return datas != null ? datas.length : 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return datas[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder holder;
//            if (convertView == null) {
//                holder = new ViewHolder();
//                convertView = View.inflate(ctx, R.layout.custom_dialog_base_list_item, null);
//                holder.llt_dialog_container = (LinearLayout) convertView.findViewById(R.id.llt_dialog_container);
//                holder.tv_text = (TextView) convertView.findViewById(R.id.tv_text);
//                holder.line = (ImageView) convertView.findViewById(R.id.line);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.tv_text.setText(datas[position]);
//            if (index == position) {
//                holder.tv_text.setSelected(true);
//                holder.tv_text.setPressed(true);
//            } else {
//                holder.tv_text.setSelected(false);
//                holder.tv_text.setPressed(false);
//            }
//            if (position == getCount() - 1) {
//                holder.line.setVisibility(View.GONE);
//            } else {
//                holder.line.setVisibility(View.VISIBLE);
//            }
//            return convertView;
//        }
//
//        class ViewHolder {
//            LinearLayout llt_dialog_container;
//            TextView tv_text;
//            ImageView line;
//        }
//    }
//
//    public OnKeyListener keylistener = new OnKeyListener() {
//        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    };
//}
