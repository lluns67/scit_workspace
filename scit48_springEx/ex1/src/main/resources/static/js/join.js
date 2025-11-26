// join.js
/*
    join.html 유효성 검사 작성.
      1. 아이디 : 3 ~ 14자, 영문/숫자/특수문자 포함 허용.
      2. 비밀번호 : 입력값(비밀번호, 비밀번호 확인)의 일치.
      3. 이름 : 필수 입력(값 존재 여부).
      4. 핸드폰 : 필수 입력(값 존재 여부).
//*/

window.onload = function() {
    const form = document.querySelector("form");

    form.addEventListener("submit", function(event) {
        const id = document.querySelector("#id").value.trim();
        const pw1 = document.querySelector("#pw1").value.trim();
        const pw2 = document.querySelector("#pw2").value.trim();
        const name = document.querySelector("#name").value.trim();
        const phone = document.querySelector("#phone").value.trim();

        // 1. 아이디 유효성 검사 (3~14자, 영문/숫자/특수문자 허용)
        const idRegex = /^[A-Za-z0-9!@#$%^&*()_+]{3,14}$/;
        if (!idRegex.test(id)) {
            alert("아이디는 3~14자의 영문, 숫자, 특수문자 조합이어야 합니다.");
            event.preventDefault();
            return;
        }
        if(pw1 == ""){
            alert("비밀벊호를 입력해주세요");
            event.preventDefault();
                        return;
        }
        // 2. 비밀번호 일치 검사
        if (pw1 !== pw2) {
            alert("비밀번호가 일치하지 않습니다.");
            event.preventDefault();
            return;
        }

        // 3. 이름 필수 입력
        if (name == "") {
            alert("이름을 입력해주세요.");
            event.preventDefault();
            return;
        }

        // 4. 핸드폰 필수 입력
        if (phone === "") {
            alert("핸드폰 번호를 입력해주세요.");
            event.preventDefault();
            return;
        }
//        모든 조건 통과 시 폼 제출 허용
    });
};

//        window.onload = function(){
//            document.querySelector("form").onsubmit =  function(e){
//            const id = document.querySelector("#id").value.trim();
//            const pw1 = document.querySelector("#pw1").value.trim();
//            const pw2 = document.querySelector("#pw2").value.trim();
//            const name = document.querySelector("#name").value.trim();
//            const phone = document.querySelector("phone").value.trim();
//
//
//            const idRegex =
//                   /^[A-Za-z0-9!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]{3,14}$/;
////            if(!idRegex.test(id)){}
//
//            if(id.length <3 || id.length > 14){
//                alert("아이디는 3-14자 영문, 숫자, 틋문자를 포함할 수 있습니다.");
//                e.preventDefault();
//                return;
//            }
//            if( !pw1 || !pw2 || pw1 !== pw2){
//                alert("비밀번호가 비어 있거나 일치하지 않습니다.")
//                e.preventDefault();
//                return;
//            }
//            if (name === '')
//
//            }
//            }
//        }
}

