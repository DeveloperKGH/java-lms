package nextstep.lms.infrastructure;

import nextstep.lms.domain.Course;
import nextstep.lms.domain.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
public class JdbcCourseRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCourseRepositoryTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository = new JdbcCourseRepository(jdbcTemplate);
    }

    @Test
    void findById() {
        Course foundCourse = courseRepository.findById(1L).orElse(null);
        assertThat(foundCourse).isEqualTo(Course.of(1L, 1, "TDD, 클린 코드 with Java", 1L, LocalDateTime.now(), LocalDateTime.now()));
    }

    @Test
    void save() {
        Course course = Course.of(2L, 1, "TDD, 클린 코드 with Java", 1L, LocalDateTime.now(), LocalDateTime.now());
        int count = courseRepository.save(course);
        assertThat(count).isEqualTo(1);

        Course foundCourse = courseRepository.findById(2L).orElse(null);
        assertThat(foundCourse).isEqualTo(course);
    }
}
