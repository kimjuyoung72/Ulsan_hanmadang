{
    const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    const newArr = arr.filter(ele => ele%2 == 0);
    console.log(newArr);
}
{ 
    const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    arr.filter(ele => ele%2 == 0).forEach(ele => console.log(ele));
    //결과 짝수
}