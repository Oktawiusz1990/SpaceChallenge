public class U1 extends Rocket{

    public U1() {
        cost = 100000000;
        weight = 10000;
        maxWeightWithCargo = 18000;
        currentWeight = weight;
        launchExplosionChance = 0;
        landingCrashChance = 0;
    }

    @Override
    public boolean launch() {
        this.launchExplosionChance = (0.05 * (this.currentWeight/this.maxWeightWithCargo));
        int chance = (int) (Math.random() * 100 + 1);
        return this.launchExplosionChance <= chance;
    }

    @Override
    public boolean land() {
        this.landingCrashChance = (0.01 * (this.currentWeight/this.maxWeightWithCargo));
        int chance = (int) (Math.random() * 100 + 1);
        return this.landingCrashChance <= chance;
    }
}
