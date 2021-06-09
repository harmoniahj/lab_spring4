// 기본값 매개변수(default function parameter
//  > https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/Default_parameters
{
  function print(msg) {
    if(msg == null) {
      msg = 'default message';
    }
    console.log(msg);
  }

  print('hello');
  print();

  {
    function print(msg = 'default msg') {
      console.log(msg);
      }
  
    print('hi');
    print();
  }
}