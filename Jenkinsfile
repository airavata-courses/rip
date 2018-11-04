pipeline {
    agent any

    stages {
	stage('Building JSONParser')
	{
		steps{
			sh 'mvn clean install -Dmaven.test.skip=true'
		}
	   
	}
    }
}
