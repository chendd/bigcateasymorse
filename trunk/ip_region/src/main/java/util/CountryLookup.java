/* CountryLookupTest.java */

/* Only works with GeoIP Country Edition */
/* For Geoip City Edition, use CityLookupTest.java */
package util;

import com.maxmind.geoip.*;
import java.io.IOException;

import org.apache.log4j.Logger;

class CountryLookup {
	
	private static final Logger logger = Logger.getLogger(CountryLookup.class);
	
	private static RegionModel regionModel;
	
	private static LookupService lookupService;
	private static String dbfile = "GeoLiteCity.dat";
	
	 
	public static RegionModel formatIpToRegion(String ipString){
			
		try {
			lookupService = new LookupService(dbfile,LookupService.GEOIP_STANDARD);
		} catch (IOException e) {
			throw new RuntimeException("加载GeoLitecity.dat，报错，文件未找到！",e);
		}

			if(ipString != null && !ipString.isEmpty()){
				Location location = lookupService.getLocation(ipString);
				regionModel  = new RegionModel();
				regionModel.setCountry(location.countryName);
				regionModel.setCity(location.city);
				regionModel.setLongitude(String.valueOf(location.longitude));
				regionModel.setLatitude(String.valueOf(location.latitude));
				
				logger.debug("result is _:  " + location.countryCode
						+ "\n" + location.countryName + "\n" + location.region
						+ "\n" + location.city + "\n" + location.postalCode + "\n"
						 + location.longitude + "\n"+ location.latitude + "\n"
						+ location.metro_code + "\n" + location.area_code);

				lookupService.close();
			}
			return regionModel;
	}
	
	public static void main(String[] args) {
		try {
			String sep = System.getProperty("file.separator");
			String dbfile = "GeoLiteCity.dat";
			// You should only call LookupService once, especially if you use
			// GEOIP_MEMORY_CACHE mode, since the LookupService constructor
			// takes up
			// resources to load the GeoIP.dat file into memory
			// LookupService cl = new
			// LookupService(dbfile,LookupService.GEOIP_STANDARD);
			LookupService cl = new LookupService(dbfile);
			Location location = cl.getLocation("114.247.10.65");

			System.out.println(location.latitude + "\n" + location.countryCode
					+ "\n" + location.countryName + "\n" + location.region
					+ "\n" + location.city + "\n" + location.postalCode + "\n"
					+ location.latitude + "\n" + location.longitude + "\n"
					+ location.metro_code + "\n" + location.area_code);


			cl.close();
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
}
