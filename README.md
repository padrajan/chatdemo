# chatdemo

A Sample application to demonstrate <b>@mention, emoticons and weburl</b> extraction from given text/message

Version 1.0

What this app can do ? 

   - Allows you to type text, get the text and parse of required values like @mentions, emoticons and weburl (http/https and http less urls)
   - get those , seggregate and print the values on new textview.
   - For website title, it will load the webside in WebView and get the title and update in link object.

Are we following MVC pattern ?
   - yes
   - How ?
   

Are we using <b>Google's Protocol Buffer</b> for data design ? 
  
   - yes.
   
   Why and Why not JSON/GSON? 
   
      As per requirement we have to provide json as output. But json/gson is too slow to handle in Android environment. So we are using
      Google's protocol buffer, construct data design using that and  store text data on this.
   
   Few points about protoBuf :-
   
   
What we can expect in Version 2.0 ? 

    - Auto Suggesion List (popup) for @mention and emoticons
    - Render / Give Preview for Links once message sent.
    
    
    
   

