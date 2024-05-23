package com.ie.ebingo21.repository;

import com.ie.ebingo21.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
