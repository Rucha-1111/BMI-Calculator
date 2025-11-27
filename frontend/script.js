function receiveData() {
    const weight = document.getElementById('weight').value;
    const height = document.getElementById('height').value;

    console.log(weight, height);

    const storeData = {
        weight: weight,
        height: height
    }

    fetch("http://localhost:8080/api/handleData", {
        method: "POST",
        headers: {"Content-type": "application/json"},
        body:JSON.stringify(storeData)
        //send the data from the frontend to the backend
    })
    .then(response=>response.text())
    .then(bmi => {document.getElementById("bmiResult").innerText = "BMI: " + bmi;})
    .catch(error => console.log("Error: ", error))
    //then(response=>response.text()) == converts backend response into text
}