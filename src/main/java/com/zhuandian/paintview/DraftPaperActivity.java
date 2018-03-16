package com.zhuandian.paintview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.ccpaintview.view.CcPaintView;

/**
 * desc :草稿纸公用Activity
 * author：xiedong
 * data：2018/3/5
 */
public class DraftPaperActivity extends Activity implements View.OnClickListener {

    private CcPaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);  //改为引用style设置
        setContentView(R.layout.activity_draftpaper);
        initView();
    }

    private void initView() {
        RelativeLayout rootView = (RelativeLayout) findViewById(R.id.rootView);
        rootView.getBackground().setAlpha(150);
        paintView = (CcPaintView) findViewById(R.id.paintView);
        paintView.setPenSize(4);
        paintView.setGlobalPenFlag(false);
        paintView.setPenColor(Color.BLACK);
        paintView.setPenMode(CcPaintView.PEN_MODE_ALL);
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext);
        ImageButton btnPrivious = (ImageButton) findViewById(R.id.btnPrivious);
        ImageButton btnClear = (ImageButton) findViewById(R.id.btnClear);
        RadioButton whitePaint = ((RadioButton) findViewById(R.id.rb_white_paint));
        RadioButton blackPaint = (RadioButton) findViewById(R.id.rb_black_paint);
        RadioButton redPaint = (RadioButton) findViewById(R.id.rb_red_paint);
        RadioButton bluePaint = (RadioButton) findViewById(R.id.rb_blue_paint);
        RadioButton yellowPaint = (RadioButton) findViewById(R.id.rb_yellow_paint);

        whitePaint.setOnClickListener(this);
        blackPaint.setOnClickListener(this);
        redPaint.setOnClickListener(this);
        bluePaint.setOnClickListener(this);
        yellowPaint.setOnClickListener(this);

        btnClose.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrivious.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClose:
                this.finish();
                break;
            case R.id.btnNext:
                paintView.redo();
                break;
            case R.id.btnPrivious:
                paintView.undo();
                break;
            case R.id.btnClear:
                paintView.clearAll();
                break;
            case R.id.rb_black_paint:
                paintView.setPenColor(Color.BLACK);
                break;
            case R.id.rb_blue_paint:
                paintView.setPenColor(Color.parseColor("#00ffff"));
                break;
            case R.id.rb_red_paint:
                paintView.setPenColor(Color.RED);
                break;
            case R.id.rb_white_paint:
                paintView.setPenColor(Color.WHITE);
                break;
            case R.id.rb_yellow_paint:
                paintView.setPenColor(Color.YELLOW);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        paintView.recycle();
        System.gc();
    }
}
