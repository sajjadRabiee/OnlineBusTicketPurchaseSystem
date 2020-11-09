package Service.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private City beginning;

    @Column
    private City destination;

    @Column
    private Date timeOfMovement;

    @ManyToMany
    @JoinTable(
            name = "travels_buses",
            joinColumns = {@JoinColumn(name = "travel_id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id")}
    )
    private List<Bus> buses = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getBeginning() {
        return beginning;
    }

    public void setBeginning(City beginning) {
        this.beginning = beginning;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Date getTimeOfMovement() {
        return timeOfMovement;
    }

    public void setTimeOfMovement(Date timeOfMovement) {
        this.timeOfMovement = timeOfMovement;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
