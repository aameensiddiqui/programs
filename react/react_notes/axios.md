# Axios

Axios is a popular promise-based HTTP client for making requests to APIs in JavaScript, including in React applications. It is often preferred over the native `fetch` API for its simplicity, rich feature set, and ease of use.

Here’s a detailed explanation of how Axios is used in React:

---

## 1. **Why Use Axios in React?**

- **Promise-Based**: Axios uses promises, making it straightforward to handle asynchronous operations.
- **Automatic JSON Transformation**: It automatically parses JSON responses and converts JavaScript objects to JSON for requests.
- **Easy Configuration**: Axios allows for easy configuration of headers, base URLs, and other options.
- **Interceptors**: You can intercept requests and responses for logging, authentication, or error handling.
- **Error Handling**: Provides more informative error messages than the `fetch` API.
- **Request and Response Cancellation**: With `CancelToken`, you can cancel requests when components unmount.

---

## 2. **Installation**

To use Axios in a React project, install it using npm or yarn:

```bash
npm install axios
# or
yarn add axios
```

---

## 3. **Basic Usage**

### GET Request

To fetch data from an API, use `axios.get`:

```jsx
import React, { useEffect, useState } from "react";
import axios from "axios";

const App = () => {
	const [data, setData] = useState(null);

	useEffect(() => {
		axios
			.get("https://api.example.com/data")
			.then((response) => {
				setData(response.data); // Axios stores the response data in `response.data`
			})
			.catch((error) => {
				console.error("Error fetching data:", error);
			});
	}, []);

	return (
		<div>
			{data ? <pre>{JSON.stringify(data, null, 2)}</pre> : "Loading..."}
		</div>
	);
};

export default App;
```

### POST Request

To send data to a server, use `axios.post`:

```jsx
const handleSubmit = async () => {
	try {
		const response = await axios.post("https://api.example.com/data", {
			name: "John Doe",
			age: 30,
		});
		console.log("Data posted:", response.data);
	} catch (error) {
		console.error("Error posting data:", error);
	}
};
```

---

## 4. **Advanced Usage**

### Setting a Base URL

If you make requests to the same API base URL repeatedly, you can configure a base URL:

```jsx
const apiClient = axios.create({
	baseURL: "https://api.example.com",
});
```

Now, you can use `apiClient.get('/data')` instead of writing the full URL.

---

### Using Interceptors

Interceptors allow you to modify requests or responses globally. For example, adding a token to all requests:

```jsx
axios.interceptors.request.use(
	(config) => {
		config.headers.Authorization = `Bearer YOUR_TOKEN`;
		return config;
	},
	(error) => Promise.reject(error)
);
```

You can also handle errors globally:

```jsx
axios.interceptors.response.use(
	(response) => response,
	(error) => {
		if (error.response.status === 401) {
			console.error("Unauthorized, redirecting...");
		}
		return Promise.reject(error);
	}
);
```

---

### Cancelling Requests

If a request is no longer needed (e.g., when a component unmounts), you can cancel it:

```jsx
import { useEffect } from "react";
import axios from "axios";

const App = () => {
	useEffect(() => {
		const source = axios.CancelToken.source();

		axios
			.get("https://api.example.com/data", { cancelToken: source.token })
			.then((response) => {
				console.log(response.data);
			})
			.catch((error) => {
				if (axios.isCancel(error)) {
					console.log("Request canceled", error.message);
				} else {
					console.error("Error:", error);
				}
			});

		return () => source.cancel("Operation canceled by the user.");
	}, []);

	return <div>Check the console for output.</div>;
};
```

---

### Axios with Async/Await

Axios works seamlessly with `async/await` syntax, improving readability:

```jsx
const fetchData = async () => {
	try {
		const response = await axios.get("https://api.example.com/data");
		console.log(response.data);
	} catch (error) {
		console.error("Error fetching data:", error);
	}
};
```

---

## 5. **Common Patterns**

### Custom Axios Instance

You can create custom Axios instances with default configurations:

```jsx
const apiClient = axios.create({
	baseURL: "https://api.example.com",
	timeout: 1000,
	headers: { "X-Custom-Header": "foobar" },
});

// Usage
apiClient.get("/data").then((response) => console.log(response.data));
```

---

### Error Handling

Error handling with Axios is flexible:

```jsx
axios
	.get("https://api.example.com/data")
	.then((response) => console.log(response.data))
	.catch((error) => {
		if (error.response) {
			// Server responded with a status code outside the 2xx range
			console.error("Server Error:", error.response.data);
		} else if (error.request) {
			// Request made but no response received
			console.error("No Response:", error.request);
		} else {
			console.error("Error:", error.message);
		}
	});
```

---

## 6. **Benefits Over Fetch**

- **Default Timeouts**: Axios supports request timeouts natively, while `fetch` requires additional handling.
- **Interceptors**: Easier global handling of requests and responses.
- **Node.js Compatibility**: Works seamlessly in both browser and Node.js environments.

---

By leveraging Axios in React, you can handle API requests effectively and manage state updates based on responses, making it an invaluable tool for modern web development.
