pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
        DOCKERHUB_USERNAME='nishthapaul'
    }
    stages {
          stage ("Clone Git") {
                steps {
                    git branch: 'main', url: 'https://github.com/nishthapaul/library-demo.git'
                }
          }

          stage ("Build via Maven") {
                steps {
                    sh 'mvn clean installl'
                }
          }

          stage ("Run tests") {
                steps {
                    sh 'mvn test'
                }
          }

          stage ("Build & Run Code") {
                steps {
                    sh 'docker build -t nishthapaul/library-project .'
                }
          }

//           stage ("Push docker image") {
//                 steps {
//                     script {
//                     sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_CREDENTIALS'
//                     sh 'docker push nishthapaul/hello-world-jenkin-project'
//                     }
//                 }
//           }
//
//           stage ("Run Ansible Playbook") {
//                 steps {
//                     sh 'ansible-playbook -i inventory deploy.yml'
//                 }
//           }
    }
    post {
        failure {
            // def jenkinsBuildUrl = "http://localhost:8080/job/${env.JOB_NAME}/${env.BUILD_NUMBER}/"
            mail bcc: '', cc: '', from: '', replyTo: '', to: 'paulnishtha19@gmail.com', subject: 'Not working Library Project',body: 'Check console output at ${jenkinsBuildUrl} to view the results.'
            
            // mail bcc: '', body: 'Check console output at ' + env.BUILD_URL + 'to view the results. \n\n ${CHANGES} \n\n ------------------', cc: '', from: '', replyTo: '', subject: 'Unstable build in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER', to: 'paulnishtha19@gmail.com'
        }
    }
}
