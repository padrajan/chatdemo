# chatdemo

A Sample application to demonstrate <b>@mention, emoticons and weburl</b> extraction from given text/message

Version : 1.0

What this app can do? 

   - Allows you to type text, get the text and parse of required values like @mentions, emoticons and weburl (http/https and http less urls)
   - get those , seggregate and print the values on new textview.
   - For website title, it will load the webside in WebView and get the title and update in link object.

Are we following MVC pattern?
   - Yes.
   - How?
      -> Whole UI/View elements are restricted into Activity
      -> Logical part is defined in ParserHanlder class
      -> Utility methods are defined in Utils class
      -> Without worrying about Views, Both ParserHandler and Utils will function. Both are POJO classes. 

Are we using <b>Google's Protocol Buffer</b> for data design? 
  
   - Yes.
   - Why & Why not JSON/GSON? 
   
      # As per requirement we have to provide json as output. But json/gson is too slow to handle in Android environment. So we are using Google's protocol buffer, construct data design using that and  store text data on this. 
      # Conversion between POJO to JSON is painstaking, While in Proto data is defined as POJO. 
      # Wire Transfer is faster in bytestream case than json/string.
      
   - What is protoBuf?
     
      *  Protocol Buffers are a way of encoding structured data in an efficient yet extensible format. They are language-neutral, platform-neutral, extensible mechanism for serializing structured data – think XML, but smaller, faster, and simpler
     
   
What we can expect in Version 2.0? 

    - Auto Suggesion List (popup) for @mention and emoticons
    - Render / Give Preview for Links once message sent.
    
    
    
   

