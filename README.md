IceNet
======
**FAST, SIMPLE, EASY**  
This library is an Android networking wrapper consisting of a combination of [Volley](https://github.com/mcxiaoke/android-volley), [OkHttp](https://github.com/square/okhttp) and [Gson](https://code.google.com/p/google-gson/). For more information see the [website](http://anton46.com/icenet-fast-simple-and-easy-networking-for-android/).



Usage
=====

**Gradle**
```gradle
compile 'com.anton46:IceNet:1.0.1'
````
**Maven**
```xml
<dependency>
    <groupId>com.anton46</groupId>
    <artifactId>IceNet</artifactId>
    <version>1.0.1</version>
</dependency>
````




**Initialization**
```java
public class YourApplications extends Application {
	...
	
	@Override
    public void onCreate() {
        super.onCreate();
        initIceNet();
    }

    public void initIceNet() {
        IceNetConfig config = new IceNetConfig.Builder()
                .setBaseUrl(BuildConfig.SERVER_URL)
                .setContext(getApplicationContext())
                .build();
        IceNet.init(config);
    }
    
    ...
}	
```

**GET REQUEST**
```java
	IceNet.connect()
                .createRequest()
                .get()
                .pathUrl("/v1/feeds")
                .fromJsonArray()
                .mappingInto(Feeds.class)
                .execute(REQUEST_TAG, callback);
```

**POST REQUEST**
```java
IceNet.connect()
                .createRequest()
                .post(bodyRequest)
                .pathUrl("/v1/feed")
                .fromJsonObject()
                .mappingInto(PostResponse.class)
                .execute(REQUEST_TAG, callback);
```

License
=======

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=====
This library already on
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-IceNet-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1054)
