package hiber.model;

import javax.persistence.*;

//Создайте сущность Car с полями String model и int series,
// на которую будет ссылаться User с помощью связи one-to-one.
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
