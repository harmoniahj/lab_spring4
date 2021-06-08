/* 일반함수 정의방식 + 익명함수 선언
 * 일반함수 > ㅎ마수 호출 시 호이스팅(hoisting)기술을 지원함
 * 익명함수 > 선언 참조 방식은 호이스팅 지원X
 * 호이스팅을 적용하면 함수 정의문 보다 호출문이 먼저 나와도 함수 정의문을 끌어올려서 함수를 호출함
*/

{
  let count = 0; // **var 사용X**
  myFnc();

  function myFnc() {
    count++;
    document.write("hello" + count, "<br>");
  }

  myFnc();
}