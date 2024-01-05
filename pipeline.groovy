pipeline {
    agent any


    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Capcent/jgsu-spring-petclinic'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw package'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }

        }

    }
}
