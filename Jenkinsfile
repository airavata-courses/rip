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
    }
}
        
