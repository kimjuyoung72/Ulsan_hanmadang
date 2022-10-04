{
const arr = [1, 2, 3];
console.log(arr);
결과 : [3, 6, 9]
let count = 0;
arr.forEach(ele=>{
    arr.push(ele*3);
    count++;
});
arr.splice(0, count);
console.log(arr);
let arr2 = [];
arr.forEach(ele=> arr2.push(ele*3));
console.log(arr2);
}

{ //Array.prototype.map()
  //콜백함수의 반환값들로 구성된 새로운 배열을 반환
    const arr = [1, 2, 3];
    const result = arr.map(ele => ele*3);
    // console.log(result);
}

{
    // method chain
    const arr = [1, 2, 3];
    arr.map(ele => ele*3).forEach(ele => console.log(ele));
    //결과 3,6,9 출력하기
}
{
    const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    //결과 [2, 4, 6, 8, 10]
    const newArr = [];
    // arr.forEach(ele => {if(ele%2 == 0){newArr.push(ele)}}); //even
    arr.forEach(ele => {if(ele%2 == 0){newArr.push(ele)}}); //odd
    console.log(newArr);
}