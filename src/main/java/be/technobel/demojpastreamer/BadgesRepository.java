package be.technobel.demojpastreamer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgesRepository extends JpaRepository<Badges, String> {
}