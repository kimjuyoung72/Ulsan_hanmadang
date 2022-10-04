const data = {
    result:'success', //success: 수신성공, fail:수신실패
    data:[
        {name:'이름1', gender:'남', age:10, blood:'A'},
        {name:'이름2', gender:'여', age:20, blood:'B'},
        {name:'이름3', gender:'남', age:30, blood:'O'},
        {name:'이름4', gender:'여', age:40, blood:'AB'},
        {name:'이름5', gender:'남', age:50, blood:'A'}
    ]
}
//0. 회원수
if(data.result == 'success'){
    console.log(data.data.length);
}
//1. 회원이름 출력
if(data.result == 'success'){
    data.data.forEach(ele => console.log(ele.name));
    
}
//2. 나이의 총합
// {
// let sumAge = 0;
// if(data.result == 'success'){
//     data.data.forEach(ele => sumAge += ele.age);
//     console.log(`회원나이총합: ${sumAge}`);
// }
// }    
{
    // const result = data.data.reduce( function(acc, ele){
    //     return acc + ele.age;
    // },0);
    const result = data.data.reduce( (acc,ele) => acc + parseInt(ele.age), 0);
    // const result = reduce((acc,ele,data.data) => acc + parseInt(ele.age ), 0);
    console.log(`회원나이총합: ${result}`);
}
//3. 남자회원의 수
if(data.result == 'success'){
    const result = data.data.filter(ele => ele.gender == '남').length;
    console.log(`남자회원 수 : ${result}`);
}
//4. 남자회원, 여자회원을 분리하여 배열에 저장
if(data.result == 'success'){
    // const males = [];
    // const females = [];
    // data.data.filter(ele => ele.gender == '남').forEach(ele => males.push(ele));
    // data.data.filter(ele => ele.gender == '여').forEach(ele => females.push(ele));
    // console.log(males);
    // console.log(females);
    const maleMember = data.data.filter(ele=>ele.gender =='남');
    const femaleMember = data.data.filter(ele=>ele.gender =='여');
    // console.log(maleMember, femaleMember);

    data.data.reduce((acc,ele,idx,arr) => {
        if(ele.gender == '남') acc.push(ele);
            return acc;
        
    }, []);
    data.data.reduce((acc,ele,idx,arr) => {
        if(ele.gender == '남') acc.push(ele);
            return acc;
        
    }, []);
    // console.log(maleMember,femaleMember);
}
//5. 남자회원 나이의 총합 출력
if(data.result == 'success'){
    // let sumAge = 0;
    // data.data.filter(ele => ele.gender == '남').forEach(ele => sumAge += ele.age);
    // console.log(sumAge);
    // const result = data.data.filter(ele => ele.gender == '남').reduce((acc,ele) => acc + Number(ele.age), 0);
    // console.log(`남자회원 나이 총합 : ${result}`);
    const result = data.data.filter( ele => ele.gender == '남'); 
    console.log(result);

    const final = result.reduce((acc, ele) => acc + ele.age , 0);
    console.log(`남자회원 나이의 총합: ${final}`);
}
//6. A형 회원 나이 총합 출력
if(data.result == 'success'){
    let sumAge = 0;
    // data.data.filter(ele => ele.blood == 'A').forEach(ele => sumAge += ele.age);
    // console.log(sumAge);
    const result = data.data.filter(ele => ele.blood == 'A').reduce((acc,ele) => acc + ele.age, 0);
    console.log(`A형 회원의 나이 총합 : ${result}`);

}
//7. name이 '이름3'인 회원의 혈액형?
if(data.result == 'success'){
    const result = [];
    
    data.data.filter(ele => ele.name == '이름3').forEach(ele => result.push(ele.blood));
    console.log('name이 이름3인 회원의 혈액형 :');
    result.forEach(ele => console.log(ele + ' '))
}
//8. 혈액형별 인원수 카운트
//결과 : {A:2, B:1, O:1, AB:1}
{
    const countOfBloodType = data.data.reduce((acc,ele,idx,arr) => {
        const obj = {};
        //같은 혈액형 프로퍼티 누적
        //case1)
        // if(acc[ele.blood]){
        //     ++acc[ele.blood];
        // }else{
        //     acc[ele.blood] = 1;
        // }
        //case2)
        // acc[ele.blood] ? ++acc[ele.blood] : acc[ele.blood] = 1;
        // acc[ele.blood] = acc[ele.blood] ? ++acc[ele.blood] : 1;
        //case3)
        acc[ele.blood] = (acc[ele.blood] || 0) + 1;
        return acc;
    }, {});
    console.log(countOfBloodType);
    console.log(countOfBloodType.A);
    // console.log(countOfBloodType['A']);

}
//9. 남성 회원의 평균 연령
{
    // const avgOfAge = data.data.filter(ele=>ele.gender == '남').reduce((acc,ele,idx,arr)=>{
        //누적하다 마지막 요소에서 요소 갯수로 나누어 반환
        //마지막 요소인지 체크
        //case1)
        // if(idx == arr.length-1){
        //     return (acc+ele.age)/arr.length;
        // } return acc+ele.age;
        //case2)
    //     return idx == arr.length -1 ? (acc+ele.age)/arr.length : acc+ele.age;
        
    // },0);

    //case3)
    const avgOfAge = data.data.filter(ele=>ele.gender == '남').
        reduce((acc,ele,idx,arr)=> idx == arr.length-1 ? (acc+ele.age)/arr.length : acc+ele.age,0);
    console.log(`남성회원 평균연령 : ${avgOfAge}`);


}
//10. 나이가 가장 많은 회원의 혈액형은?
{

    // const bloodOfTheOldest = data.data.reduce((acc,ele,idx,arr) => {
        // if(acc < ele.age ){
        //     acc = ele.blood;
        // }
        // return acc;
        // return (acc < ele.age) ? ele.blood : acc;

    // }, 0);
    const bloodOfTheOldest = data.data.reduce((acc,ele,idx,arr) => (acc < ele.age) ? ele : acc);
    console.log(`나이가 가장 많은 회원의 혈액형은 ${bloodOfTheOldest.blood}`);

}
//11. 아래처럼...
{
// [
//     {name:'이름1', age:10},
//     {name:'이름2', age:20},
//     {name:'이름3', age:30},
//     {name:'이름4', age:40},
//     {name:'이름5', age:50}
// ]
    const temp = data.data.reduce((acc,ele,idx,arr) => {
        acc.push({name:ele.name,age:ele.age});
        return acc;
    },[]);
    // console.log(temp);
}
//12. 수신된 데이터에 남자회원이 있는지 여부
{
    console.log(data.data.some(ele=>
        ele.gender == '남'
    ));   
}
//13. 수신된 데이터가 모두 남자회원 인지 여부
{
    console.log(data.data.every((ele=>ele.gender == '남')))
}
//14. 여성 회원의 나이 내림차순 정렬
{
    const sortedFemaleMember = data.data.filter(ele => ele.gender == '여').sort((e1, e2) => e1.age - e2.age);
    console.log(sortedFemaleMember);
}
//15. 여성이면서 혈액형이 'AB'인 첫번째 회원의 이름?
{
    console.log(data.data.filter(ele => ele.gender == '여' && ele.blood == 'AB')[0].name);
    console.log(data.data.find(ele => ele.gender == '여' && ele.blood == 'AB').name);
}