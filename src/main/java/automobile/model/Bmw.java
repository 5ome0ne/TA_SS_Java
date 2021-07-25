package automobile.model;

import java.util.Objects;

public class Bmw extends Car {
    private String model;
    private static final String[] models = {"3", "5", "7"};

    public Bmw() {
        super();
        setBrand(TXT_BMW);
        this.model = generateModel(models);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bmw)) return false;
        Bmw bmw = (Bmw) o;
        return getEngine() == bmw.getEngine() && getModel().equals(bmw.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVIN());
    }
}
