function getNumber() {
    var number = document.getElementById("number");
    return number.value;
}

function displaysResult(originalNumber, decompositionArray) {
    var resultString = originalNumber + ' = ';
    resultString = resultString + decompositionArray.join(" x ");
    document.getElementById('result').innerHTML = resultString;
}