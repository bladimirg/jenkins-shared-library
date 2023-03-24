package slu.madrid.jenkins

class Docker implements Serializable {
  def script
  Docker(script){
    this.script=script
  }

  def  buildDockerImage(String imageName){
    script.echo "building the docker image..."
   // script.sh "docker build  -t $imageName ."
  }

  def dockerLogin(){
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh "echo $script.PASSWORD | docker login  -u $script.USERNAME --password-stdin localhost:5000"

    }
  }

  def dockerPush(String imageName){
    script.sh "docker push $imageName  localhost:5000"
  }
}