package cn.vsp;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class SecondChart {
	
		public static void main(String[] args) throws IOException{
			DefaultPieDataset data = getDataSet();
			JFreeChart chart = ChartFactory.createPieChart3D("水果产量图",  // 图表标题
			data, 
			true, // 是否显示图例
			false,
			false
			);
			
			
			FileOutputStream fos_jpg = null;
			try {
				fos_jpg = new FileOutputStream("/home/ubuntu/bing.jpg");
				ChartUtilities.writeChartAsJPEG(fos_jpg,1.0f,chart,700,300,null);
			} finally {
				try {
					fos_jpg.close();
				} catch (Exception e) {}
			}
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
