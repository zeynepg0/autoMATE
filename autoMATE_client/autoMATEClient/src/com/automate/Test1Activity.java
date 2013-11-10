package com.automate;

import com.automate.app.AutoMATEApplication;
import com.automate.app.route.Action;
import com.automate.app.route.Route;
import com.automate.app.route.RouteController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Test1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void onPressMePressed(View v) {
		((AutoMATEApplication)getApplication()).handleRoute(new Route<Void>(RouteController.TEST, Action.TEST2, null));
	}
}
