package in.internity.serviceapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.internity.serviceapp.entities.Game;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer>{}
