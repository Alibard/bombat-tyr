## Tabata SDK
=============
###Authorize Module 
This module should connect application and API on Tabata Server.


Usage
-----

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

