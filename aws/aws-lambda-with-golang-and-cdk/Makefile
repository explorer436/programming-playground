cdk_dir = cdk-workshop-golang
app_dir1 = hello-world-lambda
app_dir2 = hit-counter-lambda

export GOOS=linux
export CGO_ENABLED=0

help:
	@echo 'setup       : Configure local environment'
	@echo 'build       : Build Go package'
	@echo 'zip         : Compress Go package for deployment'
	@echo 'cdk-deploy  : Deploy latest version through CDK'
	@echo 'cdk-cleanup : Clean up cloud environment'

setup:
	cd $(cdk_dir); go mod download
	cd $(app_dir1); go mod download
	cd $(app_dir2); go mod download

build:
	go build -C $(app_dir1)/ -tags lambda.norpc -o bootstrap main.go
	go build -C $(app_dir2)/ -tags lambda.norpc -o bootstrap main.go

zip: build
	cd $(app_dir1); zip main.zip bootstrap
	cd $(app_dir2); zip main.zip bootstrap

cdk-deploy: zip
	cd $(cdk_dir); cdk deploy

cdk-cleanup:
	cd $(cdk_dir); cdk destroy