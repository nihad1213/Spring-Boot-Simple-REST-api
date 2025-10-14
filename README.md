# 📚 Spring Boot REST API – Books, Authors & Users

## 📝 Project Overview
This project is a simple **REST API** built with **Spring Boot**.  
It manages three main entities:

1. **Books** – information about books (title, description, author, etc.).
2. **Authors** – information about authors (name, bio, etc.).
3. **Users** – system users who can interact with books (e.g., add to favorites).

The project demonstrates **CRUD operations**, **entity relationships**, and a **layered architecture** (Controller → Service → Repository → Database).

---

## 🏗️ Tech Stack
- **Java 17+**
- **Spring Boot 3**
- **Spring Web** (REST APIs)
- **Spring Data JPA** (database access)
- **Hibernate** (ORM)
- **PostgreSQL** (production database)
- **Lombok** (boilerplate reduction)
- **Maven**

---

## 🔑 Business Logic

### Entities & Relationships
- **Author**
    - One author can write **many books**.
    - Example: J.K. Rowling → Harry Potter series.

- **Book**
    - Belongs to **one author**.
    - Can be associated with **many users** (favorite books).

- **User**
    - Can have **many favorite books**.
    - Users don’t create books/authors; they just interact with them.

### Relationships
- `Author (1) ↔ (M) Book`
- `User (M) ↔ (M) Book` (many-to-many, for favorites)

---

## 🚀 Features
- **Authors**
    - Create, read, update, delete authors.
    - Get all books by a specific author.

- **Books**
    - Create, read, update, delete books.
    - Assign a book to an author.
    - List all books with optional filters (title, author).

- **Users**
    - Register a new user.
    - Add/remove favorite books.
    - View all favorite books of a user.

---
