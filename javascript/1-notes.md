# Mutation in js


In JavaScript, **mutation of an array** means **changing the
contents of the array directly**, rather than creating a new one.
This can include:

* Modifying existing elements
* Adding or removing elements
* Reordering elements

### Examples of **mutating** array methods:

These methods **change (mutate)** the original array:

| Method      | Description                         |
| ----------- | ----------------------------------- |
| `push()`    | Adds elements to the end            |
| `pop()`     | Removes the last element            |
| `shift()`   | Removes the first element           |
| `unshift()` | Adds elements to the beginning      |
| `splice()`  | Adds/removes elements at a position |
| `sort()`    | Sorts the array (mutates it!)       |
| `reverse()` | Reverses the array                  |

#### Example:

```js
const arr = [1, 2, 3];

arr.push(4);        // [1, 2, 3, 4] - mutated
arr.sort();         // [1, 2, 3, 4] - still mutated (in-place)
```

---

###  Non-mutating methods

These methods **do not** change the original array - they return
a **new** one:

| Method     | Description                          |
| ---------- | ------------------------------------ |
| `slice()`  | Returns a shallow copy               |
| `concat()` | Merges arrays and returns a new one  |
| `map()`    | Transforms elements into a new array |
| `filter()` | Filters elements into a new array    |
| `flat()`   | Flattens into a new array            |

#### Example:

```js
const arr = [1, 2, 3];
const newArr = arr.map(x => x * 2);  // [2, 4, 6]

console.log(arr);     // [1, 2, 3] - original is untouched
console.log(newArr);  // [2, 4, 6] - new array
```

---

###  Why it matters:

* **Mutating arrays** can lead to bugs if you're unintentionally
changing data.
* In **React or functional programming**, **immutability** is
preferred to avoid side effects.

Let me know if you'd like to practice identifying which methods
mutate arrays.

-------------------------------------------------

# Higher order function

In JavaScript, a **higher-order function** is a function that does
**at least one** of the following:

1. **Takes another function as an argument**
2. **Returns a function**

---

### Common examples in JavaScript

#### 1. **Takes a function as an argument**

```js
function greet(name) {
  return `Hello, ${name}`;
}

function processUserInput(callback) {
  const name = "Amin";
  console.log(callback(name));
}

processUserInput(greet);  // Hello, Amin
```

Here, `processUserInput` is a **higher-order function** because
it **accepts `greet` as a function argument**.

---

#### 2. **Returns a function**

```js
function multiplier(factor) {
  return function(x) {
    return x * factor;
  };
}

const double = multiplier(2);
console.log(double(5));  // 10
```

Here, `multiplier` is a **higher-order function** because it
**returns another function**.

---

### Built-in higher-order functions

These are **common array methods** that take a function as a
callback:

| Method      | Example                              |
| ----------- |	-----------------------------------  |
| `map()`     | `arr.map(x => x * 2)`                |
| `filter()`  | `arr.filter(x => x > 5)`             |
| `reduce()`  | `arr.reduce((acc, x) => acc + x, 0)` |
| `forEach()` | `arr.forEach(x => console.log(x))`   |
| `sort()`    | `arr.sort((a, b) => a - b)`          |

---

### Why use higher-order functions?

* **Reusability** - logic can be abstracted into reusable functions
* **Cleaner code** - especially with array operations
* **Functional programming** - enables composition and avoids
side effects

---

Let me know if you'd like to write your own higher-order function
or see how they're used in frameworks like React!


----------------------------------------------

## Lexical Scoping and function currying

---

# Lexical Scoping

**Lexical scope** (also called **static scope**) means that **a
function's scope is determined by its location in the source code**.
Inner functions have access to variables defined in outer functions
(and globally), based on **where they are defined**, not where they
are called.

### Example:

```js
function outer() {
  const a = 10;

  function inner() {
    console.log(a);  // inner can access `a` from outer
  }

  inner();
}

outer();  // prints: 10
```

Even if you call `inner()` elsewhere, it remembers where
it was **defined**,
not where it is **called** - that's lexical scoping.

### Not dynamic:

```js
function outer() {
  const a = 10;
  return function inner() {
    console.log(a);
  };
}

const fn = outer();
fn();  // still prints: 10, because `a` is from its
lexical environment
```

-----------------------------------------

# Function Currying

**Currying** is a technique where a function with
**multiple arguments** is transformed into a **series of
functions**, each taking **one argument at a time**.

### Example:

```js
function add(a) {
  return function(b) {
    return a + b;
  };
}

const add5 = add(5);
console.log(add5(3));  // 8
```

This is equivalent to `add(5)(3)`.
You can also write a more generic curry function.

---

### Use case:

Suppose you want a reusable multiply-by function:

