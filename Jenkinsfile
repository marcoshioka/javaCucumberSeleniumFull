 /*======================================================================================*
 * Pipeline para execução dos testes de regressão automatizados no Jenkins CI/CD
 * Author: Carlos Almeida 
 * Job Execution: once a day on the 1st and 15th of every month except December 
 *=======================================================================================*/
pipeline {
 
  agent { 
    kubernetes {
      label 'qa-slave'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: qa-slave
spec:
  containers:
  - name: qa-slave
    image: 507208215022.dkr.ecr.us-east-1.amazonaws.com/ecr-jenkins-slave-qa:latest
    resources:
      limits:
        memory: "1000Gi"
        cpu: "1"
      requests:
        memory: "1024Mi"
        cpu: 500m
    tty: true
    command:
    - cat
    env:
    - name: AWS_DEFAULT_REGION
      value: sa-east-1
"""      
    }
  }
  
triggers { 
cron('H H 1,15 1-11 *')
}
  stages {
        stage('Configurar ChromeDriver ') {
      steps {
        echo "Branch is ${env.BRANCH_NAME}..."
       
          echo "Projeto de testes com Selenium - Copiar chromedriver de /usr/local/bin para Direatório do Projeto de Testes /driver "
        container("qa-slave") {
         
          script {
            
             sh (script: "cp /usr/local/bin/chromedriver /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/driver/")
             
          }
        }
      }
    }
      stage('Listar arquivos do diretorio') {
      steps {
        echo "Branch is ${env.BRANCH_NAME}..."
       
          echo "Projeto de testes com Selenium - Copiar chromedriver de /usr/local/bin para Direatório do Projeto de Testes /driver "
        container("qa-slave") 
        {
         
            script {
            
             sh (script: "cd /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/driver/; ls")
             
          }
        }
      }
    }
    
     stage('Criar Diretorio para Evidencias') {
      steps {
        echo "Branch is ${env.BRANCH_NAME}..."
       
          echo "Projeto de testes com Selenium - /RelatorioTest/ArquivoPDFRelatorio/evidences/ "
        container("qa-slave") {
         
          script {
            
             sh (script: "mkdir -p /RelatorioTest/ArquivoPDFRelatorio/evidences/ cd /RelatorioTest/ArquivoPDFRelatorio/evidences/; ls")
             
          }
        }
      }
    }
     
    stage('QA-Selenium - Regression Test Plataforma PI') {
      steps {
        echo "Branch is ${env.BRANCH_NAME}..."
        container("qa-slave") {
          echo "Projeto de testes com Selenium"
          script {
    sh (script: "mvn test; cd /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/; ls")
            
          }
        }
      }
    }
    
       
  }
  
  post {
        
           always {
          echo 'Publicar Evidências da execução dos testes automatizados no Jenkins '
              
            script {
            
            sh (script: "cd /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/; ls; tar -czvf Evidencias.tar.gz /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/; pwd ; ls -la; ")
          }
          
          archiveArtifacts artifacts: '**/Evidencias.tar.gz', fingerprint: true 
         
        }
         
           failure {
           echo 'I failed :('
              script: sendMessage("Existem falhas nos Testes do Job ${env.JOB_NAME} - Build Number: ${env.BUILD_NUMBER} Verificar Evidências publicadas no Jenkins")
         
           script {
            
            sh (script: "cd /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/; ls; tar -czvf Evidencias.tar.gz /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/; pwd ; ls -la; ")
          }
           archiveArtifacts artifacts: '**/Evidencias.tar.gz', fingerprint: true 
         
        }
         
        success {
           echo ' Build Success!! - Testes executados com sucesso!'
              
                    
            script {
            
             sh (script: "cd /home/jenkins/workspace/piCoreAutomation_qa-7PYEI7R6VQS22S5LVUUOM2JB4N44WHQTST7TV5JVOFHCGOI5UUFQ/evidences/;  pwd ; ls -la;")
             
          }
         
        }

    }
    
     
  }
  
 /*================================================================*
 * Scripts Utilitarios                * 
 *================================================================*/
   
      def sendMessage(msg) {
  try {
      withCredentials([string(credentialsId: 'gchat-token', variable: 'GTOKEN')]) {
        googlechatnotification url: "https://chat.googleapis.com/v1/spaces/AAAASaW7Wy8/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=$GTOKEN", message: msg + "(<${env.BUILD_URL}|Mais Informacoes>)" 
                                   
      }
    }
    
    catch (Exception e) {
                          
   }
}
