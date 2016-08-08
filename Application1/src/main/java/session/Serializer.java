package session;

import entity.Film;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class Serializer implements ISerializer {
    private Path path = Paths.get("object.bin");

    @Override
    public void serialize(ConcurrentHashMap<Long, Film> films) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(films);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    @Override
    public ConcurrentHashMap<Long, Film> deserialize() {
        if (!Files.exists(path)) {
            return new ConcurrentHashMap<Long, Film>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (ConcurrentHashMap<Long, Film>) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
