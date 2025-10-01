## 🔹 1. Basics

* **What is MySQL?**

  * Open-source RDBMS (Relational Database Management System).
  * Uses SQL (Structured Query Language) for querying and managing data.
* **ACID Properties:**

  * **Atomicity**: all-or-nothing.
  * **Consistency**: DB moves from one valid state to another.
  * **Isolation**: transactions don’t interfere.
  * **Durability**: results persist after commit.

---

## 🔹 2. SQL Commands

* **DDL (Data Definition Language)**: `CREATE`, `ALTER`, `DROP`, `TRUNCATE`
* **DML (Data Manipulation Language)**: `INSERT`, `UPDATE`, `DELETE`
* **DQL (Data Query Language)**: `SELECT`
* **DCL (Data Control Language)**: `GRANT`, `REVOKE`
* **TCL (Transaction Control Language)**: `COMMIT`, `ROLLBACK`, `SAVEPOINT`

---

## 🔹 3. Constraints

* **PRIMARY KEY**: unique + not null
* **FOREIGN KEY**: refers to PK in another table
* **UNIQUE**: unique but allows one null
* **NOT NULL**: no null values
* **CHECK**: validates a condition
* **DEFAULT**: sets a default value

---

## 🔹 4. Joins

* **INNER JOIN**: common records
* **LEFT JOIN**: all left + matched right
* **RIGHT JOIN**: all right + matched left
* **FULL OUTER JOIN**: all records (not directly supported in MySQL, workaround with `UNION`)
* **CROSS JOIN**: cartesian product

---

## 🔹 5. Indexes

* **Why?** Improve query performance.
* **Types:**

  * Primary (auto-created on PK)
  * Unique index
  * Composite index (multiple columns)
  * Full-text index (for searching text)
* Downsides: slower `INSERT`/`UPDATE` due to re-indexing.

---

## 🔹 6. Transactions

```sql
START TRANSACTION;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
COMMIT;
-- or ROLLBACK;
```

---

## 🔹 7. Normalization

* **1NF**: atomic values, no repeating groups.
* **2NF**: 1NF + no partial dependency.
* **3NF**: 2NF + no transitive dependency.
* **BCNF**: stricter form of 3NF.

---

## 🔹 8. Stored Procedures, Functions, Triggers

* **Stored Procedure**: reusable block of SQL.
* **Function**: returns a value.
* **Trigger**: runs automatically on `INSERT`, `UPDATE`, or `DELETE`.

---

## 🔹 9. Views

* Virtual table from `SELECT` statement.

```sql
CREATE VIEW high_salary AS
SELECT name, salary FROM employees WHERE salary > 100000;
```

---

## 🔹 10. Optimization

* Use **EXPLAIN** to analyze queries.
* Avoid `SELECT *`.
* Use proper indexing.
* Normalize (but sometimes denormalize for performance).
* Partitioning / sharding for very large data.

---

## 🔹 11. Common Interview Q’s

* Difference between `WHERE` and `HAVING`?
* Difference between `DELETE`, `TRUNCATE`, `DROP`?
* Difference between `UNION` and `UNION ALL`?
* What are indexes and when not to use them?
* Explain `InnoDB` vs `MyISAM`.
* How does `JOIN` work internally?
* Explain transactions and isolation levels.
* How do you handle deadlocks?

---
---
---
---
---

# ✅ MySQL Interview Revision in Detail

---

## 🔹 1. Basics

**What is MySQL?**

* It’s an **open-source RDBMS** (Relational Database Management System).
* Stores data in **tables** (rows & columns).
* Uses **SQL (Structured Query Language)** to manipulate data.

**ACID Properties** (important for transaction reliability):

1. **Atomicity** → Transaction is "all or nothing." If one step fails, the whole transaction rolls back.
2. **Consistency** → Database must always remain valid (e.g., foreign key rules must hold).
3. **Isolation** → Multiple transactions don’t affect each other.
4. **Durability** → Once committed, data is permanent (even after crash).

👉 Interview Tip: Companies love ACID questions because it’s critical for financial or sensitive data systems.

---

## 🔹 2. SQL Commands

* **DDL (Data Definition Language)**
  Defines schema/structure.
  Example:

  ```sql
  CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(50));
  ALTER TABLE employees ADD COLUMN salary INT;
  DROP TABLE employees;
  ```

