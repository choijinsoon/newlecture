package collect;

public class ObjectList {
	private Object[] data;
	private int index;
	private int max;
	
	private Object[] tmp;
	private int index1;
	
	public ObjectList() {
		max = 3;
		data = new Object[max];
		index = 0;
		
	}

	public void add(Object object) {
		if(index == max) {
			Object[] temp = new Object[++max];
			for(int i=0; i<index; i++) {
				temp[i] = data[i];
			}
			//data = new Object[max];
			data = temp;
			//data[max] = object;
			
		}
		data[index] = object;
		index++;
	}

	public void remove(Object object) {
		int index1 = index;
		for(int i=0; i<index; i++) {
			if(data[index] == object) {
				index1--;
				continue;
			}
			else {
				Object[] temp = new Object[index];
				temp[index] = object;
				data = temp;
			}
		}
		
	}

	public Object get(int i) {
		return data[i];
		
	}

	public int size() {
		return index;
	}
	
}
