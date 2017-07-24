package bits.bits.team;

class DataBed
{
  private int sleeping;

  DataBed(int sleeping)
  {
    this.sleeping = sleeping;
  }

  int getSleeping()
  {
    return sleeping;
  }

  void setSleeping(int sleeping)
  {
    this.sleeping = sleeping;
  }

  void incrementSleeping(int increment)
  {
    sleeping += increment;
  }

  void decreaseSleeping(int decrease)
  {
    if (sleeping - decrease >= 0) sleeping -= decrease;
  }
}
