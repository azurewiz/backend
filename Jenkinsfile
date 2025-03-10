pipeline {
    agent any

    environment {
        BACKEND_DIR = "backend"   // Path to your Spring Boot app
        FRONTEND_DIR = "web-frontend" // Path to your Next.js app
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Sasidharan172/recycle-hub.git' // Replace with your repo URL
            }
        }

        stage('Build Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    sh './mvnw clean package' // Build Spring Boot using Maven Wrapper
                }
            }
        }

        stage('Test Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    sh './mvnw test' // Run tests
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm install'  // Install dependencies
                    sh 'npm run build' // Build Next.js project
                }
            }
        }

        stage('Deploy Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    sh 'java -jar target/*.jar &'
                }
            }
        }

        stage('Deploy Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm run start &'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Deployment Successful!'
        }
        failure {
            echo 'Build Failed. Check logs!'
        }
    }
}

