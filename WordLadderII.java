import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {

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
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		LinkedList<WordNode> list = new LinkedList<WordNode>();
		List<List<String>> out = new ArrayList<List<String>>();
		Set<String> visited = new HashSet<>();
		Set<String> t_visited = new HashSet<>();
		boolean isfind = false;
		list.add(new WordNode(start));
		int cur_count = 1;
		int next_count = 0;
		visited.add(start);
		
		while (cur_count > 0) {
			WordNode top = list.pop();
			start = top.word;
			
			cur_count--;
			for (int i = 0; i < start.length(); i++) {
				char[] array_start = start.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (array_start[i] != c) {
						array_start[i] = c;
						String t_start = new String(array_start);
						if (t_start.equals(end)) {
							isfind = true;
							List<String> tl = new ArrayList<String>();
							tl.add(end);
							while (top != null) {
								tl.add(0, top.word);
								top = top.pre;
							}
							out.add(tl);
						}
						if (dict.contains(t_start)
								&& !visited.contains(t_start)) {
							WordNode t_wordNode = new WordNode(t_start);
							t_wordNode.pre = top;
							list.add(t_wordNode);
							t_visited.add(t_start);
							next_count++;
						}
					}
				}
			}
			if (cur_count == 0 && isfind == false) {
				cur_count = next_count;
				next_count = 0;
				visited.addAll(t_visited);
				t_visited.clear();
			}
		}
		return out;
	}

	class WordNode {
		WordNode pre;
		String word;

		WordNode(String str) {
			this.word = str;
		}
	}
}
