var API_ENDPOINT = "https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev"

document.getElementById("submitButton").onclick = function(){
	var inputData = {
		"username" : document.getElementById('name').value,
		"income" : parseFloat(document.getElementById('income').value),
		"rent" : parseFloat(document.getElementById('rent').value),
		"food" : parseFloat(document.getElementById('food').value),
		"transportation" : parseFloat(document.getElementById('transportation').value),
		"recreation" : parseFloat(document.getElementById('recreation').value)
	};

	$.ajax({
	    url: API_ENDPOINT,
	    type: 'POST',
	    data:  JSON.stringify(inputData),
		contentType: 'application/json; charset=utf-8',
	    success: function (response) {
			console.log(response);
	    },
	    error: function (xhr, exception) {
			console.log(xhr);
			console.log("error");
		}
	});
}
