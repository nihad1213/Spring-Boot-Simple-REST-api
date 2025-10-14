# 📚 Spring Boot REST API – Users, Books & Genres

## 📝 Project Overview
This project is a simple **REST API** built with **Spring Boot**.  
It manages three main entities:

1. **Users** – system users who can write books or mark them as favorites.  
2. **Books** – information about books (title, description, author, genre, etc.).  
3. **Genres** – categories for books (e.g., Fiction, Science, History).

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
- **User**
    - Can **write many books**.
    - Can have **many favorite books**.

- **Book**
    - Belongs to **one author** (User).  
    - Belongs to **one genre**.  
    - Can be favorited by **many users**.

- **Genre**
    - Can have **many books**.

### Relationships
- `User (1) ↔ (M) Book` – One user writes many books  
- `Book (M) ↔ (M) User` – Many users can favorite many books  
- `Genre (1) ↔ (M) Book` – One genre has many books

---

## 🚀 Features
- **Users**
    - Register new users.
    - Add/remove favorite books.
    - View all favorite books.

- **Books**
    - Create, read, update, delete books.
    - Assign books to authors and genres.
    - List all books with optional filters (title, author, genre).

- **Genres**
    - Create, read, update, delete genres.
    - List all books under a specific genre.

---
