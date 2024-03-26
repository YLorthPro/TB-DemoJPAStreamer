package be.technobel.demojpastreamer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Badges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @ManyToMany
    @JoinTable(name = "Badges_javanais",
            joinColumns = @JoinColumn(name = "badges_nom"),
            inverseJoinColumns = @JoinColumn(name = "javanaises_id"))
    private List<Javanais> javanaises = new ArrayList<>();

}
