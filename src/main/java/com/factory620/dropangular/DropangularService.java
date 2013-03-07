package com.factory620.dropangular;

import com.factory620.dropangular.jdbi.PayloadDao;
import com.factory620.dropangular.resource.PayloadResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 10:04 PM
 */
public class DropangularService extends Service<DropangularConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropangularService().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropangularConfiguration> bootstrap) {
        bootstrap.setName("dropangular");
    }

    @Override
    public void run(DropangularConfiguration config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "h2");
        final PayloadDao dao = jdbi.onDemand(PayloadDao.class);
        environment.addResource(new PayloadResource(dao));

        dao.dropTable();
        dao.createTable();
    }
}
