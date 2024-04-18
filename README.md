### Spring Boot Caching
- Simple Spring Boot Caching Example with a Hello World-ish CRUD API to demonstrate
- (Application mocks expensive http requests using sleep() {3 seconds} method in service layer for both GET endpoints)

### How to run
- Clone the project
- Open in IDE
- If IDE does not automatically, run a gradle sync to install dependencies
- Run the app
- Create CRUD endpoint calls in Postman or Insomnia
- Test functionality, ensuring the cache remains up to date with the DB
- Take note of GET requests that are either expensive (3 seconds) or inexpensive (time < 3s)

### View H2 Console
- Start the app
- visit http://localhost:8080/h2-console
- Enter information as seen in application.yml
- Query the DB as you please
