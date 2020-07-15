pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
 
        stage('Clone') {
            steps {
                git credentialsId: 'a6257a11-8f87-4b2c-ad76-f30ea0df8df4',
                    url: 'https://github.com/Vishnupriya1032/MavenBuild.git',
                    branch: master
            }
        }
         stage('Build') {
             steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
             }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Upload') {
            steps {
                    rtUpload (
                    serverId: central, // Obtain an Artifactory server instance, defined in Jenkins --> Manage:
                    spec: """{
                            "files": [
                                {
                                    "pattern": "**/target/*.jar",
                                    "target": "Sample/"
                                }
                            ]
                    }""",
                    buildName: 'MavenBuild',
                    buildNumber: '1',
                    failNoOp: true    // Fails the build case if no file is uploaded
                )
            }
        }
        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: central,
                    buildName: 'MavenBuild',
                    buildNumber: '1'
                )
            }
        }
    }
}
