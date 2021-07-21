pipeline {
    agent any
    triggers {
        githubPush overrideUrl: 'https://github.com/LeoTuet/LegoRoboEV3'
    }

    stages {
        stage('Test') {
            steps {
                sh 'echo test'
            }
        }
    }
}