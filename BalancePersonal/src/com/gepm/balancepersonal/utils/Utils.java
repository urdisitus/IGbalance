package com.gepm.balancepersonal.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;

@SuppressLint("SimpleDateFormat")
public class Utils {

	public static boolean isServiceRunning(Context context,
			String serviceClassName) {
		final ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		final List<RunningServiceInfo> services = activityManager
				.getRunningServices(Integer.MAX_VALUE);
		for (RunningServiceInfo runningServiceInfo : services) {
			if (runningServiceInfo.service.getClassName().equals(
					serviceClassName)) {
				return true;
			}
		}
		return false;
	}

	public static void copiarBaseDatos(InputStream stream_origen,
			String direccionDestino, String file_name) throws Exception {
		String direccion = direccionDestino + File.separator + file_name;
		File FF = new File(direccionDestino);
		if (!FF.exists()) {
			FF.mkdirs();
		}
		OutputStream escritura = new FileOutputStream(direccion);

		byte[] buffer = new byte[512];
		int size = 0;
		while ((size = stream_origen.read(buffer)) > 0) {
			escritura.write(buffer, 0, size);
		}
		escritura.flush();
		escritura.close();
	}

	public static String getDateConGuiones(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(date);
	}

	public static Date getDateTime(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return dateFormat.parse(date);
	}

	public static String getMesAño(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MM - yyyy");
		return dateFormat.format(date);
	}

	public static String getPeriodo(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		return dateFormat.format(date);
	}

	public static String getDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public static String getTimeHHMMSS(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String getTime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(date);
	}

	public static String getDateTime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return dateFormat.format(date);
	}

	public static Calendar getCalendar() {
		return Calendar.getInstance(TimeZone.getTimeZone("America/La_Paz"));
	}

	public static Bitmap byteArraytoBitmap(byte[] image) {
		return BitmapFactory.decodeByteArray(image, 0, image.length);
	}

	public static byte[] bitmapToByteArray(Bitmap bitmap) {
		ByteArrayOutputStream blob = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, blob);
		return blob.toByteArray();
	}

	public static String doubleToStringFormater(double double1) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("###,###,##0.00", otherSymbols);
		return df.format(double1);
	}

	public static void dialTelefono(Context context, String telefono) {
		String number = "tel:" + telefono;
		Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
		context.startActivity(callIntent);
	}

	public static void llamarTelefono(Context context, String telefono) {
		String number = "tel:" + telefono;
		Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
		context.startActivity(callIntent);
	}

	public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);
		return resizedBitmap;
	}

	public static final String md5(final String s) {
		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest
					.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String h = Integer.toHexString(0xFF & messageDigest[i]);
				while (h.length() < 2)
					h = "0" + h;
				hexString.append(h);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
