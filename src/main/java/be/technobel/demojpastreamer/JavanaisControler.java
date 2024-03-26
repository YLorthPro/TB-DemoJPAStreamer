package be.technobel.demojpastreamer;

import com.speedment.jpastreamer.application.JPAStreamer;
import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.*;

import jakarta.persistence.criteria.JoinType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public Map<Long, Set<BadgesDTO>> getBadges() {
        return jpaStreamer.stream(of(Javanais.class).joining(Javanais$.badges,JoinType.RIGHT))
                .collect(
                        Collectors.groupingBy(
                                Javanais::getId,
                                Collectors.flatMapping(
                                        javanais -> javanais.getBadges().stream().map(BadgesDTO::toDTO),
                                        Collectors.toSet()
                                )
                        )
                );
    }
}
