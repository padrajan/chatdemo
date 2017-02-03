package com.show.text;

import com.show.proto.Message;
import com.show.proto.Message.Builder;
import com.show.proto.Message.Link;

import java.util.Iterator;
import java.util.List;

/**
 * Created by padmanabha-1058 on 2/2/17.
 */

public class ParserHandler {

    private Message.Builder message = Message.newBuilder();
    private Utils utils = new Utils();
    private Callbacks callbacks;

    public Builder getMessage() {
        return message;
    }

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    public void addText(String inputString){
        if(message.getTextCount() > 0) {
            int index = message.getTextCount() -1;
            String text = message.getText(index);
            text = text+inputString;
            message.setText(index, text);
        }else{
            message.addText(inputString);
        }
    }

    public void removeText(){
        if(message.getTextCount() > 0) {
            int index = message.getTextCount() - 1;
            String text = message.getText(index);
            if (text.length() > 0){
                text = text.substring(0, text.length() - 1);
            }
            message.setText(index, text);
        }else{
            message.clearText();
        }
    }

    public void space(){
        message.addText("");
    }

    public void checkMessage(Message.Builder message, int time){
        List<String> words = message.getTextList();
        Iterator<String> stringIterator = words.iterator();
        while (stringIterator.hasNext()){
            String word= stringIterator.next();
            if(!checkForWebUrl(word)) {
                checkForEmoji(word);
                checkForMention(word);
            }
        }
        callbacks.printThread(time); // FIXME: 2/2/17
    }

    private boolean checkForWebUrl(String text){
        if(utils.checkForWebUrl(text)){
            callbacks.checkForWebTitle(text);
            return true;
        }
        return false;
    }

    public void checkForMention(String text){
        if(utils.checkForMention(text)) {
            message.addMention(text.substring(1));
        }
    }

    public void checkForEmoji(String text){
        if(utils.checkForEmoji(text)){
            message.addEmoticon(text.substring(1, text.length()-1));
        }
    }

    public void updateLink(String title, String url) {
        Link.Builder link = Link.newBuilder();
        link.setTitle(title);
        link.setUrl(url);
        message.addLink(link);
    }
}