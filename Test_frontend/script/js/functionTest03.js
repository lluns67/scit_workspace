init();

function init() {
    const submitBtn = document.querySelector("#submitBtn");
    submitBtn.addEventListener('click', process);
}

// 검증코드가 처리되는 함수
// 폼 데이터는 대부분 value로 읽어올 수 있다.
function process() {
    // 아이디: 3~5글자가 입력되어야 함
    let userid = document.getElementById("userid").value; // input
    let complete = '<ul><li>';

    if (userid.length < 3 || userid.length > 5) {
        alert("아이디는 3~5글자로 입력하시오");
        document.getElementById("userid").select();
        return;
    }
    complete += `${userid}</li>`;

    let userpwd = document.getElementById("userpwd").value;


    if (userpwd.length < 3 || userpwd.length > 5) {
        alert("비밀번호는 3~5글자로 입력하시오");
        document.getElementById("userpwd").select();
        return;
    }
    complete += '<li>' + userpwd + '</li>';

    let gender = document.querySelector("input[type=radio]:checked").value;
    complete += '<li>' + gender + '</li>';

    let hobby = document.querySelectorAll("input[type=checkbox]:checked");
    let temp = '';
    hobby.forEach((item) => temp += item.value + " ");


    complete += '<li>' + temp + '</li>';

    let color = document.getElementById("color").value;
    complete += '<li>' + color + '</li>';

    let now = document.querySelector("input[type=datetime-local]").value;
    if (!now) alert("날짜 입력하세요");
    complete += '<li>' + now.replace('T', ' ') + '</li>';

    let email = document.getElementById("email").value;
    if (!email) alert("이메일 입력하세요✌️");
    complete += '<li>' + email + '</li>';

    let range = document.querySelector("input[type=range]").value;
    complete += '<li>' + range + '</li>';

    let hidden = document.querySelector("input[type=hidden]").name;
    complete += '<li>' + hidden + '</li>';

    let address = document.getElementById("address").value;
    complete += '<li>' + address + '</li>';

    let data = document.querySelector("textarea[name=data]").value;

    complete += '<li>' + data + '</li>';




    // 완성된 값을 #targer에 삽입
    document.getElementById("target").innerHTML = complete;

}