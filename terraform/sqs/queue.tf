resource "aws_sqs_queue" "queues" {
  for_each = toset(var.queue_names)
  name     = each.key
}

variable "queue_names" {
}