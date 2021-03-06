package lukelunix.ntnugo.coursehelp.courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import lukelunix.ntnugo.R;
import lukelunix.ntnugo.helpclasses.InternetConnection;
import lukelunix.ntnugo.helpclasses.InternetConnectionAlertDialog;
import lukelunix.ntnugo.mainmenu.MainActivity;

public class CoursesActivity extends AppCompatActivity {

    private WebView webview;
    private InternetConnection ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        webview = (WebView) findViewById(R.id.webviewcourses);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);

        webview.loadUrl("http://www.ntnu.no/studier/emnesok#semester=2015&faculty=-1&institute=-1&multimedia=false&english=false&phd=false&courseAutumn=false&courseSpring=false&courseSummer=false&pageNo=1&season=spring&sortOrder=ascTitle");
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //Add home menu button to actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.homewhite);

        Toast.makeText(getApplicationContext(), "Loading...",
                Toast.LENGTH_SHORT).show();

        //Check for Internet connection
        ic = new InternetConnection(this);
        if( !ic.isNetworkAvailable() ){
            InternetConnectionAlertDialog.showNoInternetConnectionAlertDialog(this);
        }
    }

    //Return to Main Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}