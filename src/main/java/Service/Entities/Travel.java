package Service.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String beginning;

    @Column
    private String destination;

    @Column
    private LocalTime timeOfMovement;

    @Column
    private Date dateOfMovement;

    @Column(name = "travel_number" , nullable = false , updatable = false , unique = true)
    private long travelNumber;

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

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getTimeOfMovement() {
        return timeOfMovement;
    }

    public void setTimeOfMovement(LocalTime timeOfMovement) {
        this.timeOfMovement = timeOfMovement;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public Date getDateOfMovement() {
        return dateOfMovement;
    }

    public void setDateOfMovement(Date dateOfMovement) {
        this.dateOfMovement = dateOfMovement;
    }

    public long getTravelNumber() {
        return travelNumber;
    }

    public void setTravelNumber(long travelNumber) {
        this.travelNumber = travelNumber;
    }
}
