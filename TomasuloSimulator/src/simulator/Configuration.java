package simulator;

import java.util.HashMap;
import java.util.Scanner;

class Configuration {
	byte cacheLevels;
	int memAccessCycles, instBufferSize, robSize;
	CacheConfiguration[] cc = new CacheConfiguration[3];
	HashMap<String, Integer[]> rs = new HashMap<String, Integer[]>();
	public static final int MEMORY_CAPACITY = 65536;
	public static final String[] UNITS = { "Adder/Subtractor", "Multipliers",
			"Load/Store Buffers", "Logical Operations" };

	public Configuration() {
		Scanner sc = new Scanner(System.in);

		// Determine no of cache levels
		System.out.println("Additional Cache Levels: [0,1,2]");
		do {
			cacheLevels = sc.nextByte();
			if (cacheLevels < 0 || cacheLevels > 2)
				System.err.println("Please enter a number between 0 and 2");
		} while (cacheLevels < 0 || cacheLevels > 2);

		// Configure each cache level
		System.out
				.println("----------------------Caches----------------------");
		for (int i = 0; i <= cacheLevels; i++) {
			System.out.println("Configuration for L" + i + " cache:");
			System.out.println("Cache Size (in bytes):");
			int S = sc.nextInt();
			System.out.println("Line Size (in bytes):");
			int L = sc.nextInt();
			System.out.println("Associativity [m-way]:");
			int m = sc.nextInt();
			System.out
					.println("Hit Write Policy [0 for Write Through/ 1 for Write Back]:");
			byte hitWritePolicy = sc.nextByte();
			System.out
					.println("Hit Write Policy [0 for Write Around/ 1 for Write Allocate]:");
			byte missWritePolicy = sc.nextByte();
			System.out.println("Cache Data Access Cycles:");
			int accessCycles = sc.nextInt();
			// TODO backup for UTS errors
			cc[i] = new CacheConfiguration(S, L, m, hitWritePolicy,
					missWritePolicy, accessCycles);
		}

		System.out
				.println("----------------------Memory----------------------");
		System.out.println("Memory Access Cycles: ");
		memAccessCycles = sc.nextInt();

		System.out
				.println("----------------Instruction Buffer----------------");
		System.out.println("Instruction Buffer Size: ");
		instBufferSize = sc.nextInt();

		System.out
				.println("----------------Reservation Stations--------------");
		for (int i = 0; i < UNITS.length; i++) {
			Integer[] rsInfo = new Integer[2];
			System.out.println("No of Reservation Stations for " + UNITS[i]
					+ ":");
			rsInfo[0] = sc.nextInt();
			System.out.println("Execution cycles for "+UNITS[i]);
			rsInfo[1] = sc.nextInt();
			rs.put(UNITS[i], rsInfo);
		}

		System.out
				.println("------------------Re-Order Buffer-----------------");
		System.out.println("Re-order Buffer Size: ");
		robSize = sc.nextInt();
		
		sc.close();
	}
}

class CacheConfiguration {
	int S, L, m, accessCycles;
	byte hitWritePolicy, missWritePolicy;
	public static final int WRITE_THROUGH = 0;
	public static final int WRITE_BACK = 1;
	public static final int WRITE_AROUND = 0;
	public static final int WRITE_ALLOCATE = 1;

	public CacheConfiguration(int S, int L, int m, byte hitWritePolicy,
			byte missWritePolicy, int accessCycles) {
		this.S = S;
		this.L = L;
		this.m = m;
		this.hitWritePolicy = hitWritePolicy;
		this.missWritePolicy = missWritePolicy;
		this.accessCycles = accessCycles;
	}
}