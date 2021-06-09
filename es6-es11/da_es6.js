// 구조 분해 할당(Destructuring assignment) 
//   > https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
{
  const sonata = {
    carColor : 'black',
    wheelNum : 4,
    speed : 40,
  };

  {
    const carColor = sonata.carColor;
    const speed = sonata.speed;
    const wheelNum = sonata.wheelNum;
  }

 // 추천
  {
    const {carColor, wheelNum, speed} = sonata;
    console.log(carColor, wheelNum, speed);

    const {carColor: sonataColor, wheelNum: sonatawheelNum, speed: sonataSpeed} = sonata;
    console.log(sonataColor, sonatawheelNum, sonataSpeed);
  }

// 배열 > 대괄호  사용
  const fruit = ['🍄','🍓'];
  {
    const one = fruit[0];
    const two = fruit[1];
    console.log(one, two);
  }
  
// 추천
  {
    const [one, two] = fruit;
    console.log(one, two);
  }
}