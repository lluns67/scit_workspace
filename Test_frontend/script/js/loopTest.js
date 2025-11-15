// 1) 반복문 (while, do~while, for, for~in, for~of)
let ary = [1, 3, 5, 7, 9];


// for~in (데이터의 index를 추출)
for (let i in ary)
    console.log(ary[i]);

// for~of (데이터의 값를 추출)
for (let i of ary)
    console.log(i);

// [연습] 0~ 100 사이에 남수를 10개 발생한다. 발생한 숫자를 배열에수집
// push.push(값);
let exam = [];
for (let i = 0; i < 10; i++) {
    exam.push(Math.floor(Math.random() * 101));
}
console.log(exam);
// [연습 2] exam 배열의 데이터를 정렬하여 출력.
// 결과를 확인한후 잘나오나 확인!
// sort()

exam_sort = (exam).sort((a, b) => a - b);
console.log(exam_sort);

// [연습 3] exam 배열을 비운다.
// 난수를 다시 발생한다.
// 마지막에 푸쉬된 데이터보다 커야만 push할수 있다.\

exam = [];

/**
 * 1. 배열을 선언하고 랜덤값을 배열에 넣기
 * 2. 배열에 첫번째 원소를 pop()을 해서 그다음 n번째 랜덤 값을 비교하기
 * 3. 배열에 있던 원소 값이 랜덤 값보다 클 경우 원소값을 다시 push()
 * 4. 만약 원소값이 랜덤 값보다 작을 경우 원소값 push() 하고 랜덤 값을 push() 하기
 * 5. 배열 길이가 9보다 클 경우 break;
 */

// exam.push(Math.floor(Math.random() * 1000001));
// tmp = exam.pop();
// exam.push(tmp);
// for (let i; ;) {
//     exam.push(Math.floor(Math.random() * 1000001));
//     i = exam.pop();
//     console.log(i)
//     if (i > tmp) {
//         exam.push(i);
//         tmp = i;
//     }
//     if (exam.length > 10) break;
// }
// console.log(exam);
// console.log(exam);
// let temp = Math.random();
// console.log(`난수 값 : ${Math.floor(temp * 100)}`);


// 2) 제어문 (if, switch, break, continue)