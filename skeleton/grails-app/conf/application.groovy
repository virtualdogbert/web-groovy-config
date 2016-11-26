server {
    port= 8080
}

info {
    app {
        name = '@info.app.name@'
        version = '@info.app.version@'
        grailsVersion = '@info.app.grailsVersion@'
    }
}

spring {
    groovy {
        template['check-template-location'] = false
    }
}

grails {
    profile = 'web'

    codegen {
        defaultPackage = ''
    }

    spring {
        transactionManagement {
            proxies = 'false'
        }
    }

    mime {
        disable {
            accept {
                header {
                    userAgents:
                    ['Gecko', 'WebKit', 'Presto', 'Trident']
                }
            }
        }

        types {
            all = '*/*'
            atom = 'application/atom+xml'
            css = 'text/css'
            csv = 'text/csv'
            form = 'application/x-www-form-urlencoded'
            html = ['text/html', 'application/xhtml+xml']
            js = 'text/javascript'
            json = ['application/json', 'text/json']
            multipartForm = 'multipart/form-data'
            pdf = 'application/pdf'
            rss = 'application/rss+xml'
            text = 'text/plain'
            hal = ['application/hal+json', 'application/hal+xml']
            xml = ['text/xml', 'application/xml']
        }
    }

    urlmapping {
        cache {
            maxsize = 1000
        }
    }

    controllers {
        defaultScope = 'singleton'
    }

    converters {
        encoding = 'UTF-8'
    }

    views {
        'default' {
            codec = 'html'
        }

        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml'
            codecs {
                expression = 'html'
                scriptlets = 'html'
                taglib = 'none'
                staticparts = 'none'
            }
        }
    }
}

endpoints {
    jmx['unique - names'] = true
}
