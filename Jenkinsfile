pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure Maven version matches Jenkins global tool configuration
    }

    environment {
        DOCKER_IMAGE = 'javacodewiz/department-service:latest'
    }

    stages {
        stage('Poll From SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/javacodewiz/department-service.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Stop Docker Image') {
                    steps {
                        script {
                            sh '''
                            docker stop department-service || true
                            docker rm department-service || true
                            '''
                        }
                    }
                }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $DOCKER_IMAGE ."
                }
            }
        }

        stage('Run Docker Image') {
            steps {
                script {
                    sh '''
                    docker run -d -p 9001:9001 --name department-service $DOCKER_IMAGE
                    '''
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'docker-password', usernameVariable: 'docker-username')]) {
                                     // some block where you can access $docker-username and $docker-password

                                 }
                }
                script {
                sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
    }
}