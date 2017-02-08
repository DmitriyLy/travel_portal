package com.netcracker.utils;

import javax.sql.DataSource;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class CleanInsertTestExecutionListener implements TestExecutionListener {
    private static final Logger LOG = LoggerFactory.getLogger(CleanInsertTestExecutionListener.class);

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        DataSetLocation dsLocation = testContext.getTestInstance().getClass().getAnnotation(DataSetLocation.class);
        if (dsLocation != null) {
            String dataSetResourcePath = dsLocation.value();
            Resource dataSetResource = testContext.getApplicationContext().getResource(dataSetResourcePath);

            if (dataSetResource.exists()) {
                IDataSet dataSet = new FlatXmlDataSetBuilder().build(dataSetResource.getInputStream());
                IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
                        testContext.getApplicationContext().getBean(DataSource.class)
                );
                DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);

                LOG.info("Annotated test, using data set: {}", dataSetResourcePath);
            }
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
    }
}