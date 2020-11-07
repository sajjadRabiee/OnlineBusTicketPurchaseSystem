package Service.Entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Gender gender;

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_number_generator")
    @SequenceGenerator(
            name="ticket_number_generator",
            sequenceName = "ticket_number_seq")
    @Column(name = "ticket_number")
    private long ticketNumber;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_travel")
    private Travel travel;

    @Column
    @Generated(GenerationTime.ALWAYS)
    private Date ticketIssuanceTime;

}
