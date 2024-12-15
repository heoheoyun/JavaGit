package ReportF;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KoreaCity {

    private JFrame frame;
    private JTextField searchField;
    private JTextField minField;
    private JTextField maxField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> searchCriteriaBox;

    // DB 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Koreacity"; // DB 주소
    private static final String DB_USER = "root"; // 사용자명
    private static final String DB_PASSWORD = "1234"; // 비밀번호

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                KoreaCity window = new KoreaCity();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public KoreaCity() {
        initialize();
    }

    private void initialize() {
        // Frame 설정
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // 검색 필드와 버튼 패널
        JPanel searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

        JLabel lblSearchCriteria = new JLabel("검색 조건:");
        searchPanel.add(lblSearchCriteria);

        // 검색 조건 선택
        searchCriteriaBox = new JComboBox<>(new String[] { "이름", "인구", "면적" });
        searchCriteriaBox.addActionListener(e -> updateInputFields());
        searchPanel.add(searchCriteriaBox);

        JLabel lblSearch = new JLabel("검색:");
        searchPanel.add(lblSearch);

        searchField = new JTextField();
        searchField.setColumns(15);
        searchPanel.add(searchField);

        JLabel lblRange = new JLabel("범위:");
        searchPanel.add(lblRange);

        minField = new JTextField();
        minField.setColumns(7);
        searchPanel.add(minField);

        JLabel lblTo = new JLabel("~");
        searchPanel.add(lblTo);

        maxField = new JTextField();
        maxField.setColumns(7);
        searchPanel.add(maxField);

        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(e -> searchCity());
        searchPanel.add(searchButton);

        JButton resetButton = new JButton("초기화");
        resetButton.addActionListener(e -> resetTableData());
        searchPanel.add(resetButton);

        // 테이블 모델 초기화
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("도시 이름");
        tableModel.addColumn("인구");
        tableModel.addColumn("면적");
        tableModel.addColumn("설명");

        // JTable 설정
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 초기 데이터 로딩
        loadCityData();
    }

    private void updateInputFields() {
        String criteria = (String) searchCriteriaBox.getSelectedItem();
        boolean isRangeSearch = criteria.equals("인구") || criteria.equals("면적");
        searchField.setVisible(!isRangeSearch);
        minField.setVisible(isRangeSearch);
        maxField.setVisible(isRangeSearch);
    }

    // MySQL 데이터베이스 연결
    private Connection connectToDatabase() throws SQLException {
        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "JDBC 드라이버를 로드할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 데이터를 JTable에 로딩
    private void loadCityData() {
        try (Connection conn = connectToDatabase()) {
            if (conn == null) {
                return;
            }

            String query = "SELECT * FROM Cities";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                // 테이블 비우기
                tableModel.setRowCount(0);

                while (rs.next()) {
                    Object[] row = new Object[5];
                    row[0] = rs.getInt("id");
                    row[1] = rs.getString("name");
                    row[2] = rs.getInt("population");
                    row[3] = rs.getFloat("area");
                    row[4] = rs.getString("description");
                    tableModel.addRow(row);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "데이터를 로드할 수 없습니다: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchCity() {
        String criteria = (String) searchCriteriaBox.getSelectedItem();
        try (Connection conn = connectToDatabase()) {
            if (conn == null) return;

            String query = null;
            PreparedStatement pstmt = null;

            if ("이름".equals(criteria)) {
                query = "SELECT * FROM Cities WHERE name LIKE ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + searchField.getText().trim() + "%");
            } else if ("인구".equals(criteria)) {
                query = "SELECT * FROM Cities WHERE population BETWEEN ? AND ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, Integer.parseInt(minField.getText().trim()));
                pstmt.setInt(2, Integer.parseInt(maxField.getText().trim()));
            } else if ("면적".equals(criteria)) {
                query = "SELECT * FROM Cities WHERE area BETWEEN ? AND ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setDouble(1, Double.parseDouble(minField.getText().trim()));
                pstmt.setDouble(2, Double.parseDouble(maxField.getText().trim()));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                tableModel.setRowCount(0);
                while (rs.next()) {
                    Object[] row = new Object[5];
                    row[0] = rs.getInt("id");
                    row[1] = rs.getString("name");
                    row[2] = rs.getInt("population");
                    row[3] = rs.getFloat("area");
                    row[4] = rs.getString("description");
                    tableModel.addRow(row);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "검색 중 오류가 발생했습니다: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetTableData() {
        searchField.setText("");
        minField.setText("");
        maxField.setText("");
        loadCityData();
    }
}
