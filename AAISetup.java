package org.openecomp.aai.aai.ajsc_aai.util;

import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.openecomp.aai.dbmap.AAIGraph;
import org.openecomp.aai.introspection.ModelInjestor;

import org.openecomp.aai.util.AAIConstants;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public abstract class AAISetup {

    @BeforeClass
    public static void setupBundleconfig() throws Exception {
        System.setProperty("AJSC_HOME", ".");
        System.setProperty("BUNDLECONFIG_DIR", "src/test/resources/bundleconfig-local");

    }

    public String getPayload(String filename) throws IOException {

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(filename);

        String message = String.format("Unable to find the %s in src/test/resources", filename);
        assertNotNull(message, inputStream);

        String resource = IOUtils.toString(inputStream);
        return resource;
    }
}
