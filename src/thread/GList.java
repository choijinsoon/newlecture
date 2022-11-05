package thread;

public class GList<우빈> {
	private 우빈[] data;
	private int index; //for adding
	private int current; //for 반환
	private int max;
	
	public GList() {
		max = 3;
		data = (우빈[]) new Object[max];
		index = 0;
		current = -1;
		
	}

	public void add(우빈 object) {
		if(index == max) {
			우빈[] temp = (우빈[]) new Object[max+3];
			for(int i=0; i<index; i++) {
				temp[i] = data[i];
			}
			data = temp;
			max = max+3;
			
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

	public boolean hasNext() {
		return data[current+1] != null;
	}

	public 우빈 next() {
		return data[++current];
	}
	
}
