package com.factory620.dropangular.jdbi.mapper;

import com.factory620.dropangular.core.Payload;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 10:29 PM
 */
public class PayloadMapper implements ResultSetMapper<Payload> {
    @Override
    public Payload map(int i, ResultSet r, StatementContext ctx) throws SQLException {
        return new Payload(r.getLong("id"), r.getString("aValue"));
    }
}
