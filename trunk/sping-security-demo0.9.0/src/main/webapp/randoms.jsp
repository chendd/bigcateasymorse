<%@ page language="java"
	import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%!	Color getRandColor(int fc, int bc) {
		Random r = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int red = fc + r.nextInt(bc - fc);
		int green = fc + r.nextInt(bc - fc);
		int blue = fc + r.nextInt(bc - fc);
		return new Color(red, green, blue);
		}%>
	<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",0);
	Random r = new Random();
	
	int width = 60, heigth = 20;
	BufferedImage pic = new BufferedImage(width,heigth,BufferedImage.TYPE_INT_RGB);
	
	Graphics gc = pic.getGraphics();
	
	gc.setColor(getRandColor(200,250));
	gc.fillRect(0,0,width,heigth);
	
	gc.setFont(new Font("Times New Roman",Font.PLAIN,18));
	gc.setColor(getRandColor(160,200));
	for(int i=0;i<200;i++){
		int x1 = r.nextInt(width);
		int y1 = r.nextInt(heigth);
		int x2 = r.nextInt(15);
		int y2 = r.nextInt(15);
		gc.drawLine(x1,y1,x1+x2,y1+y2);
	}
	gc.setColor(getRandColor(120,240));
	for(int i=0;i<100;i++){
		int x = r.nextInt(width);
		int y = r.nextInt(heigth);
		
		gc.drawOval(x,y,0,0);
	}
	String RS = "";
	String rn = "";
	for(int i=0;i<4;i++){
		rn = String.valueOf(r.nextInt(10));
		RS += rn;
		gc.setColor(new Color(20+r.nextInt(110),20+r.nextInt(110),20+r.nextInt(110)));
		gc.drawString(rn,13*i+6,16);
		
		
	}
	gc.dispose();
		session.setAttribute("random",RS);
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(pic,"JPEG",sos);
	sos.close();
	%>

<html>
<head>
</head>

<body>

</body>
</html>
