package BOBO.dao.impl;
/**
 * 用于调用数据库的JDBC操作
 */

import BOBO.utils.JDBCutil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    //用于增删查改功能
    public int update(String sql, Object... args) {
        Connection connection = JDBCutil.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            JDBCutil.close(connection);
        }
    }

    //用于查询一条数据
    public <T> T queryForone(Class<T> type, String sql, Object... args) {
        Connection connection = JDBCutil.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            JDBCutil.close(connection);
        }
    }

    //用于查询返回多行数据
    public <T> List<T> queryForlist(Class<T> type, String sql, Object... args) {
        Connection connection = JDBCutil.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            JDBCutil.close(connection);
        }
    }

    //返回一个值的查询
    public Object queryForsingleValue(String sql, Object... args) {
        Connection connection = JDBCutil.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutil.close(connection);
        }
        return null;
    }

}
