package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.tsinghua.saleshopmanager.vo.ShopVip;
import com.tsinghua.saleshopmanager.vo.VipSaveMoney;

public class VipDAO {
	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";
	
	public VipDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}
	/**
	 *   会员充值 1. 添加充值记录
	 *            2. 修改会员余额
	 */
	public boolean updateMoney(VipSaveMoney vm){
		if (vm==null) {
			return false;
		}
		sql="select * from ShopVip where vid='"+vm.getVid()+"'";
		rs=baseDAO.executeQuery(sql);
		try {
			if (!rs.next()) {
				return false;
			}
			else {
				sql="insert into VipSaveMoney values("+vm.getVid()+",'"+vm.getVtime()+"',"+vm.getVMoney()+",'"+vm.getUId()+"') ";
				System.out.println("会员充值语句："+sql);
				if (baseDAO.executeUpdate(sql)) {
					sql="update ShopVip set VBalance=VBalance+"+vm.getVMoney()+" where VId='"+vm.getVid()+"'";
					System.out.println("修改会员余额："+sql);
					if (baseDAO.executeUpdate(sql)) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
	}//end
	/**
	 * 修改积分余额值
	 * @return
	 */
	public boolean encashIntegral(String vid,int score){
		sql="update ShopVip set ConsumeScore=ConsumeScore-"+score+" where vid='"+vid+"'";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检查会员是否存在
	 * @param vid 会员账号
	 * @return 状态
	 */
	public boolean checkVid(String vid){
		if (vid.equals("")||vid==null) {
			return false;
		}
		sql="select * from ShopVip where vid='"+vid+"'";
		rs=baseDAO.executeQuery(sql);
		try {
			if (rs!=null&&rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据会员账号返回积分
	 * @param vid 会员账号
	 * @return 积分
	 */
	public String searchIntegral(String vid){
		String consumeScore=null;
		if (vid.equals("")||vid==null) {
			return null;
		}
		if (!checkVid(vid)) {
			return null;
		}
		sql="select ConsumeScore from ShopVip where VId='"+vid+"'";
		rs=baseDAO.executeQuery(sql);
		try {
			if (rs!=null&&rs.next()) {
				consumeScore=String.valueOf(rs.getInt(1));
				return consumeScore;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询会员详细信息
	 * 
	 * @return 会员详细信息集合
	 */
	public Vector<Vector<String>> getShopVIP(ShopVip vip) {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select * from ShopVip where vid is not null";
		String vid=vip.getVId();
		String name=vip.getVName();
		String phone=vip.getVPhone();
		if (vip!=null) {
			if (!vid.equals("")) {
				sql=sql+" and vid like '%"+vid+"%'";
			}
			if (!name.equals("")) {
				sql=sql+" and VName like '%"+name+"%'";
			}
			if (!phone.equals("")) {
				sql=sql+" and VPhone like '%"+phone+"%'";
			}			
		}
		
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(rs.getString(1));
				v.addElement(rs.getString(2));
				v.addElement(rs.getString(3));
				v.addElement(String.valueOf(rs.getFloat(4)));
				v.addElement(String.valueOf(rs.getInt(5)));
				v.addElement(String.valueOf(rs.getInt(6)));
				v.addElement(String.valueOf(rs.getFloat(7)));
				v.addElement(String.valueOf(rs.getDate(8)));
				v.addElement(String.valueOf(rs.getFloat(9)));
				vector.addElement(v);
			}
			return vector;
		} catch (SQLException e) {
			System.out.println("会员充值数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
//	 填充会员信息表格的标题
	public Vector<String> getVipColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("会员卡号");		
		vector.add("姓名");
		vector.add("电话");
		vector.add("消费总金额");
		vector.add("积分");
		vector.add("消费次数");
		vector.add("积分率");
		vector.add("生日");
		vector.add("余额");		
		return vector;
	}// end
/**
 * 添加会员
 * @param vip 会员对象
 * @return 状态
 */
	public boolean saveShopVip(ShopVip vip){
		if (vip==null) {
			return false;
		}
		if (checkVid(vip.getVId())) {
			return false;
		}
		sql="insert into ShopVip values('"+vip.getVId()+"','"+vip.getVName()+"','"+vip.getVPhone()+"',"+vip.getConsumeSum()+","+vip.getConsumeScore()+","+vip.getConsumeCount()+","+vip.getConsumeRate()+",'"+vip.getVBirthday()+"',"+vip.getVBalance()+")";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	/**
	 * 修改会员信息
	 * @param v
	 * @return
	 */
	public boolean updateVip(ShopVip v){
		if (v==null) {
			return false;
		}
		sql="update shopvip set vname='"+v.getVName()+"',vphone='"+v.getVPhone()+"',vbirthday='"+v.getVBirthday()+"',ConsumeScore="+v.getConsumeScore()+",VBalance="+v.getVBalance()+",ConsumeRate="+v.getConsumeRate()+" where vid='"+v.getVId()+"'";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	/**
	 * 删除会员，有消费记录不能删除
	 * @param vid
	 * @return
	 */
	public boolean delVip(String vid){
		if (vid==null||vid.equals("")) {
			return false;
		}
		sql="select * from shopvip s,vipsavemoney v where s.vid=v.vid and s.vid='"+vid+"'";
		rs=baseDAO.executeQuery(sql);
		try {
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="delete from shopvip where vid='"+vid+"'";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new VipDAO().searchIntegral("56071"));
	}
}
