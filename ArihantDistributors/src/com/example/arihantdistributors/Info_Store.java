package com.example.arihantdistributors;

public class Info_Store {
		/*
		 * Singleton class to hold the data to be sent to webservice,
		 */

			
			
		public String AccountID = "";
		public String Name = "";
		public String Street_1 = "";	
		public String Street_2 = "";
		public String Area = "";	
		public String City = "";	
		public String District = "";
		public String State = "";
		public String Pincode = "";
		public String Mobile = "";
		public String Email = "";
		
			private static Info_Store dataHolder = new Info_Store();
			
			public static Info_Store getInstance()
			{
				return dataHolder;
			}
			
			
			
			
			
		}
