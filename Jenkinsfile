pipeline {
    agent any

    stages 
    {
	  stage('Building ThriftServer') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
    }
}
