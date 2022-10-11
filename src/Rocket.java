public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int maxWeightWithCargo;
    int currentWeight;
    double launchExplosionChance;
    double landingCrashChance;

    @Override
    public boolean launch() {
        return false;
    }

    @Override
    public boolean land() {
        return false;
    }

    /*Method that takes an Item as an argument and returns true if the rocket can carry such item or false if
    it will exceed the weight limit.*/
    @Override
    public boolean canCarry(Item item) {
        return this.currentWeight + item.getWeight() <= maxWeightWithCargo;
    }

    /*Method that also takes an Item object and updates the current weight of the rocket.*/
    @Override
    public int carry(Item item) {
        return this.currentWeight = this.currentWeight + item.getWeight();
    }
}