```js
function multiply(a) {
  return function(b) {
    return a * b;
  };
}

const double = multiply(2);
const triple = multiply(3);

console.log(double(5)); // 10
console.log(triple(4)); // 12
```

---

### Currying with Arrow Functions:

```js
const add = a => b => a + b;

console.log(add(2)(3));  // 5
```

---

### Summary:

| Concept           | Description				|
| ----------------- | -----------------------------------------	|
| Lexical Scoping   | Functions access variables from their	|
| 	  	    | **definition context**, not call site	|
|		    |						|
| Function Currying | Breaking a function of multiple args into	|
| 	   	    | **nested single-arg functions**		|

# Infinite currying

```js
function add(a){
    return function inner(b){
	if(b !== undefined){
	    return add(a+b);
	} else {
	    return a;	    
	}
    }
}
console.log(add(1)(2)(3)(4)(5)());

```
-----------------------------------------------

# Destructuring in JavaScript - Simple Explanation

**Destructuring** means **unpacking values from arrays or
properties from objects** into variables.

It helps you write cleaner, shorter code.

---

## 1. Array Destructuring

```js
const colors = ['red', 'green', 'blue'];
const [a, b, c] = colors;

console.log(a); // red
console.log(b); // green
console.log(c); // blue
```

You can also skip elements:

```js
const [first, , third] = colors;
console.log(third); // blue
```

Set default values:

```js
const [x, y, z = 'black'] = ['white'];
console.log(z); // black
```

---

## 2. Object Destructuring

```js
const user = {
  name: 'Amin',
  age: 25,
  city: 'Mumbai'
};

const { name, age } = user;

console.log(name); // Amin
console.log(age);  // 25
```

Rename and set defaults:

```js
const { name: userName, country = 'India' } = user;
console.log(userName); // Amin
console.log(country);  // India
```

---

## 3. Nested Destructuring

```js
const person = {
  id: 1,
  address: {
    city: 'Delhi',
    pincode: 110001
  }
};

const { address: { city, pincode } } = person;
console.log(city);    // Delhi
console.log(pincode); // 110001
```

---

## 4. Function Parameter Destructuring

```js
function greet({ name, city }) {
  console.log(`Hello ${name} from ${city}`);
}

greet({ name: "Amin", city: "Mumbai" });
```

---

## Summary

| Type     | Example                           |
| -------- | --------------------------------- |
| Array    | `const [a, b] = [1, 2]`           |
| Object   | `const { x, y } = { x: 1, y: 2 }` |
| Nested   | `const { a: { b } } = obj`        |
| Renaming | `const { x: newX } = obj`         |
| Default  | `const { x = 10 } = {}`           |

Let me know if you want destructuring examples inside loops or
`React` props!
-------------------------------------------------------

Great question! Let's explore **WeakMap** and **WeakSet** in
JavaScript in simple terms.

---

## WeakMap

### What is it?

A **WeakMap** is like a regular `Map`, but:

* **Only allows objects** as keys (not strings, numbers, etc.)
* **Does not prevent garbage collection** - if the key object is
no longer referenced elsewhere, it's removed from the WeakMap.

### Syntax:

```js
const weakMap = new WeakMap();

const obj = { name: "Amin" };
weakMap.set(obj, "some value");

console.log(weakMap.get(obj)); // "some value"

weakMap.delete(obj);           // removes the entry
```

### You **can't**:

* Loop over a WeakMap
* Get its size
* Clear all entries

> Why? Because it's meant to allow safe memory handling without
interfering with garbage collection.

---

## WeakSet

### What is it?

A **WeakSet** is like a regular `Set`, but:

* Stores **only objects** (no primitives)
* Removes an object automatically if it's no longer referenced
elsewhere

### Syntax:

```js
const weakSet = new WeakSet();

const obj = { data: 123 };
weakSet.add(obj);

console.log(weakSet.has(obj)); // true

weakSet.delete(obj);           // removes it
```

### You **can't**:

* Loop over a WeakSet
* Get size
* Clear it

---

## Why use WeakMap or WeakSet?

| Feature      | Use Case Example                                 |
| ------------ | ------------------------------------------------ |
| WeakMap      | Private data storage for class instances         |
| WeakSet      | Track object presence without preventing cleanup |
| Auto cleanup | Avoid memory leaks when objects go out of scope  |

---

### Summary:

| Feature      | WeakMap               | WeakSet                  |
| ------------ | --------------------- | ------------------------ |
| Keys/Values  | Object-> Any          | Object only              |
| No Iteration | yes                   | yes			  |
| GC-friendly  |yes(keys auto-removed) |yes(objects auto-removed) |

---

Let me know if you'd like a real-world example like storing
private variables in a class using WeakMap!
