# closures

```js
function myCounter() {
  let counter = 0;
  return function() {
    counter++;
    return counter;
  };
}
const add = myCounter();
add();
add();
add();
```
---

Example Explained
The variable add is assigned to the return value of a function.

The function only runs once. It sets the counter to zero (0), and
returns a function expression.

This way add becomes a function. The "wonderful" part is that it can
access the counter in its parent scope.

This is called a closure. It makes it possible for a function to
have "private" variables.

The counter is protected by the scope of the myCounter function, and
can only be changed using the add function.

Conclusion
A closure is a function that has access to the parent scope, after
the parent function has closed.

Closures has historically been used to:

Create private variables
Preserve state between function calls
Simulate block-scoping before let and const existed
Implement certain design patterns like currying and memoization

---
# Shallow Copy

jab hum ek object ka reference copy karke ek new element ko dete hai
tab only top level properties copy hoti hai
lekin nested objects aur arrays abhi bhi original mem location ko
reference karte hai

iska matlab ek ki properties change ki to dusare ki bhi hogi kyuki
they share same mem location

eg
```js
let a = {
    name: "amin",
    age: 25,
    gender: "male"
};
let b = a; // shallow copy 
b.name = "azan";
console.log(a); ==> {name: "azan", age: 25, gender: "male"};
console.log(a); ==> {name: "azan", age: 25, gender: "male"};
```

ye age, gender abhi bhi old ke ref karte hai

---
# Deep Copy

isme new completly independent copy banti hai
This ensures that changes made to one object do not affect the other.
changes alag alag hoge. will not be dependent on other

eg
```js
let a = {
    name: "amin",
    age: 25,
    gender: "male"
};
let b = JSON.parse(JSON.stringify(a));
b.name = "azan";

console.log(a); ==> {name: "amin", age: 25, gender: "male"};
console.log(a); ==> {name: "azan", age: 25, gender: "male"};


```javascript
let a = { name: "amin" };
let z = { ...a };
z.name = "azan";
```

### Kya ho raha hai?

* `a` ek object hai: `{ name: "amin" }`
* `z = { ...a }` ka matlab hai **object ka copy banana** using
**spread operator** (`...`)
* Is copy mein, **ek naya object** banega jismein same key-value
pair honge

---

### Fir tumne `z.name = "azan"` kiya:

Ab `z.name` badal gaya `"azan"` ho gaya, lekin `a.name` **same hi
rahega** `"amin"`.

### Output:

```javascript
console.log(a); // { name: "amin" }
console.log(z); // { name: "azan" }
```

### Kyun aisa hua?

* Kyunki `name` ek **string (primitive)** hai.
* Primitive values copy hone par **alag memory mein jaate hain**.
* Toh `z` aur `a` alag object hain, aur unka `name` alag string hai.

---

### Lekin agar andar object hota:

```javascript
let a = {
  name: "amin",
  address: { city: "Mumbai" }
};

let z = { ...a };
z.address.city = "Delhi";
```

### Output:

```javascript
console.log(a.address.city); // "Delhi"
```

### Kyun hua aisa?

* `address` ek **nested object** hai.
* Spread operator sirf **uper wala level** copy karta hai
(shallow copy).

* `address` ka reference same rehta hai - `a` aur `z` dono ka.

---

### Ek line mein:

* `{ ...a }` **primitive values ke liye safe** hai.
* **Nested object ya array** ke liye `deep copy` chahiye, warna
dono objects **andar se jude rahte hain**.

Agar chaho toh

`structuredClone(a)`

ya

`JSON.parse(JSON.stringify(a))`

use kar sakte ho deep copy ke liye.