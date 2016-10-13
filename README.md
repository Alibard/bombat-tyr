## Tabata SDK

#Initializa SDK

To properly work SKD need be initialized
```java
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        TabatoSDK.Initialize(this);
    }
}
```

###Authorize Module 
This module should connect application and API on Tabata Server.


Usage


```java
AuthorizeManager autorize = new AuthorizeManager.AuthorizeManagerBuilder()
                                                 .setmIntegrationId("12345678")
                                                 .build();
                                                 
                                                 
 autorize.startAuthorization(new OnErrorListener() {
                    @Override
                    public void OnError(String message) {
                        Log.i(TAG, "OnError: " + message);
                    }
                }, new OnSuccessListener() {
                    @Override
                    public void OnSuccess(String message) {
                        Log.i(TAG, "OnSuccess: " + message);
                    }
                });    
```       

## AdditionalData 

It's custom fiels of user profile will be sent to the Tabat server.

```java
 final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
 list.add(new AdditionalDataModel("color", "read", AdditionalDataModel.NO_VALIDATION));
```
Where: color - it's value name, read - it's value, AdditionalDataModel.NO_VALIDATION - it's type.

Example of adding list of additional data to SDK.

```java
final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
list.add(new AdditionalDataModel("color", "read", AdditionalDataModel.NO_VALIDATION));

AuthorizeManager autorize = new AuthorizeManager.AuthorizeManagerBuilder()
                        .setmIntegrationId("12345678")
                        .setAdditionalUserData(list)
                        .build();
```   

# Custom syles

SDK has 8 type of elemnts:
 * TITLE
 * BUTTON
 * MESSAGE
 * EDIT_FIELD
 * MAIN_LAYOUT
 * PHONE_TITLE
 * PHONE_PREFIX
 * TEXT_BUTTON
 
 Example of adding Custom style  to SDK.
 
 ```java
 CustomStyle myStyle1 = new CustomStyle(getResources().getColor(R.color.bg)
                ,getResources().getDimension(R.dimen.header)
                ,type
                ,getResources().getColor(R.color.textColor)
                , CustomStyle.Type.MESSAGE);
.......
.......

   final ArrayList<CustomStyle> styles = new ArrayList<>();
   styles.add(myStyle);
   
                AuthorizeManager autorize = new AuthorizeManager.AuthorizeManagerBuilder()
                        .setmIntegrationId("12345678")
                        .setCustomStyle(styles)
                        .build();
  ```                      
  
 Field what you don't want change set as 0. But typeFace should be null to set default value.
 
   ```java
 CustomStyle myStyle1 = new CustomStyle(0
                ,0
                ,type
                ,getResources().getColor(R.color.textColor)
                , CustomStyle.Type.MESSAGE);
.......
  
  
