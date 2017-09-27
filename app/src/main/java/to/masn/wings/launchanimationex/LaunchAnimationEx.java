package to.masn.wings.launchanimationex;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by 4163208 on 2017/09/26.
 */

public class LaunchAnimationEx extends Activity implements View.OnClickListener{
    private final static int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final static String TAG_DEFAULT = "default";
    private final static String TAG_SCALEUP = "scaleup";
    private final static String TAG_THUMBNAIL = "thumbnai";
    private final static String TAG_CUSTOM = "costom";
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        layout.addView(makeButton("デフォルト", TAG_DEFAULT));
        layout.addView(makeButton("スケールアップ", TAG_SCALEUP));
        layout.addView(makeButton("サムネイルスケールアップ", TAG_THUMBNAIL));
        layout.addView(makeButton("カスタム", TAG_CUSTOM));

    }

    private Button makeButton(String text,String tag) {
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        return button;
    }
    public void onClick(View view){
        String tag = (String)view.getTag();
        if(TAG_DEFAULT.equals(tag)){
            Intent intent = new Intent (this,MainActivity.class);
            startActivity(intent);
        }
        else if(TAG_SCALEUP.equals(tag)){
            ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(view,0,0,view.getWidth(),view.getHeight());
            startActivity(new Intent(this,MainActivity.class),opts.toBundle());
        }
        else if(TAG_THUMBNAIL.equals(tag)){
            view.setDrawingCacheEnabled(true);
            view.setPressed(false);
            view.refreshDrawableState();
            Bitmap bmp = view.getDrawingCache();

            ActivityOptions opts = ActivityOptions.makeCustomAnimation(this,R.anim.zoom_enter,R.anim.zoom_exit);
            startActivity(new Intent(this,MainActivity.class),opts.toBundle());
            view.setDrawingCacheEnabled(false);
        }
        else if(TAG_CUSTOM.equals(tag)){
            ActivityOptions opts = ActivityOptions.makeCustomAnimation(this,R.anim.zoom_enter,R.anim.zoom_exit);
            startActivity(new Intent(this,MainActivity.class),opts.toBundle());
        }
    }
}