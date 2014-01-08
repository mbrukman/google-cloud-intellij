/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gct.intellij.endpoints.validation;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ex.LocalInspectionToolWrapper;

public class ApiNameInspectionTest extends EndpointTestBase {
  /**
   *  Test to verify that when the API name attribute is not used,
   *  an ApiNameInspection error is not generated.
   */
  public void testEmptyApiNameAttribute() {
    doTest();
  }

  /**
   * Test to verify that an Api name that matches "^[a-z]+[A-Za-z0-9]*$"
   * pattern does not generate an ApiNameInspection error.
   */
  public void testValidApiNameAttribute() {
    doTest();
  }

  /**
   * Test to verify that an Api name beginning with a digit causes an ApiNameInspection
   * error to be generated.
   */
  public void testApiNameAttribute_startWithNumber() {
    doTest();
  }

  /**
   * Test to verify that an Api name with a special character causes an
   * ApiNameInspection error to be generated.
   */
  public void testApiNameAttribute_withSpecialCharacter() {
    doTest();
  }

  private void doTest() {
    LocalInspectionTool localInspectionTool = new ApiNameInspection();
    String testName = getTestName(true);
    final String testDataPath = getTestDataPath();
    myFixture.setTestDataPath(testDataPath);
    myFixture.testInspection("inspections/apiNameInspectionTest/" + testName,
                             new LocalInspectionToolWrapper(localInspectionTool));
  }
}