package com.mypdf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;

import com.pdfjet.A4;
import com.pdfjet.Box;
import com.pdfjet.CodePage;
import com.pdfjet.Embed;
import com.pdfjet.Font;
import com.pdfjet.Image;
import com.pdfjet.ImageType;
import com.pdfjet.Letter;
import com.pdfjet.Line;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Point;
import com.pdfjet.RGB;
import com.pdfjet.TextLine;

public class MainActivity extends Activity {

	private static final String PATH = Environment
			.getExternalStorageDirectory().getPath();

	AssetManager assetManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		assetManager = this.getAssets();
		try {
			
			Example_03();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Example_03() throws Exception {

		FileOutputStream fos = new FileOutputStream(PATH + File.separator
				+ "aaa.pdf");

		PDF pdf = new PDF(fos);

		// If PDF/A is not required use Helvetica:
		// Font f1 = new Font(pdf, "Helvetica");

		Font f1 = new Font(pdf, new BufferedInputStream(
				assetManager.open("DroidSans.otf")), CodePage.UNICODE,
				Embed.YES);

		String fileName = "eu-map.png";
		BufferedInputStream bis1 = new BufferedInputStream(
				assetManager.open(fileName));
		Image image1 = new Image(pdf, bis1, ImageType.PNG);

		fileName = "fruit.jpg";
		BufferedInputStream bis2 = new BufferedInputStream(
				assetManager.open(fileName));
		Image image2 = new Image(pdf, bis2, ImageType.JPEG);

		fileName = "mt-map.bmp";
		BufferedInputStream bis3 = new BufferedInputStream(
				assetManager.open(fileName));
		Image image3 = new Image(pdf, bis3, ImageType.BMP);

		Page page = new Page(pdf, A4.PORTRAIT);

		TextLine text = new TextLine(f1,
				"The map below is an embedded PNG image");
		text.setPosition(90, 30);
		text.drawOn(page);

		image1.setPosition(90, 40);
		image1.drawOn(page);

		text.setText("JPG image file embedded once and drawn 3 times");
		text.setPosition(90, 550);
		text.drawOn(page);

		image2.setPosition(90, 560);
		image2.scaleBy(0.5);
		image2.drawOn(page);

		image2.setPosition(260, 560);
		image2.scaleBy(0.5);
		image2.drawOn(page);

		image2.setPosition(350, 560);
		image2.scaleBy(0.5);
		image2.drawOn(page);

		text.setText("The map on the right is an embedded BMP image");
		text.setUnderline(true);
		text.setStrikeLine(true);
		text.setTextDirection(15);
		text.setPosition(90, 800);
		text.drawOn(page);

		image3.setPosition(390, 630);
		image3.scaleBy(0.5);
		image3.drawOn(page);

		pdf.flush();
		fos.close();
	}

}
