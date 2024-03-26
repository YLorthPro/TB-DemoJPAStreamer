package be.technobel.demojpastreamer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "javanais")
public class Javanais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String commentaire;

}
