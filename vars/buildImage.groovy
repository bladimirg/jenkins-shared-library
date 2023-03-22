#!/usr/bin/env groovy
import slu.madrid.jenkins.Docker
def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}
