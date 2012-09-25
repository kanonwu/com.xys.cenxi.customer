package com.xys.cenxi.customer.data;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.data.query.QueryRateResultKey;
import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.exception.CusException;
import com.xys.cenxi.customer.pojo.RateConclusion;
import com.xys.cenxi.customer.pojo.RateResult;
import com.xys.cenxi.customer.pojo.Rating;
import com.xys.cenxi.customer.pojo.Regional;
import com.xys.cenxi.customer.pojo.basic.BasicData;
import com.xys.cenxi.customer.pojo.query.QRateResultInfo;
import com.xys.cenxi.customer.start.Content;
import com.xys.cenxi.customer.util.OrderGenerator;
import com.xys.cenxi.customer.util.Util;

public class RatingService {

	private static final Logger logger = LoggerFactory
			.getLogger(RatingService.class);

	/**
	 * 初评
	 */
	public static Integer RATE_TYPE_FIRST = 0;

	/**
	 * 复评
	 */
	public static Integer RATE_TYPE_SECOND = 1;

	private static BasicData[] LEVELS = new BasicData[4];

	private static RatingService service;

	/**
	 * 评分项目数
	 */
	public static final int ITEM_SIZE = 18;

	private RatingService() {
		LEVELS[0] = new BasicData("1", "优秀");
		LEVELS[0].setValue("80");
		LEVELS[1] = new BasicData("2", "良好");
		LEVELS[1].setValue("70");
		LEVELS[2] = new BasicData("3", "一般");
		LEVELS[2].setValue("60");
		LEVELS[3] = new BasicData("4", "较差");
		LEVELS[3].setValue("60");
	}

	public static RatingService getInstance() {
		if (service == null) {
			service = new RatingService();
		}

		return service;
	}

	public BasicData[] getRatingLevels() {
		return LEVELS;
	}

	public String getLevelLabel(int value) {
		if (value >= 80) {
			return LEVELS[0].getName();
		} else if (value >= 70) {
			return LEVELS[1].getName();
		} else if (value >= 60) {
			return LEVELS[2].getName();
		} else if (value > 1) {
			return LEVELS[3].getName();
		} else {
			return "";
		}
	}

	public int[] getRange(String levelName) {
		int[] result = new int[2];
		result[0] = 0;
		result[1] = 104;
		if (Util.isEmpty(levelName)) {
			return result;
		}
		for (BasicData bd : LEVELS) {
			if (bd.getName().equals(levelName)) {
				if (bd.getCode().equals("1")) {
					result[0] = 80;
				} else if (bd.getCode().equals("2")) {
					result[0] = 70;
					result[1] = 80;
				} else if (bd.getCode().equals("3")) {
					result[0] = 60;
					result[1] = 70;
				} else if (bd.getCode().equals("4")) {
					result[0] = 0;
					result[1] = 60;
				}
			}
		}
		return result;
	}

	public Rating add(Rating fa) {
		Dao dao = DataSourceManager.getDao();
		fa.setModifyTime(new Date());
		if (Content.getUser() != null) {
			fa.setUserID(Content.getUser().getRowID());
		}
		if (fa.getRowID() == null) {
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		} else {
			// 检查是否主键是否重复
			Rating old = dao.fetch(fa);
			if (old != null) {
				dao.update(fa);
				return fa;
			} else {
				return dao.insert(fa);
			}
		}
	}

	public void add(List<Rating> cr) {
		for (Rating c : cr) {
			add(c);
		}
	}

	public void delete(Rating fa) {
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}

	public void delete(List<Rating> fas) {
		Dao dao = DataSourceManager.getDao();
		for (Rating f : fas) {
			dao.delete(f);
		}
	}

	public void update(Rating fa) {
		Dao dao = DataSourceManager.getDao();
		fa.setModifyTime(new Date());
		dao.update(fa);
	}

