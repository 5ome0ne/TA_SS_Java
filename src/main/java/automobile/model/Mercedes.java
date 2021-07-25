package automobile.model;

import java.util.Objects;

public class Mercedes extends Car {
    private String model;

    public Mercedes() {
        super();
        setBrand(TXT_MERCEDES);
        this.model = generateModel(MERCEDES_MODELS);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mercedes)) return false;
        Mercedes mercedes = (Mercedes) o;
        return getEngine() == mercedes.getEngine() && getModel().equals(mercedes.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVIN());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }
}
