package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

import com.tsinghua.saleshopmanager.vo.Goods;
import com.tsinghua.saleshopmanager.vo.Sell;
import com.tsinghua.saleshopmanager.vo.SellDetail;
import com.tsinghua.saleshopmanager.vo.ShopVip;
import com.tsinghua.saleshopmanager.vo.saleGoodBean;

public class SaleDAO {
	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";
	
	private String sidd="";
	/**
	 * 创建数据库操作对象
	 */
	public SaleDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}

	/**
	 * 根据条形码查询商品信息
	 * 
	 * @return 商品对象集合
	 */
	public saleGoodBean SearchSaleGood(String gid) {
		saleGoodBean gb=new saleGoodBean();
		sql = "select g.GId,g.gname,g.GSpec,gu.guname,SalePrice,VipPrice from goods g,goodsclass gc,goodsunit gu where g.cid=gc.cid and g.guid=gu.guid and g.gid='"+gid+"'";
		
		System.out.println(sql);
		
		
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				gb.setGid(rs.getString(1));
				gb.setGName(rs.getString(2));
				gb.setGSpec(rs.getString(3));
				gb.setGuname(rs.getString(4));
				gb.setGAmount(1);
				gb.setSalePrice(rs.getFloat(5));
				gb.setVipPrice(rs.getFloat(6));
				
			}
			return gb;
		} catch (SQLException e) {
			System.out.println("商品数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据输入的会员卡号显示姓名积分余额
	 * 
	 */
	public ShopVip SearchShopVip(String vid) {
		ShopVip sv=new ShopVip();
		sql = "select vname,ConsumeScore,VBalance,ConsumeSum,ConsumeCount,ConsumeRate from ShopVip where vid='"+vid+"'";
		
		System.out.println(sql);
		
		
		rs = baseDAO.executeQuery(sql);
		try {
			if (!rs.next()) {
				return null;
			}
			sv.setVName(rs.getString(1));
			sv.setConsumeScore(Integer.parseInt(rs.getString(2)));
			sv.setVBalance(Float.parseFloat(rs.getString(3)));
			sv.setConsumeSum(Float.parseFloat(rs.getString(4)));
			sv.setConsumeCount(Integer.parseInt(rs.getString(5)));
			sv.setConsumeRate(Float.parseFloat(rs.getString(6)));
			
			return sv;
		} catch (SQLException e) {
			System.out.println("商品数据查询失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更新会员信息
	 * @param sv 会员信息
	 * @return 状态
	 */
	public boolean updateSaleInfo(ShopVip sv){
		if (sv==null) {
			return false;
		}
		sql="update ShopVip set VBalance="+sv.getVBalance()+",ConsumeSum="+sv.getConsumeSum()+",ConsumeScore="+sv.getConsumeScore()+",ConsumeCount="+sv.getConsumeCount()+" where VId='"+sv.getVId()+"'";
		System.out.println(sql);
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;		
	}
	/**
	 * 添加销售记录
	 */
	public boolean saveSale(Sell s){
		if (s==null) {
			return false;
		}
		sidd=createSID();
		sql="insert into Sell values('"+sidd+"','"+s.getVId()+"','"+s.getSTime()+"',"+s.getSCount()+",'"+s.getUId()+"',"+s.getSCountPrice()+")";
		System.out.println(sql);
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}
	//添加销售明细记录
	public boolean saveSellDetail(SellDetail sd){
		if (sd==null) {
			return false;
		}
		sql="insert into SellDetail values('"+sidd+"','"+sd.getGId()+"',"+sd.getSQuantity()+","+sd.getSSalePrice()+")";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	
	
	/** *********************************************
	 *              流水号生成                      *
	 ************************************************/
	// 生成流水号
	public String createSID() {
		String inStoreId = "";
		String year, month, day;
		String tempdate;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		inStoreId = sdf.format(calendar.getTime());// 日期格式化字符串
		// 将字符串以‘-’进行分割
		StringTokenizer st = new StringTokenizer(inStoreId, "-");
		year = st.nextToken();// 年份
		month = st.nextToken();// 月份
		day = st.nextToken();// 日
		tempdate = year + month + day;
		if (checkDate(tempdate)) {
			Vector<String> vector = getInStoreId(tempdate);
			String k = vector.get(0).substring(8);
			int ad = Integer.valueOf(k);
			if (ad < 10) {
				inStoreId = tempdate + "0" + (Integer.valueOf(k) + 1);

			} else {
				inStoreId = tempdate + (Integer.valueOf(k) + 1);

			}

		} else {
			inStoreId = tempdate + "01";
		}
		return inStoreId;

	}

	// 检查该天是否已经生成流水号
	public boolean checkDate(String datestr) {
		Vector<String> list = getInStoreId(datestr);
		System.out.println(list.size() + "");
		if (list.size() > 0) {
			return true;
		}
		return false;

	}

	
	/**
	 * 查询所有的销售单流水号
	 * 
	 * @return 流水号集合
	 */
	public Vector<String> getInStoreId(String str) {
		Vector<String> list = new Vector<String>();
		sql = "select SId from Sell where SId like '" + str
				+ "%' order by SId desc";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				list.add(rs.getString("SId"));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}







}
