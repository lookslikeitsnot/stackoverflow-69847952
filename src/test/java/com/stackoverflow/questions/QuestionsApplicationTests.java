package com.stackoverflow.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.transaction.Transactional;
import com.stackoverflow.questions.ids.MyIdClass;
import com.stackoverflow.questions.repositories.MyEntityRepository;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionsApplicationTests {
	@Autowired
	private MyEntityRepository myEntityRepository;

	@Test
	void contextLoads() {}

	@Test
	@Transactional
	void findById_validId_findsMyEntity() {
		assertNotNull(myEntityRepository.findById(new MyIdClass("foo1", "bar1")));
	}

	@Test
	void findById_validId_findsMyEntityWithFK() {
		assertEquals("externalPk1", myEntityRepository.findById(new MyIdClass("foo1", "bar1")).get()
				.getAnotherEntity().getExternalPk());

	}

	@Test
	void findById_validId_findsMyEntityWithoutJoining() {
		assertThrows(LazyInitializationException.class, () -> myEntityRepository
				.findById(new MyIdClass("foo1", "bar1")).get().getAnotherEntity().getSomething());
	}
}
