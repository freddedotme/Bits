package bits.bits.team.file;

import bits.bits.team.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * The type File manager.
 */
public class FileManager {
  private Main main;
  private String path;
  private FileConfiguration configuration;
  private File file;

  /**
   * Instantiates a new File manager.
   *
   * @param main the main
   * @param path the path
   */
  public FileManager(Main main, String path) {
    this.main = main;
    this.path = path;
    init();
  }

  private void init() {
    String root = main.d().ROOT_PATH;
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

  /**
   * Write.
   *
   * @param path  the path
   * @param value the value
   */
  public void write(String path, Object value) {
    configuration.set(path, value);
    try {
      configuration.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Read object.
   *
   * @param path the path
   * @return the object
   */
  public Object read(String path) {
    return configuration.get(path);
  }

  /**
   * Gets keys.
   *
   * @param path the path
   * @return the keys
   */
  public Set<String> getKeys(String path) {
    if (configuration.getConfigurationSection(path) == null) return null;
    return configuration.getConfigurationSection(path).getKeys(false);
  }
}