
public class TestComputer {
	public static void main(String[] args) {
        // Create an array of computers
        Computer[] lab = new Computer[5];

        // Computer 1: OEM Basic w/ default VideoCard
        lab[0] = new Computer();

        // Computer 2: Dell Optiplex w/ discrete VideoCard
        VideoCard vc2 = new VideoCard("discrete", "PCIEx16", 575, "8-pin", 24);
        lab[1] = new Computer("Dell", "Optiplex", vc2);

        // Computer 3: Lenovo IdeaCentre w/ integrated VideoCard
        VideoCard vc3 = new VideoCard("integrated", "N/A", 120, "N/A", 4);
        lab[2] = new Computer("Lenovo", "IdeaCentre", vc3);

        // Computer 4: HP Omen Obelisk w/ discrete VideoCard
        VideoCard vc4 = new VideoCard("discrete", "PCIEx8", 150, "6-pin", 8);
        lab[3] = new Computer("HP", "Omen Obelisk", vc4);

        // Computer 5: Lenovo IdeaCentre w/ integrated VideoCard
        VideoCard vc5 = new VideoCard("integrated", "N/A", -110, "N/A", 2);
        lab[4] = new Computer("Lenovo", "IdeaCentre", vc5);

        // Print info of each computer
        displayComputerInfo(lab);
    }

    // Method to display info of all computers
    public static void displayComputerInfo(Computer[] computers) {
        for (Computer computer : computers) {
            System.out.println(computer.getInfo());
            System.out.println(); // Print an empty line after each computer info
        }
    }
}
/*
 * Computer 1: OEM Basic w/ default VideoCard
• Computer 2: Dell Optiplex w/ disrete VideoCard, PCIEx16 motherboard connection, 575W
draw, 8-pin external power, 24 GB memory
• Computer 3: Lenovo IdeaCentre w/ integrated VideoCard, N/A connection, 120W draw,
N/A external power, 4 GB memory
• Computer 4: HP Omen Obelisk w/ discrete VideoCard, PCIEx8 motherboard connection,
150W draw, 6-pin external power, 8GB memory
• Computer 5: Lenovo IdeaCentre w/ integrated VideoCard, N/A connection, -110W draw,
N/A external power, 2 GB memory
 */

