function Node(data) {
	this.data = data;
	this.previous = null;
	this.next = null;
}

function DoublyList() {
	this.length = 0;
	this.head = null;
	this.tail = null;
}

DoublyList.prototype.add = function (value) {
	var node = new Node(value);

	if (this.length) {
		this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;
	} else {
		this.head = node;
		this.tail = node;
	}

	this.length++;

	return node;
};

DoublyList.prototype.printList = function () {
	var currentNode = this.head;
	var list = "";
	while (currentNode) {
		list = list + currentNode.data + " ";
		currentNode = currentNode.next;
	}
	console.log(list);
};

DoublyList.prototype.remove = function (position) {
	var currentNode = this.head,
		length = this.length,
		count = 1,
		message = {
			failure: 'Failure: non-existent node in this list.'
		},
		beforeNodeToDelete = null,
		nodeToDelete = null,
		deletedNode = null;

	// 1st case: an invalid position
	if (length === 0 || position < 1 || position > length) {
		throw new Error(message.failure);
	}

	// 2nd case: the first node is removed
	if (position === 1) {
		this.head = currentNode.next;

		// 2nd case: there is a second node
		if (!this.head) {
			this.head.previous = null;
			// 2nd case: there is no second node
		} else {
			this.tail = null;
		}

		// 3rd case: the last node is removed
	} else if (position === this.length) {
		this.tail = this.tail.previous;
		this.tail.next = null;
		// 4th case: a middle node is removed
	} else {
		while (count < position) {
			currentNode = currentNode.next;
			count++;
		}

		beforeNodeToDelete = currentNode.previous;
		nodeToDelete = currentNode;
		afterNodeToDelete = currentNode.next;

		beforeNodeToDelete.next = afterNodeToDelete;
		afterNodeToDelete.previous = beforeNodeToDelete;
		deletedNode = nodeToDelete;
		nodeToDelete = null;
	}

	this.length--;

	return message.success;
};
