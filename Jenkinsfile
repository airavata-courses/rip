pipeline {
    agent any

    stages 
    {
	  stage('setting up required directories') {
            steps {
                sh 'chmod +x fileCreate.sh'
		sh './fileCreate.sh'
            }
        }
	    stage('Building Kafka queue') {
            steps {
                build job: 'Kafka'
            }
        }
	    stage('Building ThriftServer') {
            steps {
                build job: 'ThriftServer'
            }
        }
	    stage('Building JSONParser') {
            steps {
                build job: 'JSONParser'
            }
        }
	    stage('Building MongoManager') {
            steps {
                build job: 'MongoManager'
            }
        }
	    stage('Starting service') {
            steps {
                sh 'docker-compose up --build'
            }
        }
    }
}
        
