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

## GET Requests

#### GET /Students/

Returns an array of all the students in the database and `200 OK`. If database is empty, returns `204 No Content`.
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
    
    
    
 #### GET /Students/{id}
 
Returns student with id `id` and status `200 OK` if student with `id` exists. Returns `404 Not Found` if student doesn't exist in the database 
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
   
## POST requests

#### POST /Students/

Adds new students to the database. Returns `201 Created` Status if student was successfully added to the database. Returns `400 Bad Request` if any field is left out or if a student with the same ID already exists in the database. Requires a JSON in the body of the HTTP request of the form
   ```
  {
        "id": 3,
        "firstName": "Karlie",
        "lastName": "McKenzie",
        "email": "KMcKenzie336@tcd.ie",
        "course": "Computer Science",
        "address": "60545 Hoppe Green",
        "age": 24
    },
   ```
   
   
## DELETE requests
#### DELETE /Students/{id}

Delete the student with `id` from the database. Returns `200 OK` status if successfully deleted. If a student with `id` is not in the database, returns `404 Not Found` status.


## PUT requests
#### PUT /Students/{id}

Updates the student with `id` in the database. Returns `200 OK` status if successfully updated. If however a student with `id` does not exist a `404 Not Found` status is returned. Requires a JSON object of student in the body of the HTTP request and if any field is left blank, returns a `400 Bad Content` status. Accepts JSON object in the form of
```
    {
        "firstName": "Estel",
        "lastName": "Hoeger",
        "email": "EHoeger711@tcd.ie",
        "course": "Nursing",
        "address": "189 Jonathon Rest",
        "age": 24
    },
```
Note how ID attribute is not needed in the object

