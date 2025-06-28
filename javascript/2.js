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

/* deep copy - separate mem reference */
// let a = {
//     name: "amin",
//     age: 25,
//     address:{city: {street: "sw nagar"}} 
// };
// let z = JSON.parse(JSON.stringify(a));
// console.log(a)
// console.log(z)
// z.address.city.street = "Phaltan"
// console.log(a)
// console.log(z)

/* shallow copy - same mem reference */
// let a = {
//     name: "amin",
//     age: 25,
//     address:{city: {street: "sw nagar"}} 
// };
// let z = a;
// console.log(a)
// console.log(z)
// z.address.city.street = "Phaltan"
// console.log(a)
// console.log(z)

/* ...a spread operator */
// let a = {
//     name: "amin",
//     age: 25,
//     address:{city: {street: "sw nagar"}} 
// };
// let z = {...a};
// console.log(a)
// console.log(z)
// z.address.city.street = "Phaltan"
// console.log(a)
// console.log(z)
/////////////////////////////

// console.log(+true);
// console.log(!"xyz");

// function curryfunc1(a){
//     return function(b){
// 	return function(c){
// 	    return a*b*c;
// 	}
//     }
// }
// console.log(curryfunc1(1)(2)(3));

// function curryfunc(a){
//     return function(b){
// 	const mult = a*b;
// 	return function(c){
// 	    return res = mult*c;
// 	}
//     }
// }
// console.log(curryfunc(1)(2)(3));
//////////////////////////////////////

/* @author amin */
// function alternateStings(s1, s2)
// {
//     let i = 0;
//     let j = 0;
//     let res = '';
    
//     while(i < s1.length || j < s2.length){
// 	res = res+s1[i];
// 	res = res+s2[j];
// 	i++; j++;
	
// 	if(i >= s1.length){
// 	    res = res+s2.slice(j);
// 	    return res;
// 	}
// 	if(j >= s2.length){
// 	    res = res+s1.slice(i);
// 	    return res;
// 	}
//     }
//     return res;
// }
// console.log(alternateStings("Hello77", "World1234"));

/* cleaner and better version */
// function alternate(s1, s2){
//     let res = "";
//     const maxlen = Math.max(s1.length, s2.length);
    
//     for(let i = 0 ; i < maxlen ; i++){
// 	if(i < s1.length) res = res+s1[i];
// 	if(i < s2.length) res = res+s2[i];
//     }
//     return res;
// }
// console.log(alternate("Hello77", "World1234"));

// console.log(sum(2, 4));
// console.log(sum(2)(4));

// function sum(a, b){
//     if(b !== undefined) return a+b;
//     else{
// 	return function(c){
// 	    return a+c;
// 	}
//     }
// }

//////////////////////////////
// let arr = [
//     [1,2],
//     [3,4],
//     [5,6]
// ];
// let nums = [];

// function flatten1(arr, nums)
// {
//     let cnt = 0;

//     for(let i = 0 ; i < arr.length ; ++i){
// 	for(let j = 0 ; j < arr[i].length ; ++j){
// 	    nums[cnt] = (arr[i][j]);
// 	    cnt++;
// 	}
//     }
//     return nums;
// }

// console.log(flatten1(arr, nums));
// -------------------
// nums = arr.flat();
// console.log(nums)
// -------------------

// let arrr = [
//     [1,2],
//     [3,4],
//     [5,6]
// ];
// let num = [];


// function flatten(arrr, num)
// {
//     for(let i = 0 ; i < arrr.length ; ++i){
// 	if(Array.isArray(arrr[i])){
// 	    flatten(arrr[i], num);
// 	}
// 	else{
// 	    num.push(arrr[i]);
// 	}
//     }
//     return num;
// }
// console.log(flatten(arrr, num));
