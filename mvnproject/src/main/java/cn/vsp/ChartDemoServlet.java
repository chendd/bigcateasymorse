package cn.vsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartDemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			resp.setContentType("image/jpeg");
			DefaultPieDataset data = getDataSet();
			JFreeChart chart = ChartFactory.createPieChart3D("水果产量图",
			data,
			true,
			false,
			false
			);
					
			ChartUtilities.writeChartAsJPEG(resp.getOutputStream(),
				1.0f,chart,400,300,null);
		}
		/**
		 * 获取一个演示用的简单数据集对象
		 * @return
		 */
		private static DefaultPieDataset getDataSet() {
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue("苹果",100);
			dataset.setValue("梨子",200);
			dataset.setValue("葡萄",300);
			dataset.setValue("香蕉",400);
			dataset.setValue("荔枝",500);
			return dataset;
		}

	
}
