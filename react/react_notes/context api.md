# **Context API for Managing Global State in React**

The Context API is a React feature designed to manage global state, allowing you to share data across multiple components without needing to pass props down manually through every level of the component tree (a problem known as **prop drilling**).

---

### **Key Features of Context API**

1. **Avoids Prop Drilling**: Data is accessible directly to any component, bypassing intermediary ones.
2. **Global State Management**: Ideal for scenarios like themes, user authentication, or language preferences.
3. **Simple to Use**: Built into React; no need for additional libraries.
4. **Efficient**: Only the components that consume context re-render when the context value changes.

---

### **How Context API Works**

Context involves three main steps:

1. **Create a Context**: Use `React.createContext()` to create a context object.
2. **Provide a Context Value**: Use a `Provider` component to make the data available to descendant components.
3. **Consume the Context**: Access the context value using `useContext` (for functional components) or `Context.Consumer` (for class components).

---

### **Detailed Example: Theme Management**

#### **Step 1: Create a Context**

```javascript
import React, { createContext } from "react";

export const ThemeContext = createContext(); // Creates a context object
```

---

#### **Step 2: Provide a Context Value**

Use the `ThemeContext.Provider` component to wrap the parts of the component tree that need access to the context.

```javascript
import React, { useState } from "react";
import { ThemeContext } from "./ThemeContext";
import Navbar from "./Navbar";
import Footer from "./Footer";

function App() {
	const [theme, setTheme] = useState("light");

	const toggleTheme = () => {
		setTheme(theme === "light" ? "dark" : "light");
	};

	return (
		<ThemeContext.Provider value={{ theme, toggleTheme }}>
			<div
				style={{
					backgroundColor: theme === "light" ? "#fff" : "#333",
					color: theme === "light" ? "#000" : "#fff",
				}}>
				<Navbar />
				<Footer />
			</div>
		</ThemeContext.Provider>
	);
}

export default App;
```

---

#### **Step 3: Consume the Context**

**Using `useContext` (Functional Components):**

```javascript
import React, { useContext } from "react";
import { ThemeContext } from "./ThemeContext";

function Navbar() {
	const { theme, toggleTheme } = useContext(ThemeContext); // Access context

	return (
		<nav>
			<p>Current Theme: {theme}</p>
			<button onClick={toggleTheme}>Toggle Theme</button>
		</nav>
	);
}

export default Navbar;
```

**Using `Context.Consumer` (Class Components or Functional Components):**

```javascript
import React from "react";
import { ThemeContext } from "./ThemeContext";

function Footer() {
	return (
		<ThemeContext.Consumer>
			{({ theme }) => (
				<footer
					style={{
						backgroundColor: theme === "light" ? "#fff" : "#333",
						color: theme === "light" ? "#000" : "#fff",
					}}>
					Footer Content
				</footer>
			)}
		</ThemeContext.Consumer>
	);
}

export default Footer;
```

---

### **When to Use Context API**

1. **Global Themes**: Dark/light mode or color themes.
2. **User Authentication**: Share user login status and user data across the app.
3. **Localization**: Pass language preferences and translations.
4. **Application Configurations**: Provide global app settings like API URLs or feature flags.

---

### **Advanced Features**

#### **1. Nested Contexts**

If your application needs multiple contexts (e.g., Theme and Auth), you can nest providers.

```javascript
<ThemeContext.Provider value={themeValue}>
	<AuthContext.Provider value={authValue}>
		<App />
	</AuthContext.Provider>
</ThemeContext.Provider>
```

To avoid deep nesting, consider combining contexts into a single provider or using tools like **React Context Selector**.

---

#### **2. Optimizing Context Performance**

By default, when a context value changes, all consuming components re-render. To mitigate unnecessary re-renders:

- Memoize values with `useMemo`.
- Split contexts to target specific data.

**Example with `useMemo`:**

```javascript
const themeValue = useMemo(() => ({ theme, toggleTheme }), [theme]);
```

---

#### **3. Combining Context API with Reducers**

For complex state logic, combine Context API with `useReducer`.

**Example: Counter with Context and Reducer**

```javascript
import React, { createContext, useReducer } from "react";

const CounterContext = createContext();

const counterReducer = (state, action) => {
	switch (action.type) {
		case "INCREMENT":
			return { count: state.count + 1 };
		case "DECREMENT":
			return { count: state.count - 1 };
		default:
			return state;
	}
};

export function CounterProvider({ children }) {
	const [state, dispatch] = useReducer(counterReducer, { count: 0 });

	return (
		<CounterContext.Provider value={{ state, dispatch }}>
			{children}
		</CounterContext.Provider>
	);
}

// App.js
import React, { useContext } from "react";
import { CounterProvider, CounterContext } from "./CounterContext";

function Counter() {
	const { state, dispatch } = useContext(CounterContext);

	return (
		<div>
			<p>Count: {state.count}</p>
			<button onClick={() => dispatch({ type: "INCREMENT" })}>Increment</button>
			<button onClick={() => dispatch({ type: "DECREMENT" })}>Decrement</button>
		</div>
	);
}

function App() {
	return (
		<CounterProvider>
			<Counter />
		</CounterProvider>
	);
}

export default App;
```

---

### **Advantages of Context API**

1. No need for external libraries like Redux for small to medium-scale apps.
2. Simplifies state management for global data.
3. Encourages clean and declarative component structures.

---

### **Limitations of Context API**

1. Overuse can lead to performance bottlenecks (re-renders).
2. Not ideal for apps with very frequent updates to global state (e.g., real-time updates).
3. Contexts can become unwieldy if too many values are passed.

For larger applications, combining Context API with state management libraries like Redux or Zustand might be beneficial.

---
