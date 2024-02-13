<h1>Institute Management System RESTful API</h1>

<h3>Overview</h3>
This project is an Institute Management System backend service implemented using Java and Spring Boot. It provides a RESTful API for managing institutes, including registration, retrieval, and modification of institute information. Additionally, Docker support is provided for easy deployment.

<h3>Setup</h3>
<h4>Prerequisites</h4>
Java JDK 8 or higher<br>
Maven<br>
Docker <br>
<h3>Steps</h3>
Clone the repository: git clone https://github.com/ameenaazad/institution-management-system.git<br>
Navigate to the project directory: cd institute-management-system<br>
Build the project: mvn clean install<br>
<h3>Running the Application</h3>
You can run the application using Maven or as a Docker container.<br>
<h5>Maven</h5>
mvn spring-boot:run<br>
The application will start on http://localhost:8080

<h5>Docker</h5>
<ul>
<li>Build the Docker image: docker build -t assessment-docker-demo .</li><br>
<li>Create mysql docker container: docker run -d --name mysqlcontainer --network networkmysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=institutiondb -e MYSQL_USER=root -e MYSQL_PASSWORD=root mysql:latest</li>
<li>Run the Docker container: docker run -d --name assessmentcontainer --network networkmysql -p 8089:8080 -e MYSQL_HOST=mysqlcontainer -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=institutiondb -e MYSQL_USER=root -e MYSQL_PASSWORD=root assessment-docker-demo</li>
<li>The application will be accessible at http://localhost:8089</li><br>
</ul>



<h3>API Endpoints</h3>
<h4>1.	Institute Registration</h4>
URL				: “/api/register”<br>
Method 			: POST<br>
Request Body Format:		: {<br>
  "name": "Institute Name",<br>
  "location": "Institute Location",<br>
  "contact": "Contact Information"<br>
}<br>
<h4>2.	Get All Institutes</h4>
URL				: /api/register<br>
Method				: GET<br>
Response Format		: {<br>
  "name": "Institute Name",<br>
  "location": "Institute Location",<br>
  "contact": "Contact Information"<br>
}<br>
<h4>3.	Get Institute by ID</h4>
URL				: /api/register/{id}<br>
Method				: GET<br>
Response Format		: {<br>
  "name": "Institute Name",<br>
  "location": "Institute Location",<br>
  "contact": "Contact Information"<br>
}<br>

<h4>4.	Update Institute by ID</h4>
URL				: /api/register/{id}<br>
Method				: PUT<br>
Request Body Format		: {<br>
  "name": "Institute Name",<br>
  "location": "Institute Location",<br>
  "contact": "Contact Information"<br>
}<br>


