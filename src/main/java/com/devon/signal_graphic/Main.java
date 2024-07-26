package main.java.com.devon.signal_graphic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.devon.signal_graphic.bean.Person;
import main.java.com.devon.signal_graphic.bean.SignalData;
import main.java.com.devon.signal_graphic.service.PersonService;
import main.java.com.devon.signal_graphic.service.SignalDataService;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SignalDataService service = new SignalDataService();
        PersonService personService = new PersonService();
        Person person = new Person();
        person.setName("小明");
        person.setMoney(1000);
        int id = personService.save(person);

        //新增
//        SignalData signalData = new SignalData();
//        signalData.setCounty("桃園市");
//        signalData.setCountyId(68000);
//        signalData.setTown("中壢區");
//        signalData.setTownId(68000020);
//        signalData.setDayWork(123.12);
//        int id = service.save(signalData);
//        if (id != -1){
//            System.out.println(id);
//        }


        //查詢指定id
       SignalData signalData = service.findById(1);
       System.out.println("town==" + signalData.getTown());
       System.out.println("id:10的信令" + service.findById(10));
       System.out.println("id:100的信令" + service.findById(100));

        //刪除指定id
//        service.delete(2);

        //更新
//        Map<String, Object> updateSql = new HashMap<>();
//        updateSql.put("county", "勞壢市");
//        service.update(3, updateSql);

//        SignalData signalData1 = service.findById(3);
//        System.out.println("county=" + signalData1.getCounty());




        //從網站中寫入JSON資料
        //  readJson();
        //輸出成CSV格式資料
        //  exportCSV();
        //輸出成JSON格式資料
        //  exportJSON();
    }

    public static void readJson() {
        SignalDataService service = new SignalDataService();
        try {
            String urlString = "https://segisws.moi.gov.tw/STATWSSTData/OpenService.asmx/GetAdminSTDataForOpenCode?oCode=BF3B727F423963563B5AF84EB798086251A1FBEE829C41DBFED9A17677A5F615847AEA07D4E87EC3D5421BC7960893AF";
            URL url = new URL(urlString);


            try (InputStream inputStream = url.openStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                JsonNode node = objectMapper.readTree(inputStream);

                JsonNode dataNode = node.get("RowDataList");
                List<SignalData> signalDatas = objectMapper.convertValue(dataNode, new TypeReference<>() {
                });

                for (SignalData signalData : signalDatas) {
                    service.save(signalData);
                }
                System.out.println("已匯入成功");
            } catch (IOException e) {
                System.out.println("匯入失敗");
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            System.out.println("匯入失敗");
            throw new RuntimeException(e);
        }
    }

    public static void exportCSV() {
        SignalDataService service = new SignalDataService();
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String csvFile = desktopPath + "signalData.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("ID,Name,Salary,Commission\n");
            List<SignalData> signalDataList = service.findAll();
            for (SignalData signalData : signalDataList) {
                writer.append(String.valueOf(signalData.getId())).append(",");
                writer.append(signalData.getInfoTime()).append(",");
                writer.append(String.valueOf(signalData.getCountyId())).append(",");
                writer.append(signalData.getCounty()).append(",");
                writer.append(String.valueOf(signalData.getTownId())).append(",");
                writer.append(signalData.getTown()).append(",");
                writer.append(String.valueOf(signalData.getNightWork())).append(",");
                writer.append(String.valueOf(signalData.getDayWorkMorning())).append(",");
                writer.append(String.valueOf(signalData.getDayWorkAfternoon())).append(",");
                writer.append(String.valueOf(signalData.getDayWork())).append(",");
                writer.append(String.valueOf(signalData.getNightWeekend())).append(",");
                writer.append(String.valueOf(signalData.getDayWeekendMorning())).append(",");
                writer.append(String.valueOf(signalData.getDayWeekendAfternoon())).append(",");
                writer.append(String.valueOf(signalData.getDayWeekend())).append(",");
                writer.append(String.valueOf(signalData.getMorningWork())).append(",");
                writer.append(String.valueOf(signalData.getMiddayWork())).append(",");
                writer.append(String.valueOf(signalData.getAfternoonWork())).append(",");
                writer.append(String.valueOf(signalData.getEveningWork())).append(",");
                writer.append(String.valueOf(signalData.getMorningWeekend())).append(",");
                writer.append(String.valueOf(signalData.getMiddayWeekend())).append(",");
                writer.append(String.valueOf(signalData.getAfternoonWeekend())).append(",");
                writer.append(String.valueOf(signalData.getEveningWeekend())).append("\n");
            }
            System.out.println("CSV 文件已成功創建!");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void exportJSON(){
        SignalDataService service = new SignalDataService();
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String jsonFile = desktopPath + "signalData.json";
        try {
            // 創建 ObjectMapper 實例
            ObjectMapper objectMapper = new ObjectMapper();

            // findall
            List<SignalData> signalDataList = service.findAll();

            // 將 對象寫入到 JSON 文件
            objectMapper.writeValue(new File(jsonFile), signalDataList);

            System.out.println("JSON 文件已成功創建！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}