🛠️ Technologies Used
Java 17 – modern, stable language for backend logic

Spring Boot 3 – rapid setup, production-ready features

Spring Data JPA & Hibernate – easy database mapping

MySQL – reliable relational database

Spring Validation – ensure clean and valid user input

JavaMailSender – automate email communications

springdoc (Swagger UI) – built-in, interactive API documentation

✅ Key Features
JobSeeker & Employer Registration – secure user onboarding

Job Listing & Filtering – find jobs by title, location, or both

Apply to Jobs – track discrete applications with notifications

Global Exception Handling – cleaner error management

Automated Emails – welcome messages & application confirmations

Swagger UI Integration – test APIs in-app at /swagger-ui.html

🧩 Architecture Overview
Entities: Job, Employer, JobSeeker, JobApplication

Layered Structure: Clean separation of Controllers → Services → Repositories

Exception Handling: @ControllerAdvice with custom exceptions

DTOs (optional future upgrade): For better request/response control

🚀 Running the Project Locally
Clone this repo

Create a MySQL database named job_portal

Set your credentials in application.properties

Run mvn clean install to build

Start the app with mvn spring-boot:run or from your IDE

Access:

Swagger UI – http://localhost:8080/swagger-ui.html

Email Logs – Watch console or check sent email inbox
