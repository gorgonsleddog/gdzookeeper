package com.generaldynamics.habitats;

public enum Habitat {
    WATER_BREATHER(false, false), AIR_BREATHER(true, true);

    Habitat(final boolean getsThirsty, final boolean canBePutToBed) {
        this.getsThirsty = getsThirsty;
        this.canBePutToBed = canBePutToBed;
    }

    public boolean canBeThirsty() {
        return getsThirsty;
    }

    public boolean canBePutToBed() {
        return canBePutToBed;
    }

    private final boolean getsThirsty;

    private final boolean canBePutToBed;
}
