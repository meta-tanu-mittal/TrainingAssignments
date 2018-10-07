String.prototype.repeatify = function (number) {
	var string = "";
	for (var i = 0; i < number; i++) {
		string = string + this;

	}
	return string;
}
