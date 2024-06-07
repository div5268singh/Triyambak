import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;

public class TrackerPage extends Activity {

  // @Override
  private WebView webview;
  private ProgressDialog progressDialog;

  private boolean error;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Get rid of the android title bar
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    // Set the XML layout
    setContentView(R.layout.tracker_page);

    // Bundle objectbundle = this.getIntent().getExtras();
    webview = (WebView) findViewById(R.id.tracker);

    final Activity activity = this;

    // Enable JavaScript and lets the browser go back
    webview.getSettings().setJavaScriptEnabled(true);
    webview.canGoBack();

    webview.setWebViewClient(new WebViewClient() {
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }

      public void onLoadResource(WebView view, String url) {
        // Check to see if there is a progress dialog
        if (progressDialog == null) {
          // If no progress dialog, make one and set message
          progressDialog = new ProgressDialog(activity);
          progressDialog.setMessage("Loading please wait...");
          progressDialog.show();

          // Hide the webview while loading
          webview.setEnabled(false);
        }
      }

      public void onPageFinished(WebView view, String url) {
        // Page is done loading;
        // hide the progress dialog and show the webview
        if (progressDialog.isShowing()) {
          progressDialog.dismiss();
          progressDialog = null;
          webview.setEnabled(true);
        }
      }

    });

    // The URL that webview is loading
    webview.loadUrl("http://url.org/");
  }
}