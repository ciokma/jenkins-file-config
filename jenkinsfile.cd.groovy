// Define secret variables
def MY_PASSWORD = "YWVyY3dxZWY"
def MY_SECRET = "ZGZoeWt5OGt"

// Mask secret variables and try to print
pipeline {
  agent any
  stages {
    stage ("Print variable") {
      steps {
        wrap([$class: "MaskPasswordsBuildWrapper",
              varPasswordPairs: [[password: MY_PASSWORD],
                                 [password: MY_SECRET]]]) {
          echo "Password: ${MY_PASSWORD}"
          echo "Secret: ${MY_SECRET}"
        }
      }
    }
  }
}

