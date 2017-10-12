import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Person {

	private String id;
	private Map<String, Long> neighborHoodInterests;

	Map<String, Integer> interests;
	SortedSet<String> visitedHoods;
	private int locationCount;

	public Person(String id) {
		this.id = id;
		neighborHoodInterests = new HashMap<String, Long>();
		interests = new HashMap<String, Integer>();
		visitedHoods = new TreeSet<String>();
		locationCount = 0;

		// processEvents(events);
	}

	public void processEvent(Event e) {
		if (e.getUserID().equals(id)) {
			String neighborhood = e.getNeighborhood();
			long timestamp = e.getTimeStamp();
			if (enterExitEvent(e)) {
				if (!(neighborHoodInterests.containsKey(neighborhood))) {
					neighborHoodInterests.put(neighborhood, timestamp);
				} else {
					long interest = e.getTimeStamp() - neighborHoodInterests.get(neighborhood);
					if (interest > 30) {
						int count = interests.containsKey(neighborhood) ? interests.get(neighborhood) : 0;
						interests.put(neighborhood, count + 1);
						locationCount++;
						visitedHoods.add(neighborhood);
					}
					neighborHoodInterests.remove(neighborhood);
				}
			}
		}
	}

	private void processEvents(List<Event> events) {
		for (Event e : events) {

		}
	}

	private boolean enterExitEvent(Event e) {
		return e.getEventType().equals("enter") || e.getEventType().equals("exit");
	}

	public String getID() {
		return id;
	}

	public Map<String, Integer> getInterests() {
		return interests;
	}

	public Set<String> getVisitedHoods() {
		return visitedHoods;
	}

	public int getTotalCount() {
		return locationCount;
	}

}
