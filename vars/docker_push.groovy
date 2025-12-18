def call(String projectName,String imageTag,String dockerHubUser){
  withCredentials([usernamePassword(credentialsId: "dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  // sh "docker image tag product-service:latest ${env.dockerHubUser}/product-service:latest"
  sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
  echo "docker push completed" 
                 

}
