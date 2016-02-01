/*

 Add function in lambda calculus
λx.   λy.   x+y

*/
function add(x){
    return function(y){ return x+y};
}


console.log("Hello World");


// Call the function
console.log(add(1)(2));
