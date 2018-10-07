window.addEventListener('load', main);
//main function to test linked list, stack and queue implementation 
function main(event) {
	//singly linked list
	var singlyList = new SinglyList();
	singlyList.add(10);
	singlyList.add(20);
	singlyList.add(30);
	singlyList.add(40);
	singlyList.printList();
	console.log(singlyList.remove(2));
	singlyList.printList();


	//doubly linked list
	var doublyList = new DoublyList();
	doublyList.add(10);
	doublyList.add(20);
	doublyList.add(30);
	doublyList.add(40);
	doublyList.printList();
	console.log(doublyList.remove(2));
	doublyList.printList();


	//remove consecutive repeating characters of a string
	console.log(removeConsecutiveCharacters("eeabcddcbfgf"));



	//stack 
	var stack = new Stack();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	console.log(stack);
	stack.pop();
	console.log(stack);


	//queue
	queueObject = new Queue();
	queueObject.enqueue(10);
	queueObject.enqueue(20);
	queueObject.enqueue(30);
	queueObject.enqueue(40);
	console.log(queueObject);
	console.log(queueObject.dequeue());
	console.log(queueObject);


	//repeat string n number of times 
	console.log("hello".repeatify(3));
}
