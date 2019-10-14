package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    Connection conn;
    PreparedStatement stmt;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "123456";
    String tableName = "etl_job_dependency";




    Test() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String etlJob, String jobDependency) {
        try {
            String sql = "insert into " + tableName + " values (null, ?,?)";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
//            stmt.setString(1, jobDependency);
            stmt.setString(1, etlJob);
            stmt.setString(2, jobDependency);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getVertices() {
        String sql = "select job_dependency from etl_job_dependency where job_dependency like 'S%' and job_dependency not in (select etl_job from etl_job_dependency) group by job_dependency";
        List<String> resultsList = new ArrayList<>();

        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while(results.next()) {
                String v = results.getString(1);
//                System.out.println(v);
                resultsList.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultsList;
    }

    public List<String> getJobs(String v) {
        String sql = "select etl_job from etl_job_dependency where job_dependency = ?";
        List<String> resultsList = new ArrayList<>();
        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, v);

            ResultSet results = stmt.executeQuery();
            while(results.next()) {
                String job = results.getString(1);
                resultsList.add(job);
//                System.out.println(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultsList;
    }

    public void loadData() {
        try {
            FileReader fr = new FileReader("/Users/tianzhuoli/IdeaProjects/leetcode_java/src/Graph/import.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String etlJob = "";
            String jobDependency;
            int lineSwitch = 0;

            while ((line = br.readLine()) != null) {
                switch (lineSwitch) {
                    case 0:
                        etlJob = line.trim();
                        lineSwitch++;
                        break;
                    case 1:
                        jobDependency = line.trim();
                        lineSwitch++;
                        insertData(etlJob, jobDependency);
                        ;
                        break;
                    case 2:
                        lineSwitch = 0;
                        break;
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        List<Graph> graphs = new ArrayList<>();
        Test t = new Test();

        List<String> vertices = t.getVertices();
        for (String v: vertices) {
            Graph g = new Graph();
            Vertex vFrom = g.createVertex(v);
            List<String> adjJobs = t.getJobs(v);
            for (String job: adjJobs) {
                Vertex vTo = g.createVertex(job);
                g.addDirectEdge(vFrom, vTo);
            }
            graphs.add(g);
        }

        for(Graph g: graphs) {
            if(g.getVertexSize() > 2) {
                g.printGraph();
                System.out.println(g.getVertexSize());
                System.out.println();
            }
        }
    }
}
