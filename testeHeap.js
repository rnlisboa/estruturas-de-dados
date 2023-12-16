class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    getRight(){
        return this.right;
    }

    getLeft(){
        return this.left;
    }
}

class MinBinaryHeap {
    constructor() {
        this.root = null;
    }

    insert(value) {
        const newNode = new Node(value);

        if (!this.root) {
            this.root = newNode;
        } else {
            this.insertNode(this.root, newNode);
        }
    }

    insertNode(node, newNode) {
        if (node.left === null) {
            node.left = newNode;
        } else if (node.right === null) {
            node.right = newNode;
        } else {
            if (this.getHeight(node.left) <= this.getHeight(node.right)) {
                this.insertNode(node.left, newNode);
            } else {
                this.insertNode(node.right, newNode);
            }
        }

        this.heapify(node);
    }

    heapify(node) {
        if (node === null) return;

        let smallest = node;
        const left = node.left;
        const right = node.right;

        if (left !== null && left.value < smallest.value) {
            smallest = left;
        }

        if (right !== null && right.value < smallest.value) {
            smallest = right;
        }

        if (smallest !== node) {

            const temp = node.value;
            node.value = smallest.value;
            smallest.value = temp;

            this.heapify(smallest);
        }
    }

    getHeight(node) {
        if (node === null) return 0;
        return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
    }

    printNode(node, level) {
        if (node !== null) {
            this.printNode(node.getRight(), level + 1);
            console.log(" ".repeat(level * 4) + node.value);
            this.printNode(node.getLeft(), level + 1);
        }
    }
}


const heap = new MinBinaryHeap();
heap.insert(12);
heap.insert(7);
heap.insert(8);
heap.insert(15);
heap.insert(23);
heap.insert(37);
heap.insert(2);

heap.printNode()
