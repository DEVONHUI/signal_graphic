package main.java.com.devon.signal_graphic.service;



import main.java.com.devon.signal_graphic.bean.SignalData;
import main.java.com.devon.signal_graphic.dao.impl.SignalDataDAO;

import java.util.List;
import java.util.Map;

//service是專門處理業務邏輯
public class SignalDataService {
    private final SignalDataDAO signalDataDAO = new SignalDataDAO();

    public int save(SignalData signalData) {
        return signalDataDAO.save(signalData);
    }

    public SignalData findById(Integer id) {
        return signalDataDAO.findById(id);
    }

    public List<SignalData> findAll() {
        return signalDataDAO.findAll();
    }

    public void update(Integer id, Map<String, Object> updates) { //String是指欄位名稱,Object是指欄位值
        signalDataDAO.update(id, updates);
    }

    public void delete(Integer id) {
        signalDataDAO.delete(id);
    }
}
