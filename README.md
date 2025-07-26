# 💊 PharmEase System

A **Java-based pharmacy management system** with a MySQL backend — developed as a **Software Testing** project.  
The project simulates an online pharmacy where patients can search, order, and manage medicines, while admins handle inventory and orders.

---

## 🚀 Key Features

### 🧑‍💻 User Side
- **🔑 Login & Sign Up** — Validated login and registration with input checks.
- **🔍 Search Medicines** — Search by name or keyword.
- **🛒 Add to Cart** — Add items with quantity checks.
- **📋 Cart & Bill** — View cart, total amount auto-calculated.
- **✅ Place Orders** — Currently supports *Cash on Delivery* only.

### 🗂️ Admin Side
- **🔐 Admin Login** — Admin dashboard access.
- **📦 Manage Orders** — View and process orders.
- **💊 Manage Medicines** — Add, update, or remove medicines.

---

## 🧪 Testing Highlights

- ✔️ **Manual Black Box Testing**
  - Equivalence Partitioning & Boundary Value for login, sign up, search, cart.
  - Decision table & state transition tests.
- ✔️ **JUnit Unit Tests**
  - Validates input fields (`validateQuantityInput`), order total calculation, and cart status checks.
- ✔️ **Performance Testing (JMeter)**
  - Compared page response time against *PharmEasy.in*.
- ✔️ **Automated GUI Testing (TestComplete)**
  - Simulated user actions on NetBeans Swing screens.

📑 *Detailed test cases, sample runs, and result screenshots included in `docs/`.*

---

## ⚙️ How to Run

1. **Clone** the repository:
   ```bash
   git clone https://github.com/eshxl/PharmEase-System.git
   ```

2. **Open in NetBeans IDE.**

3. **Configure your MySQL:**

	-Create database & tables as per schema.

	-Update DB credentials in DBConnection.java.

4. **Run Login.java and navigate through the UI.**
