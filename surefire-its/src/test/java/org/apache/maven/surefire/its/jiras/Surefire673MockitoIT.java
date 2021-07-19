package org.apache.maven.surefire.its.jiras;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.its.fixture.SurefireJUnit4IntegrationTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.apache.maven.surefire.its.fixture.HelperAssertions.assumeJavaVersion;

/**
 * SUREFIRE-673 Asserts that a given mockito build works as it should (classloader problem in 2.7)
 *
 * @author Kristian Rosenvold
 */
@SuppressWarnings( "checkstyle:magicnumber" )
public class Surefire673MockitoIT
    extends SurefireJUnit4IntegrationTestCase
{
    @Before
    public void assumeJava8Plus()
    {
        assumeJavaVersion( 1.8d );
    }

    @Test
    public void testBuildFailingWhenErrors()
    {
        unpack( "/surefire-673-mockito" )
            .executeTest()
            .assertTestSuiteResults( 1, 0, 0, 0 );
    }
}
