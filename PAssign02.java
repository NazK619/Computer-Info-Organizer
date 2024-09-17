
public class PAssign02 {
    public static void main(String[] args) {
        // Create Computer/VideoCard instances and test here
    }
}


class Computer {
    private String brand;
    private String model;
    private VideoCard videoCard;

    public Computer(String brand, String model, VideoCard videoCard) {
        this.brand = brand;
        this.model = model;
        this.videoCard = videoCard;
    }
    public Computer(VideoCard videoCard) {
        this("OEM", "Basic", videoCard); // Default to OEM Basic
    }
    public Computer() {
        this.brand = "OEM";
        this.model = "Basic";
        this.videoCard = new VideoCard(); // Create default VideoCard
    }

    // Getter methods for brand, model, and video card
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public String getInfo() {
        return brand + " " + model + "\n" +
               "Video Card Info:\n" +
               videoCard.getInfo();
    }
}

class VideoCard {
    private String type;
    private String connectionType;
    private double powerRequirement;
    private String externalPower;
    private double memorySize;

    public VideoCard(String type, String connectionType, double powerRequirement,
                     String externalPower, double memorySize) {
        this.type = type;
        this.connectionType = connectionType;
        setPowerRequirement(powerRequirement);
        this.externalPower = externalPower;
        setMemorySize(memorySize);
    }

    public VideoCard() {
        this("integrated", "N/A", 100, "N/A", 1);
    }

    // Getter methods for video card properties
    public String getType() {
        return type;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public double getPowerRequirement() {
        return powerRequirement;
    }

    public String getExternalPower() {
        return externalPower;
    }

    public double getMemorySize() {
        return memorySize;
    }

    public String getInfo() {
        return "Type: " + type + "\n" +
               "Connection: " + connectionType + "\n" +
               "Power: " + (int) powerRequirement + "W\n" +
               "Ext Power: " + externalPower + "\n" +
               "Memory: " + (int) memorySize + "GB";
    }

    public void setPowerRequirement(double powerRequirement) {
        if (powerRequirement < 1) {
            this.powerRequirement = 75;
        } else if (powerRequirement > 500) {
            this.powerRequirement = 400;
        } else {
            this.powerRequirement = powerRequirement;
        }
    }

    public void setMemorySize(double memorySize) {
        if (memorySize < 1) {
            this.memorySize = 1;
        } else if (memorySize > 16) {
            this.memorySize = 16;
        } else {
            this.memorySize = memorySize;
        }
    }
}