function validateMoviesForm() {
	var title = document.forms["moviesForm"]["title"].value;
	if (title == "") {
		alert("Title is required");
		return false;
	}
	var titlelength = title.length;
	if (titlelength < 2 || titlelength > 100) {
		alert("Title should have 2 to 100 characters");
		return false;
	}
	var gross = document.forms["moviesForm"]["gross"].value;
	if (isNaN(gross)) {
		alert("Box Office has to be a number");
		return false;
	}
	if (gross == "") {
		alert("Box Office is required");
		return false;
	}
	var genre = document.forms["moviesForm"]["genre"].value;
	if (genre == "0") {
		alert("Select one genre");
		return false;
	} 
	var dateOfLaunch= document.forms["moviesForm"]["dateOfLaunch"].value;
	if(dateOfLaunch == ""){
	    alert("Date Of Launch is required");
	    return false;
	}
	if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
	    alert("Incorrect date format.Expected format(dd/mm/yyyy)");
	    return false;
	} 
	  
}
