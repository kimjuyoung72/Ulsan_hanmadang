// const str = '내이름은 홍길동입니다';
// console.log(str);

// const name = '홍길동';
// const str2 = '내이름은 ' + name + '입니다';
// console.log(str2);

// template literal
// const str3 = `내이름은 ${name}입니다`;
// console.log(str3);

//taged template
const taged = (string, exp1, exp2, exp3) => {
    console.log(string);
    console.log(exp1, exp2, exp3);

    return `${exp1}-${exp2}`
}
const taged2 = (string, ...exp) => {
    console.log(string);
    const str = exp.map((ele,idx) => `${ele}-${idx}`).join();

    return str;
}
const name = '홍길동';
const age = 30;
const blood = 'A';
// const str4 = taged`내이름은 ${name}이고 나이는 ${age}입니다`;
const str4 = taged2`내이름은 ${name}이고 나이는 ${age}입니다${blood}형`;

console.log(str4);
