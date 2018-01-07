var API_ENDPOINT = "https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev"

document.getElementById("submitButton").onclick = function(){
	var inputData = {
		"username" : document.getElementById('name').value,
		"income" : document.getElementById('income').value,
		"rent" : document.getElementById('rent').value,
		"food" : document.getElementById('food').value,
		"transportation" : document.getElementById('transportation').value,
		"recreation" : document.getElementById('recreation').value
	};

	// $.ajax({
	//     url: API_ENDPOINT,
	//     type: 'POST',
	//     data:  JSON.stringify(inputData),
	// 	contentType: 'application/json; charset=utf-8',
	//     success: function (response) {
	// 		console.log(response);
	//     },
	//     error: function (xhr, exception) {
	// 		console.log(xhr);
	// 		console.log("error");
	// 	}
	// });

	var xhr = new XMLHttpRequest();
	xhr.open("POST", API_ENDPOINT, true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        var json = JSON.parse(xhr.responseText);
	        console.log(json);
	    }
	};
	var data = JSON.stringify(inputData);
	console.log(data);
	xhr.send(data);
}
