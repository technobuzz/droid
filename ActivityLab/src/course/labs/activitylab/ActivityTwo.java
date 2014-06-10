package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

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
		setContentView(R.layout.activity_two);

       
		
		Log.i(TAG , "onCreate()");
		
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		

		createView = (TextView) findViewById(R.id.create);
		startView = (TextView) findViewById(R.id.start);
		resumeView = (TextView) findViewById(R.id.resume);
		restartView = (TextView) findViewById(R.id.restart);
		
		//createView.setText("onCreate() calls: " + mCreateHits);
		





		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method

                finish();
			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable

			mResumeHits = savedInstanceState.getInt(RESUME_KEY);
			mRestartHits = savedInstanceState.getInt(RESTART_KEY);
			mStartHits = savedInstanceState.getInt(START_KEY);
			mCreateHits = savedInstanceState.getInt(CREATE_KEY);

		}

		// TODO: Emit LogCat message



		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method


        mCreateHits ++;
		
		displayCounts();

	}

	// Lifecycle callback methods overrides

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

		// TODO: Emit LogCat message
		
		Log.i(TAG , "onPause()");



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