* **DML (Data Manipulation Language)**
  Changes data.

  ```sql
  INSERT INTO employees VALUES (1, 'Amin', 50000);
  UPDATE employees SET salary = 60000 WHERE id = 1;
  DELETE FROM employees WHERE id = 1;
  ```

* **DQL (Data Query Language)**
  Retrieves data.

  ```sql
  SELECT name, salary FROM employees WHERE salary > 50000;
  ```

* **DCL (Data Control Language)**
  Manages permissions.

  ```sql
  GRANT SELECT ON employees TO user1;
  REVOKE SELECT ON employees FROM user1;
  ```

* **TCL (Transaction Control Language)**
  Manages transactions.

  ```sql
  COMMIT;
  ROLLBACK;
  SAVEPOINT s1;
  ```

---

## 🔹 3. Constraints

Constraints ensure **data integrity**:

1. **PRIMARY KEY** → Uniquely identifies each row (cannot be NULL).

   ```sql
   id INT PRIMARY KEY
   ```

2. **FOREIGN KEY** → Creates relation between tables.

   ```sql
   FOREIGN KEY (dept_id) REFERENCES departments(id)
   ```

3. **UNIQUE** → Ensures all values are unique (allows 1 NULL).

4. **NOT NULL** → Disallows NULL values.

5. **CHECK** → Validates condition.

   ```sql
   CHECK (salary > 0)
   ```

6. **DEFAULT** → Assigns default value.

   ```sql
   DEFAULT 'India'
   ```

👉 Interview Tip: Be ready to explain the **difference between UNIQUE and PRIMARY KEY** (both enforce uniqueness, but a table can have many UNIQUE constraints, only one PRIMARY KEY).

---

## 🔹 4. Joins

* **INNER JOIN** → Returns matching rows.
* **LEFT JOIN** → All rows from left + matching from right.
* **RIGHT JOIN** → All rows from right + matching from left.
* **FULL OUTER JOIN** → All rows from both tables (not directly supported, use `UNION`).
* **CROSS JOIN** → Cartesian product (every row × every row).

👉 Example:

```sql
SELECT e.name, d.dept_name
FROM employees e
INNER JOIN departments d ON e.dept_id = d.id;
```

---

## 🔹 5. Indexes

Indexes are like a **book index** → speeds up lookups.

* **Clustered Index** (Primary Key): data physically stored in order.
* **Non-Clustered Index**: separate structure with pointers.
* **Composite Index**: multiple columns in one index.
* **Full-text Index**: for searching words in text fields.

👉 Downsides:

* Slows down `INSERT`, `UPDATE`, `DELETE` because indexes must also be updated.
* Takes extra storage.

---

## 🔹 6. Transactions

Used to **group multiple SQL queries** into one logical unit.

```sql
START TRANSACTION;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
COMMIT; -- makes changes permanent
-- or
ROLLBACK; -- undo changes
```

👉 Interview Tip: If they ask **Bank Transfer Example**, always use transaction to avoid inconsistent state.

---

## 🔹 7. Normalization

Process of **organizing data** to reduce redundancy.

1. **1NF** → No repeating groups, atomic values.
   ❌ Bad: `phones = '123, 456'`
   ✅ Fix: create separate `phones` table.

2. **2NF** → 1NF + no partial dependency (no column depends only on part of composite key).

3. **3NF** → 2NF + no transitive dependency (non-key column depends only on primary key).

4. **BCNF** → Stronger form of 3NF.

👉 Interview Tip: They may ask why normalization is important → reduces redundancy, avoids anomalies (insertion, update, deletion problems).

---

## 🔹 8. Stored Procedures, Functions, Triggers

* **Stored Procedure** → Precompiled block of SQL (does not return a value).

  ```sql
  CREATE PROCEDURE getEmployees()
  BEGIN
    SELECT * FROM employees;
  END;
  ```

* **Function** → Returns a value, can be used in queries.

  ```sql
  CREATE FUNCTION getTotalSalary() RETURNS INT
  RETURN (SELECT SUM(salary) FROM employees);
  ```

* **Trigger** → Automatically fires on events (`INSERT`, `UPDATE`, `DELETE`).

  ```sql
  CREATE TRIGGER before_insert_employee
  BEFORE INSERT ON employees
  FOR EACH ROW
  SET NEW.created_at = NOW();
  ```

---

## 🔹 9. Views

* Virtual table based on `SELECT` query.
* Good for **security** (hide sensitive columns) and **simplifying queries**.

