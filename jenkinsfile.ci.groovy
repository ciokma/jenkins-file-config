// Define secret variables
def MY_PASSWORD = 'YWVyY3dxZWY'
def MY_SECRET = 'ZGZoeWt5OGt'

// Mask secret variables and try to print
pipeline {
  agent any
  stages {
    stage('checkout') {
      git credentialsId: 'github-credentials', url: 'https://github.com/ciokma/hello-java-spring-boot.git', branch: 'main'
    }
  }
}

