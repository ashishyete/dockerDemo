pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World - from SCM'
            }
        }
      stage('Build') {
            steps {
                echo 'Building the Project.'
                mvn clean install
              echo 'Clean install Successful.
            }
        }
      stage('Deploy') {
            steps {
                echo 'Deploy Stage should Trigger.'
            }
        }
    }
}
