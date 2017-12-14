package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ToTalDAO {
	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";
	
	/**
	 * 创建数据库操作对象
	 */
	public ToTalDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}
	
	/**
	 * 查询指定时间段的会员充值明细
	 * 
	 * @return 会员充值明细集合
	 */
	public Vector<Vector<String>> getShopVIP(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select vsm.VTime,sv.VId,sv.VName,vsm.VMoney,u.UName  from shopvip sv,VipSaveMoney vsm,SuperMarketUser u where sv.vid=vsm.vid and vsm.uid=u.uid and vtime between '"+startTime+"' and '"+endTime+"'";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(String.valueOf(rs.getFloat(4)));
				v.addElement(rs.getString(5));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
/**
 * 会员充值明细
 * @return
 */
	public Vector<Vector<String>> getShopVIP() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select vsm.VTime,sv.VId,sv.VName,vsm.VMoney,u.UName  from shopvip sv,VipSaveMoney vsm,SuperMarketUser u where sv.vid=vsm.vid and vsm.uid=u.uid";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(String.valueOf(rs.getFloat(4)));
				v.addElement(rs.getString(5));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充会员充值明细表格的标题
	public Vector<String> getVipColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("充值时间");		
		vector.add("会员卡号");
		vector.add("会员姓名");
		vector.add("充值金额");
		vector.add("充值员");
		return vector;
	}// end
	/**
	 * 查询指定时间段的收银员的销售总金额
	 * 
	 * @return 会员充值明细集合
	 */
	public Vector<Vector<String>> getTurnover(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select UName,sum(SQuantity*SSalePrice) as MoneySum from superMarketUser smu,Sell s,SellDetail sd where sd.SId=s.SId and smu.UId=s.UId and STime between '"+startTime+"' and '"+endTime+"' group by UName";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(rs.getString(1));				
				v.addElement(String.valueOf(rs.getFloat(2)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}//
	/**
	 * 查询收银员的销售总金额
	 * 
	 * @return 收银员的销售总金额集合
	 */
	public Vector<Vector<String>> getTurnover() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select UName,sum(SQuantity*SSalePrice) as MoneySum from superMarketUser smu,Sell s,SellDetail sd where sd.SId=s.SId and smu.UId=s.UId group by UName";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(rs.getString(1));				
				v.addElement(String.valueOf(rs.getFloat(2)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充会员充值明细表格的标题
	public Vector<String> getTurnoverColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("收银员姓名");		
		vector.add("营业总额");
		return vector;
	}// end
	/**
	 * 查询指定时间段内的进货总金额、销售总金额
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return 结果集
	 */
	public ArrayList<String> getSaleTotal(String startTime,String endTime){
		ArrayList<String> list=new ArrayList<String>();
		
		sql="select sum(InStoreAmount*PurchasePrice) from InStore where InStoreTime between '"+startTime+"' and '"+endTime+"'";
		//进货总金额
		rs = baseDAO.executeQuery(sql);
		try {
				while (rs!=null&&rs.next()) {
					list.add(String.valueOf(rs.getFloat(1)));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//销售总金额
		sql="select sum(SQuantity*SSalePrice) from SellDetail sd,Sell s where s.SId=sd.SId and STime between '"+startTime+"' and '"+endTime+"'";
		
		rs = baseDAO.executeQuery(sql);
		try {
				while (rs!=null&&rs.next()) {
					list.add(String.valueOf(rs.getFloat(1)));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	/**
	 * 查询显示指定时间段内的进货明细
	 * 
	 * @return 进货明细集合
	 */
	public Vector<Vector<String>> getInfoWare(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select InStoreTime,InStoreId,g.GId,GName,GSpec,GUName,CName,InStoreAmount,PurchasePrice,PurchasePrice*InStoreAmount as MoneySum,GPName from GoodsPrivoder gp,GoodsClass gc,GoodsUnit gu,Goods g,InStore ist where ist.GId=g.GId and ist.GPId=gp.GPId and g.GUId=gu.GUId and g.CId=gc.CId and InStoreTime between '"+startTime+"' and '"+endTime+"'";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));				
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				v.addElement(String.valueOf(rs.getInt(8)));
				v.addElement(String.valueOf(rs.getFloat(9)));
				v.addElement(String.valueOf(rs.getFloat(10)));
				v.addElement(rs.getString(11));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询显示指定时间段内的进货明细
	 * 
	 * @return 进货明细集合
	 */
	public Vector<Vector<String>> getInfoWare() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select InStoreTime,InStoreId,g.GId,GName,GSpec,GUName,CName,InStoreAmount,PurchasePrice,PurchasePrice*InStoreAmount as MoneySum,GPName from GoodsPrivoder gp,GoodsClass gc,GoodsUnit gu,Goods g,InStore ist where ist.GId=g.GId and ist.GPId=gp.GPId and g.GUId=gu.GUId and g.CId=gc.CId";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));				
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				v.addElement(String.valueOf(rs.getInt(8)));
				v.addElement(String.valueOf(rs.getFloat(9)));
				v.addElement(String.valueOf(rs.getFloat(10)));
				v.addElement(rs.getString(11));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充会员充值明细表格的标题
	public Vector<String> getIntoWareColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("进货时间");		
		vector.add("流水号");
		vector.add("条形码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("进货数量");
		vector.add("进货单价");
		vector.add("进货金额");
		vector.add("供货商");
		return vector;
	}// end
	/**
	 * 查询进货汇总
	 * 
	 * @return 进货汇总集合
	 */
	public Vector<Vector<String>> getInfoTotal() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select g.GId,GName,GSpec,GUName,CName,sum(InStoreAmount) as AmountSum,sum(PurchasePrice*InStoreAmount) as MoneySum from GoodsClass gc,GoodsUnit gu,Goods g,InStore ist where ist.GId=g.GId and g.GUId=gu.GUId and g.CId=gc.CId group by g.GId,GName,GSpec,GUName,CName";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(String.valueOf(rs.getInt(6)));
				v.addElement(String.valueOf(rs.getFloat(7)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("进货汇总数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询进货汇总
	 * 
	 * @return 进货汇总集合
	 */
	public Vector<Vector<String>> getInfoTotal(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select g.GId,GName,GSpec,GUName,CName,sum(InStoreAmount) as AmountSum,sum(PurchasePrice*InStoreAmount) as MoneySum from GoodsClass gc,GoodsUnit gu,Goods g,InStore ist where ist.GId=g.GId and g.GUId=gu.GUId and g.CId=gc.CId and InStoreTime between '"+startTime+"' and '"+endTime+"' group by g.GId,GName,GSpec,GUName,CName";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(String.valueOf(rs.getInt(6)));
				v.addElement(String.valueOf(rs.getFloat(7)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("进货汇总数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充进货汇总表格的标题
	public Vector<String> getIntoTotalColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("条形码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("进货总数量");
		vector.add("总金额");	
		return vector;
	}// end
	/**
	 * 查询显示指定时间段内的销售明细
	 * 
	 * @return 销售明细集合
	 */
	public Vector<Vector<String>> getSaleWare() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select STime,sd.SId,sd.GId,GName,GSpec,GUName,CName,SQuantity,SSalePrice,SQuantity*SSalePrice as MoneySum,VId,UName from Sell s,SellDetail sd,Goods g,GoodsUnit gu,GoodsClass gc,superMarketUser smu where sd.SId=s.SId and sd.GId=g.GId and s.UId=smu.UId and g.CId=gc.CId and g.GUId=gu.GUId";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));				
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				v.addElement(String.valueOf(rs.getInt(8)));
				v.addElement(String.valueOf(rs.getFloat(9)));
				v.addElement(String.valueOf(rs.getFloat(10)));
				v.addElement(rs.getString(11));
				v.addElement(rs.getString(12));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询显示指定时间段内的销售明细
	 * 
	 * @return 销售明细集合
	 */
	public Vector<Vector<String>> getSaleWare(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select STime,sd.SId,sd.GId,GName,GSpec,GUName,CName,SQuantity,SSalePrice,SQuantity*SSalePrice as MoneySum,VId,UName from Sell s,SellDetail sd,Goods g,GoodsUnit gu,GoodsClass gc,superMarketUser smu where sd.SId=s.SId and sd.GId=g.GId and s.UId=smu.UId and g.CId=gc.CId and g.GUId=gu.GUId and STime between '"+startTime+"' and '"+endTime+"'";
		System.out.println(sql);
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(String.valueOf(rs.getDate(1)));				
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(rs.getString(7));
				v.addElement(String.valueOf(rs.getInt(8)));
				v.addElement(String.valueOf(rs.getFloat(9)));
				v.addElement(String.valueOf(rs.getFloat(10)));
				v.addElement(rs.getString(11));
				v.addElement(rs.getString(12));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充销售明细表格的标题
	public Vector<String> getSaleColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("销售时间");		
		vector.add("流水号");
		vector.add("条形码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("销售数量");
		vector.add("销售单价");
		vector.add("销售金额");
		vector.add("会员卡号");
		vector.add("收银员");
		return vector;
	}// end
	/**
	 * 查询销售汇总
	 * 
	 * @return 销售汇总集合
	 */
	public Vector<Vector<String>> getSaleTotal() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select STime,sd.SId,sd.GId,GName,GSpec,GUName,CName,SQuantity,SSalePrice,SQuantity*SSalePrice as MoneySum,VId,UName from Sell s,SellDetail sd,Goods g,GoodsUnit gu,GoodsClass gc,superMarketUser smu where sd.SId=s.SId and sd.GId=g.GId and s.UId=smu.UId and g.CId=gc.CId and g.GUId=gu.GUId";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(rs.getString(6));
				v.addElement(String.valueOf(rs.getFloat(7)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("进货汇总数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询销售汇总
	 * 
	 * @return 销售汇总集合
	 */
	public Vector<Vector<String>> getSaletotal(String startTime,String endTime) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select sd.GId,GName,GSpec,GUName,CName,sum(SQuantity) as AmountSum,sum(SQuantity*SSalePrice) as MoneySum from Sell s,SellDetail sd,Goods g,GoodsUnit gu,GoodsClass gc where sd.SId=s.SId and sd.GId=g.GId and g.CId=gc.CId and g.GUId=gu.GUId and STime between '"+startTime+"' and '"+endTime+"' group by sd.GId,GName,GSpec,GUName,CName";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(rs.getString(4));
				v.addElement(rs.getString(5));
				v.addElement(String.valueOf(rs.getInt(6)));
				v.addElement(String.valueOf(rs.getFloat(7)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("进货汇总数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	
//	 填充销售汇总表格的标题
	public Vector<String> getSaleTotalColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("条形码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("销售总数量");
		vector.add("销售总金额");	
		return vector;
	}// end

}
