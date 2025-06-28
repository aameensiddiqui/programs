/*

  QUES: shallow copy and deep copy  
  
  */




// function func1(){
//     return 2
// }

// function func2(){
//     return 4
// }

// console.log(func1())

// console.log(func2())

// let a = (func1(), func2())

// console.log(a)

// const arr = ['one', 'two', 'three']

// const str = 'hello'

// const x = arr.includes('on')

// const y = arr.includes('onetwo')

// const z = str.includes('ll')

// console.log(x)
// console.log(y)
// console.log(z)

// console.log('1' == 1)
// console.log(true == '')
/////////////////////////////

// let a = 10;
// let b = new Number(10);
// let c = 10;

// console.log(a === b)
/*
  a is a primitive number
  b is an Number object
  so their types are not same
  but console.log(a == b) will give true
*/
/////////////////////////////

let a = {name:'Adarsh'}
let z = {...a}
console.log(z.name)
z.name = 'Adil'
console.log(a.name)
console.log(z.name)

/////////////////////////////














