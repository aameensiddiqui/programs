# Promises, Async/Await

### **Asynchronous Programming in JavaScript**

Asynchronous programming allows JavaScript to handle tasks that take time (like fetching data from a server) without blocking the rest of the code. It ensures smooth execution of the application, especially in web development.

---

### **1. Promises**

A `Promise` is an object representing a value that might be available now, or in the future, or never.

#### **States of a Promise:**

- **Pending:** Initial state, neither resolved nor rejected.
- **Fulfilled:** The operation completed successfully, and the `resolve()` function was called.
- **Rejected:** The operation failed, and the `reject()` function was called.

#### **Creating a Promise**

```javascript
const fetchData = () => {
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			const success = true; // Simulate a condition
			if (success) {
				resolve("Data loaded successfully!");
			} else {
				reject("Failed to load data.");
			}
		}, 2000); // Simulates a delay
	});
};
```

#### **Using Promises**

- **`.then()`**: Handles the resolved value.
- **`.catch()`**: Handles errors.
- **`.finally()`**: Executes code regardless of the result.

```javascript
fetchData()
	.then((data) => {
		console.log(data); // "Data loaded successfully!"
	})
	.catch((error) => {
		console.error(error); // "Failed to load data."
	})
	.finally(() => {
		console.log("Operation completed.");
	});
```

---

### **2. Async/Await**

`async` and `await` provide a more readable way to work with asynchronous code. They allow you to write asynchronous code that looks synchronous.

#### **Key Points:**

- Use `async` to declare a function that returns a `Promise`.
- Use `await` to pause the execution of the function until the `Promise` is resolved or rejected.

#### **Example:**

```javascript
const fetchData = () => {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve("Data fetched!"), 2000);
	});
};

const fetchDataAsync = async () => {
	try {
		const data = await fetchData(); // Wait for the promise to resolve
		console.log(data); // "Data fetched!"
	} catch (error) {
		console.error("Error:", error);
	}
};

fetchDataAsync();
```

#### **Benefits of Async/Await:**

- Cleaner and easier to read than chaining `.then()` and `.catch()`.
- Error handling is simpler with `try...catch`.

---

### **3. Combining Promises and Async/Await**

You can handle multiple Promises simultaneously with `Promise.all()` or `Promise.race()`.

#### **Promise.all()**:

Waits for all Promises to resolve or rejects as soon as one fails.

```javascript
const promise1 = Promise.resolve("First");
const promise2 = new Promise((resolve) =>
	setTimeout(() => resolve("Second"), 2000)
);
const promise3 = Promise.resolve("Third");

const getAll = async () => {
	try {
		const results = await Promise.all([promise1, promise2, promise3]);
		console.log(results); // ["First", "Second", "Third"]
	} catch (error) {
		console.error("Error:", error);
	}
};
getAll();
```

#### **Promise.race()**:

Resolves or rejects as soon as the first Promise settles.

```javascript
const promise1 = new Promise((resolve) =>
	setTimeout(() => resolve("First resolved"), 1000)
);
const promise2 = new Promise((resolve) =>
	setTimeout(() => resolve("Second resolved"), 2000)
);

Promise.race([promise1, promise2])
	.then((result) => console.log(result)) // "First resolved"
	.catch((error) => console.error(error));
```

---

# Asynchronous Programming in React

In React, asynchronous programming is mostly used for:

- Fetching data from APIs.
- Performing side effects in components.
- Managing promises in event handlers or lifecycle methods.

#### **Example: Fetching Data with Promises**

Using the `fetch` API to get data:

```javascript
import React, { useState, useEffect } from "react";

function App() {
	const [data, setData] = useState(null);
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		fetch("https://api.example.com/data")
			.then((response) => response.json())
			.then((result) => {
				setData(result);
				setLoading(false);
			})
			.catch((error) => console.error("Error:", error));
	}, []);

	if (loading) return <p>Loading...</p>;
	return <div>{JSON.stringify(data)}</div>;
}

export default App;
```

---

#### **Example: Fetching Data with Async/Await**

Cleaner code for the same functionality:

```javascript
import React, { useState, useEffect } from "react";

function App() {
	const [data, setData] = useState(null);
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		const fetchData = async () => {
			try {
				const response = await fetch("https://api.example.com/data");
				const result = await response.json();
				setData(result);
				setLoading(false);
			} catch (error) {
				console.error("Error:", error);
			}
		};

		fetchData();
	}, []);

	if (loading) return <p>Loading...</p>;
	return <div>{JSON.stringify(data)}</div>;
}

export default App;
```

---

### **5. Common Practices**

- Always handle errors using `.catch()` or `try...catch`.
- Use `async/await` for complex asynchronous logic.
- Ensure proper cleanup in React when dealing with asynchronous calls in components (e.g., with `useEffect`).

**Example: Cleanup with `useEffect`:**

```javascript
useEffect(() => {
	let isMounted = true; // Track if component is still mounted

	const fetchData = async () => {
		try {
			const response = await fetch("https://api.example.com/data");
			const result = await response.json();
			if (isMounted) setData(result);
		} catch (error) {
			if (isMounted) console.error("Error:", error);
		}
	};

	fetchData();

	return () => {
		isMounted = false; // Cleanup on unmount
	};
}, []);
```

---
