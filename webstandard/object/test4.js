const tmpData = {
    '1':{id:'1', text:'dodo_1', completed:false },
    '2':{id:'2', text:'dodo_2', completed:true },
    '3':{id:'3', text:'dodo_3', completed:false },
    '4':{id:'4', text:'dodo_4', completed:true },
    '5':{id:'5', text:'dodo_4', completed:false }
};

{

    const cloneObj = {...tmpData};
    // console.log(cloneObj);
    //   객체 순회
    for(let key in tmpData) {
        // 객체 자신만 포함하는 속성인지 체크
        if(tmpData.hasOwnProperty(key)){
            
            // console.log(key, tmpData[key]);
            if(tmpData[key].completed) {
                delete cloneObj[key];
            }
        }
    }
    // console.log(tmpData, cloneObj);
}
{
   
    // console.log(Object.keys(tmpData));
    // console.log(Object.values(tmpData));
    // console.log(Object.entries(tmpData));

    // 일반 객체의 엔트리로 맵 객체 만들기

    const map = new Map(Object.entries(tmpData));
    // console.log(map);

    const cloneObj = {...tmpData};
    map.forEach((value,key,m) => {
        if(value.completed) {
            delete cloneObj[key];
        }
    });
    // console.log(cloneObj);

}
{
    // Object.entries(tmpData) 는 [key, {value}] 형태의 배열이므로 
    // 고차함수 사용할 수 있고 편리하다.
    // const result = Object.entries(tmpData).filter((entry) => entry[1].completed)
    // console.log(result);
    // console.log(Object.fromEntries(result));
}
{
    //객체 리터럴 => 배열 Objcet.entries()
    //배열 => 객체 리터럴 Object.fromEntries()
    const result = Object.fromEntries(Object.entries(tmpData).filter((entry) => !entry[1].completed));
    console.log(result);
}