package com.adnor.app;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends Activity {
    private static final String ADNOR_URL = "https://aadnor.onrender.com/";
    private boolean launchedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildLauncherScreen();
        if (savedInstanceState == null) {
            openAdnor();
        }
    }

    private void buildLauncherScreen() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 48, 48, 48);
        root.setBackgroundColor(Color.rgb(2, 2, 8));

        TextView crown = new TextView(this);
        crown.setText("♛");
        crown.setTextSize(54);
        crown.setTextColor(Color.rgb(212, 175, 55));
        crown.setGravity(Gravity.CENTER);
        root.addView(crown);

        TextView title = new TextView(this);
        title.setText("ADNOR");
        title.setTextSize(42);
        title.setTextColor(Color.rgb(244, 211, 94));
        title.setGravity(Gravity.CENTER);
        title.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        root.addView(title);

        TextView sub = new TextView(this);
        sub.setText("اضغط فتح ADNOR للدخول للتطبيق");
        sub.setTextSize(16);
        sub.setTextColor(Color.WHITE);
        sub.setGravity(Gravity.CENTER);
        sub.setPadding(0, 22, 0, 28);
        root.addView(sub);

        Button open = new Button(this);
        open.setText("فتح ADNOR");
        open.setTextSize(18);
        open.setTextColor(Color.BLACK);
        open.setBackgroundColor(Color.rgb(212, 175, 55));
        open.setOnClickListener(v -> openAdnor());
        root.addView(open, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        TextView note = new TextView(this);
        note.setText("هذه النسخة تستخدم متصفحًا آمنًا حتى يعمل تسجيل الدخول عبر Google بشكل صحيح.");
        note.setTextSize(12);
        note.setTextColor(Color.rgb(180, 180, 180));
        note.setGravity(Gravity.CENTER);
        note.setPadding(0, 28, 0, 0);
        root.addView(note);

        setContentView(root);
    }

    private void openAdnor() {
        Uri uri = Uri.parse(ADNOR_URL);
        try {
            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                    .setShowTitle(false)
                    .setToolbarColor(Color.rgb(2, 2, 8))
                    .setNavigationBarColor(Color.BLACK)
                    .setUrlBarHidingEnabled(true)
                    .build();
            customTabsIntent.intent.putExtra(Intent.EXTRA_REFERRER, Uri.parse("android-app://" + getPackageName()));
            customTabsIntent.launchUrl(this, uri);
            launchedOnce = true;
        } catch (ActivityNotFoundException ex) {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(this, "تعذر فتح ADNOR. تأكد من وجود متصفح على الجهاز.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
