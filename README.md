# Project Name

This is a take-home-test repository with a simple REST API definition for a fictious PoS retail system named Acme.  The assignment was open on use of technology stack and implementation framework.

## New Approach Taken

1. Used Spring-Initializr to build boiler plate service code
2. Layered in a Model, Controller, Repository, and Service Classes
3. Did some refactoring + Leveraged Github Co-Pilot where useful
4. Used Gen-AI to generate some init junit tests

## Requirements

- Java 17
- MVN 3.9.9

## Usage

1. mvn clean install
2. cd target
3. java -jar demo-0.0.1-SNAPSHOT.jar

##
#  API Testing with VS-Code REST Client 
# 

1.  Load acme-api.http in vs-code (will need the vs-code REST client).

2.  Send requests to locally running 
    - http://127.0.0.1:8080/api/v1/products
	- http://127.0.0.1:8080/api/v1/sales
	