```sql
CREATE VIEW high_salary AS
SELECT name, salary FROM employees WHERE salary > 100000;
```

👉 Interview Tip: Views don’t store data separately; they are just saved queries.

---

## 🔹 10. Optimization

1. Use **EXPLAIN** before complex queries.
2. Avoid `SELECT *` → fetch only needed columns.
3. Proper indexing.
4. Normalize data but sometimes **denormalize for performance**.
5. Partitioning for very large tables.
6. Use **LIMIT** with `ORDER BY`.
7. Cache results when possible.

---

## 🔹 11. Common Interview Questions

* **Q1: Difference between WHERE and HAVING?**
  👉 WHERE filters **before grouping**, HAVING filters **after grouping**.

* **Q2: Difference between DELETE, TRUNCATE, DROP?**

  * `DELETE`: removes rows, can rollback.
  * `TRUNCATE`: removes all rows, faster, no rollback (DDL).
  * `DROP`: removes table structure entirely.

* **Q3: Difference between UNION and UNION ALL?**

  * `UNION`: removes duplicates.
  * `UNION ALL`: keeps duplicates (faster).

* **Q4: Difference between InnoDB vs MyISAM?**

  * InnoDB → supports transactions, row-level locking, foreign keys.
  * MyISAM → faster for reads, no transactions, no foreign keys.

* **Q5: Deadlock handling?**

  * MySQL auto-detects deadlocks. Best practices:

    * Keep transactions short.
    * Access tables in same order.
    * Use proper indexing.

---
---
---
---

# ✅ Normalization Explained Simply

👉 **Definition in simple words:**
Normalization is the process of **organizing data in a database** so that:

1. There is **no duplicate data** (no redundancy).
2. Data is **stored logically** and related properly.
3. It avoids **problems when inserting, updating, or deleting**.

Think of it like **organizing your wardrobe**:

* If you throw all clothes in one drawer → messy, hard to find, duplicates.
* If you separate shirts, pants, socks → neat, no duplicates, easier to manage.

That’s exactly what normalization does for data.

---

## 🔹 1NF (First Normal Form) → Atomic values

**Rule:** No repeating groups, no multiple values in a single column.

❌ Example (bad design):

| StudentID | Name | PhoneNumbers |
| --------- | ---- | ------------ |
| 1         | Amin | 123, 456     |

Problem → `PhoneNumbers` column has multiple values → violates 1NF.

✅ Fix (good design):

| StudentID | Name | Phone |
| --------- | ---- | ----- |
| 1         | Amin | 123   |
| 1         | Amin | 456   |

👉 Analogy: Instead of throwing 5 socks in one drawer pocket, put each sock in its own pocket.

---

## 🔹 2NF (Second Normal Form) → Remove Partial Dependency

**Rule:** Table must be in 1NF + every non-key column should depend on the **whole primary key**, not part of it.

❌ Example (bad design):

| StudentID | CourseID | CourseName | StudentName |
| --------- | -------- | ---------- | ----------- |
| 1         | 101      | Math       | Amin        |

Here, **Primary Key = (StudentID, CourseID)**.

* `StudentName` depends only on `StudentID` (partial dependency).

✅ Fix (good design):

* Break into two tables:

**Students Table**

| StudentID | StudentName |
| --------- | ----------- |
| 1         | Amin        |

**Courses Table**

| CourseID | CourseName |
| -------- | ---------- |
| 101      | Math       |

**Enrollment Table**

| StudentID | CourseID |
| --------- | -------- |
| 1         | 101      |

👉 Analogy: Instead of writing **"Amin takes Math"** everywhere, keep “Amin” in a **Student list**, “Math” in a **Course list**, and just connect them in an **Enrollment list**.

---

## 🔹 3NF (Third Normal Form) → Remove Transitive Dependency

**Rule:** Table must be in 2NF + non-key columns should not depend on another non-key column.

❌ Example (bad design):

| EmployeeID | EmployeeName | DeptID | DeptName |
| ---------- | ------------ | ------ | -------- |
| 1          | Amin         | 10     | HR       |

Here:

* `DeptName` depends on `DeptID`, not directly on `EmployeeID` (transitive dependency).

✅ Fix (good design):
**Employees Table**

| EmployeeID | EmployeeName | DeptID |
| ---------- | ------------ | ------ |
| 1          | Amin         | 10     |

