package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        //Tehtävä 5:
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        
//        System.out.println("==========");
//        
//        Matcher n = new And( new HasFewerThan(10, "goals"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(n)) {
//            System.out.println( player );
//        }
//        
//        System.out.println("==========");
//        
//        Matcher p = new And( new HasFewerThan(10, "goals"),
//                             new Not(new PlaysIn("PHI"))
//        );
//        
//        for (Player player : stats.matches(p)) {
//            System.out.println( player );
//        }
//        
//        System.out.println("==========");
//        
//        Matcher o = new Or( new PlaysIn("SJS"),
//                            new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(o)) {
//            System.out.println( player );
//        }
//        
//        System.out.println("==========");
        
        //Tehtävä 6:
        
        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println("==========");
        
        Matcher m1 = query.playsIn("PHI")
                  .hasAtLeast(10, "goals")
                  .hasFewerThan(25, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(50, "points").build();

        m = query.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println("==========");
        
        m = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(25, "assists").build(),

                        query.playsIn("EDM")
                             .hasAtLeast(50, "points").build()
                       ).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
