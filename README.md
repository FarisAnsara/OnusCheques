# Onus Cheques Application

Onus Cheques is a web application designed to manage and process cheques efficiently. The application is built with modern web technologies to ensure a smooth and user-friendly experience.

## Features
- Create, read, update, and delete cheques.
- Search and filter cheques based on various criteria.
- Secure authentication and authorization for different user roles.
- Generate detailed reports and export data.
- User-friendly interface with responsive design.

## Installation
1. **Clone the repository:**
    ```bash
    git clone https://github.com/FarisAnsara/OnusCheques.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd OnusCheques
    ```
3. **Install dependencies:**
    ```bash
    npm install
    ```
4. **Set up environment variables:**
    Create a `.env` file in the root directory and add the necessary environment variables (refer to `.env.example` for guidance).

5. **Run the application:**
    ```bash
    npm start
    ```

## Usage
1. **Open your browser and navigate to:**
    ```
    http://localhost:3000
    ```
2. **Log in with your credentials.**
3. **Navigate through the application using the menu to manage cheques, view reports, and perform other operations.**

## API Endpoints
### Cheques
- **GET /cheques**: Retrieve a list of all cheques.
- **POST /cheques**: Create a new cheque.
- **GET /cheques/:id**: Retrieve a specific cheque by ID.
- **PUT /cheques/:id**: Update a specific cheque by ID.
- **DELETE /cheques/:id**: Delete a specific cheque by ID.

### Users
- **GET /users**: Retrieve a list of all users.
- **POST /users**: Create a new user.
- **GET /users/:id**: Retrieve a specific user by ID.
- **PUT /users/:id**: Update a specific user by ID.
- **DELETE /users/:id**: Delete a specific user by ID.

## Contact
For any inquiries, please contact [Faris Ansara](https://github.com/FarisAnsara).
