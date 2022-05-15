FROM gitpod/workspace-mongodb


FROM gitpod/workspace-mysql

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh &&  sdk install java 17.0.3-zulu && sdk use java 17.0.3-zulu"
