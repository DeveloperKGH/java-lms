package nextstep.lms.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Sessions {
    private List<Session> sessions = new ArrayList<>();

    private Sessions() {
    }

    public static Sessions create() {
        return new Sessions();
    }

    public void add(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessions() {
        return Collections.unmodifiableList(sessions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessions sessions1 = (Sessions) o;
        return Objects.equals(sessions, sessions1.sessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessions);
    }
}
