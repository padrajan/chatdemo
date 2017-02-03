package com.chat.demo;

/**
 * Created by padmanabha-1058 on 2/2/17.
 */

public class Dummy {






    /*
  private void updateLinkData(String title, String url){
        Link.Builder link = Link.newBuilder();
        link.setTitle(title);
        link.setUrl(url);
        message.addLink(link);
    }

    private boolean checkForWebUrl(String text){
        boolean isURL = android.util.Patterns.WEB_URL.matcher(text).matches();
        if(isURL){
            checkForWebTitle(text);
            return true;
        }
        return false;
    }


    private void checkForWebTitle(final String url){

        WebView myWebView = new WebView(this);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!TextUtils.isEmpty(title)) {
                    updateLinkData(title, url);
                }
            }
        });

        try {
            myWebView.loadUrl(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void checkForEmoji(String text){
        Pattern regex = Pattern.compile("\\((.*?)\\)");
        Matcher regexMatcher = regex.matcher(text);
        while (regexMatcher.find()) {
            message.addEmoticon(regexMatcher.group(1));
        }
    }
       private void checkForMention(String text){
       // Pattern regex = Pattern.compile("@\\s*(\\w+)");
       // Matcher regexMatcher = regex.matcher(text);
       // while (regexMatcher.find()) {//Finds Matching Pattern in String
        if(utils.checkForMention(text)) {
            message.addMention(text.substring(1));
        }
       // }
    }
    */
}
