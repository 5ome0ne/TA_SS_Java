package automobile.model;

import java.util.Objects;

public class Mercedes extends Car {
    private String model;
    private static final String[] models = {"C", "E", "S"};

    public Mercedes() {
        super();
        setBrand(TXT_MERCEDES);
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
        if (!(o instanceof Mercedes)) return false;
        Mercedes mercedes = (Mercedes) o;
        return getEngine() == mercedes.getEngine() && getModel().equals(mercedes.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVIN());
    }
}
