# Let's Movie API

First of all, do not judge me for the API name.

Tech stack

* Java 8
* Spring boot 2.1.0
* Maven
* Rest Template
* Hazel cast
* H2 database
* REST Assured and JUnit
* Swagger


## Information

To start the API run the Application class.

The API consumes two external APIs TMDB and Google V3.
To connect with this APIs are necessary a token, both tokens are mapped on the application.properties.

The application use cache and the configuration of that are in hazelcast.xml

## Access

The application implements JTW.

The right way to use the API is creating a user and validate the token with this new use but this step use a google email 
account to send the password to avoid possible problem to test the application,  when the application starts a new user are created. 

		
## Use postman

Import the collection and execute in the order

	/users
	/generate-token
	/movies
	/trailers

Will no be necessary insert the token because the postman have global variables that set this value when the generate token is executes. 


	

