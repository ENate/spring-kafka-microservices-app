FROM gitpod/workspace-full

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh   &&  sdk install java 17.0.3-zulu    &&  sdk use java 17.0.3-zulu"
FROM gitpod/workspace-mongodb
