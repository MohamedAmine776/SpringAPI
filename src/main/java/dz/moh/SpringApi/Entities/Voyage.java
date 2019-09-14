package dz.moh.SpringApi.Entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voyage")
@EntityListeners(AuditingEntityListener.class)
public class Voyage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_voyage;
    @Column(name="destination",nullable = false)
    private String destination ;
    @Column(name="prix",nullable = false)
    private float prix ;
    @Column(name="type",nullable = false)
    private String type;
    @Column(name="date_d",nullable = false)
    private Date date_depart;
    @Column(name="date_a",nullable = false)
    private Date date_arrive;

    public Long getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(Long id_voyage) {
        this.id_voyage = id_voyage;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }
}
