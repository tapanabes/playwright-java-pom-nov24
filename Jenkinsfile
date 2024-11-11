pipeline
{
    agent any
    tools{
        maven 'maven'
    }

    stages{
        stage('Build')
        {
            steps{
                echo("dev build successful")
            }
        }

        stage('Deploy to QA'){
            steps{
                echo("deploy to qa")
            }
        }

        stage('Regression Automation Test'){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
                    git 'https://github.com/tapanabes/playwright-java-pom-nov24'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"
                }
            }
        }

        stage('Publish Extent Report'){
            steps{
                publishHTML([allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'extent-report',
                            reportFiles: 'TestExecutionReport.html',
                            reportName: 'HTML Extent Report',
                            reportTitles: ''])
            }
        }


    }

}