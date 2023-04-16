package ru.gallismo.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gallismo.taskman.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
