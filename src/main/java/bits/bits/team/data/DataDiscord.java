package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.file.FileManager;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-23
 */
public class DataDiscord {
  private String token;
  private long id;

  public DataDiscord(Main main) {
    String DEFAULT_TOKEN = "42";
    long DEFAULT_ID = 42L;

    FileManager file = new FileManager(main, "discord.yml");
    file.write("version", main.getDescription().getVersion());

    if (file.read("token") == null) file.write("token", DEFAULT_TOKEN);
    if (file.read("id") == null) file.write("id", DEFAULT_ID);

    token = (String) file.read("token");
    id = (long) file.read("id");
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
