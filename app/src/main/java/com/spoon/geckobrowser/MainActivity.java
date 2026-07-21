package com.spoon.geckobrowser;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {
    private GeckoView geckoView;
    private GeckoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        geckoView = new GeckoView(this);
        setContentView(geckoView);

        session = new GeckoSession();
        session.open(new GeckoSession.Settings());
        geckoView.setSession(session);
        session.loadUri("https://duckduckgo.com");   // start page
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (session != null) {
            session.close();
        }
    }
}
