package be.technobel.demojpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.*;

import jakarta.persistence.criteria.JoinType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JavanaisControler {
    private final JPAStreamer jpaStreamer;
    
    public JavanaisControler(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }
    
    @GetMapping("/get")
    public List<Javanais> get(){
        return jpaStreamer.stream(Javanais.class)
                .filter(javanais -> javanais.getName().length()%2 == 0)
                .sorted(Javanais$.name.reversed())
                .toList();
    }

    @GetMapping("/getBadges")
    public void getBadges(){
        jpaStreamer.stream(of(Javanais.class).joining(Javanais$.badges, JoinType.LEFT))
                .forEach(System.out::println);
    }
}
