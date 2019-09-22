FROM ubuntu:xenial
MAINTAINER Federico Tomassetti
RUN apt-get update -y
RUN apt-get install -y wget sudo
RUN apt-get install -y gnupg
RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ trusty-pgdg main" >> /etc/apt/sources.list.d/pgdg.list
RUN apt-get update -y && apt-get install -y apt-transport-https
RUN apt --fix-broken install -y python-pycurl python-apt software-properties-common
RUN apt-get -y --allow-unauthenticated install postgresql-9.5 vim
RUN apt-get update -y
RUN echo "local   all             all trust" >> /etc/postgresql/9.5/main/pg_hba.conf
RUN echo "host    all             all             0.0.0.0/0            trust" >> /etc/postgresql/9.5/main/pg_hba.conf
RUN echo "listen_addresses='*'" >> /etc/postgresql/9.5/main/postgresql.conf
ADD ./setup.sql /db/setup.sql
ADD ./schema.sql /db/schema.sql
RUN /etc/init.d/postgresql start && sudo -u postgres psql < /db/setup.sql && /etc/init.d/postgresql stop
RUN /etc/init.d/postgresql start && sudo -u postgres psql -d dbpersons < /db/schema.sql && /etc/init.d/postgresql stop
EXPOSE 5432
USER postgres
CMD ["/usr/lib/postgresql/9.5/bin/postgres", "-D", "/var/lib/postgresql/9.5/main", "-c", "config_file=/etc/postgresql/9.5/main/postgresql.conf"]
