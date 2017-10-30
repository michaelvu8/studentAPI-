# Introduction 
I have successfully implemented the API using Spring Boot. Makes use of H2 in-memory database. The database stores students objects which look like this. 
```javascript
 {
        "id": 5,
        "firstName": "Brenden",
        "lastName": "Murphy",
        "email": "BMurphy008@tcd.ie",
        "course": "Dentistry",
        "address": "987 Maximillia Gardens",
        "age": 20
 }
 ```

##  GET Requests

### GET /Students

Returns an array of all the students in the database and '200 OK'.
For example
```
[
    {
        "id": 1,
        "firstName": "Cole",
        "lastName": "Cummerata",
        "email": "CCummerata827@tcd.ie",
        "course": "English",
        "address": "925 Jadon Freeway",
        "age": 22
    },
    .....
       {
        "id": 20,
        "firstName": "Dion",
        "lastName": "Green",
        "email": "DGreen765@tcd.ie",
        "course": "Arts",
        "address": "35293 Hillary Ramp",
        "age": 20
    }
]
```
    
    
    
 ### Get /Students/{id}
 
 Returns student with id 'id' and status '200 OK' if student with 'id' exists. Returns '404 Not Found' if student doesn't exist in the database 
 For example
 
 ```
  {
        "id": 19,
        "firstName": "Jaylen",
        "lastName": "Cormier",
        "email": "JCormier036@tcd.ie",
        "course": "Medicine",
        "address": "583 Bernadette Fords",
        "age": 21
    }
   ```
