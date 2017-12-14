package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.tsinghua.saleshopmanager.vo.GoodsClass;
import com.tsinghua.saleshopmanager.vo.GoodsPrivoder;

public class GoodsPrivoderDAO {
	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";

	private GoodsPrivoder goodsPrivoder=null;
	/**
	 * 创建数据库操作对象
	 */
	public GoodsPrivoderDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}
	/**
	 * 查询所有商品供应商信息
	 * 
	 * @return 商品供应商对象集合
	 */
	public Vector<Vector<String>> getGoodsPrivoder() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select * from GoodsPrivoder";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getInt("GPId")));
				v.addElement(rs.getString("GPName"));
				v.addElement(rs.getString("GPLinkman"));
				v.addElement(rs.getString("GPPhone"));
				v.addElement(rs.getString("GPAddress"));
				
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("商品供应商查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询商品供应商信息，用于填充进货单的下拉框
	 * 
	 * @return 商品供应商对象集合
	 */
	public Hashtable<Integer, String> getGoodsPrivoderForCombox() {
		Hashtable<Integer,String> ht=new Hashtable<Integer, String>();
		sql = "select gpid,gpname from GoodsPrivoder";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				ht.put(rs.getInt("GPId"),rs.getString("GPName"));			
			}
			return ht;
		} catch (SQLException e) {
			System.out.println("商品供应商查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加商品供应商
	 * 
	 * @param goodsClass
	 *            新商品供应商信息
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean saveGoodsPrivoder(GoodsPrivoder goodsPrivoder) {
		try {
			if (goodsPrivoder != null) {
				// 验证账号不允许重复
				sql = "select * from GoodsPrivoder where gpname='"
						+ goodsPrivoder.getGpname() + "'";
				rs = baseDAO.executeQuery(sql);

				if (rs != null && rs.next()) {// 说明该数据库中已经存在该账号，不能添加
					return false;
				}
				sql = "insert into GoodsPrivoder values('" + goodsPrivoder.getGpname()+ "','" + goodsPrivoder.getGpphone()+ "','" +goodsPrivoder.getGpaddress() + "','" + goodsPrivoder.getGplinkman()+ "')";
				if (baseDAO.executeUpdate(sql)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("数据插入失败！");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 修改商品供应商信息
	 * 
	 * @param goodsClass  修改的对象
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean updateGoodsPrivoder(GoodsPrivoder goodsPrivoder) {
		if (goodsPrivoder != null) {
			sql ="update GoodsClass set gpname='"+goodsPrivoder.getGpname()+"',gpphone='"+goodsPrivoder.getGpphone()+"',gpaddress='"+goodsPrivoder.getGpaddress()+"',gplinkman='"+goodsPrivoder.getGplinkman()+"' where gpid="+goodsPrivoder.getGpid(); 
			if (baseDAO.executeUpdate(sql)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 删除商品类别信息
	 * 
	 * @param user的主键ID
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean delGoodsPrivoder(GoodsPrivoder goodsPrivoder) {
		int gpid=goodsPrivoder.getGpid();
		sql="select * from GoodsPrivoder gp,InStore ins where gp.gpid=ins.gpid and gp.gpid="+gpid;
		//检查是否有关联的进货单
		rs=baseDAO.executeQuery(sql);
		try {
			if (rs!=null&&rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "delete from GoodsPrivoder where gpid="+gpid;
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	/**
	 * 模糊搜索 （根据电话或名称）
	 * @return
	 */
	public Vector<Vector<String>> searchGoodsPrivoder(GoodsPrivoder goodsPrivoder) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		String name=goodsPrivoder.getGpname();
		String phone=goodsPrivoder.getGpphone();
		sql = "select * from GoodsPrivoder where gpid<>0";
		if (name!=null&&!name.equals("")) {
			sql=sql+" and gpname like '%"+name+"%'";
		}
		if (phone!=null&&!phone.equals("")) {
			sql=sql+" and gpphone like '%"+phone+"%'";
		}
		System.out.println(sql);
		
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getInt("GPId")));
				v.addElement(rs.getString("GPName"));
				v.addElement(rs.getString("GPLinkman"));
				v.addElement(rs.getString("GPPhone"));
				v.addElement(rs.getString("GPAddress"));
				
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("商品供应商查询失败");
			e.printStackTrace();
		}
		return null;
	}
	//	 填充商品供应商表格的标题
	public Vector<String> getColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("编号");
		vector.add("名称");
		vector.add("联系人");
		vector.add("电话");
		vector.add("地址");
		return vector;
	}

}
