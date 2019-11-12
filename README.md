# simple-https-java

Steps to reproduce:

1. `javac SimpleHTTPSServer.java`
2. `javac Https11SimpleClient.java`
3. `native-image --no-fallback --enable-all-security-services Https11SimpleClient`
4. `java SimpleHTTPSServer`

Then in another console:

-> This request is expected to be successful.
5. `java -Djavax.net.ssl.trustStore=testkey.jks -Djavax.net.ssl.trustStorePassword=password Https11SimpleClient`
    
-> Testing the native image fails.
6. `./https11simpleclient -Djavax.net.ssl.trustStore=testkey.jks -Djavax.net.ssl.trustStorePassword=password`
    
