package be.technobel.demojpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JavanaisControler {
    private final JavanaisRepository javanaisRepository;
    
    private final JPAStreamer jpaStreamer;
    
    public JavanaisControler(JavanaisRepository javanaisRepository, JPAStreamer jpaStreamer) {
        this.javanaisRepository = javanaisRepository;
        this.jpaStreamer = jpaStreamer;
    }
    
    @GetMapping("/get")
    public List<Javanais> get(){
        return jpaStreamer.stream(Javanais.class)
                .filter(javanais -> javanais.getName().length()%2 == 0)
                .sorted(Comparator.comparing(Javanais::getName).reversed())
                .toList();
    }
}
