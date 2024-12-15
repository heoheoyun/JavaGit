package ReportF;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KoreaCity {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    // DB 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Koreacity";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
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
        // JFrame 설정
        frame = new JFrame("한국 도시 정보");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 테이블 모델 초기화
        tableModel = new DefaultTableModel(new String[]{"ID", "이름", "인구", "면적", "설명"}, 0);
        table = new JTable(tableModel);

        // 테이블 추가
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 검색 패널
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(e -> searchCity(searchField.getText()));
        searchPanel.add(new JLabel("도시 이름:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

        // 초기 데이터 로드
        loadCityData();
    }

    private void loadCityData() {
        try (Connection conn = connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Cities");
             ResultSet rs = pstmt.executeQuery()) {

            tableModel.setRowCount(0);

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("population"),
                        rs.getFloat("area"),
                        rs.getString("description")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "데이터를 불러오는 중 오류 발생: " + e.getMessage(),
                    "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchCity(String cityName) {
        String query = "SELECT * FROM Cities WHERE name LIKE ?";
        try (Connection conn = connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + cityName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                tableModel.setRowCount(0);

                while (rs.next()) {
                    tableModel.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("population"),
                            rs.getFloat("area"),
                            rs.getString("description")
                    });
                }

                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "검색 중 오류 발생: " + e.getMessage(),
                    "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Connection connectToDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "JDBC 드라이버를 로드할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            throw new SQLException("JDBC 드라이버 로드 실패");
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
