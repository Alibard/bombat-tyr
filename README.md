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
                  .setTypeFace("prisma.ttf")
                  .build();            

```

### Setting Localization
Setting localization does not work in this version of SDK. 

## User Profile Module 


This module shall show user profile data and edit them. 


Usage


```java
final ProfileManager profile = new ProfileManager.Builder()
                        .putCustomStyle(profileTitle)
                        .setAdditionalUserData(fields)
                        .setIntegrationId("12345678")
                        .putValidator(emailValidation)
                        .putValidator(nameValidation)
                        .build(getApplicationContext());


       profile.startProfile(getApplicationContext());
```
* putCustomStyle(profileTitle) - custom style for view element (not required);
* setAdditionalUserData(fields) - additional fields for parsing data (not required);
* setIntegrationId("12345678") - integration ID of application (can't be empty,  is required);
* putValidator(emailValidation) - validation for fields 2 type (can't be empty,  is required, should be all type of validation "Email" and "Names");


### Put Additional User Profile Fields  


Custom fields of user profile can be get from the Tabata server as items of ArrayList. And for they parsing need name of filed.


```java
final ArrayList<AdditionalFieldModel> fields = new ArrayList<>();
        fields.add(new AdditionalFieldModel("mobile_device_id", "device id", AdditionalFieldModel.Type.NO_VALIDATION));
        fields.add(new AdditionalFieldModel("last_mobile_login", "last", AdditionalFieldModel.Type.NO_VALIDATION));
```        
        
Where: "mobile_device_id" - is field name, "device id" - is field title, "AdditionalDataModel.NO_VALIDATION" - is field type.


Field type shall be:
* "AdditionalDataModel.NO_VALIDATION" - for freely editable user profile fields which are not supposed to be validated by user or Tabata authorities after every change of value.
* "AdditionalDataModel.VALIDATION" - for fields which are supposed to be validated by user or Tabata authorities after every change of value.
* "AdditionalDataModel.WITHOUT_CHANGES" - for not editable user profile fields.


Example of adding ArrayList of additional field to SDK.


```java
final ProfileManager profile = new ProfileManager.Builder()
                        .setAdditionalUserData(fields)
                        .setIntegrationId("12345678")
                        .build(getApplicationContext());
```


### Applying custom UI items styles


In total, all screens in Profile module have 6 types of elements:


 * TEXT_FIELD
 * TEXT_TITLE
 * FAB_BTN
 * TOOLBAR_TITLE
 * DATA_LAYOUT
 * PHOTO_LAYOUT
 
If you set some type of styles ( TEXT_FIELD,FAB_BTN etc.) it will apply this setting for all elements of this type in Profile module.
 
Example of adding Custom style to Profile module.


```java
 final CustomProfile profileTitle = new CustomProfile.Builder(CustomProfile.Type.TEXT_TITLE)
                .setTextColor(getResources().getColor(R.color.bg))
                .setTypeFace("prisma.ttf")
                .build();
```


If you don't want to change some params, you may simply not set them up. Like: 
```java
final CustomProfile titleStyle = new CustomProfile.Builder(CustomProfile.Type.TEXT_TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .build();
                  
         or
         
final CustomProfile titleStyle = new CustomProfile.Builder(CustomProfile.Type.TEXT_TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .setTextColor(getResources().getColor(R.color.textColor))
                  .build();         
         
         or
         
final CustomProfile titleStyle = new CustomProfile.Builder(CustomProfile.Type.TEXT_TITLE)
                  .setBackgroundColor(getResources().getColor(R.color.bg))
                  .setTextColor(getResources().getColor(R.color.textColor))
                  .setTypeFace("prisma.ttf")
                  .build();            
```






### Setting Validators 


Programmer should set Validator for all of fields 2 type ( First name, Last name, Email). For this work he must implement our interface Validator in his validation class. And override all methods. All logic of validation should be in  "boolean validate(String s);" method. I


Example: 


```java
public class EmailValidation implements Validator{


    @Override
    public boolean validate(String s) {
        return isStringValid(s);
    }


    @NonNull
    @Override
    public Type getType() {
        return Type.EMAIL;
    }




    @Override
    public String title(String s) {
        return s;
    }




    private boolean isStringValid(String s) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
```
In this version of SDK we represent 2 type of validation - Email and Name. Email type for validation Email field and Name for First and Last names.


Programmer should set all his validation in ProfileManager.


Example:


```java


        final Validator emailValidation = new EmailValidation();
        final Validator nameValidation = new NameValidation();
        
        final ProfileManager profile = new ProfileManager.Builder()
                        .setIntegrationId("12345678")
                        .putValidator(emailValidation)
                        .putValidator(nameValidation)
                        .build(getApplicationContext());
```
In case if he will not put some of validators all changed data in Edit Profile will consider as not valid!!!
