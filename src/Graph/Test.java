package Graph;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    Connection conn;
    PreparedStatement stmt;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "ltz5623459";
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

    public List<Vertex> getVertices() {
        String sql = "select dependency_job from etl_job_dependency where dependency_job like 'S%' and dependency_job not in (select etl_job from etl_job_dependency) group by dependency_job";
        List<Vertex> resultsList = new ArrayList<>();

        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while(results.next()) {
                String v = results.getString(1);
//                System.out.println(v);
                resultsList.add(new Vertex(v));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultsList;
    }

    public List<Vertex> getJobs(Vertex v) {
        String sql = "select etl_job from etl_job_dependency where dependency_job = ?";
        List<Vertex> resultsList = new ArrayList<>();
        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, v.getName());

            ResultSet results = stmt.executeQuery();
            while(results.next()) {
                String job = results.getString(1);
                resultsList.add(new Vertex(job));
//                System.out.println(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultsList;
    }

//    public void buildVertex(Vertex v) {
//        String sql = "select etl_job from etl_job_dependency where job_dependency = ?";
//        List<String> resultsList = new ArrayList<>();
//        try {
//            stmt = (PreparedStatement) conn.prepareStatement(sql);
//            stmt.setString(1, v.getName());
//
//            ResultSet results = stmt.executeQuery();
//            while(results.next()) {
//                Vertex adjV = new Vertex(results.getString(1));
//                g.addDirectEdge(v, adjV);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public Graph buildGraph(Graph g, Vertex o) {
        if(!g.isVertexExistsByName(o.getName())){
            g.createVertex(o);
        }
        List<Vertex> vertices = getJobs(o);
        Graph tG = new Graph();
        if (vertices.size() == 0) {
            return g;
        } else {
            for (Vertex v : vertices) {
                Vertex tV;
                Vertex tO = g.getVertexByName(o.getName());
                if(!g.isVertexExistsByName(v.getName())) {
                    tV = g.createVertex(v);
                } else {
                    tV = g.getVertexByName(v.getName());
                }
                g.addDirectEdge(tO, tV);
                buildGraph(g, tV);
            }
        }
        return g;
    }

    public void loadData() {
        try {
            FileReader fr = new FileReader("/Users/{userName}/IdeaProjects/leetcode_java/src/Graph/import.csv");
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
//
        List<Vertex> vertices = t.getVertices();

        for (Vertex v: vertices) {
            try {
                Graph g = new Graph();
                t.buildGraph(g, v);
                graphs.add(g);
            } catch (StackOverflowError e) {
                System.out.println("OverflowVertex: " + v.getName());
            }
        }

//        for(int i=0; i<100; i++) {
//            Graph g = new Graph();
//            t.buildGraph(g, vertices.get(i));
//            graphs.add(g);
//        }

        File f = new File("/Users/tianzhuoli/IdeaProjects/leetcode_java/src/Graph/adj_table.txt");
        Writer w = new FileWriter(f);

        for(Graph tG: graphs) {
            if(tG.getVertexSize() > 0) {
                tG.printGraph();
                System.out.println("Total nodes: " + tG.getVertexSize());
                System.out.println();
            }
        }
    }
}
