package sharding;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.api.config.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-08 21:20
 * @author: 十一
 */
public class ShardingTest {
    /**
     * 数据源数量
     */
    private static final int DS_COUNT = 2;

    public static DataSource createDataSource(String username, String password, String url) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    /**
     * SQL执行
     * @param ds    数据源
     * @param sql   要执行的sql
     * @param oid   列的值
     * @param uid   列的值
     * @param name  列的值
     * @throws SQLException
     */
    public static void execute(DataSource ds, String sql, int oid, int uid, String name) throws SQLException {
        Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, oid);
        ps.setInt(2, uid);
        ps.setString(3, name);
        ps.execute();
    }

    /**
     * SQL执行
     * @param ds    数据源
     * @param sql   要执行的sql
     * @throws SQLException
     */
    public static void execute(DataSource ds, String sql) throws SQLException {
        Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
    }

    /**
     * SQL执行
     * @param ds    数据源
     * @param sql   要执行的sql
     * @throws SQLException
     */
    public static ResultSet executeQuery(DataSource ds, String sql) throws SQLException {
        Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    public static void main(String[] args) {
        Map<String, DataSource> map = new HashMap<>();
        map.put("ds_0", createDataSource("root", "root", "jdbc:mysql://localhost:3306/ds_0"));
        map.put("ds_1", createDataSource("root", "root", "jdbc:mysql://localhost:3306/ds_1"));

        ShardingRuleConfiguration config = new ShardingRuleConfiguration();

        // 配置Order表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        // 设置逻辑表
        orderTableRuleConfig.setLogicTable("t_order");
        // 设置实际数据节点
        // 行表达式：https://shardingsphere.apache.org/document/current/cn/features/sharding/other-features/inline-expression/
        // 填写范围区间，最终会被解析为：ds_0.t_order_0   ds_0.t_order_1   ds_1.t_order_0    ds_1.t_order_1
        orderTableRuleConfig.setActualDataNodes("ds_${0..1}.t_order_${0..1}");
        // 设置主键列名称
        orderTableRuleConfig.setKeyGeneratorColumnName("oid");

        // 配置Order表规则：配置分库 + 分表策略(这个也可以在ShardingRuleConfiguration进行统一设置)
        // 分库
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("uid", "ds_${uid % " + DS_COUNT + "}"));
        // 分表
        orderTableRuleConfig.setTableShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("oid", "t_order_${oid % " + DS_COUNT + "}"));
        config.getTableRuleConfigs().add(orderTableRuleConfig);

        try {
            DataSource ds = ShardingDataSourceFactory.createDataSource(map, config, new HashMap(), new Properties());
            // 插入前先清空，防止主键重复插入失败
            String delSql = "delete from t_order";
            execute(ds,delSql);

            // 插入数据
            for (int i = 1; i <= 10; i++) {
                String sql = "insert into t_order(oid,uid,name) values(?,?,?)";
                execute(ds, sql, i, i, i + "-a");
            }
            System.out.println("数据插入完成。。。");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
