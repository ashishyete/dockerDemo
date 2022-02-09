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
        stage('Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/ashishyete/dockerDemo.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout branchname"
          }
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
