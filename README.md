# Service testing with java 12

This is a maven project with java 12, to show the basics of  automate rest API testing

- You have to start a local server with the needed endpoints (json-server recomended)

- To install the library use:
`$ npm install -g json-server`

- Start ther server use te db.json file in the resources folder, and execute the following:
`$ json-server --watch db.json`

To download the dependencies and execute all the tests use:
`$ ./gradlew build`