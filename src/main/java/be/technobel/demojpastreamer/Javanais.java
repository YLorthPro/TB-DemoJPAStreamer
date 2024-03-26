package be.technobel.demojpastreamer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Collection;

@Entity
@Data
@Table(name = "javanais")
public class Javanais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String commentaire;

    @ManyToMany(mappedBy = "javanaises")
    @ToString.Exclude
    private Collection<Badges> badges;

}
