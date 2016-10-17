## Tabata Android SDK

#Initialize SDK

To properly work SKD is needed to be initialized.

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
This module shall authorize user on Tabata Server by obtaining an AuthToken which is required to use all Tabata services.


Usage


```java
AuthorizeManager authorize = new AuthorizeManager.Builder()
                                                 .setIntegrationId("12345678")
                                                 .build(getApplicationContext ());
                                                 
                                                 
authorize.startAuthorization(getApplicationContext ());    
```       

* setIntegrationId() - integration ID of application (can't be empty,  is requiered);
* setPhone() - user phone (not required);
* setLocalized()  - locale of application (this parameter does not work in current version of SDK);
* setAdditionalUserData() - additional user profile data (not required);
* putCustomStyle() - custom style applied for all same UI items in module (not required);


### Sending Additional User Profile Data 

Custom fields of user profile can be sent to the Tabata server as items of ArrayList.

```java
final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
list.add(new AdditionalDataModel("color", "red", AdditionalDataModel.NO_VALIDATION));
```
Where: "color" - is value name, "red" - is value, "AdditionalDataModel.NO_VALIDATION" - is field type.

Field type shall be:
* "AdditionalDataModel.NO_VALIDATION" - for freely editable user profile fields which are not supposed to be validated by user or Tabata authorities after every change of value.
* "AdditionalDataModel.VALIDATION" - for fields which are supposed to be validated by user or Tabata authorities after every change of value.
* "AdditionalDataModel.WITHOUT_CHANGES" - for not editable user profile fields.

Example of adding ArrayList of additional data to SDK.

```java
final ArrayList<AdditionalDataModel> list = new ArrayList<AdditionalDataModel>();
list.add(new AdditionalDataModel("color", "red", AdditionalDataModel.NO_VALIDATION));

AuthorizeManager authorize = new AuthorizeManager.Builder()
                        .setIntegrationId("12345678")
                        .setAdditionalUserData(list)
                        .build();
```   

### Applying custom UI items styles

In total, all screens in Authorize module have 8 types of elements:

 * TITLE
 * BUTTON
 * MESSAGE
 * EDIT_FIELD
 * MAIN_LAYOUT
 * PHONE_TITLE
 * PHONE_PREFIX
 * TEXT_BUTTON
 
If you set some type of styles ( TITLE,BUTTON etc.) it will apply this setting for all elements of this type in Authorize module.
 
Example of adding Custom style to Authorize module.
 
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
If you don't want to change some params, you may simply not set them up. Like: 
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

### Setting Localization
Setting localization does not work in this version of SDK. 
