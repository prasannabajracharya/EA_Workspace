# TVTube
##### Enterprise Architecture - Week 2 project


###### An API documentation indicating the URLs provided, HTTP methods available and their meaning and format of the messages request and response.

Syntax to access REST API

1. RETRIEVE
  
  List all the available objects
  * http://localhost:8080/TVTube/[resource]/list
  ```
  eg. http://localhost:8080/TVTube/cast/list
  ```
2. CREATE
   
  To create an entity
  * http://localhost:8080/TVTube/[resource]/create
  ```
  eg. http://localhost:8080/TVTube/cast/create
  ```
3. UPDATE
  
  To modify an entity
  * http://localhost:8080/TVTube/[resource]/detail/<id>
  ```
  eg. http://localhost:8080/TVTube/cast/detail/1
  ```
4. DELETE
  
  To remove an entity
  * http://localhost:8080/TVTube/[resource]/delete/<id>
  ```
  eg. http://localhost:8080/TVTube/cast/delete/1
  ```

* Available resources
  1. cast
  2. episode
  3. season
  4. tvseries
