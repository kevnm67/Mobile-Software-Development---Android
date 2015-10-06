package kevinmorton.com.permission;

/**
 * Created by KevinMortonMacPro on 10/5/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class InternetActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet);
        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");
    }
}