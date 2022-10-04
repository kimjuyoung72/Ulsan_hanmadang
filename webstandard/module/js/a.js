let var1 = 1
let var2 = 2

//다른 파일에서 모듈내의 자원을 사용할 수 있게!
const add = (x,y) => x + y 
// export {add}
export default add  //원형. 다른파일에서 다른 이름으로 사용가능
// function add(x, y){
//     return x + y
// }