package com.example.timmosquadros.treeview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by TimmosQuadros on 13-01-2018.
 */

public class FamilyNodeView extends android.support.v7.widget.AppCompatImageView{

    private String imageUrl;

    public FamilyNodeView(Context context) {
        super(context);
        init(null,0);
    }

    public FamilyNodeView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(attrs,0);
    }

    public FamilyNodeView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        init(attrs,defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        //Network operations need to run on another thread than the main thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    Drawable d = drawable_from_url("http://cdn1-www.craveonline.com/assets/mandatory/legacy/2016/04/man_file_1066769_matthewmccotimetraveler2.jpg");
                    setImageDrawable(d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Drawable frame = ResourcesCompat.getDrawable(getResources(),R.drawable.frame,null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setForeground(frame);
        }
        setScaleType(ScaleType.FIT_END);


    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float touchX = ev.getX();
        float touchY = ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        //onDraw() code goes here

        canvas.restore();
    }

    public Drawable drawable_from_url(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            Log.d("Abe",d.toString() + " abe");
            return d;
        } catch (Exception e) {
            Log.d("Abe",e.toString()+" abe e");
            return null;
        }
    }
}
