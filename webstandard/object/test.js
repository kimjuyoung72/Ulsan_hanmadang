const person = {
    name: '홍길동',
    age: 30,
    blood: 'A',
    address: {nation:'한국', location:'울산'}
}

Object.keys(person).forEach((key) => {
    console.log(key);
});
Object.keys(person).forEach(console.log);
Object.values(person).forEach((value) => {
    console.log(value);
});
Object.entries(person).forEach((entry) => {
    console.log(entry);
});