**Departments Table**

| DeptID | DeptName |
| ------ | -------- |
| 10     | HR       |

👉 Analogy: Don’t store the same “Department Name” with every employee. Keep a **Department list** and link employees by ID.

---

## 🔹 BCNF (Boyce-Codd Normal Form) → Stronger 3NF

**Rule:** Every determinant must be a candidate key (no weird functional dependencies).

* Usually needed in rare, complex cases.
* For interviews, saying *“It’s a stricter version of 3NF where all dependencies are on keys only”* is enough.

---

# 🎯 Final Analogy (Wardrobe Example)

* **Unnormalized**: All clothes dumped in one drawer (shirts, pants, socks mixed, duplicates).
* **1NF**: Each item separated (socks in one section, shirts in another).
* **2NF**: Don’t repeat shirt info with every pair of socks → keep a separate list of shirts.
* **3NF**: Don’t repeat brand info with every shirt → keep a separate brand list.

---

👉 So, in an interview, you can explain:
“Normalization is just a way of organizing data to avoid duplication and ensure integrity. For example, instead of storing a department name with every employee, we store it once in a separate table and just link it with an ID.”

---

Do you want me to also show you a **real MySQL example with CREATE TABLE and normalized schema** so you can confidently write it in the interview?

---
---
---

# ✅ ACID Properties of Transactions

👉 **Definition:**
ACID ensures that **database transactions** (like transferring money, booking a ticket, etc.) are **reliable, consistent, and safe**.

Think of ACID as the rules that make sure **your bank doesn’t mess up your money** when two things happen at once.

---

## 🔹 A → Atomicity (All or Nothing)

* **Meaning:** A transaction is **atomic** → either **all steps succeed or none do**.
* If one step fails, everything is rolled back.

💳 **Example:**
You transfer ₹100 from Account A to B.

1. Deduct 100 from A
2. Add 100 to B

If step 1 succeeds but step 2 fails → rollback → both accounts remain unchanged.

👕 **Analogy:**
Think of buying a shirt online:

* If **payment succeeds** but **order fails**, it’s a problem.
* Atomicity ensures that **either both happen, or nothing happens**.

---

## 🔹 C → Consistency (Valid State Before & After)

* **Meaning:** After a transaction, the database must always remain in a **valid state** that follows rules & constraints.

💳 **Example:**
If your bank requires that total money in system stays the same:

* Account A = 5000
* Account B = 2000
* After transfer of 100 →

  * A = 4900
  * B = 2100
  * Total = 7000 ✅ (consistent)

If the system accidentally adds money and B becomes 2200 → total = 7100 ❌ (inconsistent).

👕 **Analogy:**
If you’re packing 10 apples in a box, after moving apples from one basket to another, **the total apples should remain 10**.

---

## 🔹 I → Isolation (No Interference)

* **Meaning:** Multiple transactions happening at the same time should **not affect each other’s results**.
* Transactions should behave **as if they happened one after the other** (serially).

💳 **Example:**
Two people trying to book the **last movie ticket**:

* Without isolation → both could “see” the seat available and both book it → double booking ❌.
* With isolation → only one booking succeeds, the other fails ✅.

👕 **Analogy:**
Think of **two people writing on the same whiteboard** → if they don’t wait, the writing overlaps and creates a mess. Isolation ensures each writes separately.

---

## 🔹 D → Durability (Permanent Results)

* **Meaning:** Once a transaction is committed, it’s **saved permanently**, even if system crashes.

💳 **Example:**
If you transferred money and got “Transaction Successful” → even if the server crashes right after, the money must still be transferred when system comes back.

👕 **Analogy:**
Like saving a file → once you hit **Ctrl+S**, even if your computer crashes, the file is still there on disk.

---

# 🎯 Super Simple Analogy: Bank Transfer

Imagine **transferring ₹100 from Account A to B**:

* **Atomicity:** Either the full transfer happens (deduct + add) or nothing happens.
* **Consistency:** The total balance across accounts stays correct.
* **Isolation:** If two transfers happen at once, they don’t mess each other up.
* **Durability:** Once it’s done, it stays done, even if system crashes.

---

👉 So, in an interview, you can confidently say:

**“ACID stands for Atomicity, Consistency, Isolation, and Durability. It guarantees that transactions are reliable — either fully completed or not done at all, always keep the database valid, don’t interfere with each other, and once committed, results are permanent.”**

---