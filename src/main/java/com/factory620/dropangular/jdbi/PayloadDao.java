package com.factory620.dropangular.jdbi;

import com.factory620.dropangular.core.Payload;
import com.factory620.dropangular.jdbi.mapper.PayloadMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 10:22 PM
 */

@RegisterMapper(PayloadMapper.class)
public interface PayloadDao {

    @SqlQuery("select id, aValue from payload where id = :id")
    Payload findById(@Bind("id") long id);

    @SqlUpdate("insert into payload (id, aValue) values (:id, :aValue)")
    void insert(@BindBean Payload p);

    @SqlUpdate("update payload set aValue = :p.aValue where id = :p.id")
    void update(@BindBean("p") Payload p);

    @SqlUpdate("delete from payload where id = :id")
    void delete(@Bind("id") long id);

    @SqlUpdate("create table payload (id int primary key, aValue varchar(1000))")
    void createTable();

    @SqlUpdate("drop table if exists payload")
    void dropTable();
}
