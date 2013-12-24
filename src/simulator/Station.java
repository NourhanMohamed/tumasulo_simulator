package simulator;

public class Station {
    String stationName;
    boolean busy;
    String operation;
    short Vj;
    short Vk;
    String Qj;
    String Qk;
    int A;
    short Vi;
    
    boolean resultReady;
    boolean isWritten;
    
    public Station(String name) {
    	stationName = name;
    	busy = resultReady = isWritten = false;
    	operation = Qj = Qk = null;
    	Vj = Vk = Vi = 0;
    	A = 0;
    }
    
    public boolean isReadyForExec() {
    	return (busy && Qj == null && Qk == null && !resultReady);
    }
    
    public void clear() {
    	busy = resultReady = isWritten = false;
    	Vi = Vj = Vk = 0;
    	A = 0;
    	operation = Qj = Qk = null;
    }
    
    
    
    
}
