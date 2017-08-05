package bits.bits.team.file;

import bits.bits.team.data.Data;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FileManager {
  private String path;
  private FileConfiguration configuration;
  private File file;

  public FileManager(String path) {
    this.path = path;
    init();
  }

  private void init() {
    String root = Data.ROOT_PATH;
    file = new File(root, path);

    if (!file.exists()) {
      if (file.getParentFile().mkdirs()) {
        try {
          if (file.createNewFile()) {
            configuration = YamlConfiguration.loadConfiguration(file);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    configuration = YamlConfiguration.loadConfiguration(file);
  }

  public void write(String path, Object value) {
    configuration.set(path, value);
    try {
      configuration.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Object read(String path) {
    return configuration.get(path);
  }

  public Set<String> getKeys(String path) {
    if (configuration.getConfigurationSection(path) == null) return null;
    return configuration.getConfigurationSection(path).getKeys(false);
  }
}