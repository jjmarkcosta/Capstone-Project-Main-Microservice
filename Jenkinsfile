pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
        stage('Compile') {
            steps {

                git 'https://github.com/jjmarkcosta/Capstone-Project-Main-Microservice.git'


                bat "mvn compile"

            }

        }
        stage('Test') {
            steps {

                bat "mvn test"

            }

        }
        stage('Build') {
            steps {
                
                bat "mvn package"

            }

        }
    }
}
