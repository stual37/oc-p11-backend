pipeline {
    
    agent any

    stages {
    	stage('Install') {
    		steps {
    			// Get some code from a GitHub repository
                git 'https://github.com/stual37/oc-p11-backend.git'

    		}
    	} 
    	
    	stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "./mvnw package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
        	}

        	post {
        		// If Maven was able to run the tests, even if some of the test
            	// failed, record the test results and archive the jar file.
            	success {
            		junit allowEmptyResults: true, testResults:'**/target/surefire-reports/RUN-*.xml'
            		$archiveArtifacts 'target/*.jar'
            	}
        	}
    	}
    	
    	stage('Tests') {
            steps {
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
    	
        
        
    }
}


