package com.processor.use_cases.dto;

import com.processor.log_todo.LogTODO;

@LogTODO(relatedTask = "APP-1111", description = "Class pending to modify")
public class TestDto_LogTODO {

    @LogTODO(relatedTask = "APP-2222", description = "Property pending to modify")
    private String testProperty;

    @LogTODO(relatedTask = "APP-3333", description = "Method pending to modify", displayAsError = true)
    public void testMethod() {}

}
