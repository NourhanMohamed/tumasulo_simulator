package simulator;

import java.util.ArrayList;

public class ReOrderBuffer {
	private ArrayList<ROBEntry> rob;
	
	public boolean add(ROBEntry e) {
		return rob.add(e);
	}
	
	public ROBEntry removeFirst() {
		return rob.remove(0);
	}
	
	public ROBEntry getFirst() {
		return rob.get(0);
	}
	
	public int size() {
		return rob.size();
	}
	
	public boolean isEmpty() {
		return rob.isEmpty();
	}
	
	public void flush() {
		rob.clear();
	}
}

class ROBEntry {
	private String type;
	private short value;
	private int destination;
	private boolean memOperation;
	private boolean ready;
	private boolean commited;
	
	public ROBEntry(String type, short value, int dest, boolean memOp) {
		this.type = type;
		this.value = value;
		this.destination = dest;
		this.memOperation = memOp;
		this.ready = this.commited = false;
	}
	
	public void commit() {
		if(ready)
			commited = true;
	}
	
	public boolean isCommited() {
		return commited;
	}
	
	public void setReady() {
		ready = true;
	}
	
	public boolean isBranch() {
		return type.equals("branch");
	}
	
	public boolean isMemoryOperation() {
		return memOperation;
	}
	
	public short getValue() {
		return value;
	}
	
	public int getDestination() {
		return destination;
	}
}
