package slotMachineII;

public class SlotMachineDemoII {
	
	static SlotMachineII runner = new SlotMachineII();
	
	public static void main(String[] args) {
		runner.play();
		runner.play(1000000, true);
		//runner.writeCsvFile("Test", 1000000); //used for debugging
	}
}