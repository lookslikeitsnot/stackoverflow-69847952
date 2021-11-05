package com.stackoverflow.questions.repositories;

import com.stackoverflow.questions.entities.MyEntity;
import com.stackoverflow.questions.ids.MyIdClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, MyIdClass> {

}
