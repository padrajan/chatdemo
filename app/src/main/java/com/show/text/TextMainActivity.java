package com.show.text;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


public class TextMainActivity extends AppCompatActivity implements Callbacks {

    private TextView printView;
    private EditText es;
    private ImageView bs;
    private ParserHandler parserHandler = new ParserHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        es = (EditText) findViewById(R.id.messageBox);
        bs = (ImageView) findViewById(R.id.sendMsg);
        printView = (TextView) findViewById(R.id.messageView);
        setButtonClick(bs);
        setInputFilter(es);
        parserHandler.setCallbacks(this);
    }

    private void setButtonClick(final ImageView btn){

        btn.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btn.setBackgroundColor(Color.RED);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        btn.setBackgroundColor(Color.TRANSPARENT);
                        es.setText("");
                        parserHandler.checkMessage(parserHandler.getMessage(), 1000);
                        break;
                    }
                }
                return true;
            }
        });
    }

    private void setInputFilter(EditText editText) {

        InputFilter inputFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                int sourceStart = start;
                int sourceEnd = end;
                int destStart = dstart;
                int destEnd = dend;

                while (sourceStart != sourceEnd && destStart != destEnd) {
                    if (source.charAt(sourceStart) - dest.charAt(destStart) == 0) {
                        sourceStart++;
                        destStart++;
                    } else {
                        break;
                    }
                }
                String inputString = source.subSequence(sourceStart, sourceEnd).toString();

                if(Objects.equals(inputString, " ")){       //space
                    parserHandler.space();
                }else if(Objects.equals(inputString, "")){      //delete
                    parserHandler.removeText();
                }else if(Objects.equals(inputString, "\n")){        //enter
                    parserHandler.addText("\n");
                }else {
                    parserHandler.addText(inputString);
                }

                return null;
            }
        };

        editText.setFilters(new InputFilter[]{inputFilter});
    }

    //view specific code
    @Override
    public void checkForWebTitle(final String url){

        WebView myWebView = new WebView(this);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!TextUtils.isEmpty(title)) {
                    parserHandler.updateLink(title, url);
                }
            }
        });

        try {
            String ss = url;
            if(!URLUtil.isHttpUrl(url)) {
                ss = "http://"+url;
            }
            myWebView.loadUrl(ss);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void printThread(final int time) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                printView.setVisibility(View.VISIBLE);
                printView.setText("");
                printView.setText(parserHandler.getMessage().build().toString());
                if(time !=0) {
                    parserHandler.getMessage().clear();
                }
            }
        }, time);
    }
}