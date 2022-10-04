//a.js의 add를 쓰고 싶다!
// import {add} from './a.js'
import add2 from './a.js' //default 일경우 {} 안붙인다.
// import {minus, multi, var3 as var5} from './b.js'
import * as myObj from './b.js'

let var1 = 10
let var2 = 20


console.log(var1)
const sum = add2(var1, var2)
console.log(sum)
console.log(myObj.minus(var1, var2))
console.log(myObj.multi(var2, myObj.var3))