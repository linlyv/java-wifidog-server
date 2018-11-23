package com.k2.wifidog.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.k2.wifidog.bean.Ap;
import com.k2.wifidog.bean.Device;
import com.k2.wifidog.dao.impl.ApDao;
import com.k2.wifidog.dao.impl.DeviceDao;
import com.k2.wifidog.utils.Md5Utils;

public class ApDaoTest {
	Ap ap=new Ap();
	ApDao rd = new ApDao();
	ApDao dao=new ApDao();
	@Test
	public void testAdd(){
		ap.setGw_id("CC81DABCD4D1");
		ap.setDev_id("1921681231");
		System.out.println(Md5Utils.encode(ap.getDev_id()));
		ap.setDev_md5(Md5Utils.encode(ap.getDev_id()));
		ap.setEnable(1);
		try {
			dao.add(ap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Boolean AddRouter(String gw_id,String dev_id) throws SQLException{
		
		
		if (rd.findByDevId(dev_id)==null) {
			System.out.println(rd.findByDevId(dev_id) ); 
			ap.setDev_id(dev_id);
			ap.setGw_id(gw_id);
			System.out.println(Md5Utils.encode(ap.getDev_id()));
			ap.setDev_md5(Md5Utils.encode(ap.getDev_id()) );
			ap.setEnable(1);
			try {
				dao.add(ap);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	
	}
}
