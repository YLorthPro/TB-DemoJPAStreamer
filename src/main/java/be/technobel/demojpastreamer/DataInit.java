package be.technobel.demojpastreamer;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {

    Faker faker = new Faker();
    private final JavanaisRepository javanaisRepository;
    
    public DataInit(JavanaisRepository javanaisRepository) {
        this.javanaisRepository = javanaisRepository;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {

        
        for (int i = 0; i < 50; i++) {
            Javanais javanais = new Javanais();
            javanais.setName(faker.lordOfTheRings().character());
            javanais.setCommentaire(faker.hobbit().quote());
            javanaisRepository.save(javanais);
        }
    }
}
