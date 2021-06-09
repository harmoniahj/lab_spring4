// 전개 구문(Spread syntax (...)) : 주소의 참조 값만 복사해옴(그 아래 하나하나씩 복사가 아님)
//   > https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_syntax
{ // json과 달리 ""안 씀
  const emp = {key: 'empno'};
  const dept = {key: 'deptno'};
  const array = [emp, dept];

// array copy
  const arrayCopy = [...array]; // 주소값만 복사해옴 > 원본 하나
  console.log(array, arrayCopy);

  const arrayCopy2 = [...array, {key : 'bm_no'}];
  console.log(array, arrayCopy, arrayCopy2);
// 출력 : [ { key: 'empno' }, { key: 'deptno' } ] [ { key: 'empno' }, { key: 'deptno' } ] [ { key: 'empno' }, { key: 'deptno' }, { key: 'bm_no' } ]

// Object copy
  const otherEmp = {...emp};
  console.log(otherEmp);

// array contcatenation
  const transoirtation1 = ['🚄', '🛵'];
  const transoirtation2 = ['✈', '🛸'];
  const transoirtation = [...transoirtation1, ...transoirtation2];
  console.log(transoirtation);

// Object  merge
  const bird = {board : '🦜'};
  const bird2 = {board2 : '🐤'};
  const birds = {...bird, ...bird2};
  console.log(birds);
}