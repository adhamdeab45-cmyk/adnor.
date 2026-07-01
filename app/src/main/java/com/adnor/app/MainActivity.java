package com.adnor.app;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final String ADNOR_URL = "https://aadnor.onrender.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLauncherScreen();
        openAdnorSecureBrowser();
    }

    private void showLauncherScreen() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(40, 40, 40, 40);
        root.setBackgroundColor(Color.rgb(2, 2, 8));

        TextView logo = new TextView(this);
        logo.setText("ADNOR");
        logo.setTextColor(Color.rgb(212, 175, 55));
        logo.setTextSize(42);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, 1);

        TextView msg = new TextView(this);
        msg.setText("جاري فتح التطبيق بأمان...");
        msg.setTextColor(Color.WHITE);
        msg.setTextSize(18);
        msg.setGravity(Gravity.CENTER);
        msg.setPadding(0, 25, 0, 25);

        Button btn = new Button(this);
        btn.setText("فتح ADNOR");
        btn.setTextSize(16);
        btn.setOnClickListener(v -> openAdnorSecureBrowser());

        root.addView(logo);
        root.addView(msg);
        root.addView(btn);
        setContentView(root);
    }

    private void openAdnorSecureBrowser() {
        Uri uri = Uri.parse(ADNOR_URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Prefer Chrome when installed, because Google login accepts it as a secure browser.
        Intent chromeIntent = new Intent(intent);
        chromeIntent.setPackage("com.android.chrome");
        try {
            startActivity(chromeIntent);
            return;
        } catch (ActivityNotFoundException ignored) { }

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Keep launcher screen visible if no browser exists.
        }
    }
}
