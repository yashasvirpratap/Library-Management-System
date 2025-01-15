# Library Management System

## Overview
The Library Management System (LMS) is designed to manage books, patrons, and borrowing activities in a library. This system allows users to perform tasks like adding books, registering patrons, searching for books, and tracking borrowed books. The system also supports logging events and handling exceptions for debugging and auditing.

## Features
- **Book Management**: Add, remove, and search for books by title, author, or ISBN.
- **Patron Management**: Register patrons and track borrowed books.
- **Book Checkout & Return**: Borrow and return books.
- **Search**: Multiple search strategies (by title, author, ISBN).
- **Logging**: Log system events for tracking actions (like book borrowing/returning).

## Technologies Used
- **Java**: Core programming language.
- **Design Patterns**: Singleton, Factory, Strategy.
- **Logging**: Custom logger class for event tracking.

## Getting Started

### Prerequisites
To run this project, you'll need:
- **Java** (version 8 or higher) installed.

### Running the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd library-management-system
   ```
3. Compile and run `Main.java`:
   ```bash
   javac Main.java
   java Main
   ```

## How It Works

### Key Components:
1. **Library**: The central class that manages books and patrons. It allows adding, removing, and searching books, and checking out and returning books for patrons.
2. **Book**: Represents a book in the library with properties like title, author, ISBN, and status (available or borrowed).
3. **Patron**: Represents a library patron who can borrow and return books.
4. **BookFactory**: A factory class that creates `Book` objects.
5. **SearchStrategy**: An interface with concrete implementations for searching books by title, author, or ISBN.
6. **Logger**: A custom logging class to log system events like adding books, checking out books, etc.

### Design Patterns Used:
- **Singleton**: Ensures only one instance of `Library` exists.
- **Factory**: Encapsulates the creation of `Book` objects through the `BookFactory` class.
- **Strategy**: Provides multiple search strategies (by title, author, ISBN) for searching books.

## Example Usage
- **Search for books**:
  ```java
  List<Book> books = library.searchBooks("1984");  // Search by title
  ```
- **Checkout a book**:
  ```java
  library.checkoutBook("9876543210", "P001");  // Checkout by ISBN for patron
  ```
- **Return a book**:
  ```java
  library.returnBook("9876543210", "P001");  // Return by ISBN for patron
  ```

## Challenges Faced
As a backend fresher, the key challenges were:
- Understanding and applying design patterns like Singleton, Factory, and Strategy.
- Managing relationships between books and patrons while keeping the code modular and flexible.
- Implementing logging and error handling to track system activities efficiently.

## Conclusion
This Library Management System is designed with scalability and flexibility in mind. By implementing design patterns, adhering to OOP principles, and focusing on efficient data structures, the system is capable of handling core library tasks while being easily extendable for future features like multi-branch support or a recommendation system.

---
