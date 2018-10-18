function Stack() {
	this.size = 0;
	this.storage = {};
}

Stack.prototype.push = function (data) {
	var size = ++this.size;
	this.storage[size] = data;
};

Stack.prototype.pop = function () {
	var size = this.size,
		deletedElement;
	if (size) {
		deletedElement = this.storage[size];
		delete this.storage[size];
		this.size--;
		return deletedElement;
	}
};
