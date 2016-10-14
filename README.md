## Tabata SDK

#Initialize SDK

To properly work SKD need be initialized
```java
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        TabataSDK.Initialize(this);
    }
}
```

###Authorize Module 
This module should connect application and API on Tabata Server.


Usage


```java
AuthorizeManager authorize = new AuthorizeManager.Builder()
                                                 .setIntegrationId("12345678")
                                                 .build(getApplicationContext ());
                                                 
                                                 
 authorize.startAuthorization(getApplicationContext ());    
```       

## AdditionalData 

It's custom field of user profile will be sent to the Tabata server.

```java
 final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
 list.add(new AdditionalDataModel("color", "read", AdditionalDataModel.NO_VALIDATION));
```
Where: color - it's value name, red - it's value, AdditionalDataModel.NO_VALIDATION - it's type.

Example of adding list of additional data to SDK.

```java
final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
list.add(new AdditionalDataModel("color", "red", AdditionalDataModel.NO_VALIDATION));

AuthorizeManager authorize = new AuthorizeManager.Builder()
                        .setIntegrationId("12345678")
                        .setAdditionalUserData(list)
                        .build();
```   

# Custom styles

SDK has 8 type of elements:

 * TITLE
 * BUTTON
 * MESSAGE
 * EDIT_FIELD
 * MAIN_LAYOUT
 * PHONE_TITLE
 * PHONE_PREFIX
 * TEXT_BUTTON
 
 If you set some type of styles ( TITLE,BUTTON etc.) it will apply this setting for all elements of this type in this module (Authorize module).
 
 Example of adding Custom style  to SDK.
 
 ```java
final CustomStyle titleStyle = new CustomStyle.Builder(CustomStyle.Type.TITLE)
                .setBackgroundColor(getResources().getColor(R.color.bg))
                .setTextColor(getResources().getColor(R.color.textColor))
                .setTextSize(getResources().getDimension(R.dimen.header))
                .setTypeFace(type)
                .build();
                
final CustomStyle mainLayoutStyle = new CustomStyle.Builder(CustomStyle.Type.MAIN_LAYOUT)
                .setBackgroundColor(getResources().getColor(R.color.textColor))
                .build();
.......
.......

                AuthorizeManager autorize = new Builder()
                        .setIntegrationId("12345678")
                        .putCustomStyle(titleStyle)
                        .putCustomStyle(mainLayoutStyle)
                        .build(getApplicationContext ());
  ```                      
In case if user won't change some params hi don't setup it. Like : 
```java
final CustomStyle titleStyle = new CustomStyle.Builder(CustomStyle.Type.TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .build();
                  
         or
         
final CustomStyle titleStyle = new CustomStyle.Builder(CustomStyle.Type.TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .setTextColor(getResources().getColor(R.color.textColor))
                  .build();         
         
         or
         
final CustomStyle titleStyle = new CustomStyle.Builder(CustomStyle.Type.TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .setTextColor(getResources().getColor(R.color.textColor))
                  .setTypeFace(type)
                  .build();            

```

##Setting Local doesn't work in this version. 
  
 


