// Define secret variables
def MY_PASSWORD = 'YWVyY3dxZWY'
def MY_SECRET = 'ZGZoeWt5OGt'
def ENV = "dev"
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
        def configVal = readYaml file: "config_${ENV}.yaml" 
        echo "configVal: " + configVal
     		echo configVal['SECRET_SAFE']['BASE'][0]
     		echo configVal['SECRET_SAFE']['RUN_AS'][0]
     		echo configVal['SECRET_SAFE']['PS_AUTH_KEY'][0]
     		echo configVal['SECRET_SAFE']['SECRET_ID']['SONAR'][0]
   
        }
      }
    }
  }
  
  
  
  
}

