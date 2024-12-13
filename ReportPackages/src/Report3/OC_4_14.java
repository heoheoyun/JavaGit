package Report3;

public class OC_4_14 {
	public static void main(String[] args) {
		VArray v = new VArray(5);
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+ v.size());
		
		for(int i=0; i<7;i++) {
			v.add(i);
		}
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+ v.size());
		v.print();
		
		v.insert(3, 100);
		v.insert(5, 200);
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+ v.size());
		v.print();
		
		v.remove(10);
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+ v.size());
		v.print();
		
		for(int i=50; i<55; i++) {
			v.add(i);	
		}
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+ v.size());
		v.print();
	}
}
