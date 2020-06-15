package ssl.ois.timelog.adapter.repository.memory;

import ssl.ois.timelog.model.log.Log;
import ssl.ois.timelog.service.log.LogRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MemoryLogRepository implements LogRepository {
    private Map<UUID, Log> logs;

    public MemoryLogRepository() {
        this.logs = new HashMap<>();
    }

    @Override
    public void save(Log log) {
        this.logs.put(log.getID(), log);
    }

    @Override
    public Log findByID(UUID id) {
        return this.logs.get(id);
    }

    @Override
    public Boolean removeByID(UUID id) {
        return this.logs.remove(id) != null;
    }

    @Override
    public List<Log> getByUserID(String userID) {
        List<Log> logs = new ArrayList<Log>();
        for(Log log: this.logs.values()) {
            if(log.getUserID().toString().equals(userID)) {
                logs.add(log);
            }
        }
        return Collections.unmodifiableList(logs);
    }
}
