package com.wuhan.mall.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class EmptyStringIfNull implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        return (resultSet.getString(s) == null) ? "" : resultSet.getString(s);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        return (resultSet.getString(i) == null) ? "" : resultSet.getString(i);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return (callableStatement.getString(i) == null) ? "" : callableStatement.getString(i);
    }
}
