# simple-https-java

Steps to reproduce:

1. `javac SimpleHTTPSServer.java`: Compiles SimpleHTTPSServer class.
2. `javac Https11SimpleClient.java`: Compiles Https11SimpleClient class.
3. `native-image --no-fallback --enable-all-security-services Https11SimpleClient`: Creates a native image.
4. `java SimpleHTTPSServer`: Starts the server.

Then in another console:

5. `java -Djavax.net.ssl.trustStore=testkey.jks -Djavax.net.ssl.trustStorePassword=password Https11SimpleClient`: This request is expected to be successful.
6. `./https11simpleclient -Djavax.net.ssl.trustStore=testkey.jks -Djavax.net.ssl.trustStorePassword=password`: Testing the native image fails.
