# D-TECK-Test

The main goal is : Build a REST API that contains the following:

-A minimum of 1 POST endpoint with a body

-A minimum of 1 GET endpoint with a response

-A simple UI to interact with both endpoints

-An in memory database with 1 find query and 1 save query

# Getting Started
These project is done in java J2EE with tomcat, and connects to Mysql database.


# Running the tests
We provided 4 API methods : POST (to insert a welcoming message), PUT (to update the message), DELETE (to delete a message) and GET (to view informations of messages)

You can use Postman to run the tests

Anyway, the api response provide's details of the enitity (message) updated or inserted The REST API is available at [ /api ]

main_uri = localhost:8080

POST	/api/welcomings/[name]	Insert a message

GET	/api/welcomings/[id]	View one user

GET	/api/welcomings	View all users

PUT	/api/welcomings/[id]	Update a message with that id

DELETE	/api/welcomings/[id]	Delete a user
