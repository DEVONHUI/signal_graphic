package main.java.com.devon.signal_graphic.dao.impl;


import main.java.com.devon.signal_graphic.bean.SignalData;
import main.java.com.devon.signal_graphic.dao.AbstractGenericDAO;
import main.java.com.devon.signal_graphic.util.CountProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

//把每張表的資訊帶入並覆寫AbstractGenericDAO的抽象方法
public class SignalDataDAO extends AbstractGenericDAO<SignalData, Integer> {
    @Override
    protected String getTableName() {
        return "signal_data";
    }

    @Override
    protected String getInsertColumns() {
        return "info_time, county_id, county, town_id, town, night_work, `day_work(7:00~13:00)`, `day_work(13:00~19:00)`, day_work, night_weekend, `day_weekend(7:00~13:00)`, `day_weekend(13:00~19:00)`, day_weekend, morning_work, midday_work, afternoon_work, evening_work, morning_weekend, midday_weekend, afternoon_weekend, evening_weekend";
    }

    //程式自動生成ＪＤＢＣ新增時需要的 ?
    @Override
    protected String getInsertPlaceholders() {
        int count = CountProperty.getPropertyCount(SignalData.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < count - 1; i++) {
            if (i == count - 2){
                stringBuilder.append("?");
            } else {
                stringBuilder.append("?, ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    protected SignalData mapRowToObject(ResultSet rs) throws SQLException {
        SignalData signalData = new SignalData();
        signalData.setId(rs.getInt("id"));
        signalData.setInfoTime(rs.getString("info_time"));
        signalData.setCountyId(rs.getInt("county_id"));
        signalData.setCounty(rs.getString("county"));
        signalData.setTownId(rs.getInt("town_id"));
        signalData.setTown(rs.getString("town"));
        signalData.setNightWork(rs.getDouble("night_work"));
        signalData.setDayWorkMorning(rs.getDouble("day_work(7:00~13:00)"));
        signalData.setDayWorkAfternoon(rs.getDouble("day_work(13:00~19:00)"));
        signalData.setDayWork(rs.getDouble("day_work"));
        signalData.setNightWeekend(rs.getDouble("night_weekend"));
        signalData.setDayWeekendMorning(rs.getDouble("day_weekend(7:00~13:00)"));
        signalData.setDayWeekendAfternoon(rs.getDouble("day_weekend(13:00~19:00)"));
        signalData.setDayWeekend(rs.getDouble("day_weekend"));
        signalData.setMorningWork(rs.getDouble("morning_work"));
        signalData.setMiddayWork(rs.getDouble("midday_work"));
        signalData.setAfternoonWork(rs.getDouble("afternoon_work"));
        signalData.setEveningWork(rs.getDouble("evening_work"));
        signalData.setMorningWeekend(rs.getDouble("morning_weekend"));
        signalData.setMiddayWeekend(rs.getDouble("midday_weekend"));
        signalData.setAfternoonWeekend(rs.getDouble("afternoon_weekend"));
        signalData.setEveningWeekend(rs.getDouble("evening_weekend"));
        return signalData;
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement stmt, SignalData entity) throws SQLException {
        stmt.setString(1, entity.getInfoTime());
        stmt.setInt(2, entity.getCountyId());
        stmt.setString(3, entity.getCounty());
        stmt.setInt(4, entity.getTownId());
        stmt.setString(5, entity.getTown());
        stmt.setDouble(6, entity.getNightWork());
        stmt.setDouble(7, entity.getDayWorkMorning());
        stmt.setDouble(8, entity.getDayWorkAfternoon());
        stmt.setDouble(9, entity.getDayWork());
        stmt.setDouble(10, entity.getNightWeekend());
        stmt.setDouble(11, entity.getDayWeekendMorning());
        stmt.setDouble(12, entity.getDayWeekendAfternoon());
        stmt.setDouble(13, entity.getDayWeekend());
        stmt.setDouble(14, entity.getMorningWork());
        stmt.setDouble(15, entity.getMiddayWork());
        stmt.setDouble(16, entity.getAfternoonWork());
        stmt.setDouble(17, entity.getEveningWork());
        stmt.setDouble(18, entity.getMorningWeekend());
        stmt.setDouble(19, entity.getMiddayWeekend());
        stmt.setDouble(20, entity.getAfternoonWeekend());
        stmt.setDouble(21, entity.getEveningWeekend());
    }

    @Override
    protected void setUpdateStatementParameters(PreparedStatement stmt, Map<String, Object> updates) throws SQLException {
        int index = 1;
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            stmt.setObject(index++, entry.getValue());
        }
    }
}

