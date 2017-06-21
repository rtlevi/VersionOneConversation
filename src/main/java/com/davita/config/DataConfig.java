package com.davita.config;

public class DataConfig {

	/**
	 * For mac users, change the ***** to your Home name... click on the finder,
	 * on top of the screen in the menu, click on go, and in the dropdown click
	 * on Home see the Home name probably your name i.e: rmarlyn ...
	 */

	/***
	 * Windows users, do the same but your directory should change instead of
	 * Users, it should be C:// always double the slashes
	 */

	public static String INPUT_FILE_Path = "gtshihata";

	public static String CSV_OUTPUT_FILE = "VersionOneConversations.csv";
	public static String ID = "id";
	public static String COMMENT = "comment";
	public static String SUMMARY = "summary";

	public static String INPUT_FILE_PrePaht = "/Users/";
	public static String INPUT_FILE_ENPATH = "/Documents/";
	public static String STSVERSION = "workspace-sts-3.8.3.RELEASE";
	public static String INPUT_FILE_FINAL_PATH = "/v2ToJira/ids.xls";

	public static String INPUT_FILE = INPUT_FILE_PrePaht + INPUT_FILE_Path + INPUT_FILE_ENPATH + STSVERSION
			+ INPUT_FILE_FINAL_PATH;

	/**
	 * No need to touch unless you know what you're doing table setup readers
	 */

	public static String TABLE_NAME = "DataPool";
	public static String SHEET_NAME = "testdata1";
}
