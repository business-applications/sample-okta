# Business Applications by jBPM - Single Sign-On with Okta

This is a demo business application built with https://start.jbpm.org and expanded
to add SSO functionality to it using Okta (https://www.okta.com/).

It shows how easy it is to set up SSO with your jBPM Business applications. It also shows 
how to display pages based on authentication information.

For further information on Okta based setups with Spring Boot you can look at
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

![Okta app setup](img/oktademo3.png?raw=true)

Once your application is generated look at your Client Id and Client secret of your app. You will need 
those. Then go to API->Authorization Servers and copy your authorization server url. 

3. Create two new groups called "Admin" and "Sales". Assign your user to the Admin group as well (and add the group to 
your created application). This will allow you to test the index and the sales pages of the demo app.

![Okta groups setup](img/oktademo5.png?raw=true)

4. Edit your sample-okta/sample-okta-service/src/main/resources/application.properties. Specifically the section:

```
#okta config
okta.oauth2.issuer={your_auth_server}
okta.oauth2.clientId={your_client_id}
okta.oauth2.clientSecret={your_client_secret}
```
   
5. Start your Business Application:
In your business app service module run:
```
./launch.sh clean install(or launch.bat clean install for windows)
```


## Interacting with the demo
Once your business application is started, you can interact with the demo by launching a browser and going to

```
http://localhost:8090
```

If you are already logged in with developer.okta.com your app should automatically log you in and show the "Admin" page.
for your user (if you have created an Admin group in Okta and assigned your user to it).
To force a login via Okta we recommend to delete your browser cookies at this point.

With cookies deleted you should see the following Okta login page:

![Demo Login](img/oktademo2.png?raw=true)

(With the username and password being yours of course...).

Once you log in you will see the "Admin" index page:

![Demo Admin Page](img/oktademo.png?raw=true)

(Again the info should be of your user that you logged in with).

If you try going to 

```
http://localhost:8090/sales
```

You will be presented with a "403" page, like this one:

![Demo 403 Page](img/oktademo4.png?raw=true)

You can go back to developer.okta.com, and create a new group called "Sales". Add your user to that group and then 
add that group to your Okta application. When you have that done your use should also be in the "Sales" group
which will grant it access to 

```
http://localhost:8090/sales
```

You can play with groups and access to different pages of your demo app as you wish. 

For more info view this youtube video: https://www.youtube.com/watch?v=luIiXnYxE5I