// 널 병합 연산자(??) (Nullish coalescing operator)
//  > https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Nullish_coalescing_operator
{
  {
    const name = 'scott';
    const userName = name || 'Guest';
    console.log(userName);
  }
  
  {
    const name = null;
    const userName = name || 'Guest';
    console.log(userName);
  }

  {
    const name = '';
    const userName = name || 'Guest';
    console.log(userName);

    const num = 0;
    const message = num || 'undefinded';
    console.log(message);
  } 

// 문제 해결 구간
  {
    const name = '';
    const userName = name ?? 'Guest';
    console.log(`난 달라 ==>${userName}<==`);

    const num = 0;
    const message = num ?? 'undefinded';
    console.log(`[??] [||]랑 비교XX ==>${message}<==`);
  }    
}