# Flexera Technical Test

### Springboot REST API with MongoDB integration for persistence

# Setup

1. In an IDE with maven support, add as maven project and download sources.

2. Ensure MongoDB is installed running on the default port 27017 - if on MacOS you can install MongoDB using Homebrew - https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/

3. Using a MongoDB IDE like Studio 3t or Robo 3T
    1. Create a database called `technicalTest`
    2. Import the `awesomeCollection.json` Collection which you can find at the repo root

4. Run SpringBoot project which will serve the app on localhost:8080 
5. Make requests to the below endpoints. For resource POST and PUT methods, you will need to provide a Person object in the request body

       {
        "_id": "612bc203e1c21da01c2013e9",
        "name": "James Kirk",
        "age": "50",
        "balance": "120000",
        "email": "aaaa@ufp.com",
        "address": "5 Federation Way, Sanfansicsco",
        "managers": [
            {
                "name": "Admiral Archer",
                "age": "55",
                "email": "admiralArcher@ufp.com",
                "address": "any street"
            }
        ]}

# Endpoints
Each endpoint (except DELETE) returns either an array or single Person object as JSON

### GET /app/people/ 
#### JSON: 
     Gets all people. Can sort in alphabetical order using name or email e.g.:
     /app/people/?sortkey=name

### POST /app/people/
    Creates a new Person
### DELETE /app/people/{id}
    Deletes a person using id
### PUT /app/people/{id}
    Updates a person by id
### GET /app/people/no-managers
    Example of pagination with an unrealistic endpoint. Defaults to page 0 with 4 results per page
    Can customise pagingation using optional path variables:
    page
    size
    e.g. app/people/no-managers?size=3&page=2

