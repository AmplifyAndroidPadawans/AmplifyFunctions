/* Amplify Params - DO NOT EDIT
	ENV
	REGION
	STORAGE_AUTHORSTABLE_ARN
	STORAGE_AUTHORSTABLE_NAME
	STORAGE_AUTHORSTABLE_STREAMARN
	STORAGE_BOOKSTABLE_ARN
	STORAGE_BOOKSTABLE_NAME
	STORAGE_BOOKSTABLE_STREAMARN
Amplify Params - DO NOT EDIT */

const AWS = require('aws-sdk')

AWS.config.update({ region: process.env.TABLE_REGION });

const dynamodb = new AWS.DynamoDB.DocumentClient();
let booksTableName = "booksTable";
let authorsTableName = "authorsTable";

if (process.env.ENV && process.env.ENV !== "NONE") {
	booksTableName = booksTableName + '-' + process.env.ENV;
	authorsTableName = authorsTableName + '-' + process.env.ENV;
}


exports.handler = function (event, context) {
  console.log(JSON.stringify(event, null, 2));
  event.Records.forEach(record => {
    console.log('DynamoDB Record: %j', record.dynamodb);
	
	console.log('DynamoDB author: %j', record.dynamodb.NewImage.author.S);
	
	let params = {
		TableName: booksTableName,
		Key: {
			'author': record.dynamodb.NewImage.author
		},
		ProjectionExpression: 'ATTRIBUTE_NAME'
	  };

	console.log('DynamoDB params: %j', JSON.stringify(command));
	
	dynamodb.get(params, (error, result) => {
		if (error) {
			console.log("{ statusCode: 500, error: %j }", error.message);
		} else {
			console.log("{ statusCode: 200, url: request.url, body: %j }", JSON.stringify(result.Item));
		}
	});
  });
  context.done(null, 'Successfully processed DynamoDB record');
};