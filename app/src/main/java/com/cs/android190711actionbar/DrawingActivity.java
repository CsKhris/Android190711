package com.cs.android190711actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingActivity extends AppCompatActivity {

    // 점의 좌표를 저장할 변수
    class Vertex{
        float x;
        float y;
        boolean isDraw;

        Vertex(float x, float y, boolean isDraw){
            this.x = x;
            this.y = y;
            this.isDraw = isDraw;
        }
    }

    // 점의 좌표를 저장할 변수
    ArrayList<Vertex> list;

    // 화면에서 Touch를 하고 Drag 하면 선을 그려주는 View
    class MyCustomView extends View{
        // 그리기 정보를 저장할 변수
        Paint paint;

        // 생성자
        MyCustomView(Context context){
            // 상위 Class의 생성자 호출
            super(context);

            // 그리기 정보를 저장할 객체를 생성하고 Option 설정
            paint = new Paint();
            paint.setColor(Color.CYAN);
            paint.setStrokeWidth(10);
        }

        // 화면에 보여질 때 호출되는 Method - 그림을 그립니다.
        @Override
        public void onDraw(Canvas canvas){

            /*
            // 모든 점들을 순회하면서 홀수 번째 좌표에서 짝수 번째로 선을 그리면 됩니다.
            // isDraw 값을 확인하여 true인 경우 이전 좌표에서 현재 좌표까지 선을 그리면 됩니다.
            int len = list.size();
            for(int i=0 ; i<len ; i=i+1){
                if(list.get(i).isDraw == true){
                    canvas.drawLine(list.get(i-1).x, list.get(i-1).y,
                            list.get(i).x, list.get(i).y, paint);
                }
            }

            // Image를 반대로 출력하기
            Paint paint = new Paint();

            // Resource로 추가한 image1.png File을 가지고 Bitmap 만들기
            Resources resources = getResources();
            Bitmap bit = BitmapFactory.decodeResource(resources, R.drawable.irin);

            // 위의 Bitmap 출력
            //canvas.drawBitmap(bit, 0, 0, null);

            // 크기는 곱하기 '1', 좌표는 더하기 '0', 회전은 더하기 '0'
            Matrix matrix = new Matrix();
            matrix.setScale(0.4f, 0.4f);
            //matrix.setRotate(70.0f);
            Bitmap editBitmap = Bitmap.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), matrix, false);
            canvas.drawBitmap(editBitmap, 10, 10, paint);

            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.STROKE);

            // Path 만들기
            Path path = new Path();
            path.moveTo(100, 900); // 원점 이동
            path.cubicTo(80, 700, 300, 700, 500, 700); // 곡선
            canvas.drawPath(path, paint);

            // Path 위에 글자 출력
            paint.setTextSize(30);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text", path, 0, 0, paint);
            */

            Paint paint = new Paint();

            // Image 생성
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.irin);

            // Color Filter 생성
            ColorFilter filter = new LightingColorFilter(0xff0000, 0x000000);

            paint.setColorFilter(filter);

            // Image 출력
            canvas.drawBitmap(bitmap, 10, 10, paint);

        }

        // Touch Event가 발생했을 때 호출될 Method
        public boolean onTouchEvent(MotionEvent event){
            // Touch가 시작된 경우에는 좌표만 저장 합니다.
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                list.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            // Touch를 이동시킬 때는 좌표를 저장하고 다시 그려달라고 요청
            if(event.getAction() == MotionEvent.ACTION_MOVE){
                list.add(new Vertex(event.getX(), event.getY(), true));

                // 다시 출력하도록 초기화
                invalidate();
                return true;
            }
            return false;
        }
    }

    class MyView extends View {
        // 기본 생성자가 없기 때문에 생성자를 만들어서 상위 Class의 생성자를 직접 호출해야 합니다.
        public MyView(Context context){
            super(context);
        }

        // View가 화면에 출력될 때 View를 그려주는 Method
        @Override
        public void onDraw(Canvas canvas){
            // 그림을 그릴 때는 그리기 정보를 저장할 Paint 객체가 필요 합니다.
            Paint paint = new Paint();
            paint.setColor(Color.CYAN);
            canvas.drawCircle(300, 300, 100, paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drawing);

        // 직접 만든 View가 화면에 출력
        //MyView view = new MyView(DrawingActivity.this);
        //setContentView(view);

        MyCustomView view = new MyCustomView(DrawingActivity.this);
        setContentView(view);
        list = new ArrayList<>();
    }
}
