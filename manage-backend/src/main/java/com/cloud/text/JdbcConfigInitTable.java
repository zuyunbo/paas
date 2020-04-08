package com.cloud.text;


import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zuyunbo
 */
@Configuration
public class JdbcConfigInitTable {

    private Connection con = null;

    @Resource
    private JdbcBean jdbcBean;

    /**
     * 建立数据库查询
     *
     * @throws SQLException
     */
    private void connectionConfig() throws SQLException {
        con = DriverManager.getConnection(jdbcBean.getUrl(), jdbcBean.getUsername(), jdbcBean.getPassword());
        Objects.requireNonNull(con, "创建数据库链接失败");
    }

    /**
     * 执行sql查询
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    private ResultSet getResultSet(String tableName) throws SQLException {
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = String.format(jdbcBean.getSql(), tableName);
        //执行sql查询
        return statement.executeQuery(sql);
    }

    /**
     * 处理结果
     *
     * @param tableName
     * @return
     */
    public List<String> initTableInfo(String tableName) {
        List<String> collNames = new ArrayList<>();
        //创建连接
        try {
            connectionConfig();
            ResultSet resultSet = getResultSet(tableName);
            //将游标指向结果集的末尾，方便getRow()使用
            resultSet.last();
            //减去 Id 列，设置数组初始化容量的时候用到
            //将游标指向结果集的第一行前，开始获取参数
            resultSet.beforeFirst();
            while (resultSet.next()) {
                String name = resultSet.getObject("column_name").toString();
                if (!"id".equals(name)) {
                    collNames.add(name);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //数据库查询结束，关闭数据库连接
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return collNames;
    }


}
