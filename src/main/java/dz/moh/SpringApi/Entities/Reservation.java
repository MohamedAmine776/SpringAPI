package dz.moh.SpringApi.Entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;
    @Column(name = "id_voyage")
    @JoinColumn(name = "id_voyage")
    private Long id_voyage;
    @Column(name = "id_user")
    @JoinColumn(name = "id_user")
    private Long id_user;
    @Column(name = "date_r")
    private Date date_reservation ;


    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Long getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(Long id_voyage) {
        this.id_voyage = id_voyage;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }
}
