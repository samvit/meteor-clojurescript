console.log("hello")
// this needs to be in your project.js file;
if (Meteor.isServer) {
	require = __meteor_bootstrap__.require;
}
