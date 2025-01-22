package org.example.Model;

public class Blender implements IBlender {
    private boolean powerStatus = false;
    private byte speed = 0;
    private float currentCapacity = 0;
    private final float maxCapacity = 2000; // in milliliters

    @Override
    public byte checkPowerStatus() {
        return (byte) (powerStatus ? 1 : 0);
    }

    @Override
    public byte switchPowerStatus() {
        powerStatus = !powerStatus;
        return checkPowerStatus();
    }

    @Override
    public void fillBlender(String prod, float ml) {
        if (currentCapacity + ml > maxCapacity) {
            currentCapacity = currentCapacity;
        } else {
            currentCapacity += ml;
        }
    }

    @Override
    public void fillBlender(String prod) {
        fillBlender(prod, 300); // Default to 500ml
    }

    @Override
    public float actualCapacity() {
        return (float) currentCapacity;
    }

    @Override
    public void increaseSpeed() {
        if (!powerStatus) {
            return;
        }
        if (speed < 10) {
            speed++;
        }
    }

    @Override
    public void decreaseSpeed() {
        if (!powerStatus) {
            return;
        }
        if (speed > 0) {
            speed--;
        }
    }

    @Override
    public byte checkSpeed() {
        return speed;
    }

    @Override
    public boolean isFull() {
        return currentCapacity >= maxCapacity;
    }

    @Override
    public void emptyBlender() {
        currentCapacity = 0;
    }

    @Override
    public void emptyBlender(float ml) {
        if (ml > currentCapacity) {
            emptyBlender();
        } else {
            currentCapacity -= ml;
        }
    }
}
