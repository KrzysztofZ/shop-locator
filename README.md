# README #

This is a simple shop-locator, using google maps api

* Quick summary: Simple shop locator standalone application
* Version 0.0.1

### How do I get set up? ###
This is a standalone application. All that's needed to get it up and running, is building it with gradle using correct
Java version.

####Dependencies
* JDK 1.8

###Configuration
As of now, no configuration is necessary.

#How to run tests
## Unit and Integration Tests
```
gradle test
```
will run all unit tests and integration tests.

## How to run application
```
gradle clean assemble
```
After jar file is built, application can be run locally using the following command.

```
java -jar ./build/libs/ShopLocator-0.0.1-SNAPSHOT.jar
```
shop-locator project folder is assumed.

Use RESTful client, e.g. Postman to make call to following REST resources:

```
/add
```

and include shop address JSON in the body, e.g.

{
    "shopName" : "Shop 1",
    "shopAddress" : {
        "number" : "14",
        "postcode" : "NW107HB"
    }
}

### Current issues ###

* Validation is not completely implemented
* Google Maps Api key is hardcoded, but should be externalised
* logging should be introduced
* error handling needs improving
* good integration/automation test for resource endpoints needs to be introduced in this project
