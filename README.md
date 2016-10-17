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

## Authorize Module 
This module should connect application and API on Tabata Server.


Usage


```java
AuthorizeManager authorize = new AuthorizeManager.Builder()
                                                 .setIntegrationId("12345678")
                                                 .build(getApplicationContext ());
                                                 
                                                 
authorize.startAuthorization(getApplicationContext ());    
```       

* setIntegrationId() - integration ID of application (can't be empty necessary);
* setPhone() - user phone (not necessary);
* setLocalized()  - locale of application ( don't work now);
* setAdditionalUserData() - additional data (not necessary);
* putCustomStyle() - custom style, apply for all same item's in module;


## AdditionalData 

It's custom field of user profile will be sent to the Tabata server.

```java
final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
list.add(new AdditionalDataModel("color", "red", AdditionalDataModel.NO_VALIDATION));
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

## Custom styles

In total all screens in authorize module has 8 type of elements:

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
if the user doesn’t want change some params, the user shan't sets it up. Like: 
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

## Setting Local doesn't work in this version. 
