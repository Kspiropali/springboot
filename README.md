# springboot
#2 tiered Java webapp based on springboot components, simulates a simple store login/logout system along with products(buy/sell in development)
#with postgresql

## **_app - backend_**
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/mspiropali/app/actions)
* url: http://localhost:8080/

### Run with docker:

* run docker image:
```docker
(sudo) docker -t springboot build .
(sudo) docker run -p 8080:8080 -d --name springbootapp springboot
```

### Or standalone run without docker:
```javascript
gradle build

gradle bootRun
```

* Note: This server is not to be used for production as it has cors,csrf disabled and https is not implemented according to industry standards(yet!)
