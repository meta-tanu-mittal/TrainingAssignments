function removeConsecutiveCharacters(inputString) {
	var i = 0,
		flag = 0;
	for (i = 0; i <= inputString.length - 2; i++) {
		var temp = inputString[i];
		while (inputString[i] == inputString[i + 1]) {
			flag = 1;
			temp = temp + inputString[i + 1];
			i++;

		}
		if (flag == 1) {
			inputString = inputString.replace(temp, "");
			flag = 0;
			i = 0;
		}

	}
	return inputString;
}
