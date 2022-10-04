
const person = {
    name: '홍길동',
    age: 30
}
{
    // Person 객체를 매개값으로 받아서 출력
    function printPerson(obj) {
        const name = obj.name;
        const age = obj.age;
        console.log(name, age);
    }
    printPerson(person);
}
{
    // 화살표 함수
    const printPerson = (obj) => {
        const name = obj.name;
        const age = obj.age;
        console.log(name, age);
    }
    printPerson(person);
}
{
    // 화살표 함수 + 객체 디스트럭처링 1
    const printPerson = (obj) => {
        const {name, age} = obj;
        console.log(name, age);
    }
    printPerson(person);
}
{
    // 화살표 함수 + 객체 디스트럭처링 2
    const printPerson = ({name, age}) => {
        
        console.log(name, age);
    }
    printPerson(person);
}
{
    // 화살표 함수 + 객체 디스트럭처링 2-1
    const printPerson = ({name, age}) => console.log(name, age);
    
    printPerson(person);
}
