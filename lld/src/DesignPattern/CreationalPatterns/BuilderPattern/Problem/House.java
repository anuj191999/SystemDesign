package DesignPattern.CreationalPatterns.BuilderPattern.Problem;

public class House {

    private String houseName;
    private String houseType;
    private String houseColor;
    private boolean hasSwimmingPool;
    private boolean hasFlyingPool;
    private boolean hasGarden;
    private boolean hasGarage;
    private String roof;

    public House(String houseName, String houseType, String houseColor, boolean hasSwimmingPool, boolean hasFlyingPool, boolean hasGarden, boolean hasGarage, String roof) {
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseColor = houseColor;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasFlyingPool = hasFlyingPool;
        this.hasGarden = hasGarden;
        this.hasGarage = hasGarage;
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseName='" + houseName + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseColor='" + houseColor + '\'' +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasFlyingPool=" + hasFlyingPool +
                ", hasGarden=" + hasGarden +
                ", hasGarage=" + hasGarage +
                ", roof='" + roof + '\'' +
                '}';
    }
}
