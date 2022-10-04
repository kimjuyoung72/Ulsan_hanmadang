
{
// 함수 선언문을 통해 객체 반환
    function getPerson() {
        return {
            name: '홍길동',
            age: 30
        }
    };
    const {name, age} = getPerson();
    console.log(name, age);
}
{
    // 함수 표현식을 통해 객체 반환
    const getPerson = function() {
        return {
            name: '홍길동',
            age: 30
        }
    };
    const {name, age} = getPerson();
    console.log(name, age);
}
{
    // 화살표 함수를 통해 객체 반환
    const getPerson = () => {
        return {
            name: '홍길동',
            age: 30
        }
    };
    const {name, age} = getPerson();
    console.log(name, age);
}
{
    // 화살표 함수를 통해 객체 반환
    const getPerson = () => 
        ({
            name: '홍길동',
            age: 30
        });
    
    const {name, age} = getPerson();
    console.log(name, age);
}
{
    const sum = (x,y) => x + y;
}
{
    
}