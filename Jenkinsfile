pipeline {
    agent any
    tools{
    maven 'default'
    }
    environment {
    dockerimagename = "ashishyete/dockerdemonstration"
        dockerImage = ""
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
           // List all branches in your repo. 
            "git branch -a"
           // Checkout to a specific branch in your repo.
            "git checkout master"
          }
       }
    }
      stage('Build') {
            steps {
                echo 'Building the Project.'
                bat "mvn clean install"
            }
        }
        stage("Docker build"){
            steps {
                script{
                dockerImage = docker.build dockerimagename
                }
        echo 'EXITING DOCKER BUILD'
            }
    }
        stage("Image Push"){
            environment{
            registryCredential = 'DOCKER_HUB_CREDENTIALS'
            }
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com', registryCredential)
                    {
                    dockerImage.push("latest")
                   }
                }
            }
        }
      stage('Deploy') {
            steps {
                echo 'Deploy Stage should Trigger.'
            }
        }
    }
}
