function Queue() {
	this.front = 0;
	this.rear = 0;
	this.array = {};
}

Queue.prototype.size = function () {
	return this.rear - this.front;
};

Queue.prototype.enqueue = function (data) {
	if (this.front == 0) {
		this.array[++this.rear] = data;
		++this.front;
	} else {
		this.array[++this.rear] = data;
	}
};

Queue.prototype.dequeue = function () {

	if (this.front !== this.rear) {
		deletedData = this.array[this.front];
		delete this.array[this.front];
		this.front++;

		return deletedData;
	}
};
