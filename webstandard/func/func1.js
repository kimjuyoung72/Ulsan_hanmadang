//2개의 매개값을 받아 덧셈하는 함수
{
    function sum(x, y) {
        return x + y;
    }
    sum(1, 2);
}
{
    const sum = function(x, y) {
        return x + y;
    }
    sum(1, 2);
}
{
    const sum = (x, y) => x + y; //return 생략. 표현식
    console.log(sum(1, 2));
    const f = (x, y) => console.log(y); //return 생략된 함수가 아니다. 실행문.
    console.log(f(1,2)); //undefined
}
{
    function x() {
        return undefined;
    }
    console.log(x());
}
//2배수 함수
{
    const mul_f_2 = n => 2 * n;
    console.log(mul_f_2(3));
}
//3배수 함수
{
    const mul_f_3 = n => 3*n;
    console.log(mul_f_3(3));
}
//4배수 함수
{
    const mul_f_4 = n => 4*n;
    console.log(mul_f_4(3));

}
//2,3,4배수 함수
{
    const num = [1, 2, 3];
    const mul_f_2 = n => 2 * n;
    const mul_f_3 = n => 3*n;
    const mul_f_4 = n => 4*n;
    num.forEach(ele => console.log(mul_f_2(ele)));
    num.forEach(ele => console.log(mul_f_3(ele)));
    num.forEach(ele => console.log(mul_f_4(ele)));
}
console.log('----------------------배수 function--------------------');
{
    function mul(m) {
        return function(n) {
            return m * n;
        }
    }
    const f2 = mul(2);
    console.log(f2(10));
    console.log(mul(2)(10));
    console.log(mul(3)(10));
}
console.log('----------------------배수 화살표 function--------------------');
{
    const mul = m => n => m * n;
    console.log(mul(2)(15));
    console.log(mul(3)(15));
    console.log(mul(4)(15));
}
