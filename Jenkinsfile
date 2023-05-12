pipeline {
  options {
    timeout(time: 50, unit: 'MINUTES')
    buildDiscarder(logRotator(numToKeepStr:'10'))
    disableConcurrentBuilds(abortPrevious: true)
  }

  agent {
    label "centos-latest"
  }

  tools {
    maven 'apache-maven-latest'
    jdk 'temurin-jdk17-latest'
  }

  environment {
    CLONE_URL = 'https://github.com/merks/org.eclipse.datatools'
    CHECKOUT = 'true'
  }

  parameters {
    choice(
      name: 'BUILD_TYPE',
      choices: ['nightly', 'milestone', 'release'],
      description: '''
      Choose the type of build.
      Note that a release build will not promote the build, but rather will promote the most recent milestone build.
      '''
    )

    booleanParam(
      name: 'PROMOTE',
      defaultValue: true,
      description: 'Whether to promote the build to the download server.'
    )
  }

  stages {
    stage('Display Parameters') {
        steps {
            echo "BUILD_TYPE=${params.BUILD_TYPE}"
            echo "PROMOTE=${params.PROMOTE}"
            script {
                env.BUILD_TYPE = params.BUILD_TYPE
                if (env.BRANCH_NAME == 'master') {
                  if (params.PROMOTE) {
                    env.MAVEN_PROFILES = "-Peclipse-sign -Ppromote"
                  } else {
                    env.MAVEN_PROFILES = "-Peclipse-sign"
                  }
                } else {
                  env.MAVEN_PROFILES = ""
                }
            }
        }
    }

    stage('Git Checkout') {
      when {
        environment name: 'CHECKOUT', value: 'true'
      }
      steps {
        script {
          def gitVariables = checkout(
            poll: false,
            scm: [
              $class: 'GitSCM',
              branches: [[name: '*' + '/master']],
              doGenerateSubmoduleConfigurations: false,
              submoduleCfg: [],
              userRemoteConfigs: [[url: "${env.CLONE_URL}.git" ]]
            ]
          )

          echo "$gitVariables"
          env.GIT_COMMIT = gitVariables.GIT_COMMIT

          if (params.PROMOTE) {
            env.MAVEN_PROFILES = "-Peclipse-sign -Ppromote"
           } else {
             env.MAVEN_PROFILES = "-Peclipse-sign"
           }
        }
      }
    }

    stage('Build') {
      steps {
        sshagent (['projects-storage.eclipse.org-bot-ssh']) {
          wrap([$class: 'Xvnc', useXauthority: true]) {
            sh '''
              mvn \
              clean \
              verify \
              -B \
              $MAVEN_PROFILES \
              -Dmaven.repo.local=$WORKSPACE/.m2/repository \
              -Dmaven.test.failure.ignore=true \
              -Dmaven.test.error.ignore=true \
              -Ddash.fail=false \
              -Dorg.eclipse.justj.p2.manager.build.url=$JOB_URL \
              -Dorg.eclipse.justj.p2.manager.relative=dtp/updates \
              -Dbuild.type=$BUILD_TYPE \
              -Dgit.commit=$GIT_COMMIT \
              -Dgit.commit.${CLONE_URL}/commit/ \
              -Dorg.eclipse.storage.user=genie.oomph \
              -Dorg.eclipse.justj.p2.manager.target=oomph
            '''
          }
        }
      }

      post {
        always {
          archiveArtifacts artifacts: '**/target/repository/**/*,**/target/*.zip,**/target/work/data/.metadata/.log'
          junit '**/target/surefire-reports/TEST-*.xml'
        }
      }
    }
  }
}
