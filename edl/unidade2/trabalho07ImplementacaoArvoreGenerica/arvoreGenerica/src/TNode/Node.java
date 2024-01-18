package TNode;

import java.util.Iterator;
import java.util.ArrayList;

public class Node {
		private Object o;
		private Node pai;
		private ArrayList<Node> filhos = new ArrayList<Node>();

		public Node(Node pai, Object o) {
			this.pai = pai;
			this.o = o;
		}

		public Object element() {
			return o;
		}

		public Node parent() {
			return pai;
		}

		public void setElement(Object o) {
			this.o = o;
		}

		public void addChild(Node o) {
			filhos.add(o);
		}

		public void removeChild(Node o) {
			filhos.remove(o);
		}

		public int childrenNumber() {
			return filhos.size();
		}

		public Iterator<Node> children() {
			return filhos.iterator();
		}
	}
