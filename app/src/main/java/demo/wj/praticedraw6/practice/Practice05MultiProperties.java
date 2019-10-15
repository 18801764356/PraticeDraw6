package demo.wj.praticedraw6.practice;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import demo.wj.praticedraw6.R;
import demo.wj.praticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private boolean flag = false;
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                if(flag){
                    imageView.animate().translationX(Utils.dpToPixel(0))
                            .rotation(-360)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0);
                    flag = false;
                }else{
                    imageView.animate().translationX(Utils.dpToPixel(200))
                            .rotation(360)
                            .scaleX(1)
                            .scaleY(1)
                            .alpha(1);
                    flag = true;
                }
            }
        });
    }
}
