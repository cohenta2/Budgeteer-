import boto3
import uuid

def lambda_handler(event, context):
    username = event["username"]
    income = event["income"]
    rent = event["rent"]
    food = event["food"]
    transportation = event["transportation"]
    recreation = event["recreation"]
    print('Generating new DynamoDB record, with ID: ' + username)
    #Creating new record in DynamoDB table
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table("budgetData")
    response = table.get_item(
        Key={
            'username' : username
        })

    if response is None:
        table.put_item(
            Item={
            'username' : username,
            'income' : income,
            'rent' : rent,
            'food' : food,
    		'transportation' : transportation,
    		'recreation' : recreation
        })
    else:
        table.update_item(
            Key={
                'username': username
            },
            UpdateExpression='set income = :i, rent = :r, food = :f, transportation = :t, recreation = :rec',
            ExpressionAttributeValues={
                ':i': income,
                ':r': rent,
                ':f': food,
                ':t': transportation,
                ':rec': recreation
            })
