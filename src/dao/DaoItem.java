package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Item;
import util.DBHelper;

//商品的业务逻辑类
public class DaoItem {
	//获得所有的商品信息
	public ArrayList<Item> getAllItems(){
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		ArrayList<Item> list=new ArrayList<Item>();
		
		try {
			con=DBHelper.getConnection();
			String sql="select * from items";		
			pre=con.prepareStatement(sql);
			res=pre.executeQuery();
			
			while(res.next()){
			Item item=new Item();
			item.setId(res.getInt("id"));
			item.setName(res.getString("name"));
			item.setCity(res.getString("city"));
			item.setPrice(res.getInt("price"));
			item.setNumber(res.getInt("number"));
			item.setPicture(res.getString("picture"));
			list.add(item);
			}	
			return list;					
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			//释放数据集对象
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res=null;
			}			
			//释放语句对象
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pre=null;
			}
		}
		
	}
	
	//根据商品ID获取商品详情
	public Item getItemById(int id){
		Connection con=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		try {
			con=DBHelper.getConnection();
			String sql="select * from items where Id=?";		
			pre=con.prepareStatement(sql);
			pre.setInt(1,id );
			res=pre.executeQuery();
			
			if(res.next()){
				Item item=new Item();
				item.setId(res.getInt("id"));
				item.setName(res.getString("name"));
				item.setCity(res.getString("city"));
				item.setPrice(res.getInt("price"));
				item.setNumber(res.getInt("number"));
				item.setPicture(res.getString("picture"));
				return item;
			}					
			else{
				return null;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			//释放数据集对象
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res=null;
			}			
			//释放语句对象
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pre=null;
			}
		}
	}
}

