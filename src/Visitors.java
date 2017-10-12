import java.util.HashMap;

public class Visitors {
		public Visitors() {
			
		}
	
		
		public HashMap<String,Long> hmap = new HashMap<String, Long>();
		
		public int add(String id, long timeStamp, String eventType) {
			if (timeStamp == (long)-1) {
				int total = 0;
				for (String s : hmap.keySet()) {
					if (hmap.get(s) == 1000) {
						total++;
					}
				}
				return total;
			}
			
			if (!hmap.containsKey(id)) {//If doesn't have key
				hmap.put(id, (long)0); //Put it in there
			}//Done if for not have key
			if (hmap.get(id) == 1000) {//If already got a visit
					//Do nothing
			} else { //If id is not 1000s
				if (eventType.equals("enter")) { //If entering
					hmap.put(id,timeStamp); //Add new enter time
				} else { //If exiting
						if (timeStamp - hmap.get(id) >= 30) { //If a legit visit
							hmap.put(id, (long)1000); //Victory, done with it
						}// Otherwise it's worthless whatever
				}//End if else for if enter or exit
			}//End if else for 
			return 0;
		}//End add method
	
	}//End visitors object
