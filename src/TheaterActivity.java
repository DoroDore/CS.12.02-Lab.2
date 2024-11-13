import java.util.ArrayList;
public class TheaterActivity extends Activity {
    private ArrayList<Actor> cast;
    public TheaterActivity(String activityName, String activityDescription, double activityPrice, int activityCapacity, ArrayList<Actor> cast) {
        super(activityName, activityDescription, activityPrice, activityCapacity);
        this.cast = cast;
    }
    public ArrayList<Actor> getCast() {
        return cast;
    }
    public void setCast(ArrayList<Actor> cast) {
        this.cast = cast;
    }
    @Override
    public String toString() {
        String thing = super.toString();
        thing += (ConsoleColors.CYAN + "\n\t\t---------- CAST: ----------" + ConsoleColors.RESET);
        for (Actor actor : cast) {
            thing += "\n\t\t" + actor;
        }
        return thing;
    }
}
