package com.k2.wifidog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.k2.wifidog.bean.Ap;
import com.k2.wifidog.dao.Dao;
import com.k2.wifidog.utils.Utils4DB;

public class ApDao implements Dao<Ap> {
	private QueryRunner qr=null;
	public ApDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	@Override
	public int add(Ap t) throws SQLException {
		return qr.update("insert into ap(gw_id,dev_id,dev_md5,name,remark,enable) values(?,?,?,?,?,?)", 
				new Object[]{t.getGw_id(),t.getDev_id(),t.getDev_md5(),t.getName(),t.getRemark(),t.getEnable()+""});
	}

	@Override
	public int delete(Ap t) throws SQLException {
		return 0;
	}

	@Override
	public List<Ap> find() throws SQLException {
		return null;
	}

	@Override
	public int update(Ap t) throws SQLException {
		return 0;
	}
	
	/**
	 *通过dev_id获取ap 
	 * @param devId
	 * @throws SQLException 
	 */
	public Ap findByDevId(String devId) throws SQLException {
		List<Ap> query = (List<Ap>) qr.query("select * from ap where dev_id=?", new BeanListHandler(Ap.class), devId);
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}
	/**
	 *通过device_token获取ap 
	 * @param device_token
	 * @throws SQLException 
	 */
	public Ap findByDeviceToken(String device_token) throws SQLException {
		List<Ap> query = (List<Ap>) qr.query("select * from ap where dev_md5=?", new BeanListHandler(Ap.class), device_token);
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}
}
