package com.chat.demo;

import java.util.regex.Pattern;

/**
 * Created by padmanabha-1058 on 2/2/17.
 */

public class Utils {

    private static final String MENTION_REGX = "@\\s*(\\w+)";
    private static final String EMOTICON_REGX = "\\((.*?)\\)";
    private static final String URL_REGX = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[\u200C\u200Ba-z]{3}\\.([a-z]+)?$";

    public boolean checkForEmoji(String text){
        return Pattern.compile(EMOTICON_REGX).matcher(text).matches();
    }

    public boolean checkForMention(String text){
        return Pattern.compile(MENTION_REGX).matcher(text).matches();
    }

    public boolean checkForWebUrl(String text){
        return Pattern.compile(URL_REGX).matcher(text).matches();
    }
}