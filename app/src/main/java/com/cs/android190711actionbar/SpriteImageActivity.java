package com.cs.android190711actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class SpriteImageActivity extends AppCompatActivity {

    // 사용자 정의 View Class
    // 생성자를 재정의하여 상위 Class의 생성자를 호출해 주어야 합니다.
    // onDraw Method에 화면에 출력할 Code 작성
    class MyView extends View {
        public MyView(Context context){
            super(context);
        }

        // 화면에 보여질 때 화면에 그리는 Method
        public void onDraw(Canvas canvas){
            // Paint 객체 생성
            Paint paint = new Paint();

            // Canvas의 배경색 설정
            canvas.drawColor(Color.MAGENTA);

            // Resource File을 가지고 Bitmap 생성
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);

            // Image 출력
            // drawBitmap Method는 여러 형태로 Overloading 되어 있기 때문에
            // 원하는 만큼 잘라서 원하는 크기로 출력하는 Method도 소유하고 있습니다.
            // 이런 Method들을 이용하면 Image를 잘라서 출력할 수 있습니다.
            canvas.drawBitmap(bitmap, new Rect(0,0,260,260),
                    new Rect(0,0,260,260), paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sprite_image);
        MyView view = new MyView(SpriteImageActivity.this);
        setContentView(view);
    }
}
