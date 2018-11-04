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
	    stage('Stopping previous containers') {
            steps {
                sh 'docker-compose down'
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
    }
}
        
