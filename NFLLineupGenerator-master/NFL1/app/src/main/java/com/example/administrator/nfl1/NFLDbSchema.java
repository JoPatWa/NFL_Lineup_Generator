package com.example.administrator.nfl1;

/**
 * Created by jw76577 on 6/8/2016.
 */
public class NFLDbSchema {
    public static final class NFLTable {
        public static final String NAME = "Players";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TEAM = "team";
            public static final String POS = "position";
            public static final String FULLNAME = "full_name";
            public static final String ACTUALFP = "First_actual_fantasy_points";
            public static final String PFP = "fantasy_points_NFL";
            public static final String MINFP = "min";
            public static final String MAXFP = "max";
            public static final String AVERAGEFP = "avg";
            public static final String SALARY = "salary_fd";



        }
    }
}
