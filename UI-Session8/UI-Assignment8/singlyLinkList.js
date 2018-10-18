function Node(data) {
	this.data = data;
	this.next = null;
}

function SinglyList() {
	this.length = 0;
	this.head = null;
}

SinglyList.prototype.add = function (value) {
	var node = new Node(value),
		currentNode = this.head;

	// 1st case: an empty list
	if (!currentNode) {
		this.head = node;
		this.length++;

		return node;
	}

	// 2nd case: a non-empty list
	while (currentNode.next) {
		currentNode = currentNode.next;
	}

	currentNode.next = node;

	this.length++;

	return node;
};

SinglyList.prototype.printList = function () {
	var currentNode = this.head;
	var list = "";
	while (currentNode) {
		list = list + currentNode.data + " ";
		currentNode = currentNode.next;
	}
	console.log(list);
};

SinglyList.prototype.searchNodeAt = function (position) {
	var currentNode = this.head,
		length = this.length,
		count = 1,
		message = {
			failure: 'Failure: non-existent node in this list.'
		};

	// 1st case: an invalid position
	if (length === 0 || position < 1 || position > length) {
		throw new Error(message.failure);
	}

	// 2nd case: a valid position
	while (count < position) {
		currentNode = currentNode.next;
		count++;
	}

	return currentNode;
};

SinglyList.prototype.remove = function (position) {
	var currentNode = this.head,
		length = this.length,
		count = 0,
		message = {
			failure: 'Failure: non-existent node in this list.'
		},
		beforeNodeToDelete = null,
		nodeToDelete = null,
		deletedNode = null;

	// 1st case: an invalid position
	if (position < 0 || position > length) {
		throw new Error(message.failure);
	}

	// 2nd case: the first node is removed
	if (position === 1) {
		this.head = currentNode.next;
		deletedNode = currentNode;
		currentNode = null;
		this.length--;

		return deletedNode;
	}

	// 3rd case: any other node is removed
	while (count < position) {
		beforeNodeToDelete = currentNode;
		nodeToDelete = currentNode.next;
		count++;
	}

	beforeNodeToDelete.next = nodeToDelete.next;
	deletedNode = nodeToDelete;
	nodeToDelete = null;
	this.length--;

	return deletedNode;
};
