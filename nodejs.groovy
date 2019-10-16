job('NodeJS Job') {
    scm {
        git('https://github.com/iotagile/sample_nodejs.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('masahiko.sekibe@konicaminolta.com')
        }
    }
    triggers {
        scm('H/1 * * * *')
    }
    wrappers {
        nodejs('nodejs_v11')
    }
    steps {
        shell("npm install")
        shell("npm test")
    }
}
