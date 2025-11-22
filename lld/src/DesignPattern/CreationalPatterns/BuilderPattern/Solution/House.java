package DesignPattern.CreationalPatterns.BuilderPattern.Solution;

public class House {

    private String houseName;
    private String houseType;
    private String houseColor;
    private boolean hasSwimmingPool;
    private boolean hasFlyingPool;
    private boolean hasGarden;
    private boolean hasGarage;
    private String roof;

    private  House(HouseBuilder houseBuilder) {
        this.houseName = houseBuilder.houseName;
        this.houseType = houseBuilder.houseType;
        this.houseColor = houseBuilder.houseColor;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
        this.hasFlyingPool = houseBuilder.hasFlyingPool;
        this.hasGarden = houseBuilder.hasGarden;
        this.hasGarage = houseBuilder.hasGarage;
        this.roof = houseBuilder.roof;
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

    public static class HouseBuilder {
        private String houseName;
        private String houseType;
        private String houseColor;
        private boolean hasSwimmingPool;
        private boolean hasFlyingPool;
        private boolean hasGarden;
        private boolean hasGarage;
        private String roof;

        public HouseBuilder(String houseName, String houseType, String houseColor) {
            this.houseName = houseName;
            this.houseType = houseType;
            this.houseColor = houseColor;
        }
        public HouseBuilder setHasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }
        public HouseBuilder setHasFlyingPool(boolean hasFlyingPool) {
            this.hasFlyingPool = hasFlyingPool;
            return this;
        }
        public HouseBuilder setHasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }
        public HouseBuilder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }
        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public House build(){
            return new House(this);
        }

    }
}
