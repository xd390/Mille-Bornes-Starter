package nc.unc.gl.borne.session;

import com.vaadin.flow.server.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class VaadinSessionsHolder implements VaadinServiceInitListener, SessionInitListener, SessionDestroyListener {

    private static final Logger logger = LoggerFactory.getLogger(VaadinSessionsHolder.class);
    private final static Map<String, VaadinSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addSessionInitListener(this);
        event.getSource().addSessionDestroyListener(this);
    }

    @Override
    public void sessionInit(SessionInitEvent event) {
        var session = event.getSession();
        logger.info("New session: {}", session.getSession().getId());
        sessions.put(session.getSession().getId(), session);
    }

    @Override
    public void sessionDestroy(SessionDestroyEvent event) {
        var session = event.getSession();
        logger.info("Session Destroy: {}", session.getSession().getId());
        sessions.remove(session.getSession().getId());
    }

    public static Map<String, VaadinSession> getAllSessions() {
        return sessions;
    }

    public static VaadinSession getSession(String session){return sessions.get(session);}
}
