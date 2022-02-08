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
            }
        }
      stage('Deploy') {
            steps {
                echo 'Deploy Stage should Trigger.'
            }
        }
    }
}
