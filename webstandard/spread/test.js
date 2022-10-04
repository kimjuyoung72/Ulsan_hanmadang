//스프레드 문법 : ...이터러블 객체, ...객체리터럴
//의미 : 이터러블 객체, 객체 리터럴의 개별적인 값들의 목록으로
//      만들어 객체 표현식을 확정 할 수 있게 해주는 문법
//용도 : 객체,배열을 복사, 추가, 병합
{
    const arr = [1, 2, 3, 4]
    const arr2 = [4, 5, 6]

    // 배열 복사
    const copy = [...arr] //1, 2, 3, 4
    console.log(copy)

    // 배열 추가
    console.log([...arr, 10, 20])

    // 배열 병합
    console.log([...arr, ...arr2])
}
{
    const obj = {name:'홍길동', age:30}
    const obj2 = {name:'홍길순', age:25, blood:'B'}
    const obj3 = {blood:'A', weight:70}
    // 객체 복사
    const copy = {...obj}
    console.log(copy)

    // 객체 프로퍼티 추가
    console.log({...obj, blood:'A'}) 
    // 객체 병합(프로퍼티 교체 및 추가)
    console.log({...obj, ...obj2})
    console.log({...obj, ...obj3})

    delete obj.name;
    console.log(obj)
    obj.name = '홍길동'
    console.log(obj)

}