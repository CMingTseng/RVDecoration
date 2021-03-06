package rv.daimhim.rvdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：rv.daimhim.rvdecoration
 * 项目版本：RVDecoration
 * 创建人：Daimhim
 * 创建时间：2017/11/10 16:08
 * 修改人：Daimhim
 * 修改时间：2017/11/10 16:08
 * 类描述：
 * 修改备注：
 */

public class LinearDecoration implements RecycleDecoration.DrawBeforeTarget,
        RecycleDecoration.MeasureTarget  {
    /**
     * 画笔
     */
    private Paint mPaint;
    private final int mSize;
    private final int mOrientation;
    private Rect mRect;
    protected LinearDecoration(Context pContext, @ColorRes int color,
                               @DimenRes int size, int orientation) {
        mSize = pContext.getResources().getDimensionPixelSize(size);
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mPaint.setColor(ContextCompat.getColor(pContext, color));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(mSize);
        mOrientation = orientation;
        mRect = new Rect();
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        View childAt;
        for (int i = 0; i < childCount; i++) {
            mRect.set(0,0,0,0);
            childAt = parent.getChildAt(i);
            getItemOffsets(mRect,childAt,parent,state);
            DrawHelp.drawLine(c,mRect, mPaint, childAt);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.set(0, 0, mSize, 0);
        } else {
            outRect.set(0, 0, 0, mSize);
        }
    }
}
