package course.labs.activitylab;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";
	
	private Map <String,Integer> m = new HashMap <String,Integer>();

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	
	
	/*
	 * 
	 * 
	 *  Can change device configuration at run time. It will kill activity and restart. Restart code should be quick. 
	 *  Example is changing screen orientation. Can save application state or hard to recompute data.
	 *  Override onRetainNonConfigurationInstance () which gets called between OnStop and OnDestroy. 
	 *  Build an object that is saved and returned getLastNonConfigurationInstance() during OnCreate(though deprecated)
	 *  http://developer.android.com/guide/topics/resources/runtime-changes.html
	 *  Manual declare in manifest xml file and OnConfigurationChanged() method.
	 * 
	 */
	
	
	
	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	
	int mCreateHits = 0;
	int mStartHits = 0;
	int mRestartHits = 0;
	int mResumeHits = 0;
	
	// TODO: Create variables for each of the TextViews, called
    // mTvCreate, etc. 
	
	TextView createView;
	TextView startView;
	TextView restartView;
	TextView resumeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Log.i(TAG , "onCreate()");
		setContentView(R.layout.activity_one);
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		
		createView = (TextView) findViewById(R.id.create);
		startView = (TextView) findViewById(R.id.start);
		resumeView = (TextView) findViewById(R.id.resume);
		restartView = (TextView) findViewById(R.id.restart);
		
		



		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to start
				Intent intentMsg = new Intent(getApplicationContext(), ActivityTwo.class);
				
				// Launch the Activity using the intent
				
				startActivity(intentMsg);

			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			
 
			//mResumeHits = 
			
			mResumeHits = savedInstanceState.getInt(RESUME_KEY);
			mRestartHits = savedInstanceState.getInt(RESTART_KEY);
			mStartHits = savedInstanceState.getInt(START_KEY);
			mCreateHits = savedInstanceState.getInt(CREATE_KEY);
			
			
			
			
		    
			
		
		}
		
		

		// TODO: Emit LogCat message
		
		//Log.i(TAG , "justchecked savedInstanceState code");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		
        mCreateHits ++;
		
		displayCounts();



	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();
		mStartHits ++;
		
		//startView = (TextView) findViewById(R.id.start);
		
		Log.i(TAG , "onStart()");

		// TODO: Emit LogCat message


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		
		//startView.setText("onStart() calls: " + mStartHits);
		displayCounts() ;


	}

	@Override
	public void onResume() {
		super.onResume();
		
		//resumeView = (TextView) findViewById(R.id.resume);
		
		

		// TODO: Emit LogCat message
		Log.i(TAG , "onResume()");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		
		mResumeHits++;
		
		displayCounts() ;


	}

	@Override
	public void onPause() {
		super.onPause();
		
		Log.i(TAG , "onPause()");

		// TODO: Emit LogCat message

	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG , "onStop()");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG , "onRestart()");
		
		//restartView = (TextView) findViewById(R.id.restart);
		
		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		
		mRestartHits ++;
		
		//restartView.setText("onRestart() calls: " + mRestartHits);
		displayCounts() ;



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		
		Log.i(TAG , "onDestroy()");


	}
	
	@Override
	public Object onRetainNonConfigurationInstance () {
		// Called by the system, as part of destroying an activity due to a configuration change, 
		// when it is known that a new instance will immediately be created for the new configuration. 
		// You can return any object you like here, including the activity instance itself, which can later be retrieved by calling
		//getLastNonConfigurationInstance() 


		//Log.i(TAG , "onSaveInstanceState()");
		
		return new Object ();



	}
	
	

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable


		//Log.i(TAG , "onSaveInstanceState()");
		
		
		
		
		
	    
	    

	    savedInstanceState.putInt(RESUME_KEY, mResumeHits);
	    savedInstanceState.putInt(RESTART_KEY, mRestartHits);
	    savedInstanceState.putInt(START_KEY, mStartHits);
	    savedInstanceState.putInt(CREATE_KEY, mCreateHits);
	    


	}
	
	// Updates the displayed counters
	public void displayCounts() {
		

		createView.setText("onCreate() calls: " + mCreateHits);
		startView.setText("onStart() calls: " + mStartHits);
		resumeView.setText("onResume() calls: " + mResumeHits);
		restartView.setText("onRestart() calls: " + mRestartHits);
	
	}
}
