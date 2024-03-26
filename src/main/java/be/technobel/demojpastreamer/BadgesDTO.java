package be.technobel.demojpastreamer;

import lombok.Data;

@Data
public class BadgesDTO {
    private String nom;
    
    public static BadgesDTO toDTO(Badges b){
        BadgesDTO dto = new BadgesDTO();
        dto.setNom(b.getNom());
        return dto;
    }
}
