# Coupon Management and Redemption System

# Team
## Roles
-Hector Alejandro Montaña Flores - Leader

-Harold Andres Chaverra - Developer

-Tatiana Maldonado Perez - Developer

-Mateo Saldarriaga Vidales - Developer

## Project Description

The Coupon Management and Redemption System is a crucial component of Riwi's e-commerce project. This system allows users to manage and redeem discount coupons for online purchases. The API offers the following key functionalities:

### User Management
### Coupon Management
### Coupon Redemption
### Product Management

## General Business Rules

1. A registered user can redeem a specific coupon only once. The system validates that the coupon is not in the user's redemption history before allowing redemption.

2. A coupon must have at minimum:
   - A unique code
   - An expiration date
   - A discount percentage

3. When redeeming a coupon, the system requires:
   - User identifier
   - Product identifier
   If redemption rules are met, the system returns:
   - Redeemed coupon information
   - New product price after discount
   The redemption is then recorded in the user's coupon redemption history.

4. The application is pre-loaded with a minimum of 10 products in the database upon initialization.

## Database Schema

The system uses a MySQL database with the following structure:

![image](https://github.com/user-attachments/assets/e9a45b8d-9ea9-4a8b-9ebf-850ed41863d9)


## Setup and Installation

1. Clone the repository
2. Install dependencies
3. Set up the MySQL database using the provided schema
4. Configure the database connection
5. Run the application

## API Endpoints
Documentation in Swagger

http://localhost:8080/api/v1/swagger-ui/index.html#/

## Technologies Used

- Backend: Spring Boot
- Database: MySQL
- Principles: SOLID
- Documentation: Swagger
- Deploy: Render

## Contributing and Proposed solution

# Mateo: User Management
# Responsibilities:
- Implement user registration.
- Create the database structure for users.
- Develop user validation and authentication logic.
- Provide API endpoints for user registration and authentication.

# Contribution:
- Create the user model.
- Implement user registration functionality in the backend.
- Add endpoints for user registration and authentication.
- Write unit tests for user management functionality.


# Harold: Coupon Management

# Responsibilities:
- Implement the creation and listing of coupons.
- Develop logic for modifying and deleting coupons, ensuring that coupons have not been used.
- Implement verification of coupon validity (expiration date, status).

# Contribution:
- Create the Coupon model.
- Implement functionality to create, list, modify and delete coupons.
- Add logic to check the validity of coupons.
- Provide API endpoints for coupon management.
- Write unit tests for the coupon management functionality.


# Hector: Coupon Redemption
# Responsibilities:
- Implement functionality to allow users to redeem coupons on purchases.
- Develop logic to query coupon redemption history per user.
- Ensure that a registered user can only redeem a coupon once.

# Contribution:

- Create the Redemption model.
- Implement functionality to redeem coupons and view redemption history.
- Add validation to ensure coupons are not redeemed more than once per user.
- Provide API endpoints for coupon redemption and history query.
- Write unit tests for coupon redemption functionality.


# Tatiana: Product Management
# Responsibilities:
- Implement the functionality to list products.
- Develop business logic for product management (e.g. inventory management).

# Contribution:
- Create the Product model.
- Implement the functionality to list products.
- Provide API endpoints for product management.
- Write unit tests for product management functionality.


# General business rules
# Shared responsibility:

- Implement business rules that affect more than one functionality, such as validating that a user cannot redeem the same coupon more than once.
- Ensure data consistency and referential integrity in the database.
- Collaborate in the integration of different functionalities to guarantee a cohesive system.


# Board at the start 
![start](https://github.com/user-attachments/assets/7f7f1bbc-d335-4ce0-9464-9aeefd0581ef)


# Board at the End
![end](https://github.com/user-attachments/assets/32ace747-c349-4102-ac9b-18ce9f31b3ab)

# Link Board
https://app.clickup.com/9013368381/v/b/s/90131518654

