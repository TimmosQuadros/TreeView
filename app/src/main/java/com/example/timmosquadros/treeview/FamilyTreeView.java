package com.example.timmosquadros.treeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TimmosQuadros on 13-01-2018.
 */

public class FamilyTreeView extends ConstraintLayout {

    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;
    private Paint _paintDoodle = new Paint();
    private Path _path = new Path();
    ConstraintSet set = new ConstraintSet();

    public FamilyTreeView(Context context) {
        super(context);
        mScaleDetector = new ScaleGestureDetector(context, new FamilyTreeView.ScaleListener());
        init(null,0);
    }

    public FamilyTreeView(Context context, AttributeSet attrs){
        super(context,attrs);
        mScaleDetector = new ScaleGestureDetector(context, new FamilyTreeView.ScaleListener());
        init(attrs,0);
    }

    public FamilyTreeView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        mScaleDetector = new ScaleGestureDetector(context, new FamilyTreeView.ScaleListener());
        init(attrs,defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        _paintDoodle.setColor(Color.RED);
        _paintDoodle.setAntiAlias(true);
        addNode();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float touchX = ev.getX();
        float touchY = ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                _path.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                _path.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);

        invalidate();
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);

        //onDraw() code goes here
        canvas.drawPath(_path, _paintDoodle);

        canvas.restore();
    }

    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

            invalidate();
            return true;
        }
    }

    private void addNode(){

        FamilyNodeView node = new FamilyNodeView(getContext());

        this.addView(node,0);
        set.clone(this);
        set.connect(node.getId(),ConstraintSet.TOP,this.getId(),ConstraintSet.TOP,1);
        set.applyTo(this);

        node.requestLayout();
        node.getLayoutParams().height = 250;
        node.getLayoutParams().width = 200;
    }
}
