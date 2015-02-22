$(document).ready(function() {
	countdown(year(), 02, 03);
	$('.menu').click(function() {
		var id = $(this).attr("id");
		if (id == "list") {
			id = id + ".do";
		} else {
			id = id + ".jsp";
		}
		$.ajax({
			type : "POST",
			cache : false,
			url : id,
			contentType : "charset=UTF-8",
			dataType : "html",
			success : function(msg) {
				$('#cont').html(msg);
				if (id == "home") {
					countdown(year(), 02, 03);
				}
			}
		})
	})
});

function year() {
	var currentDate = new Date();
	var anno = currentDate.getFullYear();
	if (currentDate.getDate() >= 3 && currentDate.getMonth() >= 1) {
		anno++;
	}
	return anno;
}

function countdown(a, m, g) {
	var d = new Date(a, m, g).valueOf();
	var e = new Date().valueOf();
	var h = Math.round(e - d);

	dday = Math.abs(Math.floor(h / (60 * 60 * 1000 * 24) * 1));
	dhour = Math.abs(Math.floor((h % (60 * 60 * 1000 * 24)) / (60 * 60 * 1000)
			* 1));
	dmin = Math.abs(Math.floor(((h % (60 * 60 * 1000 * 24)) % (60 * 60 * 1000))
			/ (60 * 1000) * 1));
	dsec = Math
			.abs(Math
					.floor((((h % (60 * 60 * 1000 * 24)) % (60 * 60 * 1000)) % (60 * 1000)) / 1000 * 1));
	document.getElementById("conta").innerHTML = format_number(dday) + " : "
			+ format_number(dhour) + " : " + format_number(dmin) + " : "
			+ format_number(dsec);
	setTimeout("countdown(" + a + "," + m + "," + g + ")", 1000);
}

function format_number(number) {
	if (number < 10) {
		return "0" + number;
	}

	return number;
}