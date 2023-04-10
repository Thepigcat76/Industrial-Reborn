package com.maciej916.indreb.common.api.interfaces.item;

public interface IArmorProperties {

    default boolean supportsNightVision() {
        return false;
    }

    default boolean supportsFlight() {
        return false;
    }

    default boolean supportsSpeedBoost() {
        return false;
    }

    default boolean supportsQuantumAbility() {
        return false;
    }

    default boolean supportsJumpBoost() {
        return false;
    }
}
