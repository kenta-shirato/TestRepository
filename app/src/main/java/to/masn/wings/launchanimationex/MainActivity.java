package to.masn.wings.launchanimationex;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private  final static int MP = ViewGroup.LayoutParams.MATCH_PARENT;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(res2bmp(this,R.drawable.sample));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(MP,MP));
        layout.addView(imageView);
    }
    public static Bitmap res2bmp(Context context, int resID){
        return BitmapFactory.decodeResource(
                context.getResources(),resID
        );
    }
}
