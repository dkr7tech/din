
* 
 * https://www.baeldung.com/minio


API: http://172.17.0.2:9000  http://127.0.0.1:9000 
WebUI: http://172.17.0.2:9001 http://127.0.0.1:9001  

Docs: https://docs.min.io
WARN: Detected default credentials 'minioadmin:minioadmin', we recommend that you change these values with 'MINIO_ROOT_USER' and 'MINIO_ROOT_PASSWORD' environment variables

While the containerized deployment is perfectly fine for evaluating MinIO, there are some limitations to be aware of.

Specifically, some advanced features such as versioning, object locking, and bucket replication will not work. These features require the distributed deployment of MinIO, which is not available in a single-server deployment.