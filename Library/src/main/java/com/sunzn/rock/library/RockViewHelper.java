package com.sunzn.rock.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by sunzn on 2017/12/25.
 */

public class RockViewHelper {

    private static final int DEFAULT_SQUARE_CIRCLE_GAP = 2;
    private static final int DEFAULT_MIN_CIRCLE_RADIUS = 5;
    private static final int DEFAULT_MAX_CIRCLE_RADIUS = 15;
    private static final int DEFAULT_VER_CIRCLE_NUMBER = 12;
    private static final int DEFAULT_PER_CIRCLE_UPDATE = 150;
    private static final int DEFAULT_CIRCLE_FILL_COLOR = 0XFFFF0000;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            this.update();
            handler.postDelayed(this, circleUpdatePer);
        }

        void update() {
            view.postInvalidate();
        }
    };

    private Context context;
    private RackVew view;

    // RackVew 宽度
    private int viewWidth;

    // RackVew 高度
    private int viewHeight;

    // 圆的颜色
    private int circleFillColor;

    // 圆的最小半径
    private int circleMinRadius;

    // 圆的最大半径
    private int circleMaxRadius;

    // 圆和虚拟矩形的间距
    private int circleSquareGap;

    // 圆的虚拟容器宽高
    private int squareSize;

    // 圆的列数
    private int columnNums;

    // 垂直方向最多圆的数量
    private int circleNumberVer;

    // 界面刷新时间间隔
    private int circleUpdatePer;

    // RackVew 边距
    private int viewMargin;

    // 绘制圆的画笔
    private Paint circlePaint;

    private int[] points;

    public RockViewHelper(RackVew view, Context context, AttributeSet attrs, int defStyleAttr) {
        this.context = context;
        this.view = view;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RackVew, defStyleAttr, 0);
        circleMinRadius = a.getInteger(R.styleable.RackVew_rv_min_circle_radius, DEFAULT_MIN_CIRCLE_RADIUS);
        circleMaxRadius = a.getInteger(R.styleable.RackVew_rv_max_circle_radius, DEFAULT_MAX_CIRCLE_RADIUS);
        circleSquareGap = a.getInteger(R.styleable.RackVew_rv_gap_circle_square, DEFAULT_SQUARE_CIRCLE_GAP);
        circleNumberVer = a.getInteger(R.styleable.RackVew_rv_ver_circle_number, DEFAULT_VER_CIRCLE_NUMBER);
        circleUpdatePer = a.getInteger(R.styleable.RackVew_rv_per_circle_update, DEFAULT_PER_CIRCLE_UPDATE);
        circleFillColor = a.getInteger(R.styleable.RackVew_rv_circle_fill_color, DEFAULT_CIRCLE_FILL_COLOR);
        a.recycle();
        init();
    }

    private void init() {
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setDither(true);
        circlePaint.setColor(circleFillColor);
        circlePaint.setStyle(Paint.Style.FILL);
    }

    public void onSizeChanged(int w, int h) {
        Log.e("RackVew", "w = " + w);
        viewWidth = w;
        viewHeight = h;
        squareSize = (circleMaxRadius + circleSquareGap) * 2;
        columnNums = viewWidth / squareSize;
        viewMargin = viewWidth % squareSize;
        points = new int[columnNums];
    }

    public void onDraw(Canvas canvas) {
        for (int c = 1; c <= columnNums; c++) {

            int rows = 0;
            int n = c - 1;

            if (points[n] <= 0 || points[n] >= circleNumberVer) {
                rows = points[n] = RackViewRandom.randInt(1, circleNumberVer);
            } else {
                rows = points[n] = points[n] + 1;
            }

            for (int r = 1; r <= rows; r++) {
                canvas.drawCircle(getX(c), getY(r), getD(r), circlePaint);
            }
        }
    }

    private int getX(int c) {
        return (int) (viewMargin / 2 + (c - 0.5) * squareSize);
    }

    private int getY(int r) {
        return (int) (viewHeight - (r - 0.5) * squareSize);
    }

    private int getD(int r) {
        return circleMaxRadius - (circleMaxRadius - circleMinRadius) * (r - 1) / circleNumberVer;
    }

    public void start() {
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 350);
    }

    public void stop() {
        handler.removeCallbacks(runnable);
    }

}
