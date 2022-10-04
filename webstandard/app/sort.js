const arr = ['a','p','p','l','e'];
const arr2 = [6, 15, 27, 34, 23];

//Array.prototype.sort() 사용
//sort()는 배열요소를 문자열로 변환하여 각문자의 유니코드값에 따라 정렬한다.
//따라서 요소가 숫자인 경우는 콜백함수를 통해 정렬로직을 반영해야 한다.

//1)arr 오름차순정렬
const answer1 = arr.sort();
console.log(answer1);
//2)arr 내림차순정렬
const answer2 = answer1.reverse();
console.log(answer1);
//3)arr2 오름차순정렬
const answer3 = arr2.sort((ele1,ele2) => (ele1 - ele2));
console.log(answer3);
//4)arr2 내림차순정렬
const comparefunc = (ele1, ele2) => {
    // if( ele1 < ele2) {
    //     return -1;
    // }
    // if( ele2 < ele1) {
    //     return 1;
    // } else { return 0;}
    return ele2 - ele1;
}
const answer4 = arr2.sort(comparefunc);
console.log(answer3);