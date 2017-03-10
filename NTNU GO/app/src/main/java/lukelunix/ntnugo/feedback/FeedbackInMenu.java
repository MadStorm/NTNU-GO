package lukelunix.ntnugo.feedback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

/**
 * Created by Luka on 08.03.2016.
 */
public class FeedbackInMenu {

    private final static String APP_TITLE = "NTNU GO";// App Name


    public void showFeedbackDialog(final Context mContext) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle("Feedback " + APP_TITLE);




        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(mContext);
        textView.setText("If you enjoy using " + APP_TITLE + ", please take a moment to rate it.\n Thanks for your support!");
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(getScreenWidth());
        textView.setHeight(getScreenHeight()/4);
        //textView.setPadding(10,10,10,10);
        layout.addView(textView);



        /*
        Button b1 = new Button(mContext);
        b1.setText("Give feedback Google Survey");
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://goo.gl/forms/RgQn8kbc2u")));
                // dialog.dismiss();
            }
        });
        layout.addView(b1);*/

        Button b2 = new Button(mContext);
        b2.setText("Rate " + APP_TITLE);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=lukelunix.ntnumple")));
                // dialog.dismiss();
            }
        });
        layout.addView(b2);

        Button b4 = new Button(mContext);
        b4.setText("No, thanks");
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        layout.addView(b4);

        dialog.setContentView(layout);
        dialog.show();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
