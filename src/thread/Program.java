package thread;

public class Program {

	static GList list;
	
	static {
		list = new GList();
		for(int i=0;i<100;i++) 
			list.add(i+1);
	}
	
	public static void print() {
		
		String thName = Thread.currentThread().getName();
//		for(int i=0;i<100;i++) 
//			System.out.printf("%d\n", list.get(i));
		
		while(list.hasNext())
			System.out.printf("%s: %d\n", thName, list.next());
			
	}
	public static void main(String[] args) {
		
		Thread th1 = new Thread(() ->{
			print();
			System.out.println("================================");		
		});
		
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				print();
				System.out.println("================================");
			}
		});

		th1.start();
		th2.start();
		System.out.println("작업종료");
		
		Object[] arr = new Object[10];
		System.out.println(arr[0]);
	}

}
