package be.technobel.demojpastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"be.technobel.demojpastreamer", "com.speedment.jpastreamer"})
public class DemoJpaStreamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaStreamerApplication.class, args);
    }

}
