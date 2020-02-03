package aufgaben;

public class Task {
	
	public enum Priority {
		LOW(1), NORMAL(2), HIGH(3);
		
		private int size;

		private Priority(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
		
	}

	private final String description;
	
	private final Priority priority;

	public Task(String description, Priority priority) {
//		super();
		this.description = description;
		this.priority = priority;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return description + "(" + priority + ")";
	}
	
}
