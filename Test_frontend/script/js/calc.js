init();

function init() {

    const calc = document.getElementById("calc");
    const clear = document.getElementById("clear");

    calc.addEventListener('click', calcProc);
    clear.addEventListener('click', clearProc);
};

function calcProc() {
    let val1 = document.getElementById("val1").value;
    let val2 = document.getElementById("val2").value;
    let result = document.getElementById("result");
    let oper = document.getElementById("oper").value;

    // 숫자만 입력을 했나
    if (isNaN(val1) || val1.trim().length == 0) {
        alert("숫자만 입력하시오!");
        document.getElementById("val1").selected();
        return;
    }

    let calcData = 0;
    switch (oper) {
        case "+": calcData = parseInt(val1) + parseInt(val2); break;
        case "-": calcData = val1 - val2; break;
        case "*": calcData = parseInt(val1) * parseInt(val2); break;
        case "/": calcData = parseInt(val1) / parseInt(val2); break;
    }
    result.value = calcData;
}
function clearProc() {
    document.getElementById("val1").value = "";
    document.getElementById("val2").value = "";
    document.getElementById("result").value = "";

}

