# Mohammed_Aadil_DSA_project
Grocery Inventory System

A console-based **Java** application that manages the stock of a grocery store. It is a **Data Structures and Algorithms (DSA)** project that uses an **ArrayList**, a **HashMap** and several **sorting techniques**.

| | |
|---|---|
| **Student** | Mohammed Aadil |
| **ERP ID** | RU-25-10811 |
| **Guided by** | Mrs. Naina Mam M |
| **Course** | Data Structures and Algorithms (DSA), Session 2026-27 |
| **Institute** | School of Computer Science and Engineering, Rungta International Skills University, Bhilai, Chhattisgarh |

---

## ✨ Features

- Add a product (ID, name, price, quantity) with input validation and duplicate-ID check
- Display all products in a formatted table
- Search a product instantly by ID
- Update the price and quantity of a product
- Delete a product
- Sort by price using **Bubble Sort** (manual)
- Sort by quantity using **Selection Sort** (manual)
- Sort by name and by price using Java's **built-in sort** with a `Comparator`
- Low-stock check: lists products with quantity below 10
- Five sample products are loaded when the program starts

## 🧠 Data Structures Used

| Structure | Purpose |
|---|---|
| `ArrayList<Product>` | Keeps products in order; used for display and sorting |
| `HashMap<Integer, Product>` | Maps Product ID to its `Product`; used for search, update, delete and duplicate-ID check |
| `Product` class | Holds `id`, `name`, `price` and `quantity` |

Both collections store references to the **same** `Product` objects, so an update is visible in both.

## ⏱️ Time Complexity

| Operation | Structure | Time |
|---|---|---|
| Add product | ArrayList + HashMap | O(1) average |
| Search by ID | HashMap | O(1) average |
| Update product | HashMap | O(1) average |
| Delete product | ArrayList.remove + HashMap | O(n) |
| Display all | ArrayList | O(n) |
| Bubble Sort / Selection Sort | ArrayList | O(n²) |
| Built-in sort | ArrayList | O(n log n) |

## 🚀 How to Run

**Requirements:** Java JDK 8 or higher.

```bash
# 1. Clone the repository
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>

# 2. Compile
javac GroceryInventorySystem.java

# 3. Run
java GroceryInventorySystem
```

## 📋 Menu

```
================================
    GROCERY INVENTORY SYSTEM
================================
1. Add Product
2. Display Products
3. Search Product
4. Update Product
5. Delete Product
6. Bubble Sort (Price)
7. Selection Sort (Quantity)
8. Built-in Sort (Name)
9. Built-in Sort (Price)
10. Check Low Stock
11. Exit
```

## 🖥️ Sample Output

```
ID        Name            Price        Quantity
------------------------------------------------
101        Rice            60.00        50
102        Milk            30.00        20
103        Sugar           45.00        35
104        Bread           40.00        15
105        Oil             150.00       10
```

## 📁 Project Structure

```
├── GroceryInventorySystem.java   # Main program and Product class
├── cover.png                     # Project cover page
└── README.md
```

## ⚠️ Limitations

- Data is stored in memory only and is lost when the program exits
- Non-numeric input can crash the program (no `try-catch` yet)
- Console only, one user at a time

## 🔮 Future Scope

- Save and load data using a file or database
- Add exception handling for invalid input
- Search by product name (for example using a Trie)
- GUI or web interface, billing and sales reports

## 👨‍💻 Author

**Mohammed Aadil**, ERP ID RU-25-10811
Bachelor of Computer Science and Engineering, Rungta School of Computer Science and Engineering
Guided by **Mrs. Naina Mam M**
