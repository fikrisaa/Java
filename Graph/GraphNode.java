package Soal1;
import java.util.ArrayList;


public class GraphNode {
	ArrayList<GraphNode> out;
	ArrayList<GraphNode> in;
	Object element;
	boolean visit;
	
	public GraphNode(Object a){
		element = a;
		visit = false;
		
	}

}
