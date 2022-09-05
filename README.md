# springboot
#2 tiered Java webapp based on springboot components, simulates a simple store login/logout system along with products(buy/sell in development)
#with postgresql

## **_app - backend_**
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/mspiropali/app/actions)
* temporal url: http://104.155.78.112:8080
* Mappings Documentation
    Path: (temporal url)/api/v1/docs.html

### Run with docker:
* pull image from repo
```docker
(sudo) docker pull skycontroller/backend-app
```

* run docker image:
```docker
(sudo) docker run -p 8080:8080 -d --name backend-app skycontroller/backend-app
```

### Or standalone run without docker:
```javascript 
gradle build

gradle bootRun
```

* Note: This server is not to be used for production as it has cors,csrf disabled and https is not implemented according to industry standards(yet!)
