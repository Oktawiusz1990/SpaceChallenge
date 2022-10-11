public class U2 extends Rocket{
    public U2() {
        cost = 120000000;
        weight = 18000;
        maxWeightWithCargo = 29000;
        currentWeight = weight;
        launchExplosionChance = 0;
        landingCrashChance = 0;
    }

    @Override
    public boolean launch() {
        this.launchExplosionChance = (0.04 * (this.currentWeight/this.maxWeightWithCargo));
        int chance = (int) (Math.random() * 100);
        return this.launchExplosionChance <= chance;
    }

    @Override
    public boolean land() {
        this.landingCrashChance = (0.08 * (this.currentWeight/this.maxWeightWithCargo));
        int chance = (int) (Math.random() * 100);
        return this.landingCrashChance <= chance;
    }
}

