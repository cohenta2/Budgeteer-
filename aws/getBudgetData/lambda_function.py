import boto3

def lambda_handler(event, context):
    username = event["username"]
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table("budgetData")
    response = table.get_item(
        Key={
            'username' : username
        })
    return(response["Item"])
