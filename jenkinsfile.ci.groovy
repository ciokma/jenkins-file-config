// Define secret variables
def MY_PASSWORD = 'YWVyY3dxZWY'
def MY_SECRET = 'ZGZoeWt5OGt'

// Mask secret variables and try to print
pipeline {
  agent any
  stages {
    /*
    stage('checkout') {
      steps {
        git credentialsId: 'github-credentials', url: 'https://github.com/ciokma/hello-java-spring-boot.git', branch: 'main'
      }
    }*/
    stage('Read Config File') {
      steps {
        script {
        def configVal = readYaml file: "config.yaml"
        echo "configVal: " + configVal
        echo configVal['applications']['name'][0]
        def APP_NAME = configVal['applications']['name'][0]
		    def STACK = configVal['applications']['stack'][0]
		    def BUILD_PACK = configVal['applications']['buildpacks'][0][0]
        }
      }
    }
  }
  
  
  
  
}

