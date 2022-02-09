pipeline {
    agent any
    tools{
    maven 'default'
    }

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World - from SCM'
            }
        }
      stage('Build') {
            steps {
                echo 'Building the Project.'
                bat "mvn clean install"
            }
        }
      stage('Deploy') {
            steps {
                echo 'Deploy Stage should Trigger.'
            }
        }
    }
}
