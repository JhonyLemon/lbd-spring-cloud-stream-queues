terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.49"
    }
  }
}

variable "aws_region" {
  type = string
}

variable "queue_names" {
}

provider "aws" {
  region = var.aws_region
  s3_force_path_style = true
  access_key = "mock_access_key"
  secret_key = "mock_secret_key"
  skip_credentials_validation = true
  skip_metadata_api_check = true
  skip_requesting_account_id = true

  endpoints {
    sqs = "http://localhost:4566"
  }
}

module "sqs" {
  source = "./sqs"
  queue_names = var.queue_names
}







