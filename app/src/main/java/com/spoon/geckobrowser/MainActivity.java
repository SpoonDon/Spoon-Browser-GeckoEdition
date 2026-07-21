package com.spoon.geckobrowser;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {
    private GeckoView geckoView;
    private GeckoSession session;
    private GeckoRuntime runtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        geckoView = new GeckoView(this);
        setContentView(geckoView);

        session = new GeckoSession();
        runtime = GeckoRuntime.create(this);
        
        session.open(runtime); // Correctly passes the runtime
        geckoView.setSession(session);
        session.loadUri("https://duckduckgo.com");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (session != null) {
            session.close();
        }
    }
}
