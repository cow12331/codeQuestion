import java.util.*;

public class WordLadderII2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] stringset = {
				{ "dose", "ends", "dine", "jars", "prow", "soap", "guns",
						"hops", "cray", "hove", "ella", "hour", "lens", "jive",
						"wiry", "earl", "mara", "part", "flue", "putt", "rory",
						"bull", "york", "ruts", "lily", "vamp", "bask", "peer",
						"boat", "dens", "lyre", "jets", "wide", "rile", "boos",
						"down", "path", "onyx", "mows", "toke", "soto", "dork",
						"nape", "mans", "loin", "jots", "male", "sits", "minn",
						"sale", "pets", "hugo", "woke", "suds", "rugs", "vole",
						"warp", "mite", "pews", "lips", "pals", "nigh", "sulk",
						"vice", "clod", "iowa", "gibe", "shad", "carl", "huns",
						"coot", "sera", "mils", "rose", "orly", "ford", "void",
						"time", "eloy", "risk", "veep", "reps", "dolt", "hens",
						"tray", "melt", "rung", "rich", "saga", "lust", "yews",
						"rode", "many", "cods", "rape", "last", "tile", "nosy",
						"take", "nope", "toni", "bank", "jock", "jody", "diss",
						"nips", "bake", "lima", "wore", "kins", "cult", "hart",
						"wuss", "tale", "sing", "lake", "bogy", "wigs", "kari",
						"magi", "bass", "pent", "tost", "fops", "bags", "duns",
						"will", "tart", "drug", "gale", "mold", "disk", "spay",
						"hows", "naps", "puss", "gina", "kara", "zorn", "boll",
						"cams", "boas", "rave", "sets", "lego", "hays", "judy",
						"chap", "live", "bahs", "ohio", "nibs", "cuts", "pups",
						"data", "kate", "rump", "hews", "mary", "stow", "fang",
						"bolt", "rues", "mesh", "mice", "rise", "rant", "dune",
						"jell", "laws", "jove", "bode", "sung", "nils", "vila",
						"mode", "hued", "cell", "fies", "swat", "wags", "nate",
						"wist", "honk", "goth", "told", "oise", "wail", "tels",
						"sore", "hunk", "mate", "luke", "tore", "bond", "bast",
						"vows", "ripe", "fond", "benz", "firs", "zeds", "wary",
						"baas", "wins", "pair", "tags", "cost", "woes", "buns",
						"lend", "bops", "code", "eddy", "siva", "oops", "toed",
						"bale", "hutu", "jolt", "rife", "darn", "tape", "bold",
						"cope", "cake", "wisp", "vats", "wave", "hems", "bill",
						"cord", "pert", "type", "kroc", "ucla", "albs", "yoko",
						"silt", "pock", "drub", "puny", "fads", "mull", "pray",
						"mole", "talc", "east", "slay", "jamb", "mill", "dung",
						"jack", "lynx", "nome", "leos", "lade", "sana", "tike",
						"cali", "toge", "pled", "mile", "mass", "leon", "sloe",
						"lube", "kans", "cory", "burs", "race", "toss", "mild",
						"tops", "maze", "city", "sadr", "bays", "poet", "volt",
						"laze", "gold", "zuni", "shea", "gags", "fist", "ping",
						"pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
						"hume", "yowl", "craw", "pied", "toga", "lobs", "love",
						"lode", "duds", "bled", "juts", "gabs", "fink", "rock",
						"pant", "wipe", "pele", "suez", "nina", "ring", "okra",
						"warm", "lyle", "gape", "bead", "lead", "jane", "oink",
						"ware", "zibo", "inns", "mope", "hang", "made", "fobs",
						"gamy", "fort", "peak", "gill", "dino", "dina", "tier" },
				{ "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" },
				{ "hot", "dot", "dog", "lot", "log" } };
		String[] start = { "nape", "red", "hit" };
		String[] end = { "mild", "tax", "cog" };

		for (int i = 0; i < stringset.length; i++) {
			Set<String> dict = new HashSet<String>();
			for (String str : stringset[i]) {
				dict.add(str);
			}
			WordLadderII fac = new WordLadderII();
			System.out.println(fac.findLadders(start[i], end[i], dict));
		}
	}


	List<List<String>> results;
	List<String> list;
	Map<String, List<String>> map;

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		results = new ArrayList<List<String>>();
		if (dict.size() == 0)
			return results;

		int curr = 1, next = 0;
		boolean found = false;
		list = new LinkedList<String>();
		map = new HashMap<String, List<String>>();

		Queue<String> queue = new ArrayDeque<String>();
		Set<String> unvisited = new HashSet<String>(dict);
		Set<String> visited = new HashSet<String>();

		queue.add(start);
		unvisited.add(end);
		unvisited.remove(start);
		// BFS
		while (!queue.isEmpty()) {

			String word = queue.poll();
			curr--;
			for (int i = 0; i < word.length(); i++) {
				StringBuilder builder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					builder.setCharAt(i, ch);
					String new_word = builder.toString();
					if (unvisited.contains(new_word)) {
						// Handle queue
						if (visited.add(new_word)) {// Key statement,Avoid
													// Duplicate queue insertion
							next++;
							queue.add(new_word);
						}

						if (map.containsKey(new_word))// Build Adjacent Graph
							map.get(new_word).add(word);
						else {
							List<String> l = new LinkedList<String>();
							l.add(word);
							map.put(new_word, l);
						}

						if (new_word.equals(end) && !found)
							found = true;

					}

				}// End:Iteration from 'a' to 'z'
			}// End:Iteration from the first to the last
			if (curr == 0) {
				if (found)
					break;
				curr = next;
				next = 0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}// End While

		backTrace(end, start);

		return results;
	}

	private void backTrace(String word, String start) {
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null)
			for (String s : map.get(word))
				backTrace(s, start);
		list.remove(0);
	}
}
