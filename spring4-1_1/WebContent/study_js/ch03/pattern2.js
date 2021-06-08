// 제공 함수를 텅한 패턴 분석2
{
  'use strict'
  let addNum = 0;
  const auto = setTimeout(function() {
    addNum++;
    console.log(addNum);
  }, 3000);
}