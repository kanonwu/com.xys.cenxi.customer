package com.xys.cenxi.customer.data.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.util.Util;

public class QueryRateResult {

	public void query(QueryRateResultKey key){
		Dao dao = DataSourceManager.getDao();
		Sql sql = null;
		sql = Sqls.create("select  from t_customer c join t_rateConclusion r  ");
		Criteria cri = Cnd.cri();
		if(!Util.isEmpty(key.name)){
//			cri.where().and("c.name", "", "");
			cri.where().andLike("c.name", key.name);
		}
		if(!Util.isEmpty(key.archivesID)){
			cri.where().andLike("c.archivesID", key.archivesID);
		}
		if(!Util.isEmpty(key.regional)){
			cri.where().andLike("c.regional", Util.removeRightZero(key.regional));
		}
		if(key.firstValueFrom != null){
			cri.where().andGTE("r.firstValue", key.firstValueFrom);
		}
		if(key.firstValueTo != null){
			cri.where().andLT("r.firstValue", key.firstValueTo);
		}
		if(key.secondValueFrom != null){
			cri.where().andGTE("r.secondValue", key.secondValueFrom);
		}
		sql.setCondition(cri);
		dao.execute(sql);
		sql.setCallback(new SqlCallback() {
			
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				// TODO Auto-generated method stub
				rs.next();
				return null;
			}
		});
	}
}
