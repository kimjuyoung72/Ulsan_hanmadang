{
    // Array.prototype.forEach()
    // 콜백함수내에서 배열을 순회하면서 요소하나에 대한 수행처리
    // 반한값 undefined
let fruits = ['사과', '바나나']
console.log(fruits.length)
// 2
// fruits.forEach(function (item, index, array) {
//     console.log(item, index)
// })
// // 사과 0
// // 바나나 1
// fruits.forEach(function(ele,idx){
// console.log(ele,idx);
// })
// fruits.forEach(ele=>{console.log(ele)});
// fruits.forEach(ele => console.log(ele));

// forEach(callbackfn: (value: T, index: number, array: T[]) => void, thisArg?: any): void;
// console.log(findedIdx);
console.log('------------------------------------------')
fruits.push('오렌지');
fruits.forEach(ele => console.log(ele));
console.log('------------------------------------------')
fruits.pop('오렌지');
fruits.forEach(ele => console.log(ele));
console.log('------------------------------------------')
fruits.unshift('오렌지');
fruits.forEach(ele => console.log(ele));
console.log('------------------------------------------')
fruits.shift('오렌지');
fruits.forEach(ele => console.log(ele));
const findedIdx = fruits.indexOf('바나나');
console.log('------------------------------------------')
const deletedElement = fruits.splice(fruits.indexOf('바나나'),1);
console.log(deletedElement);
fruits.forEach(ele => console.log(ele));
console.log('------------------------------------------')
let fruits2 = [...fruits];
}

{ //스프레드 문법 [...배열]
let fruits = ['사과', '바나나', '딸기'];
let fruits2 = ['수박', '참외'];
//배열복사
let fruits3 = fruits;
let fruits4 = [...fruits];
//배열결합
let fruits5 = [...fruits, ...fruits2, '오렌지'];
console.log(fruits5);
console.log('------------------------------------------')

}

  