# **Event Handling in React**

Event handling in React is similar to handling events in DOM, but with some key differences and improvements. React uses a **synthetic event system** that wraps the browser's native events, ensuring cross-browser compatibility.

---

### **1. Adding Event Handlers**

- Use JSX to define event handlers.
- React event names are camelCase (e.g., `onClick` instead of `onclick`).
- Pass a function as the event handler (not a string or method call).

**Example:**

```javascript
function App() {
	const handleClick = () => {
		alert("Button clicked!");
	};

	return <button onClick={handleClick}>Click Me</button>;
}
export default App;
```

---

### **2. Event Object**

React provides a synthetic `event` object to access event properties. It mimics the native event object but works consistently across browsers.

**Example:**

```javascript
function App() {
	const handleClick = (event) => {
		console.log("Event type:", event.type); // "click"
		console.log("Target:", event.target); // The button element
	};

	return <button onClick={handleClick}>Click Me</button>;
}
export default App;
```

---

### **3. Passing Arguments to Event Handlers**

When you need to pass arguments to an event handler, wrap the function in another function.

**Example:**

```javascript
function App() {
	const handleClick = (message) => {
		alert(message);
	};

	return <button onClick={() => handleClick("Hello, Amin!")}>Click Me</button>;
}
export default App;
```

---

### **4. Binding `this` in Class Components**

In class components, you often need to bind `this` to the event handler, so it has the correct context.

**Example:**

```javascript
import React, { Component } from "react";

class App extends Component {
	constructor() {
		super();
		this.handleClick = this.handleClick.bind(this); // Binding 'this'
	}

	handleClick() {
		alert("Button clicked!");
	}

	render() {
		return <button onClick={this.handleClick}>Click Me</button>;
	}
}

export default App;
```

Alternatively, use an arrow function to avoid manual binding:

```javascript
class App extends Component {
	handleClick = () => {
		alert("Button clicked!");
	};

	render() {
		return <button onClick={this.handleClick}>Click Me</button>;
	}
}
```

---

### **5. Common React Events**

Here’s a list of common React events and their uses:

| **Event**  | **React Prop** | **Example**                                |
| ---------- | -------------- | ------------------------------------------ |
| Click      | `onClick`      | `<button onClick={handler}>Click</button>` |
| Change     | `onChange`     | `<input onChange={handler} />`             |
| Submit     | `onSubmit`     | `<form onSubmit={handler}>...</form>`      |
| Mouse Over | `onMouseOver`  | `<div onMouseOver={handler}>Hover</div>`   |
| Key Press  | `onKeyPress`   | `<input onKeyPress={handler} />`           |
| Focus      | `onFocus`      | `<input onFocus={handler} />`              |
| Blur       | `onBlur`       | `<input onBlur={handler} />`               |

---

### **6. Preventing Default Behavior**

To stop the default behavior of an event (like form submission), use `event.preventDefault()`.

**Example:**

```javascript
function App() {
	const handleSubmit = (event) => {
		event.preventDefault(); // Prevent page reload
		console.log("Form submitted!");
	};

	return (
		<form onSubmit={handleSubmit}>
			<input type="text" />
			<button type="submit">Submit</button>
		</form>
	);
}
export default App;
```

---

### **7. Handling Events in Functional Components**

With React Hooks like `useState`, you can handle events easily in functional components.

**Example: Toggle Button**

```javascript
import React, { useState } from "react";

function App() {
	const [isOn, setIsOn] = useState(false);

	const toggleButton = () => {
		setIsOn(!isOn);
	};

	return <button onClick={toggleButton}>{isOn ? "ON" : "OFF"}</button>;
}
export default App;
```

---

### **8. Conditional Rendering and Events**

You can show or hide components or add conditional logic in response to events.

**Example:**

```javascript
function App() {
	const [isVisible, setIsVisible] = useState(true);

	return (
		<div>
			<button onClick={() => setIsVisible(!isVisible)}>
				Toggle Visibility
			</button>
			{isVisible && <p>This is visible</p>}
		</div>
	);
}
export default App;
```

---

### **9. Event Propagation**

React follows the same event propagation model as the DOM: events bubble up from the target element to its parent elements.

You can stop propagation using `event.stopPropagation()`.

**Example:**

```javascript
function App() {
	const handleOuterClick = () => {
		console.log("Outer div clicked!");
	};

	const handleInnerClick = (event) => {
		event.stopPropagation(); // Stops the event from bubbling
		console.log("Inner div clicked!");
	};

	return (
		<div onClick={handleOuterClick}>
			<div onClick={handleInnerClick}>Click Me!</div>
		</div>
	);
}
export default App;
```

---

### **10. Advanced Example: Input Event Handling**

You can use events to manage input fields dynamically.

**Example: Controlled Component**

```javascript
function App() {
	const [name, setName] = useState("");

	const handleChange = (event) => {
		setName(event.target.value);
	};

	return (
		<div>
			<input type="text" value={name} onChange={handleChange} />
			<p>Hello, {name}</p>
		</div>
	);
}
export default App;
```

---
