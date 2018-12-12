# Business Applications by jBPM - Single Sign-On with Okta

This is a demo business application built with https://start.jbpm.org and expanded
to add SSO functionality to it using Okta (https://www.okta.com/).
 
![Sample of demo 1](img/oktademo2.png?raw=true)

![Sample of demo 2](img/oktademo1.png?raw=true)

This demo is a minimal setup to get SSO running with Okta, for more details and information
how to take things further take a look at:
https://developer.okta.com/blog/2017/10/13/okta-groups-spring-security
and
https://github.com/oktadeveloper/okta-spring-security-roles-example 


## Getting Started 
1. Clone this repository locally:
   
   ```
   git clone https://github.com/business-applications/sample-okta.git
   cd sample-okta
   cd sample-okta-service
   chmod 755 launch.sh (only needed for unix environments , use launch.bat for windows)
   ```
2. Create an account on https://developer.okta.com. Once logged in create a new application
You can use this info in General settings of your application:

![Sample of demo 3](img/oktademo3.png?raw=true)

Once your application is generated look at your Client Id and Client secret of your app. You will need 
those. Then go to API->Authorization Servers and copy your authorization server url. 

3. Edit your sample-okta/sample-okta-service/src/main/resources/application.properties. Specifically the section:

```
#okta config
okta.oauth2.issuer={your_auth_server}
okta.oauth2.clientId={your_client_id}
okta.oauth2.clientSecret={your_client_secret}
```
   
4. Start your Business Application:
In your business app service module run:
```
./launch.sh clean install(or launch.bat clean install for windows)
```

## Login using SSO
If you are still logged in with developer.okta.com your app should already log you in and show the 
index page. If this is the case go ahead and delete your browser cookies and navigate to localhost:8090 again.
At this point you will be redirected to the okta auth server url and presented a login screen. 
If you authenticate with that you will be redirected to your apps index page which should show your 
login email address.