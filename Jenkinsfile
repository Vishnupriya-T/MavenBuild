pipeline {
    agent any

    tools {
        maven "maven"
    }
    /*environment{
        
    }*/

    stages {
        stage('Clone') {
            steps {
                git credentialsId: 'a6257a11-8f87-4b2c-ad76-f30ea0df8df4',
                url: 'https://github.com/Vishnupriya1032/MavenBuild.git'
            }
        }
         stage('Build') {
             steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "echo $environment"
             }
        }
        stage('Upload') {
            when {
                anyOf { branch 'production'; branch 'development' }
            }
            steps {
                   script {
                    def server= Artifactory.server "central"
                    def buildInfo = Artifactory.newBuildInfo()
                    def uploadSpec="""{
                            "files": [
                                {
                                    "pattern": "/var/lib/jenkins/workspace/MavenBuild2/target/*.jar",
                                    "target": "Sample/"
                                }
                            ]
                    }"""
                    server.upload(uploadSpec)
                    server.publishBuildInfo buildInfo
                   }
            }
        }
    }
}
