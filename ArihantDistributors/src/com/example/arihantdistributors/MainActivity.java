package com.example.arihantdistributors;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private List<Item> myItem = new ArrayList<Item>();
	private static List<BrandCategory> myBrand = new ArrayList<BrandCategory>();
	private static List<BrandCategory> myCategory = new ArrayList<BrandCategory>();
	static ArrayAdapter<BrandCategory> adapter;
	static ArrayAdapter<Item> adapter1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		populateCategoryList("asdfs");
		 Log.d("point1","");
		 FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      Forgetfragment fragment = new Forgetfragment();
	   
	         fragmentTransaction.replace(R.id.content_frame1, fragment);				
		     fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void populateItemList() {
		myItem.clear();
		Item i = new Item(0 , "flask", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		 i = new Item(1 , "flask0", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		 i = new Item(2 , "flask1", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		 i = new Item(3 , "flask2", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		 i = new Item(4 , "flask3", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		 i = new Item(5 , "flask4", 200, "xyz", "flask, hulk likes flask");
		myItem.add(i);
		// call the web servicet to fetch brand images and brand names into myBrand arraylist
		
		
		
	}
    public void populateCategoryList(String brand) {
		myBrand.clear();
		BrandCategory b = new BrandCategory(0, "xyz", "Caategory0");
		myBrand.add(b);
		
		b = new BrandCategory(1, "xyz", "category1");
		myBrand.add(b);
		b = new BrandCategory(2, "xyz", "category2");
		myBrand.add(b);
		b = new BrandCategory(2, "xyz", "category3");
		myBrand.add(b);
		b = new BrandCategory(3, "xyz", "category4");
		myBrand.add(b);
		b = new BrandCategory(4, "xyz", "category5");
		myBrand.add(b);
		// call the web service to fetch category images and category names in to myCategory arraylist
		
		
	}

    private void populateCategoryList(String brand, String Category) {
		
		
  		// call the web service to fetch item images and item names.
  		
  		
  	}
	
	 public  void populateBrandCategoryListView() {
		//	ArrayAdapter<BrandCategory> adapter = new BrandListAdapter1(myBrand);
	 adapter = new BrandListAdapter1(myBrand);
			//ListView list = (ListView)findViewById(R.id.listviewb);
		//	list.setAdapter(adapter);
			Log.d("Checkpoint2", "Executed populate listview()");
		}
	    
	    public void populateItemListView() {
	  		 adapter1 = new ItemListAdapter1(myItem);
	  		//ListView list = (ListView) findViewById(R.id.listviewI);
	  		//list.setAdapter(adapter1);
	  		Log.d("Checkpoint2", "Executed populate listview()");
	  	}
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		 switch(item.getItemId()){
			 
         case R.id.home:
             Toast.makeText(getBaseContext(), "You selected hone", Toast.LENGTH_SHORT).show();
             break;

         case R.id.chat:
             Toast.makeText(getBaseContext(), "You selected chat", Toast.LENGTH_SHORT).show();
             break;

         case R.id.action_settings:
             Toast.makeText(getBaseContext(), "You selected settings", Toast.LENGTH_SHORT).show();
             break;

         case R.id.feedback:
             Toast.makeText(getBaseContext(), "You selected feedback", Toast.LENGTH_SHORT).show();
             break;

         case R.id.phone:
             Toast.makeText(getBaseContext(), "You selected phone", Toast.LENGTH_SHORT).show();
             break;

         case R.id.Cart:
             Toast.makeText(getBaseContext(), "You selected EMail", Toast.LENGTH_SHORT).show();
             break;
         }
     return true;
	
	}
	
	public class BrandListAdapter1 extends ArrayAdapter<BrandCategory> {
		public BrandListAdapter1(List<BrandCategory> myBrand) {
			
			super(MainActivity.this, R.layout.list_row, myBrand);
			
			}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure we have a view to work with (may have been given null)
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.list_row, parent, false);
			}
			
			// Find the Item to work with.
			BrandCategory currentBrand = myBrand.get(position);
			
			// Fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.brandCatImage);
			imageView.setImageResource(R.drawable.foodicon);
			
			// title
			TextView titleText = (TextView) itemView.findViewById(R.id.brandCatTitle);
			titleText.setText(currentBrand.getBrandCatName());

			
			


			return itemView;
		}	
	
	}
	
	public class ItemListAdapter1 extends ArrayAdapter<Item> {
		public ItemListAdapter1(List<Item> myItem) {
			
			super(getApplicationContext(), R.layout.list_row1, myItem);
			
			}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure we have a view to work with (may have been given null)
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.list_row1, parent, false);
			}
			
			// Find the Item to work with.
			Item currentItem = myItem.get(position);
			
			// Fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.itemImage);
			imageView.setImageResource(R.drawable.foodicon);
			
			// title
			TextView titleText = (TextView) itemView.findViewById(R.id.itemTitle);
			titleText.setText(currentItem.getItemName());
			
			//price
			TextView PriceText = (TextView) itemView.findViewById(R.id.itemPriceT);
			titleText.setText(currentItem.getItemPrice()+"");
			
            ImageView imageView2 = (ImageView)itemView.findViewById(R.id.addToCart);
            imageView2.setOnClickListener(new OnClickListener(){
            	   @Override
       		    public void onClick(View v) {
            		   // opens up item description window.
            		   
            	   }
            });

			return itemView;
		}	
	
	}
	
	private static class Forgetfragment extends Fragment
	{
		 EditText field1 ;
		public int fragNum = 1;
		TextView txt1;
		 View rootView;
		 @Override
		   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
			 
			 
			
			 
			 
			 if(fragNum == 1)
			 {			 
			 rootView = inflater.inflate(R.layout.brand_fragment, container,
						false);
			 Log.d("point1","frag1");
			 /*
			 open up progress dialog, call webservice, then populate the brandfragment
			 */
			 //listview for brand
			 
		
			
			
			 
			 ListView list = (ListView) rootView.findViewById(R.id.listviewb);
			 ((MainActivity)getActivity()).populateBrandCategoryListView();
				list.setAdapter(adapter);
			    Log.d("point2","frag1");
				list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View viewClicked,
							int position, long id) {
						
						
					
					//call category fragment
						 FragmentManager fragmentManager = getFragmentManager();
					      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
					      Forgetfragment fragment = new Forgetfragment();
					      fragment.fragNum=2;
					      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
					      fragmentTransaction.replace(R.id.content_frame1, fragment);		
					        
						    fragmentTransaction.addToBackStack(null);
					         fragmentTransaction.commit();
				        
						}
				});
			 }
			 else if (fragNum ==2)
			 {
				 rootView = inflater.inflate(R.layout.categoryfragment, container,
							false);
				 
				//listview for category
				 ListView list = (ListView) rootView.findViewById(R.id.listviewC);
				 ((MainActivity)getActivity()).populateCategoryList("sparta");
				 ((MainActivity)getActivity()).populateBrandCategoryListView();
					list.setAdapter(adapter);
					list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> parent, View viewClicked,
								int position, long id) {
							
							
						
						//call item fragment
							 FragmentManager fragmentManager = getFragmentManager();
						      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
						      Forgetfragment fragment = new Forgetfragment();
						      fragment.fragNum=3;
						      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
						      fragmentTransaction.replace(R.id.content_frame1, fragment);		
						        
							    fragmentTransaction.addToBackStack(null);
						         fragmentTransaction.commit();
					        
							}
					});
				
			 }
			 
			 else if( fragNum ==3)
			 {
				 rootView = inflater.inflate(R.layout.itemfragment, container,
							false);
				 
				 //listview for item
				 ListView list = (ListView) rootView.findViewById(R.id.listviewI);
				 ((MainActivity)getActivity()).populateItemList();
				 ((MainActivity)getActivity()).populateItemListView();
					list.setAdapter(adapter1);
			 }
			 
			 
			 
			 
		      return rootView;
		      
		      
		      
		      
		   }
	
		
	}
}
