package com.gepm.balancepersonal;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.TextView;

public class GlobalApp extends Application {

	public static Typeface bold, regular, italic, ultraLigth;

	private static GlobalApp miApp;

	@Override
	public void onCreate() {
		super.onCreate();
		miApp = this;
		regular = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
		bold = Typeface.createFromAsset(getAssets(), "fonts/Comfortaa_Bold.ttf");
		italic = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
		ultraLigth = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
	}

	public static GlobalApp getInstance() {
		return miApp;
	}

	public void setBoldHelveticaNeue(TextView lbl) {
		if (lbl != null && bold != null) {
			lbl.setTypeface(bold);
		}
	}

	public void setItalicHelveticaNeue(TextView lbl) {
		if (lbl != null && italic != null) {
			lbl.setTypeface(italic);
		}
	}

	public void setUltraLigthHelveticaNeue(TextView lbl) {
		if (lbl != null && ultraLigth != null) {
			lbl.setTypeface(ultraLigth);
		}
	}

	public void setRegularHelveticaNeue(TextView lbl) {
		if (lbl != null && regular != null) {
			lbl.setTypeface(regular);
		}
	}
}
