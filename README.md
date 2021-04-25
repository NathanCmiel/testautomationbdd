# Test Automation Framework for BDD Environment
Test automation framework that works well with BDD environment. It generates Cluecumber reports for every test execution. It supports multiple browser selection and parallel testing.


## Execution Triggers
The test can be triggered with the following commands:
```bash
mvn test
```

Specified tests can be triggered with the folllowing commands:
```bash
mvn test -Dcucumber.options="--tags @smoke"
```

Specified tests with specified browser can be triggered with the following commands:
```bash
mvn test -Dcucumber.options="--tags @smoke" -Dbrowser="chrome"
```

Supported Browser:
| Browser         | Options String        |
| --------------- | --------------------- |
| Google Chrome   | `-Dbrowser="chrome"`  |
| Mozilla Firefox | `-Dbrowser="firefox"` |
| MS Edge         | `-Dbrowser="edge"`    |


## Generating the Report
After the test execution, you can generate Cluecumber Test Report by executing the following maven command.
```bash
mvn cluecumber-report:reporting
```


Example Report: 
![screenshot](/images/report_example.png)
