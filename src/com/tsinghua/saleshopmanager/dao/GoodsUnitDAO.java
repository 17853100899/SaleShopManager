package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import com.tsinghua.saleshopmanager.vo.GoodsUnit;
/**
 * 商品单位数据操作
 * @author Administrator
 *
 */
public class GoodsUnitDAO {
	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";

	/**
	 * 创建数据库操作对象
	 */
	public GoodsUnitDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}

	/**
	 * 查询所有商品单位信息
	 * 
	 * @return 商品单位对象集合
	 */
	public Vector<Vector<String>> getGoodsUnit() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select * from GoodsUnit";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getInt("GUId")));
				v.addElement(rs.getString("GUName"));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("商品单位数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询所有商品单位信息，填充到进货单窗体的下拉框中
	 * 
	 * @return 商品单位对象集合
	 */
	public Hashtable<Integer, String> getGoodsUnitForCombox() {
		Hashtable<Integer, String> ht=new Hashtable<Integer, String>();
		sql = "select * from GoodsUnit";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				ht.put(rs.getInt("GUId"),rs.getString("GUName"));
			}
			return ht;
		} catch (SQLException e) {
			System.out.println("商品单位数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加商品单位
	 * 
	 * @param goodsUnit
	 *            新商品单位信息
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean saveGoodsClass(GoodsUnit goodsUnit) {
		try {
			if (goodsUnit != null) {
				// 验证账号不允许重复
				sql = "select * from GoodsUnit where guname='"
						+ goodsUnit.getGuname() + "'";
				rs = baseDAO.executeQuery(sql);

				if (rs != null && rs.next()) {// 说明该数据库中已经存在该账号，不能添加
					return false;
				}
				sql = "insert into GoodsUnit values('" + goodsUnit.getGuname()
						+ "')";
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
	 * 修改商品类别信息
	 * 
	 * @param goodsClass  修改的对象
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean updateGoodsClass(GoodsUnit goodsUnit) {
		if (goodsUnit != null) {
			sql ="update goodsUnit set guname='"+goodsUnit.getGuname()+"' where guid="+goodsUnit.getGuid(); 
			if (baseDAO.executeUpdate(sql)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 删除商品类别信息
	 * 
	 * @param goodsUnit的主键ID
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean delGoodsUnit(GoodsUnit goodsUnit) {
		int guid=goodsUnit.getGuid();
		sql="select * from GoodsUnit gc,Goods g where gc.guid=g.guid and gc.guid="+guid;
		//检查是否有关联的商品
		rs=baseDAO.executeQuery(sql);
		try {
			if (rs!=null&&rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "delete from GoodsUnit where guid="+guid;
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	//	 填充商品单位表格的标题
	public Vector<String> getColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("单位编号");
		vector.add("单位名称");
		return vector;
	}
	//hashtable测试
	public static void main(String[] args) {
		GoodsUnitDAO goodsUnit=new GoodsUnitDAO();
		Hashtable<Integer, String> ht=goodsUnit.getGoodsUnitForCombox();
		Enumeration<Integer> eu=ht.keys();
		while (eu.hasMoreElements()) {
			Integer index=eu.nextElement();
			System.out.println("---"+ht.get(index));
		}
	}

}
