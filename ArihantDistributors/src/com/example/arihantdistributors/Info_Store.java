package com.example.arihantdistributors;

public class Info_Store {
		/*
		 * Singleton class to hold the data to be sent to webservice,
		 */

			
			
		public String AccountID = "18";
		public String Name = "kumaru";
		public String Street_1 = "26/121";	
		public String Street_2 = "Dharmapurtam rd";
		public String Area = "palaca street";	
		public String City = "Mayuram";	
		public String District = "Nagai";
		public String State = "Tamil Nadu";
		public String Pincode = "609001";
		public String Mobile = "8438317271";
		public String Email = "lzmkhan@yahoo.com";
		
			private static Info_Store dataHolder = new Info_Store();
			
			public static Info_Store getInstance()
			{
				return dataHolder;
			}
			
			
			
			
			
		}
