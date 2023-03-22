#!/usr/bin/env groovy
import slu.madrid.jenkins.Docker

def call() {
    return new Docker(this).dockerLogin()
}
