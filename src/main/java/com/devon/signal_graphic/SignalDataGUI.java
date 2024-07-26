package main.java.com.devon.signal_graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.devon.signal_graphic.bean.SignalData;
import main.java.com.devon.signal_graphic.service.SignalDataService;

public class SignalDataGUI extends JFrame {
    private SignalDataService service;
    private JTextField idField, countyField, townField, dayWorkField;
    private JTextArea resultArea;

    public SignalDataGUI() {
        service = new SignalDataService();
        initComponents();
    }

    private void initComponents() {
        // 设置窗口标题和大小
        setTitle("Signal Data Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 创建输入面板
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField(10);
        inputPanel.add(idField);
        inputPanel.add(new JLabel("County:"));
        countyField = new JTextField(10);
        inputPanel.add(countyField);
        inputPanel.add(new JLabel("Town:"));
        townField = new JTextField(10);
        inputPanel.add(townField);
        inputPanel.add(new JLabel("Day Work:"));
        dayWorkField = new JTextField(10);
        inputPanel.add(dayWorkField);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton findButton = new JButton("Find");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton findAllButton = new JButton("Find All");

        buttonPanel.add(saveButton);
        buttonPanel.add(findButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findAllButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // 创建结果显示区域
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // 添加事件监听器
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSignalData();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findSignalData();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSignalData();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSignalData();
            }
        });

        findAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAllSignalData();
            }
        });

        // 将主面板添加到窗口
        add(mainPanel);

        // 设置窗口可见
        setVisible(true);
    }

    private void saveSignalData() {
        // 从输入框获取数据
        SignalData data = new SignalData();
        data.setCounty(countyField.getText());
        data.setCountyId(0);
        data.setTownId(0);
        data.setTown(townField.getText());
        data.setDayWork(Double.parseDouble(dayWorkField.getText()));

        // 调用service保存数据
        int id = service.save(data);
        resultArea.setText("Saved successfully. ID: " + id);
    }

    private void findSignalData() {
        // 清空之前的结果
        resultArea.setText("");

        // 从ID输入框获取ID
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            resultArea.setText("Please enter an ID to search.");
            return;
        }

        try {
            int id = Integer.parseInt(idText);

            // 调用service查找数据
            SignalData data = service.findById(id);
            if (data != null) {
                // 显示找到的数据
                displaySignalData(data);
            } else {
                resultArea.setText("No data found for ID: " + id);
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid ID format. Please enter a valid integer.");
        } catch (Exception e) {
            resultArea.setText("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void displaySignalData(SignalData data) {
        // 清空输入字段
        countyField.setText(data.getCounty());
        townField.setText(data.getTown());
        dayWorkField.setText(String.valueOf(data.getDayWork()));

        // 在结果区域显示完整信息
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(data.getId()).append("\n");
        sb.append("County: ").append(data.getCounty()).append("\n");
        sb.append("Town: ").append(data.getTown()).append("\n");
        sb.append("Day Work: ").append(data.getDayWork()).append("\n");
        // 添加其他字段...

        resultArea.setText(sb.toString());
    }

    private void updateSignalData() {
        // 从输入框获取数据
        int id = Integer.parseInt(idField.getText());
        Map<String, Object> updates = new HashMap<>();
        updates.put("county", countyField.getText());
        updates.put("town", townField.getText());
        updates.put("day_work", Double.parseDouble(dayWorkField.getText()));

        // 调用service更新数据
        service.update(id, updates);
        resultArea.setText("Updated successfully.");
    }

    private void deleteSignalData() {
        // 从ID输入框获取ID
        int id = Integer.parseInt(idField.getText());

        // 调用service删除数据
        service.delete(id);
        resultArea.setText("Deleted successfully.");
    }

    private void findAllSignalData() {
        // 调用service获取所有数据
        List<SignalData> allData = service.findAll();
        StringBuilder sb = new StringBuilder();
        for (SignalData data : allData) {
            sb.append(data.toString()).append("\n");
        }
        resultArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建并显示GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignalDataGUI();
            }
        });
    }
}
