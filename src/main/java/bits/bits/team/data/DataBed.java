package bits.bits.team.data;

public class DataBed {
  private int sleeping;

  public DataBed(int sleeping) {
    this.sleeping = sleeping;
  }

  public int getSleeping() {
    return sleeping;
  }

  public void setSleeping(int sleeping) {
    this.sleeping = sleeping;
  }

  public void incrementSleeping(int increment) {
    sleeping += increment;
  }

  public void decreaseSleeping(int decrease) {
    if (sleeping - decrease >= 0) sleeping -= decrease;
  }
}
