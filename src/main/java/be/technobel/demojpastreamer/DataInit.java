package be.technobel.demojpastreamer;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    Faker faker = new Faker();
    private final JavanaisRepository javanaisRepository;
    private final BadgesRepository badgesRepository;
    
    public DataInit(JavanaisRepository javanaisRepository, BadgesRepository badgesRepository) {
        this.javanaisRepository = javanaisRepository;
        this.badgesRepository = badgesRepository;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {

        Badges b1 = new Badges();
        b1.setNom("Git");
        b1.setJavanaises(new ArrayList<>());

        Badges b2 = new Badges();
        b2.setNom("Angular");
        b2.setJavanaises(new ArrayList<>());
        
        for (int i = 0; i < 10; i++) {
            Javanais javanais = new Javanais();
            javanais.setName(faker.lordOfTheRings().character());
            javanais.setCommentaire(faker.hobbit().quote());
            javanais.setBadges(new ArrayList<>());
            if(i %4 == 0 ) {
                b1.getJavanaises().add(javanais);
            }
            if(i %6 == 0 ) {
                b2.getJavanaises().add(javanais);
            }
            javanaisRepository.save(javanais);
        }
        badgesRepository.save(b1);
        badgesRepository.save(b2);
    }
}