	public List<Rating> getAllRating() {
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, null);
	}

	/**
	 * 根据农户rowID查询初评评分结果
	 * 
	 * @param cusomerID
	 * @return
	 */
	public List<Rating> getFirstRating(String customerID) {
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, Cnd.where("ownerID", "=", customerID)
				.and("rateType", "=", RATE_TYPE_FIRST).asc("rateOrder"));
	}

	/**
	 * 根据农户rowID查询初评评分结果
	 * 
	 * @param cusomerID
	 * @return
	 */
	public List<Rating> getSecondRating(String customerID) {
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, Cnd.where("ownerID", "=", customerID)
				.and("rateType", "=", RATE_TYPE_SECOND).asc("rateOrder"));
	}

	/**
	 * 删除一个用户的评分结果
	 * 
	 * @param customerID
	 */
	public void delete(String customerID) {
		Dao dao = DataSourceManager.getDao();
		dao.clear(Rating.class, Cnd.where("ownerID", "=", customerID));
		// TODO:删除综合评分结果及评分意见
	}

	/**
	 * 返回的结果必须含有18项评分项，当没有评分数据时，评分项内容为空
	 * 
	 * @param customerID
	 * @return
	 */
	public RateResult getRateResult(String customerID) {
		List<Rating> firstRating = getFirstRating(customerID);
		List<Rating> secondRating = getSecondRating(customerID);

		if (firstRating.isEmpty()) {
			firstRating = initRating(RATE_TYPE_FIRST, customerID);
		}
		if (secondRating.isEmpty()) {
			secondRating = initRating(RATE_TYPE_SECOND, customerID);
		}

		RateResult result = new RateResult(firstRating, secondRating);

		RateConclusion con = getRateConclusion(customerID);
		result.setConclusion(con);
		return result;
	}

	public void updateResult(RateResult result) {
		logger.info("更新评分结果");
		add(result.getFirstRating());
		add(result.getSecondRating());
		add(result.getConclusion());
	}

	private List<Rating> initRating(int type, String customerID) {
		List<Rating> rates = new ArrayList<Rating>(ITEM_SIZE);
		for (int i = 0; i < ITEM_SIZE; i++) {
			Rating rate = new Rating();
			rate.setOwnerID(customerID);
			rate.setRateOrder(i + 1);
			rate.setRateType(type);
			rates.add(rate);
		}

		return rates;
	}

	public List<RateConclusion> getAllRateConclution() {
		Dao dao = DataSourceManager.getDao();
		return dao.query(RateConclusion.class, null);
	}

	public RateConclusion getRateConclusion(String customerID) {
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(RateConclusion.class,
				Cnd.where("ownerID", "=", customerID));
	}

	public void update(RateConclusion conclusion) {
		Dao dao = DataSourceManager.getDao();
		dao.update(conclusion);
	}

	public RateConclusion add(RateConclusion conclusion) {
		Dao dao = DataSourceManager.getDao();
		if (conclusion.getRowID() == null) {
			conclusion.setRowID(OrderGenerator.newOrder());
			return dao.insert(conclusion);
		} else {
			// 检查是否主键是否重复
			RateConclusion old = dao.fetch(conclusion);
			if (old != null) {
				dao.update(conclusion);
				return conclusion;
			} else {
				return dao.insert(conclusion);
			}
		}
	}

	public void addRateConclusion(List<RateConclusion> cons) {
		for (RateConclusion rc : cons) {
			add(rc);
		}
	}

	private Criteria getCri(QueryRateResultKey key) {
		Criteria cri = Cnd.cri();
		if (!Util.isEmpty(key.name)) {
			// cri.where().and("c.name", "", "");
			cri.where().andLike("c.name", key.name);
		}
		if (!Util.isEmpty(key.archivesID)) {
			cri.where().andLike("c.archivesID", key.archivesID);
		}
		if (!Util.isEmpty(key.regional)) {
			cri.where().andLike("c.regional",
					Util.removeRightZero(key.regional));
		}
		if (key.firstValueFrom != null) {
			cri.where().andGTE("r.firstValue", key.firstValueFrom);
		}
		if (key.firstValueTo != null) {
			cri.where().andLT("r.firstValue", key.firstValueTo);
		}
		if (key.secondValueFrom != null) {
			cri.where().andGTE("r.secondValue", key.secondValueFrom);
		}
		if (key.secondValueTo != null) {
			cri.where().andLT("r.secondValue", key.secondValueTo);
		}

		return cri;
	}

	/**
	 * 查询评分结果
	 * 
	 * @param key
	 * @return
	 */
	public List<QRateResultInfo> query(final QueryRateResultKey key) {
		Dao dao = DataSourceManager.getDao();
		Sql sql = null;
		sql = Sqls
				.create("select c.archivesID , c.name, c.identify, c.regional, r.firstValue, r.secondValue from t_customer "
						+ "c join t_rateConclusion r  on c.rowID = r.ownerID  $condition ");
		Criteria cri = Cnd.cri();
		cri = getCri(key);

		cri.getOrderBy().asc("c.archivesID");

		sql.setCondition(cri);
		if (key.pagerInfo != null) {
			sql.setPager(key.pagerInfo);
		}
		final List<QRateResultInfo> result = new ArrayList<QRateResultInfo>();
		sql.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				while (rs.next()) {
					QRateResultInfo rate = new QRateResultInfo();
					rate.archivesID = rs.getString(1);
					rate.name = rs.getString(2);
					rate.identify = rs.getString(3);
					String regionalCode = rs.getString(4);
					Regional re = RegionalService.getInstance()
							.getRegionalByCode(regionalCode);
					if (re != null) {
						rate.regional = re.getName();
					}
					rate.firstValue = rs.getInt(5);
					if (rate.firstValue != null) {
						rate.firstLevel = getLevelLabel(rate.firstValue);
					}
					rate.secondValue = rs.getInt(6);
					if (rate.secondValue != null) {
						rate.secondLevel = getLevelLabel(rate.secondValue);
					}

					result.add(rate);
				}
				return null;
			}
		});
		dao.execute(sql);
		if(key.pagerInfo != null){
			Sql countSql = Sqls
					.create("select count(*) from t_customer c join t_rateConclusion r on c.rowID = r.ownerID  $condition ");
			cri = getCri(key);
			countSql.setCondition(cri);
			
			countSql.setCallback(new SqlCallback() {
				
				@Override
				public Object invoke(Connection conn, ResultSet rs, Sql sql)
						throws SQLException {
					if (rs.next()) {
						key.pagerInfo.setRecordCount(rs.getInt(1));
					}
					return null;
				}
			});
			dao.execute(countSql);
		}
		return result;
	}

	private WritableCellFormat getWritableCellFormat(boolean isHead)
			throws Exception {
		WritableFont wf = new WritableFont(WritableFont.createFont("宋体"));
		configFont(wf, isHead);
		WritableCellFormat wcf = new WritableCellFormat(wf);
		configCellFormat(wcf);
		return wcf;
	}

	public void export(List<QRateResultInfo> data, OutputStream os){
		WritableWorkbook book = null;
		try {
			book = Workbook.createWorkbook(os);
			WritableSheet sheet  = book.createSheet("评分结果", 0);
			export(data, sheet);
			book.write();
		} catch (Exception e) {
			logger.error("导出出错：", e);
			throw new CusException(e);
		}finally{
			try {
				book.close();
			} catch (WriteException e) {
				logger.error("关闭流出错：", e);
			} catch (IOException e) {
				logger.error("关闭流出错：", e);
			}
		}
	}
	
	private void export(List<QRateResultInfo> data, WritableSheet sheet)
			throws Exception {
		WritableCellFormat wcf = getWritableCellFormat(true);
		String[] titles = { "档案号", "姓名", "身份证号", "行政区划", "初评分值", "复评分值",
				"初评等级", "复评等级" };
		for (int i = 0; i < titles.length; i++) {
			Label label = new Label(i, 0, titles[i], wcf);
			sheet.addCell(label);
		}

		wcf = getWritableCellFormat(false);

		int rows = data.size();
		if (rows > 65535) {
			rows = 65535;
		}
		int row = 1;
		for (QRateResultInfo info : data) {
			String firstValue = "";
			if (info.firstValue != null) {
				firstValue = info.firstValue.toString();
			}
			String secondValue = info.secondValue == null ? ""
					: info.secondValue.toString();
			String[] content = { info.archivesID, info.name, info.identify,
					info.regional, firstValue, secondValue, info.firstLevel,
					info.secondLevel };

			for (int j = 0; j < content.length; j++) {
				Label label = new Label(j, row, content[j], wcf);
				sheet.addCell(label);
			}

			row++;
			if(row > rows){
				break;
			}
		}

		adjustColWidth(sheet);
	}

	private void adjustColWidth(WritableSheet workSheet) throws Exception {
		for (int i = 0; i < workSheet.getColumns(); i++) {
			Cell[] colCells = workSheet.getColumn(i);
			if ((colCells == null) || (colCells.length == 0))
				continue;
			int maxLen = 0;
			for (int j = 0; j < colCells.length; j++) {
				Cell currCell = colCells[j];

				int len = currCell.getContents().getBytes().length;
				if (len <= maxLen)
					continue;
				maxLen = len;
			}

			if (maxLen < 6)
				maxLen = 6;

			workSheet.setColumnView(i, maxLen + 1);
		}
	}

	private void configFont(WritableFont font, boolean isHead) throws Exception {
		font.setPointSize(10);
		font.setBoldStyle(isHead ? WritableFont.BOLD : WritableFont.NO_BOLD);
		font.setItalic(false);
		font.setUnderlineStyle(UnderlineStyle.NO_UNDERLINE);
		font.setColour(Colour.BLACK);
	}

	private void configCellFormat(WritableCellFormat cellFmt) throws Exception {
		cellFmt.setAlignment(Alignment.LEFT);

		cellFmt.setVerticalAlignment(VerticalAlignment.CENTRE);

		cellFmt.setWrap(true);

		cellFmt.setBackground(Colour.WHITE);

		cellFmt.setBorder(Border.LEFT, BorderLineStyle.THIN);
		cellFmt.setBorder(Border.TOP, BorderLineStyle.THIN);
		cellFmt.setBorder(Border.RIGHT, BorderLineStyle.THIN);
		cellFmt.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
	}
}
