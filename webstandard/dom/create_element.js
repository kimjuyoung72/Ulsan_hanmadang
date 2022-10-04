/*
  element 생성 함수
  element 이름(name), 속성(attribuets), 자식노드를 포함하는 element를 만들어 반환한다.
  속성(attribuets)객체 구조 {속성명1:값1, 속성명2:값2,...}
*/
function makeElements(name, attribuets, ...contents) {
    const node = document.createElement(name);
    if(attribuets){
        for(let attr in attribuets) {
            if(attribuets.hasOwnProperty(attr)) { //상속받은 속성 이외의 자신만의 속성에
                node.setAttribute(attr, attribuets[attr]); //속성,속성값 할당.
            }
        }
    }
    //컨텐츠가 있는 경우
    if(contents) {
        for(let ele of contents) {
            let child = ele;
            //문자열이면 텍스트 노드 생성
            if( typeof child == 'string') {
                child = document.createTextNode(ele);
            }
            node.appendChild(child);
        }
    }
    return node;
}