/*
*  
TODO: Learn objects of objects

TODO: learn mutation ==>
  mutation of an array means changing the contents of the array
  directly, rather than creating a new one. This can include:
  Modifying existing elements
  Adding or removing elements
  Reordering elements
  ...more in notes.md

TODO: Learn slice method ==>
  done

QUES: does slice method mutate? ==>
  No. It returns a shallow copy

QUES: what is a higher order function? ==>
  a function which accepts or returns another function

QUES: what is lexical scoping ==>
  a functions scope is determined by its position
  (where they are called)  
  not where they are defined
  
QUES: what is function currying ==>
  function having multiple arguments
  can be broken down into multiple functions with single arguments

QUES: destructuring ==>
  unpacking values from arrays / properties of objects into variables
  for writing cleaner shorter code
  *
*/

//console.log("A"-1);
//console.log("Amin"+"100")
//console.log("2"+2+"2");
//console.log("2"+2-"2");

//const a = {};
//const b = {name:"Amin"};
//const c = {name:"sachin"};
//const d = {name:"d"};

//a[b] = {name:"ankit"};
//a[c] = {name:"priyanka"};
//a[d] = {name:"shivaji"};

//console.log(a[b]);
//console.log(b);

//const y = 0;
//const z = true;
 
//console.log(y == z);
//console.log(y === z);

//console.log(1+z);
//console.log(z-"abc");

//console.log(NaN == NaN);
//console.log(NaN === NaN);

//const arr = [21, 92, 43, 4, 65];

//console.log(arr);
//arr.sort();
//console.log(arr);

/*
  JavaScript’s Array.prototype.sort() by default sorts
  elements as strings in lexicographical order, not
  numerical order.

  So the sort is actually:

  "21", "4", "43", "65", "92"

  And "21" comes before "4" because "2" is less than
  "4" in string comparison.
  ------------------------------------------
  To sort in ascending order you've to
  To sort numbers numerically, you must provide
  a compare function:
*/
//const nums = [21, 92, 43, 4, 65];
//nums.sort((a, b)=>a-b);
//console.log(nums);

//nums.unshift(69);
//console.log("unshift");
//console.log(nums);

//nums.shift();
//console.log("shift");
//console.log(nums);
//---
//arr.map((i) => {console.log(i);})

//const fun = arr.map((i) => {return(i>2);})
//console.log(fun);

//arr.forEach((i) =>{
//    console.log(i);
//})
//---
//console.log(arr.slice(3, 5));


/* Higher order functions */
// takes function as an argument
// function greet (name){
//     return `Hello, ${name}`;
// }
// function input(callback){
//     const name = "Amin";
//     console.log(callback(name));
// }
// input(greet);

// return a function
// function multiplier(factor){
//     return function(x){
// 	return (x*factor);
//      }
// }


// const double = multiplier(2);
// console.log(double(5));

/* function currying */
// used for reusability and cleaner fun chains
// don't use it for functions which have
// one time function call. cause it inc code
// 
// function fun(a, b, c){
//     return a*b*c;
// }
// console.log(fun(2, 2, 2));

// function nuf(a){
//     return function(b){
// 	return function(c){
// 	    return a*b*c;
// 	}
//     }
// }
// console.log("short : "+nuf(3)(4)(5));
// // this is a short form of the same thing as below
// // long version
// const x = nuf(3);
// const y = x(4);
// const z = y(5);
// console.log("long : "+z);

// function add(a){
//     return function inner(b){
// 	if(b !== undefined){
// 	    return add(a+b);
// 	} else {
// 	    return a;	    
// 	}
//     }
// }
// console.log(add(1)(2)(3)(4)(5)());

// /* destructuring an array */
// const arr = ['#FF0000', '#00FF00', 'blue'];
// const [a, b, c] = arr;
// console.log(a);
// console.log(b);
// console.log(c);

// /* destructuring an object */
// const obj = {
//     'x':"shyam",
//     'y':"raju",
//     'z':"babubhai"
// };
// const {x, y, z} = obj;
// console.log(x);
// console.log(y);
// console.log(z);

/* temporal dead zone
   simply means cannot access const and let before initialization
 */
// function f(){
//     console.log(a);
//     let a = 2;
// }
// console.log(f(
// ));


