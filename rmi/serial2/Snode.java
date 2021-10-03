import java.io.Serializable;

public class Snode implements Serializable{
	int key;
	String name="";
	
	Snode(int key, String name) {
		this.key = key;
		this.name = name;
	}

	void print(){
		System.out.println("this node's name is "+name+", and key value is "+key);
	}
}