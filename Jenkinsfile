pipeline{
    environment{
        registry = "ehrazhasan/scientificalculator"
        registryCredential = "docker-cred"
        dockerImage = ''
    }
    agent any
    stages{

         stage("step-1 git pull"){

            steps{

                git url : "https://github.com/ehrazhasan/DevOpsCalculator.git", branch : "master",
                credentialsId : "git-cred"

            }
         }

         stage("step-2 build maven"){

            steps{

                sh "mvn -B -DskipTests clean package"
            }
         }

         stage("step-3 test"){

                steps{

                    sh "mvn test"
                }
         }

         stage("step-4 Building the docker image"){

             steps{

                 script{
                    dockerImage = docker.build registry + ":latest"
                 }
             }
        }

        stage("step-5 Push dockerImage to docker hub"){

             steps{

                 script{
                    docker.withRegistry( '', registryCredential){
                        dockerImage.push()
                    }
                 }
             }
        }

    }
}