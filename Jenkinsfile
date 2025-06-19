pipeline {
    agent any

    tools {
        maven 'M3'
    }

    parameters {
        choice(
            name: 'version',
            choices: ['major', 'minor', 'patch'],
            description: 'Choose version increment type'
        )
    }

    environment {
        GIT_USERNAME = 'norahalr' // hardcoded GitHub username
        GIT_CREDENTIALS_ID = 'github-creds' // ID of stored Jenkins credential
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: "${env.GIT_CREDENTIALS_ID}", url: 'https://github.com/norahalr/simple-calculator-java-app-master.git'
            }
        }

        stage('Determine and Set New Version') {
            steps {
                script {
                    def currentVersion = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
                    echo "Current version: ${currentVersion}"

                    def baseVersion = currentVersion.replace("-SNAPSHOT", "")
                    def parts = baseVersion.tokenize('.').collect { it.toInteger() }
                    while (parts.size() < 3) { parts << 0 }

                    def (major, minor, patch) = parts

                    if (params.version == 'major') {
                        major += 1; minor = 0; patch = 0
                    } else if (params.version == 'minor') {
                        minor += 1; patch = 0
                    } else if (params.version == 'patch') {
                        patch += 1
                    }

                    def newVersion = "${major}.${minor}.${patch}-SNAPSHOT"
                    echo "Setting new version: ${newVersion}"

                    sh "mvn versions:set -DnewVersion=${newVersion}"
                    sh "mvn versions:commit"

                    sh 'git config user.name "jenkins"'
                    sh 'git config user.email "jenkins@example.com"'

                    // Use credentials securely for push
                    withCredentials([usernamePassword(credentialsId: "${env.GIT_CREDENTIALS_ID}", usernameVariable: 'USERNAME', passwordVariable: 'TOKEN')]) {
                        sh 'git add pom.xml'
                        sh "git commit -m 'Update version to ${newVersion}' || echo 'No changes to commit'"
                        sh "git push https://${USERNAME}:${TOKEN}@github.com/norahalr/simple-calculator-java-app-master.git HEAD:master"
                    }
                }
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }
    }
}
