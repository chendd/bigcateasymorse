package cn.vsp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


/**
 * Hello world!
 *
 */
public class App 
{
	private void doThumbCompress(File file) {

		BufferedImage bis = null;

		BufferedImage bid = null;
		int WIDTH = 84;
		int HEIGHT = 113;
		
		try {

			int nw = 113; // 定义宽为113
			int nh = 84; // 定义高为84

			bis = ImageIO.read(file);
			int c_w = bis.getWidth();
			int c_h = bis.getHeight();

			if (c_w < 114 && file.length() < 1) {
				bis = null;
				return;
			}
			if (c_w > WIDTH) {
				nw = WIDTH;
				nh = c_h * (WIDTH) / c_w;
				c_h = nh;
				c_w = nw;
			}

			if (c_h > HEIGHT) {
				nh = HEIGHT;
				nw = c_w * (HEIGHT) / c_h;
			}

			bid = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics g = bid.getGraphics();

			g.setColor(Color.white);

			g.fillRect(0, 0, WIDTH, HEIGHT);

			g.drawImage(bis, (WIDTH - nw) / 2, 0, nw, nh, null);

			long oldFileSize = file.length();

//			if (isOverlay) {
//				ImageIO.write(bid, "jpeg", file);
//			} else {
				ImageIO.write(ImageIO.read(file), "jpeg", new File(file.getName()));
		//	}
			long newFileSize = file.length();

		} catch (Exception e) {

		}

		bis = null;

		bid = null;
	}
	
	 private void doCompressQuality(File file)  {
	        BufferedImage src = null;
	        FileOutputStream out =  null;
	        JPEGImageEncoder encoder = null;
	        JPEGEncodeParam  param   = null;
	        
	        try{
	            src= ImageIO.read(file);//or png.
	            src.getWidth(null);
	            src.getHeight(null);
	            BufferedImage _primaryTag = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
	            _primaryTag.getGraphics().drawImage(src,0,0,100, 100,null);   
	            if(true){
	                out= new FileOutputStream("dd/"+file.getName());
	            }else{
	                //out= new FileOutputStream(outPath+File.separator+file.getName());
	            }
	            encoder= JPEGCodec.createJPEGEncoder(out);
	            
	            param= encoder.getDefaultJPEGEncodeParam(_primaryTag);            
	           // param.setQuality(0.5F, false);
	            encoder.setJPEGEncodeParam(param);            
	            encoder.encode(_primaryTag);//近JPEG编码
	            out.close();
	            //ImageIO.write(src, "jpeg", new File(outPath+File.separator+file.getName()));            
	           
	        } catch (IOException e){
	           throw new RuntimeException(e);
	        }
	        out = null;
	        encoder = null;
	        param   = null;
	        src     = null;
	    }
public static void main(String[] args) {
	App co = new App();
	//co.doThumbCompress(new File("qingansi.jpg"));
	co.doCompressQuality(new File("luxungongyuan.jpg"));
}
}
