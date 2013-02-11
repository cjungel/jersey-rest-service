jersey-rest-service
===================

Simple REST service based on Jersey.


Run service on tomcat
=====================

```
mvn tomcat:run
```

WADL URL
========

```
http://localhost:8080/jersey-rest-service/application.wadl
```

Create a person
===============

```
curl -X POST --header "Content-Type: application/xml" \
-d '<person><name>Cristian</name><email>cristan@example.com</email></person>' \
http://localhost:8080/jersey-rest-service/person/post
```

Get list of all people
======================

```
curl http://localhost:8080/jersey-rest-service/person/
```

Get list of person by it's name
===============================

```
curl http://localhost:8080/jersey-rest-service/person/Cristian
```


