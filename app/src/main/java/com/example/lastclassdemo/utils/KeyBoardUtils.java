package com.example.lastclassdemo.utils;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.lastclassdemo.R;

/**
 * @author SpreadWater
 * @Date 2020-12-02
 * @Time 21:43
 * @description
 */
public class KeyBoardUtils {
    private final Keyboard k1;//自定义的键盘
    private KeyboardView keyboardView;
    private EditText editText;

    public interface OnEnsureListener{
        public void onEnsure();
    }
    private OnEnsureListener onEnsureListener;

    //传入一个接口对象，接口对象的onEnsure方法就可以被调用
    public void setOnEnsureListener(OnEnsureListener onEnsureListener) {
        this.onEnsureListener = onEnsureListener;
    }

    public KeyBoardUtils(KeyboardView keyboardView, EditText editText) {
        this.keyboardView = keyboardView;
        this.editText = editText;
        this.editText.setInputType(InputType.TYPE_NULL);//取消弹出系统键盘
        k1 = new Keyboard(this.editText.getContext(), R.xml.key);
//        设置要显示的键盘
        this.keyboardView.setKeyboard(k1);
        this.keyboardView.setEnabled(true);
        this.keyboardView.setPreviewEnabled(false);

        this.keyboardView.setOnKeyboardActionListener(listener);//设置键盘被点击的监听
    }

    KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int i) {
        }

        @Override
        public void onRelease(int i) {
        }

        @Override
        public void onKey(int i, int[] ints) {
            Editable editable = editText.getText();
            int start = editText.getSelectionStart();
            //被选中的ASC码
            switch (i) {
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start>0){
                            editable.delete(start-1,start);
                        }
                    }
                    break;//点击了删除键
                case Keyboard.KEYCODE_CANCEL://点击了清零
                    editable.clear();
                    break;
                case Keyboard.KEYCODE_DONE://点击了完成
                    //接口回调，传回数据
                    onEnsureListener.onEnsure();
                    break;
                default:
                    editable.insert(start, Character.toString((char) i));//其他的数字直接插入
                    break;
            }
        }

        @Override
        public void onText(CharSequence charSequence) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };
    //显示键盘的方法
    public void showKeyboard(){
        int visibility=keyboardView.getVisibility();
        if (visibility== View.INVISIBLE||visibility==View.GONE){
            keyboardView.setVisibility(View.VISIBLE);
        }
    }

    //隐藏键盘
    public void hideKeyboard(){
        int visibility=keyboardView.getVisibility();
        if (visibility==View.VISIBLE||visibility==View.INVISIBLE){
            keyboardView.setVisibility(View.GONE);
        }
    }
}
