package com.example.rehamalmutairi_assognment17.Repository;

import com.example.rehamalmutairi_assognment17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
