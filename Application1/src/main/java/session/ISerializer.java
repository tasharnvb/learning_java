package session;

import entity.Film;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Academy07 on 08/08/2016.
 */
public interface ISerializer {
    void serialize(ConcurrentHashMap<Long, Film> map);

    <T> T deserialize();
}
