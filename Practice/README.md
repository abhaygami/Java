# Java Practice Assignment

This repository contains Java programs demonstrating concepts of **Collections, Object-Oriented Programming (OOP), Custom Exceptions, Multithreading, and File I/O**.

---

# Practice Question 1: Collections, OOP, and Custom Exceptions

**Total: 20 Marks**

A multi-tenant e-commerce dashboard stores records of **Tenants (stores)** and their **Users** as an in-memory database using classes from the **Java Collection Framework**.

### Entities

**Tenant**

* `tenantId`
* `tenantName`
* `tenantId` must be **unique** and **cannot be null**

**User**

* `userId`
* `tenantId`
* `userName`
* `userId` must be **unique** and **cannot be null**

### Requirements

1. **[5 Marks]** Insert at least **3 records** into both the **Tenant** and **User** entities.
2. **[5 Marks]** Display the list of users based on a given **tenantName**.

   * Hint: Look up the **tenantId** first, then find matching users.
3. **[10 Marks]** Remove the record of a **Tenant** using `tenantId`.

   * Write and throw a **custom exception** (`TenantInUseException`) if someone tries to delete a tenant that already has users present in the user list.

---

# Practice Question 2: Multithreading and File I/O

**Total: 20 Marks**

You are tasked with building a simple **concurrent logging system** that writes and reads application errors to a local text file.

### Requirements

1. **[5 Marks]** Create a Java program with **two separate threads**

   * You can either use the **Runnable interface** or **extend the Thread class**.

2. **[5 Marks]** **Thread 1 (Log Writer)**

   * Create a file named **`server_logs.txt`**.
   * Write an array of **5 different log messages** into the file.
   * Ensure **at least two messages contain the word `ERROR`**.

3. **[5 Marks]** **Thread 2 (Log Reader)**

   * Wait for **Thread 1 to finish execution**.
   * After completion, read `server_logs.txt` **line by line**.
   * Print only the lines that contain **`ERROR`** to the console.

4. **[5 Marks]** Handle all **checked exceptions** properly:

   * `IOException`
   * `InterruptedException`
   * Use **try-catch-finally blocks** or **try-with-resources**.

---

# Technologies Used

* Java
* Java Collections Framework
* Multithreading
* File I/O
* Custom Exceptions

---

# Author

**Abhay Gami**
