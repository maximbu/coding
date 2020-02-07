package CodingInterviews2018.P16;

public class Ant {
    private Location location;

    public Ant() {
        location = new Location(new Cell(0,0),Orientation.Right);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        location = newLocation;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "location=" + location +
                '}';
    }
}
