
public class Node2<T>{
	private	int key;  // Key foi definida com inteiro, mas poderia ser String (por ex.)
	private T data;
	private	Node2<T> left, right;
	
	public	Node2() {
		this(-1, null, null, null);
	}
	
	public Node2(int key, T data, Node2<T> left, Node2<T> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
	};

	public T getData() { return data;};
	public Node2<T> getLeft(){ return left;};
	public Node2<T> getRight(){ return right;};
	public int getKey(){ return key; };
	public void setData(T data) { this.data = data;};
	public void setKey(int key){ this.key = key; };
	public void setLeft(Node2<T> left){ this.left = left; };
	public void setRight(Node2<T> right){ this.right = right; };
}
