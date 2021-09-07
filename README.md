SUMMARY:
A web application to allow customers to view food menu, order food after registering online and login, add item to the order. Also, admin can view user list, and add and modify menu item.

FUNCTIONAL REQUIREMENTS:
1.	Customer registration: If the customer wants to order food, he/she must register before ordering food. 
2.	Customer login: If customer has an account, he/she must login using valid username/ password.
3.	Modify the order: customer should be able to add items in the cart. 
4.	Order review before submitting: Before submitting the order, customer should be able to review the order details and can make necessary changes. After that, the customer can submit the order.
5.	Database managed by the admin: The admin should be able to sign in and will be able to view users’ accounts.
6.	Inventory managed by the admin: The admin will be able to add, modify or delete a food item, its price and description. 
7.	Order seen by the admin: The admin will be able to view the order placed by the customer. 


User Stories:
1.	As a user, I want to create a login username and password so that I can create my online account.
2.	As a user, I want to register to my account so that I can enter my personal info.
3.	As a user, I want to logout from my account so that nobody other than me can enter my account.
4.	As a customer, I want to see the list of foods, descriptions, and prices so that I can better choose my product.
5.	As a customer, I want to add multiple food items so that I can specify what I want to order. 
6.	As a customer, I want to review my cart so that I can adjust my order before checkout.
7.	As an administrator, I want to see a different view page other than the customers so that I can modify the menu, and customer info. 
8.	As an administrator, I want to modify the menu so that I can add/remove items. 
9.	As an administrator, I want to see the customer info so that I can make any adjustment. 


Tech Stack Selected:
•	Frontend: HTML, CSS, Bootstrap
•	Business Logic: Java
•	Backend: Spring Boot, Thymeleaf, Hibernate, JPA, Lombok
•	Data Layer: MariaDB
•	Build Automation Tool: Apache Maven
•	Web Server: Tomcat
