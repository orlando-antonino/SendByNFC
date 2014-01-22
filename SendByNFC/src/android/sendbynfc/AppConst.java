package android.sendbynfc;

public final class AppConst {

	
    public static final String BEND_URL 			= "http://192.168.193.104/tps/";
    public static final String ACTN_STORE 			= "indgdg.php?";
    public static final String PRM_TEXT 			= "text=";
    
    
    
   /*
    * LogLevel
    */
    public static final int LOGLEVEL 				= 5; //0 assert >, 1 err >, 2 warn >, 3 info > 4 debug >, 5 verbose
    public static final boolean ASSERT 				= LOGLEVEL > -1;
    public static final boolean ERROR 				= LOGLEVEL > 0;
    public static final boolean WARN 				= LOGLEVEL > 1;
    public static final boolean INFO 				= LOGLEVEL > 2;
    public static final boolean DEBUG 				= LOGLEVEL > 3;
    public static final boolean VERBOSE 			= LOGLEVEL > 4;
    													



    
}