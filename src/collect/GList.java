package collect;

public class GList<우빈> {
	private 우빈[] data;
	private int index;
	private int max;
	
	public GList() {
		max = 3;
		data = (우빈[]) new Object[max];
		index = 0;
		
	}

	public void add(우빈 object) {
		if(index == max) {
			우빈[] temp = (우빈[]) new Object[++max];
			for(int i=0; i<index; i++) {
				temp[i] = data[i];
			}
			data = temp;
			
		}
		data[index] = object;
		index++;
	}

	public void remove(우빈 object) {
		
	}

	public 우빈 get(int i) {
		return data[i];
		
	}

	public int size() {
		return index;
	}
	
}
