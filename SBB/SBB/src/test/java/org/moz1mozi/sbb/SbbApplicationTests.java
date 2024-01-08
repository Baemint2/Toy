package org.moz1mozi.sbb;

import static
		org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.moz1mozi.sbb.answer.Answer;
import org.moz1mozi.sbb.answer.AnswerRepository;
import org.moz1mozi.sbb.question.QuestionRepository;
import org.moz1mozi.sbb.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.Subject;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {
		for (int i = 1; i < 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "냉무";
			this.questionService.create(subject, content, null);
		}

		}
		}

