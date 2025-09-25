
pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\apache-maven-3.9.11' // Update if Maven is in a different path
        PATH = "${env.MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling the Spring Boot application..."
                echo "${WORKSPACE}"
                bat """cd ${WORKSPACE}\\evaluation
                mvn clean compile"""
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Running unit tests..."
                bat """cd ${WORKSPACE}\\evaluation
                                    mvn clean test"""
            }
        }

        stage('Jar File Creation') {
                    steps {
                        echo "Running unit tests..."
                        bat """cd ${WORKSPACE}\\evaluation
                                            mvn package"""
                    }
                }

        stage('Sonar') {
                            steps {
                                echo "Running Sonar..."
                                bat """cd ${WORKSPACE}\\evaluation
                                                    mvn sonar:sonar"""
                            }
                        }



    }

    post {
        success {
            echo 'Build and test completed successfully.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
