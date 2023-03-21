#!/usr/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t docker build -t localhost:5000/demo-app:jma-2.0 .'
        sh "echo $PASSWORD | docker login  -u $USERNAME --password-stdin localhost:5000"
        sh 'localhost:5000/demo-app:jma-2.0'
    }
}