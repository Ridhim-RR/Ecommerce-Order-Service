🛒 Order Service
The Order Service is a crucial component of the e-commerce platform, responsible for handling the creation, updating, and management of customer orders. It integrates with other services like Product and Payment Service to ensure seamless order processing and fulfillment. The service is registered with Eureka for service discovery and is accessed via the API Gateway.

📦 Core Functionalities
1. Order Management
Create, update, and retrieve orders.

Each order contains:

Order ID

Customer details

List of ordered products

Order status (e.g., Pending, SUCCESS)

2. Order Validation
Validates product availability before order creation.

Ensures that all necessary details are provided (e.g., shipping address, payment method).

3. Integration with Other Services
Product Service: Fetches product details like price and availability.

Payment Service: Handles payment processing for orders.

User Service: Verifies user information and authentication before allowing order placement.

⚙️ Non-Functional Requirements
1. Scalability
Designed to efficiently handle a high volume of orders.

Leverages message queues for decoupling components and processing orders asynchronously.

2. Performance
API responses optimized for quick order creation and retrieval, aiming for sub-200ms response times.

3. Security
Implements authentication and authorization to ensure only authorized users can place or manage orders.

Uses JWT tokens for secure user session management.

4. Maintainability & Extensibility
Modular and scalable architecture that allows for easy integration with other services and features.

Clean, well-documented code for ease of future updates.

🧑‍💻 Service Discovery with Eureka
The Order Service is registered with Eureka Server for automatic service discovery in a microservices environment. This ensures that the service can be located by other services in the platform, such as the Payment Service or Product Service, allowing seamless communication across services.

🌐 API Gateway Integration
The Order Service is accessed through the API Gateway, which acts as a reverse proxy to route API requests to the appropriate service. The API Gateway handles load balancing, routing, and security, ensuring that incoming requests to the Order Service are authenticated and routed to the correct service endpoint.

📌 Technologies Used
Java / Spring Boot

MySQL (for database management)

RESTful APIs

Kafka (for message queues)

JWT (for authentication)

Eureka (for service discovery)

API Gateway (for routing and load balancing)

🧩 Contributors
[Ridhim Singh Raizada]

