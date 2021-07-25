package automobile.model;

import automobile.data.Constants;
import utils.Utils;

import java.awt.*;

public abstract class Car implements Vehicle, Alarm, Constants {
    private final String VIN;
    private int speed = 0;
    private Color color;
    protected String brand;
    protected float engine;

    public Car() {
        this.color = Utils.getRandomColor();
        this.engine = Math.max(ENGINE_MIN, Utils.getRandomInt(ENGINE_MAX));
        VIN = Utils.generatingRandomString(VIN_LENGTH).toUpperCase();
    }

    public abstract void setBrand(String brand);

    public int getSpeed() {
        return speed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected String generateModel(String[] models) {
        return models[Utils.getRandomInt(models.length)];
    }

    public String getVIN() {
        return this.VIN;
    }

    public float getEngine() {
        return engine;
    }

    @Override
    public void speedUp() {
        speed += SPEED_STEP;
    }

    @Override
    public void slowDown() {
        speed = Math.max(0, speed - SPEED_STEP);
    }

    @Override
    public String toString() {
        return brand + "{" +
                "VIN='" + VIN + '\'' +
                ", color=" + color +
                ", speed=" + speed;
    }
}
