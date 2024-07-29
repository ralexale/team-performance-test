# Coupon Management and Redemption System

## Project Description

The Coupon Management and Redemption System is a crucial component of Riwi's e-commerce project. This system allows users to manage and redeem discount coupons for online purchases. The API offers the following key functionalities:

### User Management
- User registration

### Coupon Management
- Creation and listing of coupons
- Modification and deletion of unused coupons
- Verification of coupon validity (expiration date, status)

### Coupon Redemption
- Allow users to redeem coupons on purchases
- Query redemption history by user

### Product Management
- Product listing

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


### Users Table
- id (PK)
- name
- email
- password

### Products Table
- id (PK)
- name
- description
- price

### Coupons Table
- id (PK)
- code
- percentage
- expiration_date
- status

### Redemptions Table
- id (PK)
- user_id (FK)
- coupon_id (FK)
- product_id (FK)
- redemption_date

## Setup and Installation

1. Clone the repository
2. Install dependencies
3. Set up the MySQL database using the provided schema
4. Configure the database connection
5. Run the application

## API Endpoints

(List and describe the main API endpoints here)

## Technologies Used

- Backend: (Specify your backend technology, e.g., Node.js, Express)
- Database: MySQL
- (Add any other relevant technologies)

## Contributing

(Add guidelines for contributing to the project)

## License

(Specify the project license)

## Contact

For any queries regarding this project, please contact:
(Add contact information)
