# Simple Search Engine Service

Public UI with simple page for search by tokens.
UI is very simple sorry for that.
This service is based on the spring-boot framework and uses emebedded tomcat to serve static and dynamic content.

## How to build

- Compile boot jar
```bash
./gradlew clean build
```

## Run project

```bash
java -jar build/libs/*.jar or ./gradlew bootRun
```

If you need to override post, search host or search port execute export command:

```bash
export PORT=7777
export SEARCH_HOST=localhost
export SEARCH_PORT=5555
```

## Demo 

- simple search engine deployed on heroku 
- CI/CD for test and deploy use travis https://travis-ci.org/levik666/search-client



## UI documentation:

- Application health
```bash
curl -X GET \
  http://127.0.0.1:7777/actuator/health \
  -H 'accept: application/json' \
  -H 'content-type: application/json'

```

- Aplication main page

```bash
curl -X GET http://localhost:7777/

```