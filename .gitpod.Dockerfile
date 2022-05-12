FROM gitpod/workspace-full

FROM gitpod/workspace-mongodb
RUN sudo mkdir -p /workspace/data && mongod --dbpath /workspace/data


FROM gitpod/workspace-mysql

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh   &&  sdk install java 17.0.3-zulu    &&  sdk use java 17.0.3-zulu"
