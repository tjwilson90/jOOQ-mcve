package org.jooq.mcve.test.java;

import org.jooq.mcve.java.tables.records.TestRecord;
import org.junit.Test;

import static org.jooq.mcve.java.Tables.TEST;
import static org.junit.Assert.assertFalse;

public class JavaTest extends AbstractTest {

    @Test
    public void mcveTest() {
        org.jooq.mcve.java.tables.Test table = TEST.rename("test_copy");
        String query = ctx.insertInto(table)
           .columns(table.VALUE)
           .values(42)
           .onDuplicateKeyIgnore()
           .toString();
        assertFalse(query.contains("\"MCVE\".\"TEST\".\"ID\""));
    }
}