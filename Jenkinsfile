pipeline {
	agent any
	stages {
		stage('building')
		{
			steps{
				sh 'mvn clean install -Dmaven.test.skip=true'
			}
		}
	}
}
