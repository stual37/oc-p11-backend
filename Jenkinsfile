pipeline {
    
    agent any

    stages {
    
    	stage('Tests') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/stual37/oc-p11-backend.git'
                // Run Maven on a Unix agent.
                sh "./mvnw test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                
                success {
                    junit allowEmptyResults: true, testResults:'**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    
    	stage('Build') {
            steps {
            	// Get some code from a GitHub repository
                git 'https://github.com/stual37/oc-p11-backend.git'
                // Run Maven on a Unix agent.
                sh "./mvnw package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
        	}

        	
    	}
    	
    	
    	
        
        
    }
}


