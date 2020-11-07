package Service.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Gender gender;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<>();
}
