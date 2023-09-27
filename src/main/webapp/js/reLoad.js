window.setTimeout(function(){
    if (window.name != "reloadFlag") {
		location.reload();
		window.name = "reloadFlag";
	}
}, 5000);