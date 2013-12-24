package simulator;

public class RegisterFile {
	Register[] regs;
	String[] producingUnits;
	
	public RegisterFile() {
		regs = new Register[8]; //initialize 8 Registers
		producingUnits = new String[8]; //8 slots to save producing units Qi
	}
	
	public short readRegister(int index) {
		if(withinBounds(index))
			return regs[index].read();
		return -1;
	}
	
	public boolean writeRegister(int index, short data) {
		if(withinBounds(index))
			return regs[index].write(data);
		return false;
	}
	
	public boolean withinBounds(int index) {
		if(index>=0 && index<=7)
			return true;
		else
			throw new ArrayIndexOutOfBoundsException();
	}
}

class Register {
	private short data;
	private final boolean canWrite;
	private String producingUnit;
	
	public Register(boolean canWrite){
		this.data = 0;
		this.canWrite = canWrite;
		this.producingUnit = null;
	}
	
	public short read() {
		return data;
	}
	
	public boolean write(short data) {
		this.data = canWrite? data : 0;
		return canWrite ? true : false;
	}
	
	public void setProducingUnit(String stationName) {
		producingUnit = stationName;
	}
	
	public String getProducingUnit() {
		return producingUnit;
	}
}
