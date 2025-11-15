"use strict"; // 문법 검사를엄격하게 하도록 설정

// 산술 연산자 : + - * / % **           ++ --
let a = 3;
console.log(`거듭제곱 연산자: ${a ** 3}`); // 3의 3제곱

/*
비교 연산자: > < >= <= ==(동등) != ===(일치) !==
*/
let b = 15;
let c = '15';
(b == c) ? console.log('같다') : console.log('같지않다');
(b === c) ? console.log('같다') : console.log('같지않다');



// 논리 연산자: &&(AND) ||(OR) !(NOT)

// 논리연산자의 단축평가(Short-circuit evaluation
// && 연산자: 앞의 피연산자가 false이면 뒤의 피연산자는 평가하지않음)

// || 연산의 앞부분의 평가값이 true이면 뒤의 피연산자는 평가하지않음
let age = [];
let ok1 = age >= 20 && age <= 30; // t
let ok2 = 20 <= age <= 30;        // x

// 단축평가 연습 : 식, 표현
// && 연산자: 앞의 피연산자가 false이면 뒤의 피연산자는 평가하지않음)
(10 > 5 && console.log("and 단축평가 1"));
(10 < 5 && console.log("and 단축평가 2"));

// || 연산자: 앞의 피연산자가 false이면 뒤의 피연산자는 평가하지않음)
(10 > 5 || console.log("or 단축평가 1"));
(10 < 5 || console.log("or 단축평가 2"));

// spread 연산자: ...
let obj1 = { name: '홍길동' };
let obj2 = { name: '손오공' };
let obj3 = { addr: '부산시 사하구' };

let obj13 = { ...obj1, ...obj3 };
console.log(obj13);
console.log(JSON.stringify(obj13));
alert(JSON.stringify(obj13));

let obj12 = { ...obj1, ...obj2 };   // 키값이 같으면 뒤의 값만 남는다.
console.log(JSON.stringify(obj12)); // 일반문자열로 변환됨

let ary1 = [1, 3, 5, 7, 9];
let ary3 = [2, 4, 6, 8, 10];
let ary13 = [...ary1, ...ary3];
console.log(ary13);
alert(ary13);

