package nextstep.lms.domain;

import nextstep.global.domain.BaseTimeDomain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Course extends BaseTimeDomain {
    private Long id;

    private Sessions sessions = Sessions.create();

    private int generation;

    private String title;

    private Long creatorId;

    private Course(Long id, int generation, String title, Long creatorId, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.generation = generation;
        this.title = title;
        this.creatorId = creatorId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }


    public static Course of(String title, int generation, Long creatorId) {
        return new Course(0L, generation, title, creatorId, LocalDateTime.now(), null);
    }

    public static Course of(Long id, int generation, String title, Long creatorId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Course(id, generation, title, creatorId, createdAt, updatedAt);
    }

    public void addSession(Session session) {
        session.toCourse(this);
        sessions.add(session);
    }

    public Long getId() {
        return id;
    }

    public Sessions getSessions() {
        return sessions;
    }

    public String getTitle() {
        return title;
    }

    public int getGeneration() {
        return generation;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", sessions=" + sessions +
                ", generation=" + generation +
                ", title='" + title + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return generation == course.generation && Objects.equals(id, course.id) && Objects.equals(sessions, course.sessions) && Objects.equals(title, course.title) && Objects.equals(creatorId, course.creatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessions, generation, title, creatorId);
    }
}
