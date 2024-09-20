/*/
 * Class: CSCI 1302
 * Author: Nazim Muhammad
 * Created on: September 18, 2024
 * Last Modified: September 20, 2024
 * Description : PA03 is a modified PA02
 *
 */
public class PAssign03 {
	public static void main(String[] args) {
		// Create the computer lab with 5 computers
		Computer[] computers = new Computer[5];

		// Computer 1: OEM Basic w/ default IntegratedVideoCard
		computers[0] = new Computer();

		// Computer 2: Dell Optiplex w/ DiscreteVideoCard
		computers[1] = new Computer("Dell", "Optiplex", new DiscreteVideoCard("PCIEx16", "8-pin", 400, 16));

		// Computer 3: Lenovo IdeaCentre w/ IntegratedVideoCard
		computers[2] = new Computer("Lenovo", "IdeaCentre", new IntegratedVideoCard(120, 4, 2, false));

		// Computer 4: HP Omen Obelisk w/ DiscreteVideoCard
		computers[3] = new Computer("HP", "Omen Obelisk", new DiscreteVideoCard("PCIEx8", "6-pin", 150, 8));

		// Computer 5: Lenovo IdeaCentre w/ IntegratedVideoCard
		computers[4] = new Computer("Lenovo", "IdeaCentre", new IntegratedVideoCard(75, 3, 2, false));

		// Print information about each computer
		for (Computer computer : computers) {
			System.out.println(computer);
			System.out.println();
		}
	}
}

// The Computer class
class Computer {
	private String brand;
	private String model;
	private VideoCard videoCard;

	// Default constructor
	public Computer() {
		this.brand = "OEM";
		this.model = "Basic";
		this.videoCard = new IntegratedVideoCard();
	}

	// Constructor with parameters
	public Computer(String brand, String model, VideoCard videoCard) {
		this.brand = brand;
		this.model = model;
		this.videoCard = videoCard;
	}

	// Getters
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public VideoCard getVideoCard() {
		return videoCard;
	}

	// toString() method to return computer info
	public String toString() {
		return brand + " " + model + "\nVideo Card Info:\n" + videoCard;
	}
}

// The VideoCard class (base class)
class VideoCard {
	private String type;
	private int powerRequirement;
	private int memorySize;

	// Default constructor
	public VideoCard() {
		this("integrated", 100, 1);
	}

	// Constructor with parameters
	public VideoCard(String type, int powerRequirement, int memorySize) {
		this.type = type;
		setPowerRequirement(powerRequirement);
		setMemorySize(memorySize);
	}

	// Setters with validation
	public void setPowerRequirement(int powerRequirement) {
		if (powerRequirement < 1) {
			this.powerRequirement = 75;
		} else if (powerRequirement > 500) {
			this.powerRequirement = 400;
		} else {
			this.powerRequirement = powerRequirement;
		}
	}

	public void setMemorySize(int memorySize) {
		if (memorySize < 1) {
			this.memorySize = 1;
		} else if (memorySize > 16) {
			this.memorySize = 16;
		} else {
			this.memorySize = memorySize;
		}
	}

	// Getters
	public String getType() {
		return type;
	}

	public int getPowerRequirement() {
		return powerRequirement;
	}

	public int getMemorySize() {
		return memorySize;
	}

	// toString() method
	public String toString() {
		return "Type: " + type + "\nPower: " + powerRequirement + " W\nMemory: " + memorySize + " GB";
	}
}

//The IntegratedVideoCard subclass
class IntegratedVideoCard extends VideoCard {
	private int sharedMemory;
	private boolean usesComputerRAM;

	// Default constructor
	public IntegratedVideoCard() {
		super("integrated", 100, 1);
		this.sharedMemory = 2;
		this.usesComputerRAM = false;
	}

	// Constructor matching test case
	public IntegratedVideoCard(int sharedMemory, boolean usesComputerRAM) {
		super("integrated", 100, 1); // Default values for power and memory
		this.sharedMemory = sharedMemory;
		this.usesComputerRAM = usesComputerRAM;
	}

	// Full constructor
	public IntegratedVideoCard(int powerRequirement, int memorySize, int sharedMemory, boolean usesComputerRAM) {
		super("integrated", powerRequirement, memorySize);
		this.sharedMemory = sharedMemory;
		this.usesComputerRAM = usesComputerRAM;
	}

	// Getters
	public int getSharedMemory() {
		return sharedMemory;
	}

	public boolean getUsesComputerRAM() {
		return usesComputerRAM;
	}

	// toString() method with required formatting
	public String toString() {
		return super.toString() + "\n\nShared Memory: " + sharedMemory + " GB\nComputer RAM: " + usesComputerRAM;
	}
}

//The DiscreteVideoCard subclass
class DiscreteVideoCard extends VideoCard {
	private String connectionType;
	private String usesExternalPower;

	// Default constructor
	public DiscreteVideoCard() {
		super("discrete", 150, 8);
		this.connectionType = "PCIEx8";
		this.usesExternalPower = "6-pin";
	}

	// Constructor matching test case
	public DiscreteVideoCard(String connectionType, String usesExternalPower) {
		super("discrete", 150, 8); // Default values for power and memory
		this.connectionType = connectionType;
		this.usesExternalPower = usesExternalPower;
	}

	// Full constructor
	public DiscreteVideoCard(String connectionType, String usesExternalPower, int powerRequirement, int memorySize) {
		super("discrete", powerRequirement, memorySize);
		this.connectionType = connectionType;
		this.usesExternalPower = usesExternalPower;
	}

	// Getters
	public String getConnectionType() {
		return connectionType;
	}

	public String getUsesExternalPower() {
		return usesExternalPower;
	}

	// toString() method with required formatting
	public String toString() {
		return super.toString() + "\n\nConnection: " + connectionType + "\nExternal Power: " + usesExternalPower;
	}
}