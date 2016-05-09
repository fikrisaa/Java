package array;

public class tesArrayLinearList {
	
	public static void main(String[] args){
		ArrLinearList arr = new ArrLinearList(5);
		System.out.println("Size Arr = "+arr.size);
		arr.add(0, "A");
		arr.add(0, "B");
		arr.add(2, "C");
		arr.add(3, "D");
		arr.add(4, "E");
		arr.add(5, "F");
		arr.add(6, "G");
		System.out.println("Size Arr Setelah ditambah elemen = "+arr.size);
		System.out.println("=== Element Arr ===");
		for(int i=0;i<arr.size;i++){
			System.out.println(arr.get(i));
		}
		arr.remove(1);
		System.out.println("Size Arr Setelah diremove = "+arr.size);
		System.out.println("=== Element Arr ===");
		for(int i=0;i<arr.size;i++){
			System.out.println(arr.get(i));
		}
	}
	
}