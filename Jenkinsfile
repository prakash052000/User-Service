pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t userservice-api:latest .'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8084:8084 userservice-api:latest'
            }
        }
    }
}