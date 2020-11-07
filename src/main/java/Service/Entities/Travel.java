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
    private String beginning;

    @Column
    private String destination;

    @Column
    private Date timeOfMovement;

    @ManyToMany
    @JoinTable(
            name = "travels_buses",
            joinColumns = {@JoinColumn(name = "travel_id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id")}
    )
    private List<Bus> buses = new ArrayList<>();
}
