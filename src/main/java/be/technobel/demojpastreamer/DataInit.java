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
        badgesRepository.save(b1);

        Badges b2 = new Badges();
        b2.setNom("Angular");
        badgesRepository.save(b2);
        
        for (int i = 0; i < 50; i++) {
            Javanais javanais = new Javanais();
            javanais.setName(faker.lordOfTheRings().character());
            javanais.setCommentaire(faker.hobbit().quote());
            javanais.setBadges(new ArrayList<>());
            if(i %4 == 0 )
                javanais.getBadges().add(b1);
            if(i %6 == 0 )
                javanais.getBadges().add(b2);
            javanaisRepository.save(javanais);
        }
    }
}
