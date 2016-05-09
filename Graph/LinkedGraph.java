package Soal1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;


public class LinkedGraph {
	Scanner in = new Scanner(System.in);

	GraphNode node;
	
	public LinkedGraph (Object a){
		this.node = new GraphNode(a);
		node.out = new ArrayList<>();
		node.in = new ArrayList<>();
	}
	
	
	int i = 0;
	public void nextVertex(GraphNode node) {
		ArrayQueue q = new ArrayQueue();
		GraphNode t = node;
		System.out.println(node.element);

		for (int i = 0; i < t.out.size(); i++) {
			q.put(t.out.get(i));
		}
		
		i = 0;
		while (!q.isEmpty()) {
			i++;
			System.out.println(i+" "+((GraphNode)q.remove()).element);
			
		}
		
		System.out.println("Pilih titik : ");
		
		nextVertex(t.out.get(in.nextInt()-1));	
		

	}
	
	
	public static void main(String [] args) {
		LinkedGraph A = new LinkedGraph("A");
		LinkedGraph B = new LinkedGraph("B");
		LinkedGraph C = new LinkedGraph("C");
		LinkedGraph D = new LinkedGraph("D");
		LinkedGraph E = new LinkedGraph("E");
		LinkedGraph F = new LinkedGraph("F");
		LinkedGraph G = new LinkedGraph("G");
		
		A.node.out.add(B.node);
		A.node.out.add(E.node);
		B.node.out.add(G.node);
		C.node.out.add(B.node);
		D.node.out.add(A.node);
		D.node.out.add(C.node);
		D.node.out.add(G.node);
		E.node.out.add(D.node);
		F.node.out.add(C.node);
		F.node.out.add(E.node);
		F.node.out.add(G.node);
		G.node.out.add(C.node);
		
		A.nextVertex(A.node);
		

		
	}

}
