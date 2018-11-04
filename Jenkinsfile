pipeline {
    agent any

    stages {
	stage('Confirming')
	{
		steps{
			sh 'mvn clean install -Dmaven.test.skip=true'
		}
	   
	}
    }
}
