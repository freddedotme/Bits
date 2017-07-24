package bits.bits.team;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

class FileManager
{
  private String            path;
  private FileConfiguration configuration;
  private File              file;

  FileManager(String path)
  {
    this.path = path;
    init();
  }

  private void init()
  {
    String root = Data.ROOT_PATH;
    file = new File(root, path);

    if (!file.exists())
    {
      if (file.getParentFile().mkdirs())
      {
        try
        {
          if (file.createNewFile())
          {
            configuration = YamlConfiguration.loadConfiguration(file);
          }
        } catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }

    configuration = YamlConfiguration.loadConfiguration(file);
  }

  void write(String path, Object value)
  {
    configuration.set(path, value);
    try
    {
      configuration.save(file);
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  Object read(String path)
  {
    return configuration.get(path);
  }

  Set<String> getKeys(String path)
  {
    if (configuration.getConfigurationSection(path) == null) return null;
    return configuration.getConfigurationSection(path).getKeys(false);
  }
}